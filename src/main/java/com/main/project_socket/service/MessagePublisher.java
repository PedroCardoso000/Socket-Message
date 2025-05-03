package com.main.project_socket.service;

import com.main.project_socket.config.RabbitMQConfig;
import com.main.project_socket.model.ChatMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher  {
    private final AmqpTemplate rabbitTemplate;

    public MessagePublisher(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(ChatMessage message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE, message);
    }
}
