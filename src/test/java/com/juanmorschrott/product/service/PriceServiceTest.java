package com.juanmorschrott.product.service;

import com.juanmorschrott.product.dto.PriceResponse;
import com.juanmorschrott.product.exception.NotFoundException;
import com.juanmorschrott.product.model.Price;
import com.juanmorschrott.product.repository.PriceRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test(expected = NotFoundException.class)
    public void searchShouldThrowNotFoundExceptionWhenNoValueIsReturnedTest() {
        // Given
        String date = "2020-06-14-10.00.00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime applyDate = LocalDateTime.parse(date, dateTimeFormatter);

        // When
        priceService.search(applyDate, 35455L, 1L);

        // Then
        failBecauseExceptionWasNotThrown(NotFoundException.class);
    }

    @Test
    public void searchShouldReturnPriceResponseTest() {
        // Given
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        Price price1 = new Price();
        price1.setBrandId(1L);
        String firstPriceStartDate = "2020-06-14-00.00.00";
        String firstPriceEndDate = "2020-12-31-23.59.59";
        price1.setStartDate(LocalDateTime.parse(firstPriceStartDate, dateTimeFormatter));
        price1.setEndDate(LocalDateTime.parse(firstPriceEndDate, dateTimeFormatter));
        price1.setPriceList(1L);
        price1.setProductId(35455L);
        price1.setPriority(0);
        price1.setPrice(new BigDecimal("35.50"));
        price1.setCurr("EUR");

        Price price2 = new Price();
        price2.setBrandId(1L);
        String secondPriceStartDate = "2020-06-14-15.00.00";
        String secondPriceEndDate = "2020-06-14-18.30.00";
        price2.setStartDate(LocalDateTime.parse(secondPriceStartDate, dateTimeFormatter));
        price2.setEndDate(LocalDateTime.parse(secondPriceEndDate, dateTimeFormatter));
        price2.setPriceList(2L);
        price2.setProductId(35455L);
        price2.setPriority(1);
        price2.setPrice(new BigDecimal("25.45"));
        price2.setCurr("EUR");

        String searchDate = "2020-06-14-10.00.00";

        // When
        when(priceRepository.findAll()).thenReturn(Arrays.asList(price1, price2));
        PriceResponse priceResponse = priceService.search(LocalDateTime.parse(searchDate, dateTimeFormatter), 35455L, 1L);

        // Then
        assertThat(priceResponse).isNotNull();
    }

}
