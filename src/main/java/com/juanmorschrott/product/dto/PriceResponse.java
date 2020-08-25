package com.juanmorschrott.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel
@Builder
@Data
public class PriceResponse {

    @ApiModelProperty(notes = "Product id", example = "1", required = true, position = 1)
    private Long productId;

    @ApiModelProperty(notes = "Brand id", example = "1", required = true, position = 2)
    private Long brandId;

    @ApiModelProperty(notes = "Price List", example = "1", required = true, position = 3)
    private Long priceList;

    @ApiModelProperty(notes = "Offer start date", example = "2020-06-16-21.00.00", required = true, position = 4)
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "Offer end date", example = "2020-06-16-21.00.00", required = true, position = 5)
    private LocalDateTime endDate;

    @ApiModelProperty(notes = "Period of time from start to end of the offer", example = "6 months, 1 day", required = true, position = 6)
    private String period;

    @ApiModelProperty(notes = "Product price", example = "35.50", required = true, position = 7)
    private BigDecimal price;

}
