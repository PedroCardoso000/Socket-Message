package com.main.project_socket.service;

import com.main.project_socket.entity.Notify;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitMessageService {

    private final List<Notify> messages = new ArrayList<>();

    public void addMessage(Notify message) {
        messages.add(message);
    }

    public List<Notify> getAllMessages() {
        return new ArrayList<>(messages);
    }

    public Notify getLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.getLast();
    }
}
