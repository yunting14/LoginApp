package com.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.demo.Model.User;
import com.demo.Service.UserService;
import com.demo.Validator.UserValidator;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initUserBinder(WebDataBinder binder){
        binder.addValidators(userValidator);
    }

    @GetMapping("")
    public String Login(Model model, HttpServletRequest request){
        model.addAttribute("user", new User());
        return "Login";
    }

    @PostMapping("/login")
    public String LoginAuthentication(@ModelAttribute("user") @Valid User user, 
                                        BindingResult bindingResult, 
                                        Model model,
                                        HttpSession httpSession){
        if (bindingResult.hasErrors()){
            return "Login";
        }
        else{
            User userFromDb = userService.findUserByEmail(user.getEmail());
            httpSession.setAttribute("userInSession", userFromDb);
            return "redirect:/home";
        }
    }

    @GetMapping("/logout")
    public String Logout(HttpSession httpSession){
        httpSession.removeAttribute("userInSession");
        return "redirect:/";
    }
}
