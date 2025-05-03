package com.main.project_socket.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE = "chat-messages";

    @Bean
    public Queue chatQueue() {
        return new Queue(QUEUE, false);
    }
}
