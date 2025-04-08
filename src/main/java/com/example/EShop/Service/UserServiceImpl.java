package com.example.EShop.Service;

import com.example.EShop.Exception.*;
import com.example.EShop.Model.*;
import com.example.EShop.Exception.*;
import com.example.EShop.Model.*;
import com.example.EShop.Repository.ForgotPasswordReqRepository;
import com.example.EShop.Repository.OTPRepository;
import com.example.EShop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;



@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncryptDecryptServiceImpl passwordEncryptDecryptService;

    @Autowired
    ForgotPasswordReqRepository forgotPasswordReqRepository;

    @Autowired
    OTPRepository otpRepository;


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void newUser(User user) {
        Optional<User> phoneVal = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        if(phoneVal.isPresent()) {
            throw new EmailAndPhoneNumberAlreadyExistsException("EmailId "+user.getEmail()+" is already registered with us. Please try to LogIn");
        }
        String upperCase = "(.*[A-Z].*)";
        String lowerCase = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String splChars = "(.*[@,#,$,%,&].*$)";
        String pswrd = user.getPassword();
        if (!pswrd.matches(upperCase) || !pswrd.matches(lowerCase) || !pswrd.matches(numbers) || !pswrd.matches(splChars) || pswrd.length()<8 || pswrd.contains(" ")){
            throw new PasswordInValidException("Password doesn't meet the requirements. Please try different one");
        }
        User user1;
        user1 = passwordEncryptDecryptService.passwordEncryption(user);
        userRepository.save(user1);
    }

    @Override
    public User userLogin(Login login) {
        User user = userRepository.findByEmail(login.getEmail());
        if(Objects.isNull(user)) {
            throw new UserNotFoundException("Email "+login.getEmail()+" please provide the valid user name or Please sign-up and try to login");
        }
        String password=passwordEncryptDecryptService.passwordDecryption(user.getPassword());
        if(!password.equals(login.getPassword())) {
            throw new PasswordIncorrectException("Password is incorrect. Please give correct password or reset your password by clicking forgot password");
        }
//        otp.setOtp(getOTP());
//        otp.setUserName(user.getUserName());

//        List<OTP> userExist = otpRepository.findByUserName(user.getUserName());
//        if(userExist.size() > 0){
//            otpRepository.deleteByUserName(user.getUserName());
//        }
//        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
//        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
//        otp.setCreatedAt(String.valueOf(localDateTime));
//        otpRepository.save(otp);
        return user;
    }

    @Override
    public User forgotUserName(ForgotRequest forgotRequest) {
        User user = userRepository.findByEmail(forgotRequest.getEmail());
        if(Objects.isNull(user)) {
            throw new UserNotFoundException("Email Id "+forgotRequest.getEmail()+" not found, Please provide the valid email");
        }
        return user;
    }

    @Override
    public ForgotPasswordRequest forgotPassword(ForgotPasswordRequest forgotRequest) {
        Optional<User> reg = Optional.ofNullable(userRepository.findByEmail(forgotRequest.getEmail()));
        if (!reg.isPresent()){
            throw new UserNotFoundException("Email Id "+forgotRequest.getEmail()+" not found, Please provide the valid email");
        }
        User user = userRepository.findByEmail(forgotRequest.getEmail());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        forgotRequest.setToken(generateToken());
        forgotRequest.setUser(user);
        forgotRequest.setCreatedAt(localDateTime);
        forgotPasswordReqRepository.save(forgotRequest);
        return forgotRequest;
    }

    @Override
    public String resetPassword(ResetPassword resetPassword) {
        Optional<ForgotPasswordRequest> validToken = Optional.ofNullable(forgotPasswordReqRepository.findByToken(resetPassword.getToken()));
        if(!validToken.isPresent()){
            throw new OTPExpiredException("Token has expired/invalid");
        }
        String upperCase = "(.*[A-Z].*)";
        String lowerCase = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String splChars = "(.*[@,#,$,%,&].*$)";
        String pswrd = resetPassword.getNewPassword();
        if (!pswrd.matches(upperCase) || !pswrd.matches(lowerCase) || !pswrd.matches(numbers) || !pswrd.matches(splChars) || pswrd.length()<8 || pswrd.contains(" ")){
            throw new PasswordInValidException("Password doesn't meet the requirements. Please try different one");
        }
        User user1 = validToken.get().getUser();
        user1.setPassword(pswrd);
        user1 = passwordEncryptDecryptService.passwordEncryption(user1);
        updateUser(user1.getUserName(), user1.getPassword());
        return "Password Reset Successfully";
    }

    @Override
    public void verifyOtp(OTP otp) {
        Optional<OTP> validateOtp = Optional.ofNullable(otpRepository.findByOtpAndUserName(otp.getOtp(), otp.getUserName()));
       LocalDateTime now  =  LocalDateTime.now();

        if(!validateOtp.isPresent()){
            throw new UserNotFoundException("OTP is Invalid.");
        } else if(LocalDateTime.parse(validateOtp.get().getCreatedAt()).plusMinutes(2).isBefore(now)){
            LocalDateTime now1 = LocalDateTime.now().minusMinutes(2);
            otpRepository.deleteByCreatedAtBefore(now1);
            throw new OTPExpiredException("OTP has Expired.");
        }

    }

    @Override
    public void changeUserName(ChangeUserName changeUserName) {
        User user = userRepository.findByUserName(changeUserName.getOldUserName());
        if(Objects.isNull(user)){
            throw new UserNotFoundException("Please provide the valid user name.");
        }
        User newUser = userRepository.findByUserName(changeUserName.getNewUserName());

        if(Objects.nonNull(newUser)){
            throw new UserNameAlreadyExistException("UserName Already Exist, Please try with different one.");
        }
        userRepository.deleteById(user.getUserName());
        user.setUserName(changeUserName.getNewUserName());
        userRepository.save(user);

    }

    private String generateToken() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder;
        Random random1 = new Random();

        stringBuilder = new StringBuilder();
        for (int j = 0; j < 6; j++) {
            int index = random1.nextInt(chars.length());
            stringBuilder.append(chars.charAt(index));
        }
    return stringBuilder.toString();
    }

    public void updateUser(String id, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(password);
        userRepository.save(user);
    }

    @Scheduled(fixedRate = 60000)
    public void deleteExpiredOTP(){
        LocalDateTime now = LocalDateTime.now().minusMinutes(10);
        forgotPasswordReqRepository.deleteByCreatedAtBefore(now);
    }

    public String getOTP(){
        String chars = "0123456789";
        StringBuilder stringBuilder;
        Random random1 = new Random();

        stringBuilder = new StringBuilder();
        for (int j = 0; j < 6; j++) {
            int index = random1.nextInt(chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();
    }
}
