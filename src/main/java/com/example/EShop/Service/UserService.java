package com.example.EShop.Service;


import com.example.EShop.Model.*;
import com.example.EShop.Model.*;

public interface UserService {
    void newUser(User user);

    User userLogin(Login login);

    User forgotUserName(ForgotRequest forgotRequest);

    ForgotPasswordRequest forgotPassword(ForgotPasswordRequest forgotRequest);

    String resetPassword(ResetPassword resetPassword);

    void verifyOtp(OTP otp);

    void changeUserName(ChangeUserName changeUserName);
}
