package com.tcs.reward_service.service;

import com.tcs.reward_service.model.Reward;
import com.tcs.reward_service.vo.OrderShipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    @Autowired
    KafkaTemplate kafkaTemplate;
    private static final String TOPIC_REWARD = "topic-reward";

    public void sendRewardEvent(Reward reward){
        kafkaTemplate.send(TOPIC_REWARD,reward);
    }
}
