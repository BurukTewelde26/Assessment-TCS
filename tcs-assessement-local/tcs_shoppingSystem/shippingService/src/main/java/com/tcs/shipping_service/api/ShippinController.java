package com.tcs.shipping_service.api;

import com.tcs.shipping_service.exception.ShippingRecordNotCreatedException;
import com.tcs.shipping_service.model.OrderShipment;
import com.tcs.shipping_service.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ShippinController {


   /* @PostMapping("label")
    public ResponseEntity<Object> generateShipping(@RequestBody OrderShipment orderShipment){
       OrderShipment newShipped = shippingService.generateShippingLabel(orderShipment);
       if(newShipped == null){
           return new ResponseEntity<>(new ShippingRecordNotCreatedException(), HttpStatus.NOT_FOUND);
       }
       String message = "Label has been Created for Order" + " : " + orderShipment.getOrderId();
       kafkaTemplate.send(TOPIC,message);
       return new ResponseEntity<>("Shippment Record Succefully Created", HttpStatus.OK);
        OrderShipment newShipped =  shippingService.ship(orderShipment);
        if(newShipped == null){
            return new ResponseEntity<>(new ShippingRecordNotCreatedException(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Shippment Record Succefully Created", HttpStatus.OK);
    }*/
    @GetMapping("test")
    public String printMessage(){
        return "test-shipping";
    }


}
