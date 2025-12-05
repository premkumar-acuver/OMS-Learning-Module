package com.task_4.Task_4.service;

import com.task_4.Task_4.entity.OrderLifecycleDocument;
import com.task_4.Task_4.repository.OrderLifecycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderEventService {

    @Autowired
    private final OrderLifecycleRepository orderLifecycleRepository;


    public OrderEventService(OrderLifecycleRepository orderLifecycleRepository) {
        this.orderLifecycleRepository = orderLifecycleRepository;
    }

    public void saveEvent(String orderId, String eventType, Map<String, Object> eventData){
        OrderLifecycleDocument orderLifecycleDocument = OrderLifecycleDocument.builder()
                .orderId(orderId)
                .eventType(eventType)
                .eventData(eventData)
                .build();
        orderLifecycleRepository.save(orderLifecycleDocument);
    }
}
