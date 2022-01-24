package com.tcs.shipping_service.service;

import com.tcs.shipping_service.model.OrderShipment;
import com.tcs.shipping_service.vo.Order;


import java.util.List;

public interface ShippingService {
    public OrderShipment  ship(OrderShipment orderShipment);
    public List<OrderShipment> getShippings();
    public void setStatusLabelCreated(Order order);
    void setStatusShipDispatched(Order order);
    void setStatusShipOnTheWay(Order order);
    void setStatusDelivered(Order order);
}
