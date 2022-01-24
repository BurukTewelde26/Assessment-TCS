package com.tcs.order_service.api;

import com.tcs.order_service.exception.OrderNotCreatedException;
import com.tcs.order_service.model.Order;
import com.tcs.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/api/")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    private KafkaTemplate<String,Order> kafkaTemplate;
    private static final String TOPIC = "order";

    @PostMapping("order")
    public ResponseEntity<Object> placeOrder(@RequestBody Order order){
        HttpStatus status = HttpStatus.OK;
        String message = "Sorry Your Order Has not been Created";;
        Order newOrder =  (orderService.placeOrder(order));

        if(newOrder == null){
            status = HttpStatus.NOT_FOUND;
            try{
                kafkaTemplate.send(TOPIC, newOrder);
            }catch(KafkaException e){
               e.printStackTrace();
            }
            throw new OrderNotCreatedException();
          //return  new ResponseEntity<>("Order can not be created",status);
        }

         kafkaTemplate.send(TOPIC,newOrder);
        return new ResponseEntity<>("Order has been Plaeced Succefully",status);

    }
    @GetMapping("test")
    public String printTest(){
        return "API test Succefull";
    }

}
