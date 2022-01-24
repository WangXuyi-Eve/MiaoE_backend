package com.example.wrdemo.Dao;

import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.Output;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ReviewDao {
    List<Input> ReviewInput(int userId);
    List<Output> ReviewOutput(int userId);
}
