# API Cadastro de Pessoas

## Descrição
Gerenciamento de Cadastro de pessoas e afinidade por região com seus respectivos score 


## Funcionalidades

* Cadastra um novo usuario
* Editar um usuario
* Busca um usuario por email
* Remover usuario por email

* Login autenticar

* Cadastra uma nova pessoa
* Lista todos pessoas
* Busca uma pessoa por ID

* Cadastra uma nova afinidade

* Cadastra um score

## Powered By

* Spring Boot 2.1.1.RELEASE;
* Banco H2 
* Swagger;
* Java 11;

## Swagger, Endpoints 

A API dispõe de acesso ao Swagger para fácil utilização. Após subir o serviço, acesse http://localhost:8080/swagger-ui.html.

Os endpoints disponíveis estão presentes nele.


## Testes 
Há alguns testes nos seguintes package
`./src/test/java/br/com/gerenciamento/scoreclientes/repository`.
`./src/test/java/br/com/gerenciamento/scoreclientes/entity`.
`./src/test/java/br/com/gerenciamento/scoreclientes/services`.
Ao executá-los, a aplicação utilizará um segundo banco de dados (o H2 in-memory).

O arquivo ./src/test/resources/application.properties gerencia a conexão dos testes com o H2.

