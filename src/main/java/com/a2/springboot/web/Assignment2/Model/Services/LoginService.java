package com.a2.springboot.web.Assignment2.Model.Services;

import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.StaffService;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean userIsValid(String username, String password){
        return UserService.checkUser(username,password);

    }


    public boolean staffIsValid(String username, String password){
        return StaffService.checkStaff(username,password);
    }
}
