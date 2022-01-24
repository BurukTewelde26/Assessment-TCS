package com.tcs.shipping_service.model;

import com.tcs.shipping_service.model.enums.Status;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderShipment {

    @Id
    @GeneratedValue
    private long id;

    private Long orderId;
    private Long customerId;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
