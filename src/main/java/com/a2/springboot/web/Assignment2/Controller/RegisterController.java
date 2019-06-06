package com.a2.springboot.web.Assignment2.Controller;

import com.a2.springboot.web.Assignment2.Model.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(value="/register")
    public String registerPage(){
        return "register";
    }

    @RequestMapping(value="/registerConfirmation")
    public String registerConfirmationPage(@RequestParam String name,@RequestParam String password, ModelMap model){
        model.put("name",name);

        registerService.register(name,password);
        return "registerConfirmation";
    }

}
