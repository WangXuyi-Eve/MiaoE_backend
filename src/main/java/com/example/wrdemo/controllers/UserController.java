package com.example.wrdemo.controllers;

import com.example.wrdemo.entity.User;
import com.example.wrdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public int Register(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String e_mail = map.get("e_mail");
        String avatar = map.get("avatar");
        int id = userService.addOne(username, password, e_mail, avatar);
        return id;
    }

    @CrossOrigin
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public User Login(@RequestParam(value="username") String username, @RequestParam(value = "password") String password) {
        return userService.Login(username, password);
    }

    @CrossOrigin
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public void modifyUser(@RequestBody Map<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        String avatar = map.get("avatar");
        String username = map.get("username");
        String email = map.get("email");
        userService.modify(id, username, avatar, email);
    }

}
