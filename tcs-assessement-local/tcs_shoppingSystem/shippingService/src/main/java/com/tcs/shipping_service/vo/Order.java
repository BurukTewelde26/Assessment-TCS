package com.tcs.shipping_service.vo;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private Long id;
    private String itemCode;
    private Long customerId;
}
