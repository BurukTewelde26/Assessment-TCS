package com.tcs.reward_service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderShipment {

    private Long id;
    private Long orderId;
    private Long customerId;
    private Status status;
}
