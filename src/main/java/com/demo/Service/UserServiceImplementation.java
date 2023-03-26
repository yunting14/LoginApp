package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.User;
import com.demo.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        User userFromDb = userRepository.findByEmail(email);
        return userFromDb;
    }
    
}
