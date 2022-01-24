package com.tcs.order_service.service;

import com.tcs.order_service.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order placeOrder(Order order);
    public List<Order> getOrders();
}
