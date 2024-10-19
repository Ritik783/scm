package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
//    dashboard page
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String userdashboard(){
        return  "user/dashboard";
    }
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String userProfile(){
        return "user/profile";
    }
//    add contact page
//    view contact page
//    user edit contact page
//    contact delete
}
