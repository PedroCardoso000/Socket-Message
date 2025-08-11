package com.main.project_socket.controller;

import com.main.project_socket.security.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitTestController {

    @Autowired
    private RabbitMQProducer producer;


    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage() {
        producer.sendMessage("Send Message!");
        return ResponseEntity.status(HttpStatus.OK).body("Send Message!");
    }
}

