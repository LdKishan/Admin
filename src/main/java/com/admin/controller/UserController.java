package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.admin.entity.User;
import com.admin.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
       return userService.login(user);
    }
    
    @GetMapping("/get")
    public ModelAndView loginShow() {
      //  return userService.login(user);
         ModelAndView mov=new ModelAndView();
       mov.setViewName("/index.html");
      return mov;
     }

    @GetMapping("/forgot-password.html")
    public ModelAndView forgotShow() {
      //  return userService.login(user);
         ModelAndView mov=new ModelAndView();
       mov.setViewName("/forgot-password.html");
      return mov;
     }
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody User user) {
        return userService.forgotPassword(user);
    }
}
