package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.Model.User;
import com.demo.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public User findUserByEmail(String email) {
        User userFromDb = userRepository.findByEmail(email);
        return userFromDb;
    }

    @Override
    public User saveUser(User user) {
        // String encodedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
    
}
