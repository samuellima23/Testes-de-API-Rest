package datafactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdutoComumComOValorIgualA (double Valor){

        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Xbox Series s");
        produto.setProdutoValor(Valor);

        List<String> cores = new ArrayList<>();
        cores.add("preto");
        cores.add("azul");

        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("Controle");
        componente.setComponenteQuantidade(1);

        componentes.add(componente);

        produto.setComponentes(componentes);

        return produto;
    }
}
