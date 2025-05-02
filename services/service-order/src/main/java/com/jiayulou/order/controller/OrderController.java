package com.jiayulou.order.controller;

import com.jiayulou.order.bean.Order;
import com.jiayulou.order.properties.OrderProperties;
import com.jiayulou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @RefreshScope //auto refresh
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    // @Value("${order.timeout}")
    // String orderTimeout;
    // @Value("${order.auto-confirm}")
    // String orderAutoConfirm;

    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/config")
    public String config(){
        return "order.timeout = " + orderProperties.getTimeout() +
                " order.auto-confirm = " + orderProperties.getAutoConfirm() +
                "order.db-url = " + orderProperties.getDbUrl();
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId, @RequestParam("productId")  Long productId) {
        Order order = orderService.createOrder(userId, productId);
        return order;
    }
}
