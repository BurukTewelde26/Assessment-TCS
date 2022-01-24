package com.tcs.shipping_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShippmentExceptionController {

    @ExceptionHandler(value = ShippingRecordNotCreatedException.class)
    public ResponseEntity<Object> exception(ShippingRecordNotCreatedException exception){
        return new ResponseEntity<>("Shipping Record Not Created", HttpStatus.NOT_ACCEPTABLE);
    }
}
