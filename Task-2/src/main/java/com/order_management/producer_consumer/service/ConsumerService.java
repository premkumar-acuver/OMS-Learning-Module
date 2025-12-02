package com.order_management.producer_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "order.created", groupId = "order-group")
    public void listen(String message) {
        System.out.println("Consumer received message: " + message);

    }
}
