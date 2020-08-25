package com.juanmorschrott.product.controller;

import com.juanmorschrott.product.dto.PriceResponseDto;
import org.junit.Before;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @Before
    public void init() {
        url = "http://localhost:" + port + "/api/v1/prices/search";
    }

    @Test
    public void test1() throws Exception {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("date", "2020-06-14-10.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        // When
        ResponseEntity<PriceResponseDto> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponseDto.class);

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

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("date", "2020-06-14-16.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        // When
        ResponseEntity<PriceResponseDto> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponseDto.class);

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

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("date", "2020-06-14-21.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        // When
        ResponseEntity<PriceResponseDto> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponseDto.class);

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

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("date", "2020-06-15-10.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        // When
        ResponseEntity<PriceResponseDto> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponseDto.class);

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

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("date", "2020-06-16-21.00.00")
                .queryParam("product", "35455")
                .queryParam("brand", "1");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        // When
        ResponseEntity<PriceResponseDto> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                PriceResponseDto.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(4L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("38.95")));
    }

}
