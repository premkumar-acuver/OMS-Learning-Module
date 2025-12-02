package com.order_management.producer_consumer.controller;

import com.order_management.producer_consumer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ProducerService producerService;



    @PostMapping
    public String createOrder(@RequestBody String orderDetails) {
        producerService.sendMessage(orderDetails);
        return "Order request sent to Kafka!";
    }
}
