package com.tcs.reward_service.controller;

import com.tcs.reward_service.model.Reward;
import com.tcs.reward_service.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RewardController {

   /* @Autowired
    RewardService rewardService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "topic-reward";

    @PostMapping("reward")
    public void generateShipping(@RequestBody Reward reward){
        Reward newShipped = rewardService.generateReward(reward);
        kafkaTemplate.send(TOPIC,"Customer Rewarded" + "=" + reward.getAmount() + "$" );
    }*/
}
