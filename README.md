# Projeto de Gerenciamento de Eventos

Este é um projeto desenvolvido em Spring Boot durante o evento NLW Unite da Rocketseat, para gerenciar eventos e participantes. 

![image](https://github.com/karGuimaraes/pass-in/assets/39937365/5b24ba24-a118-4507-8632-cce873746749)

## Dependências

Este projeto utiliza as seguintes dependências:

- **spring-boot-starter-data-jpa**: Para integração com JPA e banco de dados.
- **spring-boot-starter-web**: Para desenvolvimento de aplicativos web com Spring MVC.
- **flyway-core**: Para controle de versionamento de banco de dados.
- **spring-boot-devtools**: Ferramentas de desenvolvimento para reinicialização automática do aplicativo.
- **lombok**: Para reduzir o boilerplate do código Java.
- **hsqldb**: Banco de dados HSQLDB para testes e desenvolvimento.
- **spring-boot-starter-test**: Dependência para testes unitários e de integração.
- **springdoc-openapi-starter-webmvc-ui**: Geração de documentação OpenAPI/Swagger para API RESTful.

## Como Executar o Projeto

1. Clone este repositório para o seu ambiente de desenvolvimento:

```
git clone https://github.com/karGuimaraes/pass-in.git
```

2. Importe o projeto para sua IDE.

3. Certifique-se de configurar corretamente as propriedades do banco de dados no arquivo application.properties.

4. Execute o projeto a partir da sua IDE ou utilizando o Maven:

```
mvn spring-boot:run
```

5. Acesse a documentação da API Swagger em [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) para explorar os endpoints disponíveis.
