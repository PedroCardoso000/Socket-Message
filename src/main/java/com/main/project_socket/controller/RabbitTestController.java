package com.main.project_socket.controller;

import com.main.project_socket.security.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitTestController {

    @Autowired
    private RabbitMQProducer producer;


    @GetMapping("/send")
    public String sendMessage() {
        producer.sendMessage("Olá, RabbitMQ!");
        return "Mensagem enviada!";
    }
}

