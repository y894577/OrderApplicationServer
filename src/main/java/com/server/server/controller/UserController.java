package com.server.server.controller;

import com.server.server.entity.User;
import com.server.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/login")
    public List<User> getUser(@RequestParam("userID") String userID,
                              @RequestParam("userPwd") String userPwd) {
        return userRepository.findUserByUserIDAndAndUserPwd(userID, userPwd);
    }

    @PostMapping(value = "/register")
    public List<User> register(@RequestParam("userID") String userID,
                               @RequestParam("userName") String userName,
                               @RequestParam("userPwd") String userPwd) {
        User user = new User();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        userRepository.save(user);
        return userRepository.findAll();
    }



}
