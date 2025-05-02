package com.jiayulou.order.service;

import com.jiayulou.order.bean.Order;

public interface OrderService {

    Order createOrder(Long product, Long userId);
}
