package com.juanmorschrott.product.controller;

import com.juanmorschrott.product.dto.PriceRequestDto;
import com.juanmorschrott.product.dto.PriceResponseDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    @LocalServerPort
    private final int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test1() throws Exception {
        // Given
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        String date = "2020-06-14-10.00.00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        priceRequestDto.setApplyDate(LocalDateTime.parse(date, dateTimeFormatter));
        priceRequestDto.setProductId(35455L);
        priceRequestDto.setBrandId(1L);

        // When
        ResponseEntity<PriceResponseDto> response =
                this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/prices/", priceRequestDto, PriceResponseDto.class);

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
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        String date = "2020-06-14-16.00.00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        priceRequestDto.setApplyDate(LocalDateTime.parse(date, dateTimeFormatter));
        priceRequestDto.setProductId(35455L);
        priceRequestDto.setBrandId(1L);

        // When
        ResponseEntity<PriceResponseDto> response =
                this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/prices/", priceRequestDto, PriceResponseDto.class);

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
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        String date = "2020-06-14-21.00.00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        priceRequestDto.setApplyDate(LocalDateTime.parse(date, dateTimeFormatter));
        priceRequestDto.setProductId(35455L);
        priceRequestDto.setBrandId(1L);

        // When
        ResponseEntity<PriceResponseDto> response =
                this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/prices/", priceRequestDto, PriceResponseDto.class);

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
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        String date = "2020-06-15-10.00.00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        priceRequestDto.setApplyDate(LocalDateTime.parse(date, dateTimeFormatter));
        priceRequestDto.setProductId(35455L);
        priceRequestDto.setBrandId(1L);

        // When
        ResponseEntity<PriceResponseDto> response =
                this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/prices/", priceRequestDto, PriceResponseDto.class);

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
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        String date = "2020-06-16-21.00.00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        priceRequestDto.setApplyDate(LocalDateTime.parse(date, dateTimeFormatter));
        priceRequestDto.setProductId(35455L);
        priceRequestDto.setBrandId(1L);

        // When
        ResponseEntity<PriceResponseDto> response =
                this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/prices/", priceRequestDto, PriceResponseDto.class);

        // Then
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(response.getBody().getProductId(), equalTo(35455L));
        assertThat(response.getBody().getBrandId(), equalTo(1L));
        assertThat(response.getBody().getPriceList(), equalTo(4L));
        assertThat(response.getBody().getPrice(), equalTo(new BigDecimal("38.95")));
    }

}
