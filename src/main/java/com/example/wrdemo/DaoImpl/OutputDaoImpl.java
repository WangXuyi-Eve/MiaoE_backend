package com.example.wrdemo.DaoImpl;

import com.example.wrdemo.Dao.OutputDao;
import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.Output;
import com.example.wrdemo.entity.User;
import com.example.wrdemo.repository.OutputRepository;
import com.example.wrdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OutputDaoImpl implements OutputDao {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OutputRepository outputRepository;

    @Override
    public void SaveOutput(int user_id, String output, Timestamp time){
        User user = userRepository.findByUserId(user_id);
        Output newOutput = new Output();
        newOutput.setOutputContent(output);
        newOutput.setUser(user);
        newOutput.setOutputDate(time);
        outputRepository.save(newOutput);
    }

}
