package com.main.project_socket.entity;

import com.main.project_socket.enums.TypeNotify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notify implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String title;
    private String message;
    private TypeNotify typeNotify;
}
