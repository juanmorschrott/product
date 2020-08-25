# Product API

### Run API

```
cd ./product
docker-compose.exe up
```

### Run Integration Tests

```
cd ./product
mvnw.cmd test
```

### API Documentation

Api documentation: [Swagger](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)

### Postman Collection

You will find a postman collection to test the API inside the project.

### Request Example:

```json
curl --location --request GET 'localhost:8080/api/v1/prices/search?date=2020-06-16-21.00.00&product=35455&brand=1' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json'
```

### Response Example

```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 4,
    "period": "Price applied during: 6 months, 16 days",
    "price": 38.95
}
```

