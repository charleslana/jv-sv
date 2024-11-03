# Spring boot server

## Instalar

```bash
mvn clean install -DskipTests
```

## Executar sprint boot

```bash
mvn spring-boot:run
```

## Matar porta

```bash
kill -9 $(lsof -ti:8081)
```

## Docker compose

```bash
docker-compose up -d
```

## Swagger access

[Spring REST OpenAPI Documentation](https://www.baeldung.com/spring-rest-openapi-documentation)

```bash
http://localhost:8081/swagger-ui/index.html
```
