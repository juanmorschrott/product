package com.juanmorschrott.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
public class PriceRequestDto {

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime applyDate;

    private Long productId;

    @Min(1)
    private Long brandId;

}
