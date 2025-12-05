package com.task_4.Task_4.controller;

import com.task_4.Task_4.entity.OrderLifecycleDocument;
import com.task_4.Task_4.service.OrderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderEventService orderEventService;

    @PostMapping("/publishEvent")
    public ResponseEntity<Map<String, String>> publishEvent(@RequestBody OrderLifecycleDocument orderLifecycleDocument){
        orderEventService.saveEvent(orderLifecycleDocument.getOrderId(), orderLifecycleDocument.getEventType(), orderLifecycleDocument.getEventData());

        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", "Event '" + orderLifecycleDocument.getEventType() + "' recorded for Order " + orderLifecycleDocument.getOrderId());
        response.put("timestamp", java.time.Instant.now().toString());
        return ResponseEntity.ok(response);
    }
}
