package com.tcs.shipping_service.repository;

import com.tcs.shipping_service.model.OrderShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShippingRepository extends JpaRepository<OrderShipment,Long> {
    OrderShipment findOrderShipmentByOrderId(Long orderId);
}
