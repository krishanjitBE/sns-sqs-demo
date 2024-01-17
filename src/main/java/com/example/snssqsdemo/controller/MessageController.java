package com.example.snssqsdemo.controller;

import com.example.snssqsdemo.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final SnsService snsService;

    @Autowired
    public MessageController(SnsService snsService) {
        this.snsService = snsService;
    }

    @GetMapping("/publish")
    public String publishMessage() {
        snsService.publishMessage("Hello from Spring Boot!");
        return "Message published to SNS";
    }
}

