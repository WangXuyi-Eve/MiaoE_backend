package com.example.wrdemo.service;

import com.example.wrdemo.entity.User;

public interface UserService {
    int addOne(String username, String password, String e_mail, String avatar);
    User Login(String username, String password);
    void modify(int id, String username, String avatar, String email);
}
