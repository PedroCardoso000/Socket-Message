package com.main.project_socket.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfileBody(
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotBlank(message = "Email cannot be blank")
        String email,
        @NotBlank(message = "Phone cannot be blank")
        String phone
) {
    // This record class is used to encapsulate the profile data
    // It provides a concise way to define immutable data structures
    // with named fields.
    // The @NotBlank annotations ensure that the fields are not empty
}
