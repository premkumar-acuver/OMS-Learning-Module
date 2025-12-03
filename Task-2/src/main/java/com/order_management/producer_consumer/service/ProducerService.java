package com.order_management.producer_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) {
        String topicName = "order.created";
        kafkaTemplate.send(topicName, message);
        System.out.println("Producer sent message: " + message);
    }
}
