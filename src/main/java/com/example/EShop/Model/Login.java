package com.example.EShop.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Login {
    @NotEmpty(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    private String password;

    }

