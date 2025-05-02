package com.jiayulou.product.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;

    public Product(Long id, BigDecimal price, String productName, int num) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.num = num;
    }
}
