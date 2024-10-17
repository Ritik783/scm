package com.scm.helper;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class SessionHelper {
    public static void removeAttributeFromSession()throws  Exception{
        try {
            System.out.println("*************************************");
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("message");
        }catch (Exception e){
            System.out.println("****************************");
            e.printStackTrace();
        }
    }
}
