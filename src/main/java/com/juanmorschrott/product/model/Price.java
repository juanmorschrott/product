package com.juanmorschrott.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel
@AllArgsConstructor
@Data
@Entity
@Table(name = "PRICES")
@ToString
public class Price {

    public Price() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty(notes = "Brand id", example = "1", required = true, position = 1)
    @Column(name = "BRAND_ID")
    private Long brandId;

    @ApiModelProperty(notes = "Offer start date", example = "2020-06-16-21.00.00", required = true, position = 2)
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "Offer end date", example = "2020-06-16-21.00.00", required = true, position = 3)
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @ApiModelProperty(notes = "Price List", example = "1", required = true, position = 4)
    @Column(name = "PRICE_LIST")
    private Long priceList;

    @ApiModelProperty(notes = "Product id", example = "1", required = true, position = 5)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @ApiModelProperty(notes = "Product price", example = "35.50", required = true, position = 6)
    @Column(name = "PRICE")
    private BigDecimal price;

    @ApiModelProperty(notes = "Currency", example = "EUR", required = true, position = 7)
    @Column(name = "CURR")
    private String curr;

}
