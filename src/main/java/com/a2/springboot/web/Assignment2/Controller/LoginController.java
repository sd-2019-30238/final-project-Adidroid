package com.a2.springboot.web.Assignment2.Controller;


import com.a2.springboot.web.Assignment2.Model.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginPage(ModelMap model){

        return "login";

    }


    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name,@RequestParam String password,ModelMap model){
        if(!loginService.userIsValid(name,password)){
            model.put("errorMessage","Invalid Credentials\n");
            return "login";
        }

        model.put("name",name);
        return "welcome";

    }


}
