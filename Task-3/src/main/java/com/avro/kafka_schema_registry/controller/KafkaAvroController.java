package com.avro.kafka_schema_registry.controller;


import com.avro.kafka_schema_registry.entity.OrderCreatedEvent;
import com.avro.kafka_schema_registry.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaAvroController {

    @Autowired
    private KafkaAvroProducer kafkaAvroProducer;

    @PostMapping("/events")
    public String sendMessage(@RequestBody OrderCreatedEvent orderCreatedEvent){
        kafkaAvroProducer.send(orderCreatedEvent);
        return "Message Sent Sucessfully";
    }




}
