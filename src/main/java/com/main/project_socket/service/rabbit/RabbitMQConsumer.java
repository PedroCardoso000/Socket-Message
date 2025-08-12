package com.main.project_socket.service.rabbit;

import com.main.project_socket.config.RabbitMQConfig;
import com.main.project_socket.entity.Notify;
import com.main.project_socket.service.RabbitMessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private final RabbitMessageService rabbitMessageService;

    public RabbitMQConsumer(RabbitMessageService cacheService) {
        this.rabbitMessageService = cacheService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(Notify message) {
        rabbitMessageService.addMessage(message);
    }

}

