package com.juanmorschrott.product.service;

import com.juanmorschrott.product.dto.PriceResponse;
import com.juanmorschrott.product.exception.NotFoundException;
import com.juanmorschrott.product.model.Price;
import com.juanmorschrott.product.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Comparator;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse search(LocalDateTime applyDate, Long productId, Long brandId) {
        Price price = this.priceRepository.findAll().stream()
                .filter(p -> p.getProductId().equals(productId))
                .filter(p -> p.getBrandId().equals(brandId))
                .filter(p -> p.getStartDate().isBefore(applyDate) && p.getEndDate().isAfter(applyDate))
                .max(Comparator.comparingLong(Price::getPriority))
                .orElseThrow(() -> new NotFoundException("No product found with criteria -> DateTime: " + applyDate +
                        " Product Id: " + productId + " Brand Id: " + brandId));

        return PriceResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .period(generatePeriodStr(price.getStartDate(), price.getEndDate()))
                .price(price.getPrice())
                .priceList(price.getPriceList())
                .build();
    }

    private String generatePeriodStr(LocalDateTime startDate, LocalDateTime endDate) {
        Period period = Period.between(startDate.toLocalDate(), endDate.toLocalDate());

        return "Price applied during: " + period.getMonths() + " months, " + period.getDays() + " days";
    }

}
