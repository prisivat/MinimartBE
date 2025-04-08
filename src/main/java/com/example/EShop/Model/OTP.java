package com.example.EShop.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "otp")
@Data
public class OTP {

    @NotEmpty(message = "OTP is mandatory")
    private String otp;

    private String userName;

    private String createdAt;


}
