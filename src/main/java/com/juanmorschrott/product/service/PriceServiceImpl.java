package com.juanmorschrott.product.service;

import com.juanmorschrott.product.dto.PriceRequestDto;
import com.juanmorschrott.product.dto.PriceResponseDto;
import com.juanmorschrott.product.exception.NotFoundException;
import com.juanmorschrott.product.model.Price;
import com.juanmorschrott.product.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponseDto checkOffer(PriceRequestDto priceRequestDto) {

        Price price = this.priceRepository.findByDateAndProductIdAndBrandId(priceRequestDto.getApplyDate(),
                priceRequestDto.getProductId(), priceRequestDto.getBrandId());

        PriceResponseDto priceResponseDto = null;

        if (price != null) {
            priceResponseDto = new PriceResponseDto();
            priceResponseDto.setProductId(price.getProductId());
            priceResponseDto.setBrandId(price.getBrandId());

            Period period = Period.between(price.getStartDate().toLocalDate(), price.getEndDate().toLocalDate());
            priceResponseDto.setPeriod("Price applied during: " + period.getMonths() + " months, " + period.getDays() + " days");

            priceResponseDto.setPrice(price.getPrice());
            priceResponseDto.setPriceList(price.getPriceList());
        } else {
            throw new NotFoundException();
        }

        return priceResponseDto;
    }

    @Override
    public List<Price> findAll() {
        return this.priceRepository.findAll();
    }

    @Override
    public Price findById(Long id) {
        return this.priceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Price create(Price price) {
        return this.priceRepository.save(price);
    }

    @Override
    public void delete(Long id) {
        Optional<Price> price = this.priceRepository.findById(id);

        if (price.isPresent())
            this.priceRepository.delete(price.get());
        else
            throw new NotFoundException();
    }
}
