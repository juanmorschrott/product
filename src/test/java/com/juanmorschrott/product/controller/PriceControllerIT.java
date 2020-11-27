package com.juanmorschrott.product.controller;

import com.juanmorschrott.product.ProductApplication;
import com.juanmorschrott.product.dto.PriceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ProductApplication.class, PriceControllerImpl.class})
@AutoConfigureMockMvc
public class PriceControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String path;

    @Test
    public void test1() throws Exception {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/api/v1/prices/search")
                .scheme("http")
                .host("localhost")
                .port(port)
                .queryParam("date", "2020-06-14-10.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");

        // When
        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                uriComponentsBuilder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponse.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(1L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("35.50")));
    }

    @Test
    public void test2() throws Exception {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/api/v1/prices/search")
                .scheme("http")
                .host("localhost")
                .port(port)
                .queryParam("date", "2020-06-14-16.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");


        // When
        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                uriComponentsBuilder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponse.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(2L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("25.45")));
    }

    @Test
    public void test3() throws Exception {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/api/v1/prices/search")
                .scheme("http")
                .host("localhost")
                .port(port)
                .queryParam("date", "2020-06-14-21.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");


        // When
        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                uriComponentsBuilder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponse.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(1L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("35.50")));
    }

    @Test
    public void test4() throws Exception {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/api/v1/prices/search")
                .scheme("http")
                .host("localhost")
                .port(port)
                .queryParam("date", "2020-06-15-10.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");


        // When
        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                uriComponentsBuilder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponse.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(3L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("30.50")));
    }

    @Test
    public void test5() throws Exception {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/api/v1/prices/search")
                .scheme("http")
                .host("localhost")
                .port(port)
                .queryParam("date", "2020-06-16-21.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");


        // When
        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                uriComponentsBuilder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponse.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(4L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("38.95")));
    }

}
