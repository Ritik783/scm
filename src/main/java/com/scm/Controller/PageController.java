package com.scm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.scm.Services.UserService;
import com.scm.forms.UserForm;
import com.scm.Entities.Provider;
import com.scm.Entities.UserDetail;

@Controller
public class PageController {
    @Autowired
    private UserService userService;


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
        UserForm userform = new UserForm();
        model.addAttribute("userform", userform);
        return "Signup";
    }
    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String doRegister(@ModelAttribute UserForm form){
        // fetch form data
        // UserDetail user = UserDetail.builder()
        // .name(form.getName())
        // .email(form.getEmail())
        // .password(form.getPassword())
        // .about(form.getAbout())
        // .phoneNumber(form.getPhoneNumber())
        // .profilePic("")
        // .provider(Provider.GITHUB)    
        // .build();
        UserDetail user = new UserDetail();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setAbout(form.getAbout());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setProfilePic(""); 
        user.setProvider(Provider.GITHUB);
        userService.saveuser(user);
        // validate form data
        // save form data
        // message = successfull
        // redirect
        return "redirect:/signup";
    }

}
