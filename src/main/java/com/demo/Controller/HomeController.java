package com.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.demo.Model.User;
import com.demo.Service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    // added to test spring security
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
    //

    @GetMapping("/all")
    public String GoToHomePage(Model model, HttpSession httpSession){
        // User user = (User)httpSession.getAttribute("userInSession");
        
        // added for spring security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.findUserByEmail(email);
        // 

        // test
        auth.getAuthorities().stream().forEach(ga -> System.out.println(ga.getAuthority() + " | " + ga.getAuthority().getClass()));
        //

        model.addAttribute("user", user);
        return "Home";
    }
    
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @GetMapping("/manager")
    public String GetManagerInfo(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isManager = auth.getAuthorities().stream()
                                .anyMatch(a -> a.getAuthority().equals("ROLE_MANAGER"));
        boolean isAuth = auth.isAuthenticated();
        System.out.println("Is Manager? : " + isManager);
        System.out.println("Is Authenticated? : " + isAuth);

        return "Manager";
    }
}
