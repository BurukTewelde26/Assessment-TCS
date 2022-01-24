package com.tcs.shipping_service.listener;

import com.tcs.shipping_service.service.ShippingService;
import com.tcs.shipping_service.vo.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private String MESSAGE = "Has been Created for Customer ID: ";

    @Autowired
    private ShippingService shippingService;

    @KafkaListener(topics="order",groupId ="group_id")
    public void consumeOrder(@Payload Order order) throws MessageConversionException {
        logger.info("Order ID:" + order.getId() + MESSAGE + order.getCustomerId() );

        shippingService.setStatusLabelCreated(order);
        shippingService.setStatusShipDispatched(order);
        shippingService.setStatusShipOnTheWay(order);
        shippingService.setStatusDelivered(order);

    }

}
