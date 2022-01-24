package com.example.wrdemo.serviceImpl;

import com.example.wrdemo.Dao.OutputDao;
import com.example.wrdemo.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OutputServiceImpl implements OutputService {
    @Autowired
    private OutputDao outputDao;

    @Override
    public void SaveOutput(int userId, String output, Timestamp time){
        outputDao.SaveOutput(userId,output,time);
    }
}
