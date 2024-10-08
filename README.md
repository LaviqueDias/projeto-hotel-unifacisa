<h1 align="center">
  HOTEL UNIFACISA
</h1>

API para gerenciar tarefas (CRUD) referentes a um hotel

O projeto foi elaborado [nesse vídeo](https://youtu.be/IjProDV001o).

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombock](https://projectlombok.org/)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/hotel-unifacisa-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

 - CRUD Funcionários
    - http://localhost:8080/funcionarios

 - CRUD Hóspedes  
    - http://localhost:8080/hospedes
 - CRUD Quartos 
    - http://localhost:8080/quartos
 - CRUD Reservas
    - http://localhost:8080/reservas
