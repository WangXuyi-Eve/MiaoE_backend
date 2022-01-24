package com.example.wrdemo.serviceImpl;

import com.example.wrdemo.Dao.ReviewDao;
import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.Output;
import com.example.wrdemo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;

    @Override
    public List<Input> ReviewInput(int userId){
        return reviewDao.ReviewInput(userId);
    }

    @Override
    public List<Output> ReviewOutput(int userId){
        return reviewDao.ReviewOutput(userId);
    }

}
