package com.task_21.OrderObject.producer;

import com.task_21.OrderObject.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final String topic = "order-topic";

    @Autowired
    public KafkaTemplate<Integer, Order> kafkaTemplate;

    public void sendOrder(Order order) {
        System.out.println("Producing Order" + order);
        kafkaTemplate.send(topic,order.getOrderId(),order);
    }


}
