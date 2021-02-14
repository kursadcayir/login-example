package com.springlogin.controller;

import com.springlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = { "/","/login"})
    public boolean login (@RequestParam(name = "u", required = true, defaultValue="") String username,
                              @RequestParam(name = "p", required = true, defaultValue="") String password)
    {
     return userService.login(username,password);
    }

}
