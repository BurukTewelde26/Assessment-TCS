package com.tcs.shipping_service.service;

import com.tcs.shipping_service.model.OrderShipment;
import com.tcs.shipping_service.model.enums.Status;
import com.tcs.shipping_service.repository.ShippingRepository;
import com.tcs.shipping_service.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService{

    @Autowired
    ShippingRepository shippingRepository;
    @Autowired
    PublisherService publisherService;

    @Override
    public OrderShipment ship(OrderShipment orderShipment) {
        return shippingRepository.save(orderShipment);
    }

    @Override
    public List<OrderShipment> getShippings() {
        return shippingRepository.findAll();
    }

    @Override
    public void setStatusLabelCreated(Order order) {
        OrderShipment orderShipment = shippingRepository.findOrderShipmentByOrderId(order.getId());
        if(orderShipment == null){
            publisherService.publishShipLabelCreated(orderShipment);
        }
        orderShipment.setStatus(Status.LABEL_CREATED);

    }

    @Override
    public void setStatusShipDispatched(Order order) {

        OrderShipment orderShipment = shippingRepository.findOrderShipmentByOrderId(order.getId());
        if(orderShipment !=  null){
            publisherService.publishShipDispatched(orderShipment);
            orderShipment.setStatus(Status.ITEM_DISPATCHED);
        }
    }

    @Override
    public void setStatusShipOnTheWay(Order order) {
        OrderShipment orderShipment = shippingRepository.findOrderShipmentByOrderId(order.getId());
        if(orderShipment != null){
            publisherService.publishShipOnTheWay(orderShipment);
            orderShipment.setStatus(Status.ITEM_ON_THE_WAY);
        }
    }

    @Override
    public void setStatusDelivered(Order order) {
        OrderShipment orderShipment = shippingRepository.findOrderShipmentByOrderId(order.getId());
        if(orderShipment != null){
            publisherService.publishDelivered(orderShipment);
            orderShipment.setStatus(Status.ITEM_DELIVERED);
        }
    }
}
