package com.tcs.alert_service.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderShippment {

    private long id;
    private String orderId;

    private String customerId;
    private String status;

}
