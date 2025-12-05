package com.task_4.Task_4.repository;

import com.task_4.Task_4.entity.OrderLifecycleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLifecycleRepository extends MongoRepository<OrderLifecycleDocument, Integer> {
}
