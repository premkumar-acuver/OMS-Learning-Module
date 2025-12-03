package com.task_21.OrderObject.consumer;

import com.task_21.OrderObject.entity.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-topic", groupId = "order-group-v1")
    public void consumeOrder(Order order){
        System.out.println("Consuming Order" + order);
        System.out.println("Processing amount : " + order.getAmount());
        System.out.println("Processing product : " + order.getProduct());
    }
}
