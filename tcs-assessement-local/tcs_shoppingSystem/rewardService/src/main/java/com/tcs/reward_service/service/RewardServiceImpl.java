package com.tcs.reward_service.service;

import com.tcs.reward_service.model.Reward;
import com.tcs.reward_service.repository.RewardRepository;
import com.tcs.reward_service.vo.OrderShipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService{

    @Autowired
    RewardRepository rewardRepository;
    @Autowired
    PublishService publishService;

    @Override
    public void generateReward(OrderShipment orderShipment) {
        double amount  = 10;
        Reward newReward= null;
        Long orderId = orderShipment.getOrderId();
        Long customerId = orderShipment.getCustomerId();

        if(!rewardRepository.existsByOrderId(orderId)){
             newReward = new Reward(orderId,customerId,amount);
        }
        rewardRepository.save(newReward);
        publishService.sendRewardEvent(newReward);
    }
}
