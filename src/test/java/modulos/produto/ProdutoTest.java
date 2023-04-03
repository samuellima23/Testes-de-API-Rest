package modulos.produto;


import datafactory.ProdutoDataFactory;
import datafactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do módulo de Produto")
public class ProdutoTest {
    private String token;
    @BeforeEach
    public void beforeEach(){
        // Configurar os dados da API Rest da lojinha
        baseURI = "http://165.227.93.41";
        // port = 8080;
        basePath = "/lojinha";

        //Obter o token do usuário admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.usuarioLogar())
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");
    }
    @Test
    @DisplayName("Validar os limites menores que zero do valor do produto")
    public void testValidarLimitesZeradosProibidosValorProduto(){
            // Tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada
            // e o status code foi 422
            given()
                    .contentType(ContentType.JSON)
                    .header("token", this.token)
                    .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))
            .when()
                    .post("v2/produtos")
            .then()
                    .assertThat()
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);
    }
    @Test
    @DisplayName("Validar os limites maiores que sete mil do valor do produto")
    public void testValidarLimitesMaiorSeteMilValorValorProduto(){
        // Tentar inserir um produto com valor 7000.01 e validar que a mensagem de erro foi apresentada
        // e o status code foi 422
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7000.01))
            .when()
                .post("v2/produtos")
            .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);
    }
}
