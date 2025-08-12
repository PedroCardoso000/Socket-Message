package com.main.project_socket.controller;

import com.main.project_socket.entity.Notify;
import com.main.project_socket.service.RabbitMessageService;
import com.main.project_socket.service.rabbit.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private RabbitMQProducer producer;

    @Autowired
    private RabbitMessageService messageService;

    @PostMapping("/notify")
    public ResponseEntity<String> sendMessage(@RequestBody Notify body) {
        producer.sendMessage(body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    Get Last value
    @GetMapping("/last")
    public ResponseEntity<Notify> getLastMessage() {
        Notify last = messageService.getLastMessage();
        return (last != null) ? ResponseEntity.ok(last) : ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Notify>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }
}

