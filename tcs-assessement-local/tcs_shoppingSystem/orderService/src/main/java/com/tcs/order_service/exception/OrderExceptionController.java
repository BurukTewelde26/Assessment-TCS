package com.tcs.order_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {
    @ExceptionHandler(value = OrderNotCreatedException.class)
    public ResponseEntity<Object> exception(OrderNotCreatedException exception){
      return new ResponseEntity<>("Order Not Created", HttpStatus.NOT_FOUND);
    }
}
