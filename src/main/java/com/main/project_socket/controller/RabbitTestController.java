package com.main.project_socket.controller;

import com.main.project_socket.service.rabbit.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitTestController {

    @Autowired
    private RabbitMQProducer producer;


    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body("Send Message!");
    }
}

