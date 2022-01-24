package com.example.wrdemo.serviceImpl;

import com.example.wrdemo.Dao.UserDao;
import com.example.wrdemo.entity.User;
import com.example.wrdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addOne(String username, String password, String e_mail, String avatar){
        return userDao.addOne(username, password, e_mail, avatar);
    }

    @Override
    public User Login(String username, String password){
        return userDao.Login(username, password);
    }

    @Override
    public void modify(int id, String username, String avatar, String email){
        userDao.modify(id, username, avatar, email);
    }
}
