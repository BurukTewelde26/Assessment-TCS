package com.tcs.reward_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reward {

    @Id
    @GeneratedValue
    private long id;

    private Long customerId;

    public Reward(Long customerId, Long orderId, double amount) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.amount = amount;
    }

    private Long orderId;
    private double amount;

}
