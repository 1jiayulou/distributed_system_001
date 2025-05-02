package com.jiayulou.product.service.impl;

import com.jiayulou.product.bean.Product;
import com.jiayulou.product.service.ProductService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    public Product getProductById(Long id) {
        Product product = new Product(id, new BigDecimal("99"), "iphone-"+id, 0);
        return product;
    }
}
