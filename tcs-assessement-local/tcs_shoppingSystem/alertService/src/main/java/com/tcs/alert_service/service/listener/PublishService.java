package com.tcs.alert_service.service.listener;

import com.tcs.alert_service.vo.Order;
import com.tcs.alert_service.vo.OrderShippment;
import com.tcs.alert_service.vo.Reward;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PublishService {

    private static Logger logger = LoggerFactory.getLogger(PublishService.class);


    public void publishShippingEvent(OrderShippment orderShippment){
        logger.info("Shipping Info :" + orderShippment.toString());
    }
    public void publishOrderEvent(Order order){
        logger.info("Order Info :" + order.toString());
    }
    public void publishRewardrEvent(Reward reward){
        logger.info("Reward Info :" + reward.toString());
    }

}
