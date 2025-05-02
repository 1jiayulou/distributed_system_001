package com.jiayulou.order.bean;

import com.jiayulou.product.bean.Product;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;

@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;

    public Order(Long id, BigDecimal totalAmount, Long userId, String nickName, String address, List<Product> productList) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.nickName = nickName;
        this.address = address;
        this.productList = productList;
    }
}
