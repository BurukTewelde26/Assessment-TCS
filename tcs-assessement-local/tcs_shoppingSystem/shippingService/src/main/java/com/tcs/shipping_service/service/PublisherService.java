package com.tcs.shipping_service.service;

import com.tcs.shipping_service.model.OrderShipment;
import com.tcs.shipping_service.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    ShippingRepository shippingRepository;
    private KafkaTemplate<String,OrderShipment> kafkaTemplate;
    private static final String TOPIC_SHIP = "shippment";
    private static final String TOPIC_REWARD = "topic-reward";

    public void publishShipLabelCreated(OrderShipment orderShipment) {
        kafkaTemplate.send(TOPIC_SHIP, orderShipment);
    }

    public void publishShipDispatched(OrderShipment orderShipment) {
        kafkaTemplate.send(TOPIC_SHIP, orderShipment);
    }

    public void publishShipOnTheWay(OrderShipment orderShipment) {
        kafkaTemplate.send(TOPIC_SHIP, orderShipment);
    }

    public void publishDelivered(OrderShipment orderShipment) {
        kafkaTemplate.send(TOPIC_REWARD, orderShipment);
    }
}
