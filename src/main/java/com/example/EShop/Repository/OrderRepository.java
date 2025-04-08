package com.example.EShop.Repository;

import com.example.EShop.Model.Item;
import com.example.EShop.Model.OTP;
import com.example.EShop.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {


}
