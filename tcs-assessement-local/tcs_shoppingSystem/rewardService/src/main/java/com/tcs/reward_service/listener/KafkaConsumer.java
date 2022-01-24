package com.tcs.reward_service.listener;

import com.tcs.reward_service.model.Reward;
import com.tcs.reward_service.service.PublishService;
import com.tcs.reward_service.service.RewardService;
import com.tcs.reward_service.vo.OrderShipment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

   // private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    RewardService rewardService;
    @Autowired
    PublishService publishService;

   @KafkaListener(topics="topic-reward",groupId ="group_id",
           containerFactory = "shipKafkaListenerFactory")
    public void consumeShip(OrderShipment orderShipment){
        rewardService.generateReward(orderShipment);
    }

}
