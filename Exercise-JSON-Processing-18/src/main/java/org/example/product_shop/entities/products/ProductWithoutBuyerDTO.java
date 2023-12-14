package org.example.product_shop.entities.products;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface ProductWithoutBuyerDTO {
    String getName();
    BigDecimal getPrice();

    @Value("#{target.seller.firstName + ' ' + target.seller.lastName}")
    String getSeller();
}
