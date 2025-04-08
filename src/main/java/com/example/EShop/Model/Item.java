package com.example.EShop.Model;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Item {

    @NotEmpty
    private String name;
    @NotEmpty
    private String price;
    @NotEmpty
    private String quantity;
    @NotEmpty
    private String id;
}
