# Beblue-cashback challenge (Back-End)
Desafio Técnico BeBlue - Cashback

API Rest de uma loja de Discos que oferece Cashback na venda de Albuns listados pela API do Spotify.

## Requisitos
- Java 8

### Tecnologias utilizadas
- [Gradle](https://gradle.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [H2 Database](https://www.h2database.com/) (banco de dados)
- [Spotify Web API for Java](https://github.com/thelinmichael/spotify-web-api-java)

## Instruções de execução

### Clone
```git clone https://github.com/marciosmelo/beblue-cashback.git```

### Build
```./gradlew build```

### Executar 
- via Gradle

  ``````./gradlew bootRun``````

- via Docker

  ```docker build -t beblue .```
  
  ```docker run -p 8080:8080 beblue```

## Documentação

### Discos
* Listar Discos por Gênero (MPB, ROCK, CLASSIC ou POP): listando discos do Spotify de Rock
  * Content-Type: application/json
  * GET: [http://localhost:8080/albuns?genero=rock](http://localhost:8080/albuns?genero=rock)
  
* Retornar Disco por identificador Spotify: retorna o disco com o identificador do Spotity  
  * Content-Type: application/json
  * GET: [http://localhost:8080/albuns/{id}](http://localhost:8080/albuns/http://localhost:8080/albuns/71ZubYRSrVxjpF6OxNhb1j)
   
### Vendas
* Nova venda: Registra uma venda na API. O formato enviado deve ser um json no body da requisição conforme exemplo abaixo. Aps registrar a venda é retornando um json com um informativo geral da venda. Discos Vendidos e o valor de cashback de cada um bem como o valor total de cashback da compra.
  * Content-Type: application/json
  * POST: [http://localhost:8080/vendas](http://localhost:8080/vendas)
  * Exemplo BODY - RAW:
  ```
  [
    {
        "identificadorSpotiy": "0aA9rYw8PEv9G7tVIJ9dKg",
        "nome": "Lets Rock",
        "genero": "ROCK",
        "preco": 27.52
    },
    {
        "identificadorSpotiy": "1ZH5g1RDq3GY1OvyD0w0s2",
        "nome": "Combative Rock",
        "genero": "ROCK",
        "preco": 8.9
    },
    {
        "identificadorSpotiy": "5MKInakULmoBNApeB2ZB3A",
        "nome": "Cross Me (feat. Chance the Rapper & PnB Rock)",
        "genero": "ROCK",
        "preco": 64.26
    }
  ]
  ```

* Consultar Vendas: retorna todas as vendas realizadas
  * Content-Type: application/json
  * GET: [http://localhost:8080/vendas/](http://localhost:8080/vendas/)
 
  
* Buscar venda por id
  * Content-Type: application/json
  * GET: [http://localhost:8080/vendas/id](http://localhost:8080/vendas/1)
   
## Observações:

* As tabelas do banco de dados são apagadas, limpas e recriadas a cada execução.

## Melhorias 

* Existem algumas melhorias e implementaçes que não foram realizadas tais como:
  * Paginação dos Resultados
  * Método para Autenticação
  * Melhoria no controle de exceções para retornar mais Status específicos
  * Implementação mais ampla de TDD
  * Utilização de um plugin swagger para listar todos os endpoints e suas respectivas propriedades, restriçes e retornos


