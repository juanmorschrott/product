package com.juanmorschrott.product.service;

import com.juanmorschrott.product.dto.PriceResponseDto;

import java.time.LocalDateTime;

public interface PriceService {

    PriceResponseDto search(LocalDateTime applyDate, Long productId, Long brandId);

}
