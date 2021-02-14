package com.springlogin.service;

import com.springlogin.model.User;

public interface UserService {

    public User saveUser(User user);
    public boolean login(String email, String password);
}
