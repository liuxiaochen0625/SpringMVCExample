package com.ebaolife.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserService {
    public UserService(){
        System.out.println("UserService Constructor...\n\n\n\n\n\n");
    }
     
    public void save(){
        System.out.println("save");
    }
}
