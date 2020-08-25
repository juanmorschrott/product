package com.juanmorschrott.product.service;

import com.juanmorschrott.product.dto.PriceResponse;

import java.time.LocalDateTime;

public interface PriceService {

    PriceResponse search(LocalDateTime applyDate, Long productId, Long brandId);

}
