# Product API

### Run API

```
cd ./product
mvnw.cmd clean install
mvnw.cmd spring-boot:run
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
curl --location --request POST 'localhost:8080/api/v1/prices' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
    "applyDate": "2020-06-14-21.00.00",
    "productId": 35455,
    "brandId": 1
}'
```

### Response Example

```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "period": "Price applied during: 6 months, 17 days",
    "price": 35.50
}
```

