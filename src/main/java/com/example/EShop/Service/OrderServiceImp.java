package com.example.EShop.Service;

import com.example.EShop.Model.Item;
import com.example.EShop.Model.Order;
import com.example.EShop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderServiceImp  implements OrderService{


    @Autowired
    OrderRepository orderRepository;

    @Override
    public void saveItems(Order order) {
        orderRepository.save(order);

    }
}
