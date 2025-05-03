package com.main.project_socket.listener;

import com.main.project_socket.config.RabbitMQConfig;
import com.main.project_socket.model.ChatMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    private final SimpMessagingTemplate messagingTemplate;

    public RabbitMQListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}

