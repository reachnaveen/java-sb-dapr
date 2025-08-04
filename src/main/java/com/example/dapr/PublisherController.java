package com.example.dapr;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.Order;

@RestController
@RequestMapping("/publish")
public class PublisherController {

    private final DaprClient daprClient = new DaprClientBuilder().build();
    private static final String PUBSUB_NAME = "servicebus-pubsub";
    private static final String TOPIC = "orders";

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody Order order) {
        daprClient.publishEvent(PUBSUB_NAME, TOPIC, order).block();
        return ResponseEntity.ok("Published order: " + order);
    }

}
