package com.example.wrdemo.service;
import com.example.wrdemo.entity.Input;
import com.example.wrdemo.controllers.ReviewController;
import com.example.wrdemo.entity.Output;

import java.util.List;

public interface ReviewService {
    List<Input> ReviewInput(int userId);
    List<Output> ReviewOutput(int userId);
}
