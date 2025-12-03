package com.task_21.OrderObject.controller;

import com.task_21.OrderObject.entity.Order;
import com.task_21.OrderObject.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/order")
    public String sendOrder(@RequestBody Order order){
        orderProducer.sendOrder(order);
        return "Order sent successfully";
    }

}
