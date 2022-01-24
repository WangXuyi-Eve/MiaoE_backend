package com.example.wrdemo.DaoImpl;

import com.example.wrdemo.Dao.ReviewDao;
import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.Output;
import com.example.wrdemo.entity.User;
import com.example.wrdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Input> ReviewInput(int userId){
        User user = userRepository.findByUserId(userId);
        return user.getInputList();
    }

    @Override
    public List<Output> ReviewOutput(int userId){
        User  user = userRepository.findByUserId(userId);
        return user.getOutputList();
    }
}
