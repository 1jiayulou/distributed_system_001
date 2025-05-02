package com.jiayulou.order.feign.fallback;

import com.jiayulou.order.feign.ProductFeignClient;
import com.jiayulou.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getProductById(Long id) {
        System.out.println("Fallback...");
        return new Product(999L,new BigDecimal(0.0) , "Unknown Product", 0);
    }
}
