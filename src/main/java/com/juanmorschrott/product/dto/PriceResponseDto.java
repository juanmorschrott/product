package com.juanmorschrott.product.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Data
public class PriceResponseDto {

    @NotNull
    private Long productId;

    private Long brandId;

    private Long priceList;

    private String period;

    private BigDecimal price;

}
