package com.avro.kafka_schema_registry.producer;

import com.avro.kafka_schema_registry.entity.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, OrderCreatedEvent> template;

    public void send(OrderCreatedEvent orderCreatedEvent){
        CompletableFuture<SendResult<String, OrderCreatedEvent>> send = template.send(topicName, orderCreatedEvent);
        send.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + orderCreatedEvent +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        orderCreatedEvent + "] due to : " + ex.getMessage());
            }
        });


    }


}
