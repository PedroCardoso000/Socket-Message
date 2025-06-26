package com.main.project_socket.entity;

import lombok.*;

import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ChatMessage {
    private String from;
    private String text;
}
