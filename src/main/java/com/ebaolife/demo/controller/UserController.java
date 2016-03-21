package com.ebaolife.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebaolife.demo.model.User;
import com.ebaolife.demo.service.UserService;

@Controller
@RequestMapping("/integrate")
public class UserController {
    @Autowired
    private UserService userService;
     
    @RequestMapping("/user")
    public String saveUser(@RequestBody @ModelAttribute User u){
        System.out.println(u);
        userService.save();
        return "hello";
    }
}
