package com.juanmorschrott.product.controller;

import com.juanmorschrott.product.dto.PriceResponse;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

public interface PriceController {

    @Operation(summary = "Search a price by date, product id and brand id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the price", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PriceResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    ResponseEntity<PriceResponse> search(@ApiParam(name = "Date", example = "2020-06-16-21.00.00") @RequestParam(value = "date", required = true)
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applyDate,
                                         @ApiParam(name = "Product ID", example = "35455") @RequestParam(value = "product", required = true) Long productId,
                                         @ApiParam(name = "Brand ID", example = "1") @RequestParam(value = "brand", required = true) Long brandId);

}
