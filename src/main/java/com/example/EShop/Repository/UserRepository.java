package com.example.EShop.Repository;

import com.example.EShop.Model.User;
import com.example.EShop.Model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


    Optional<User> findByPassword(String password);

    User findByUserName(String userName);

    User findByEmail(String email);

    User findByPhoneNumberAndEmail(String phoneNumber, String email);

}
