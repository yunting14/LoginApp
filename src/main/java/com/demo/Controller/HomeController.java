package com.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.demo.Model.User;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String GoToHomePage(Model model, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("userInSession");
        model.addAttribute("user", user);
        return "Home";
    }
    
    @GetMapping("/manager")
    public String GetManagerInfo(){
        return "Manager";
    }
}
