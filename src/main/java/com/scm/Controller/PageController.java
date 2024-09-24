package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
    @RequestMapping("/home")
    public String homeController(Model model){
        System.out.println("this is the home");
        // model.addAttribute("name","Technology");
        // model.addAttribute("Github","https://github.com/Ritik783/CodeClause_Product_landing_page");
        // model.addAttribute("Leetcode","https://leetcode.com/u/ritik78/");
        return "home";
    }
    // about 
    @RequestMapping("/about")
    public String aboutPagelayout(Model model){
        model.addAttribute("isLogin",false);
        return "about";
    }

    // about service
    @RequestMapping("/services")
    public String servicePage(){
        return "services";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        return "Contact";
    }
    
    @RequestMapping("/login")
    public String loginPage(Model model) {
        return "Login";
    }

    @RequestMapping("/signup")
    public String signupPage(Model model) {
        return "Signup";
    }
    
    


}
