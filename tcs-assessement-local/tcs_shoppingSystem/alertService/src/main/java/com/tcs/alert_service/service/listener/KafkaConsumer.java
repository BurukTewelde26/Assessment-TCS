package com.tcs.alert_service.service.listener;

import com.tcs.alert_service.vo.Order;
import com.tcs.alert_service.vo.OrderShippment;
import com.tcs.alert_service.vo.Reward;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private PublishService publishService;
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    public KafkaConsumer(PublishService publishService){
        super();
        this.publishService = publishService;
    }

    @KafkaListener(topics="order",groupId ="group_id",
            containerFactory="orderKafkaListenerContainerFactory")
    public void consumeOrder(Order order){
        logger.info("Order Info :" + order.getItemCode());
        publishService.publishOrderEvent(order);
    }

    @KafkaListener(topics="shippment",groupId = "group_json",
            containerFactory = "shipKafkaListenerContainerFactory")
    public void consumeShipping(OrderShippment orderShippment){
        publishService.publishShippingEvent(orderShippment);
    }
    @KafkaListener(topics="topic-reward",groupId = "group_json",
            containerFactory = "rewardKafkaListenerContainerFactory")
    public void consumeReward(Reward reward){
        publishService.publishRewardrEvent(reward);
    }

}
