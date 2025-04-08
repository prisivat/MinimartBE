package com.example.EShop.Service;

import com.example.EShop.Model.ForgotPasswordRequest;
import com.example.EShop.Model.ForgotRequest;
import com.example.EShop.Model.User;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import com.example.EShop.Model.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class EmailService {

    final Configuration configuration;
    final JavaMailSender javaMailSender;

    public EmailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(User user) throws MessagingException {//done
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setSubject("Minimart Registration Success");
        helper.setTo(user.getEmail());
        String emailContent = EmailTemplate.getRegistrationSuccessTemplate(user);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }


    public void sendUserName(ForgotRequest forgotRequest, User user, String forgotUserName) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setSubject("Minimart - UserName ");
        helper.setTo(forgotRequest.getEmail());
        String emailContent = EmailTemplate.getForgotUserNameTemplate(user);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendPassword(ForgotPasswordRequest forgotRequest) throws MessagingException, IOException, TemplateException {
        //todo add reset link in mail
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setSubject("Minimart - Reset Password");
        helper.setTo(forgotRequest.getEmail());
        String content = EmailTemplate.getForgotPassTemplate(forgotRequest.getToken());
        helper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendOTPEmail(User user, String otp) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setSubject("Minimart login OTP.");
        helper.setTo(user.getEmail());
        String emailContent = EmailTemplate.getLoginSuccess(user,otp);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

}