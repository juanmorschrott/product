package com.juanmorschrott.product.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PriceResponseDto {

    @Min(1)
    @NotNull
    private Long productId;

    @Min(1)
    private Long brandId;

    @Min(1)
    private Long priceList;

    private String period;

    private BigDecimal price;

}
