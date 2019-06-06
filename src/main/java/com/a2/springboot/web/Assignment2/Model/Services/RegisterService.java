package com.a2.springboot.web.Assignment2.Model.Services;


import com.a2.springboot.web.Assignment2.Model.Data.Table;
import com.a2.springboot.web.Assignment2.Model.Data.User;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.UserService;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.HashSet;

@Service
public class RegisterService {

    public void register(String username,String password){
       User user=new User(username,password);
        UserService.addUser(user);

    }
}
