package com.demo.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.Model.User;
import com.demo.Service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("Validation starting");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.user.email", "Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.user.password", "Password is required");

        User user = (User) target;

        User userFromDb = userService.findUserByEmail(user.getEmail());
        if (userFromDb == null){
            errors.rejectValue("email", "error.user.email", "Email is invalid");
        }
        else if (!user.getPassword().isEmpty() && !userFromDb.getPassword().equals(user.getPassword())){
            errors.rejectValue("password", "error.user.password","Password incorrect");
        }
    }
    
}
