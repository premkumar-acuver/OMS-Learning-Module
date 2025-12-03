package com.avro.kafka_schema_registry.consumer;

import com.avro.kafka_schema_registry.entity.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroConsumer {


    private static final Logger log = LoggerFactory.getLogger(KafkaAvroConsumer.class);
    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, OrderCreatedEvent> consumerRecord) {
        String key = consumerRecord.key();
        OrderCreatedEvent value = consumerRecord.value();


        if (value == null) {
            log.warn("Skipping message with Key: '{}' because it is null/failed deserialization.", key);
            return;
        }


        log.info("Avro message received. Key: {}, Value: {}", key, value.toString());
    }
}