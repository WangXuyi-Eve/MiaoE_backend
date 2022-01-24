package com.example.wrdemo.DaoImpl;
import com.example.wrdemo.Dao.UserDao;
import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.User;
import com.example.wrdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public int addOne(String username, String password, String e_mail, String avatar){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setE_mail(e_mail);
        user.setAvatar(avatar);
        user.setInputList(new LinkedList<>());
        user.setOutputList(new LinkedList<>());
        userRepository.save(user);
        return user.getUserId();
    }

    @Override
    public User Login(String username, String password){
        List<User> user = userRepository.findByUsername(username);
        User notFound = new User();
        notFound.setUserId(-1);
        if (user.isEmpty()) return notFound;
        if(user.get(0).getPassword().equals(password)){
            return user.get(0);
        }
        return notFound;
    }

    @Override
    public void modify(int id, String username, String avatar, String email){
        User user = userRepository.findByUserId(id);
        user.setAvatar(avatar);
        user.setUsername(username);
        user.setE_mail(email);
        userRepository.save(user);
    }
}
