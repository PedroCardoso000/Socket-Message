package com.main.project_socket.entity;

import java.util.Objects;

public class ChatMessage {
    private String from;
    private String text;

    public ChatMessage(String from, String text) {
        this.from = from;
        this.text = text;
    }

    public ChatMessage(){}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(from, that.from) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, text);
    }
}
