package com.example.EShop.Controller;


import com.example.EShop.Exception.*;
import com.example.EShop.Model.*;
import com.example.EShop.Repository.OTPRepository;
import com.example.EShop.Service.EmailService;
import com.example.EShop.Service.OrderService;
import com.example.EShop.Service.PasswordEncryptDecryptServiceImpl;
import com.example.EShop.Service.UserService;
import jakarta.validation.Valid;
import com.example.EShop.Exception.*;

import com.example.EShop.Model.*;
import com.example.EShop.Repository.ForgotPasswordReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/saveOrder")
    public ResponseEntity<String> newUser(@Valid @RequestBody Order order){
        try {
            orderService.saveItems(order);
        }
        catch (Exception e){
            return new ResponseEntity<>("Please enter Valid Email ID", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Order Placed.",HttpStatus.OK);
    }
}

