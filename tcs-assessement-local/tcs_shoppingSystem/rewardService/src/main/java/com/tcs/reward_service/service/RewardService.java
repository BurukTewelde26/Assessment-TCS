package com.tcs.reward_service.service;

import com.tcs.reward_service.model.Reward;
import com.tcs.reward_service.vo.OrderShipment;
import org.springframework.stereotype.Service;


public interface RewardService {
    void  generateReward(OrderShipment orderShipment);
}
