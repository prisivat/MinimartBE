package com.example.EShop.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "order")
public class Order {

    @Id
    @JsonIgnore
    private String orderId = UUID.randomUUID().toString().substring(0, 8);

    private String email;

    private List<Item> items;
}
