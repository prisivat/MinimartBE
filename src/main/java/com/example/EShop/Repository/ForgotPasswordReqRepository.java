package com.example.EShop.Repository;


import com.example.EShop.Model.ForgotPasswordRequest;
import com.example.EShop.Exception.*;
import com.example.EShop.Model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ForgotPasswordReqRepository  extends MongoRepository<ForgotPasswordRequest, String> {

    ForgotPasswordRequest findByToken(String token);
    void deleteByToken(String token);

    void deleteByCreatedAtBefore(LocalDateTime now);
}
