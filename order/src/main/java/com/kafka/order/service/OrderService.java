package com.kafka.order.service;

import com.kafka.order.domain.Order;

public interface OrderService {
    Order order(Order order);
}

