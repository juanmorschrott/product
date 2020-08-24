package com.juanmorschrott.product.controller;

import com.juanmorschrott.product.dto.PriceRequestDto;
import com.juanmorschrott.product.dto.PriceResponseDto;
import com.juanmorschrott.product.model.Price;
import com.juanmorschrott.product.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    public ResponseEntity<PriceResponseDto> checkOffer(@RequestBody PriceRequestDto priceRequestDto) {
        return new ResponseEntity(this.priceService.checkOffer(priceRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(priceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return new ResponseEntity<>(priceService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> create(@RequestBody Price price) {
        return new ResponseEntity<>(priceService.create(price), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        priceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
