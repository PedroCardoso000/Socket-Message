package com.main.project_socket.controller;

import com.main.project_socket.model.ChatMessage;
import com.main.project_socket.service.MessagePublisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final MessagePublisher publisher;

    public ChatController(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    @MessageMapping("/chat") // Cliente envia para /app/chat
    public void handleMessage(ChatMessage message) {
        publisher.publish(message); // envia para RabbitMQ
    }
}
