# Testes-de-API-Rest
Nesse repositório faremos testes automatizados, criaremos cenários e utilizaremos heurísticas para testes em uma API Rest documentada no Swagger, para manipular os métodos da API usaremos o Postman. Essa API faz parte do objeto de estudos do Programa de Testes e Qualidade de Software do professor Julio De Lima. 

![lojinha api](https://user-images.githubusercontent.com/33026663/227372814-13c53e34-02b9-4fa9-96c0-b80b062aa4ac.png)

# Heurística VADER
A heurística VADER possui 05 princípios para avaliar o comportamento de uma API Rest, com o intuito de cobrir o maior número de pontos chaves que são básicos para uma API. A seguir um exemplo de um teste seguindo essa heurística em um dos endpoints de uma API Rest.

- Módulo testado: Componente
- Método utilizado: Adicionar componente ao produto
- Heurística utilizada: VADER

# (V)erbs:
Se trata das requisições (GET, PUT, DELETE, POST) de uma API e devemos nos certificar que todas elas estão funcionando como esperado.
- Usei um método permitido para registro de componentes do produto e obtive sucesso como esperado.

![image](https://user-images.githubusercontent.com/33026663/227582542-e22a8901-0b69-4c7a-afbb-106223acd5ae.png)

- Testei outros métodos como PUT e DELETE para o endpoint de componentes e não obtive sucesso, como era esperado.

![image](https://user-images.githubusercontent.com/33026663/227582943-3a28095f-67e8-49df-99eb-c19283292465.png)

# (A)uthentication & Authorizathion:
A autenticação diz respeito a forma de autenticação e autorização para a API, onde é possível verificar se o token para o usuário está funcionando corretamente por exemplo.
- No endpoint de adicionar novo component coloquei o token correto e obtive sucesso
- Não usei token para fazer a adição de componentes e obtive erro 401 (unauthorized), que era esperado.

![image](https://user-images.githubusercontent.com/33026663/227583682-2f1c39c4-a9f8-4dd0-b2d8-475fbda6b34a.png)

- Ao enviar um token inválido obtive o erro 500 ao invés de 401.

![image](https://user-images.githubusercontent.com/33026663/227583453-f0a8a3f6-97df-48f0-ad4a-7cd5ee765941.png)


# (D)ata:
Os dados dizem respeito a resposta da requisição, onde ela deve obedecer fielmente a regra de negócio.
- Enviei o nome do componente como true, e ele salvou o nome como "1".

![image](https://user-images.githubusercontent.com/33026663/227585203-e78370f2-ee2b-4858-b2d6-3a56f0935607.png)

- Enviei o nome do componente como false, e ele salvou o nome como "".

![image](https://user-images.githubusercontent.com/33026663/227585339-edc00f47-be97-481d-825c-1e4f9bf28207.png)

- Enviei o valor do componente como String e obtive sucesso.

![image](https://user-images.githubusercontent.com/33026663/227585475-b2fb7c5f-f60d-4e2e-9b34-68881ea636dc.png)

- Enviei o nome do componente como inteiro e obtive sucesso, um item para ser discutido com o time dev.

![image](https://user-images.githubusercontent.com/33026663/227585590-7586db15-7aab-4e63-a1d0-624c04d7f6c8.png)

- Enviei um componente com um nome acima de 500 caracteres, ele não registra o componente mesmo assim mostra um HTTP 201, como status de sucesso.

![componentes 201](https://user-images.githubusercontent.com/33026663/227371065-08680f1a-1bba-4a1d-aa06-b81ad86618f1.png)

# (E)rrors
Os erros falam sobre os códigos de estado do HTTP, onde podemos validar se o erro retornado é de fato o esperado.
- Enviei itens do corpo da requisição incorreto, e obtive o erro 400 como era esperado.

![image](https://user-images.githubusercontent.com/33026663/227586185-421222ff-6640-4bcd-84c4-9ca11bdb9d11.png)

- Não usei token para fazer a adição de componentes e obtive erro 401 (unauthorized), como era esperado.

![image](https://user-images.githubusercontent.com/33026663/227586349-25d83347-a31a-410c-bd88-0d2ca47a8de6.png)

- Ao enviar um token inválido obtive o erro 500 ao invés de 401.

![image](https://user-images.githubusercontent.com/33026663/227586447-5285435f-64be-45ba-88cb-d9bba7959a69.png)

- Enviei uma requisição com uma URL errada e obtive o erro 404 como era esperado.

![image](https://user-images.githubusercontent.com/33026663/227586570-c7d2139e-195e-43d1-aed5-ddc76b213d6a.png)

![image](https://user-images.githubusercontent.com/33026663/227586651-0ec4f078-9fe7-44f1-ae8a-874dea45186c.png)

- Enviei um componente com a quantidade inferior a um, e obtive erro 422 como era esperado.

![image](https://user-images.githubusercontent.com/33026663/227587040-5498705c-c12a-4052-afec-66982180d7f6.png)

- Obtive sucesso ao cadastrar mais de 16 componentes para um produto, não era esperado pois a regra de negócio informa que o máximo deve ser 16.

![image](https://user-images.githubusercontent.com/33026663/227588435-1e79b5f3-c5fb-4d52-b6ce-b2d8384f0a56.png)

# (R)esponsiveness
Se trata do tempo de resposta para as ações dentro da API, sendo de sucesso ou falhas.
- A média do tempo de resposta para 05 requisições de cadastro de componente foi de 235,6 milissegundos.

![image](https://user-images.githubusercontent.com/33026663/227588652-5e663ca3-dc2e-4a4f-b8f5-202987a1bb84.png)
![image](https://user-images.githubusercontent.com/33026663/227588710-d3587555-2a5a-4a72-8bd1-15afdcc4672d.png)
![image](https://user-images.githubusercontent.com/33026663/227588756-a4d18249-272e-4c4d-9eb9-0d92aa1c80ba.png)
![image](https://user-images.githubusercontent.com/33026663/227588793-af555b89-fc43-4375-b77d-3502c8dbdce9.png)
![image](https://user-images.githubusercontent.com/33026663/227588863-029232d0-5b9b-449c-9e6d-c2040aebd759.png)

![image](https://user-images.githubusercontent.com/33026663/227589337-446fb933-0cf7-4c2a-8ea3-9c43fd63ed7c.png)
