package com.example.EShop.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ChangeUserName {

    @NotEmpty(message = "old userName is mandatory")
    private String oldUserName;
    @NotEmpty(message = "new userName is mandatory")
    private String newUserName;

}
