package com.demo.Service;

import com.demo.Model.User;

public interface UserService {
    public User findUserByEmail(String email);
}
