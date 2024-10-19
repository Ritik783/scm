package com.scm.Controller;

import com.scm.helper.Message;
import com.scm.helper.MessageType;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("userform", new UserForm());
        return "Signup";
    }
    @RequestMapping(value="/doRegister", method=RequestMethod.POST)
    public String doRegister(@Valid  @ModelAttribute("userform") UserForm form, BindingResult result,
                             HttpSession session){
        // validate form data
        if(result.hasErrors()){
            return "Signup";
        }
        // fetch form data
        UserDetail user = new UserDetail();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setAbout(form.getAbout());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setProfilePic(""); 
        user.setProvider(Provider.GITHUB);
        userService.saveuser(user);
        Message printMessage =
                Message.builder().content("Registration Successfully").messageType(MessageType.Blue).build();
        session.setAttribute("message",printMessage);

        // message = successfull
        // redirect
        return "redirect:/signup";
    }

}
