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

## Enable replica Transactional

```bash
docker exec -it mongodb2 mongosh
rs.initiate()
rs.status()
```
