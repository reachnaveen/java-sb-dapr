package com.example.dapr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.dto.Order;

import io.dapr.Topic;

@RestController
public class SubscriberController {

    // pubsubName must match the component metadata.name
    // topic must match the topic you publish to
    @Topic(name = "orders", pubsubName = "servicebus-pubsub")
    @PostMapping(path = "/orders")
    @ResponseStatus(HttpStatus.OK)
    public void handleOrder(Order order) {
        System.out.println("Received order via Dapr: " + order);

    }

}
