package com.main.project_socket.service.rabbit;

import com.main.project_socket.config.RabbitMQConfig;
import com.main.project_socket.entity.Notify;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Notify body) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                body
        );
    }
}

