package com.tcs.order_service.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;

    private String itemCode;
    private Long customerId;

}
