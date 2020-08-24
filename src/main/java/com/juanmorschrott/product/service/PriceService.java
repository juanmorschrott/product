package com.juanmorschrott.product.service;

import com.juanmorschrott.product.dto.PriceRequestDto;
import com.juanmorschrott.product.dto.PriceResponseDto;
import com.juanmorschrott.product.model.Price;

import java.util.List;

public interface PriceService {

    PriceResponseDto checkOffer(PriceRequestDto priceRequestDto);

    List<Price> findAll();

    Price findById(Long id);

    Price create(Price price);

    void delete(Long id);
}
