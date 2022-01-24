package com.tcs.alert_service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {

    private Long id;
    private Long customerId;
    private Long orderId;
    private double amount;
}
