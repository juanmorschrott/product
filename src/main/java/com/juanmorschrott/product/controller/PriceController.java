package com.juanmorschrott.product.controller;

import com.juanmorschrott.product.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applyDate,
                                    @RequestParam(value = "product", required = true) Long productId,
                                    @RequestParam(value = "brand", required = true) Long brandId) {

        return new ResponseEntity<>(this.priceService.search(applyDate, productId, brandId), HttpStatus.OK);
    }

}
