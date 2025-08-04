package com.example;

import org.springframework.web.bind.annotation.GetMapping;

public class AzureEventhubListenerApplication {

    @GetMapping("/health")
    public String healthCheck() {
        return "Service is running";
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(AzureEventhubListenerApplication.class, args);
    }
}
