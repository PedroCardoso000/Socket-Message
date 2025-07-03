package com.main.project_socket.entity.dto;

import jakarta.validation.constraints.*;

public record ProfileBody(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
        String name,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        @Size(max = 100, message = "Email pode ter no máximo 100 caracteres")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        @Size(min = 8, max = 20, message = "Telefone deve ter entre 8 e 20 caracteres")
        String phone
) {
    // This record class is used to encapsulate the profile data
    // It provides a concise way to define immutable data structures
    // with named fields.
}
