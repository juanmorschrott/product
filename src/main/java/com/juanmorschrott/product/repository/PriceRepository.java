package com.juanmorschrott.product.repository;

import com.juanmorschrott.product.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /*@Query("SELECT price FROM Price price WHERE price.startDate <= :applyDate AND price.endDate >= :applyDate AND " +
            "price.productId = :productId AND price.brandId = :brandId AND price.priority = (SELECT MAX(p2.priority) FROM Price p2)")
    Price findByDateAndProductIdAndBrandId(LocalDateTime applyDate, Long productId, Long brandId);*/

    @Query("SELECT price FROM Price price WHERE price.startDate <= :applyDate AND price.endDate >= :applyDate AND " +
            "price.productId = :productId AND price.brandId = :brandId AND price.priority = " +
            "(SELECT MAX(price2.priority) FROM Price price2 WHERE price2.startDate <= :applyDate AND price2.endDate >= :applyDate AND price2.productId = :productId AND price2.brandId = :brandId)")
    Price findByDateAndProductIdAndBrandId(LocalDateTime applyDate, Long productId, Long brandId);

}
