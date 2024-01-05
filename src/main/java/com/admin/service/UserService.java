package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.admin.entity.User;
import com.admin.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JavaMailSender javaMailSender;


    public String login(User user) {
        User storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }

    public String forgotPassword(User user) {
        User storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser != null) {
            
            sendPasswordResetEmail(storedUser.getEmail());

            return "Password reset link sent to " + storedUser.getEmail();
        } else {
            return "User not found";
        }
    }
    
    private void sendPasswordResetEmail(String userEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Password Reset Request");
        message.setText("Click on the link to reset your password: https://com/reset-password?user=" + userEmail);

        javaMailSender.send(message);
    }
}

