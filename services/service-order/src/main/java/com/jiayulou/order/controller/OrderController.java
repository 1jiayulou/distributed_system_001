package com.jiayulou.order.controller;

import com.jiayulou.order.bean.Order;
import com.jiayulou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId, @RequestParam("productId")  Long productId) {
        Order order = orderService.createOrder(userId, productId);
        return order;
    }
}
