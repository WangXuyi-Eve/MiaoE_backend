package com.example.wrdemo.controllers;

import com.example.wrdemo.entity.User;
import com.example.wrdemo.service.ReviewService;
import com.example.wrdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.Output;

import java.util.List;
import java.util.Map;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @CrossOrigin
    @RequestMapping(value = "/reviewInput",method = RequestMethod.POST)
    public List<Input> ReviewInput(@RequestBody Map<String, String> map) {
        int userId = Integer.parseInt(map.get("user_id"));
        List<Input> reviewInput = reviewService.ReviewInput(userId);
        return reviewInput;
    }

    @CrossOrigin
    @RequestMapping(value = "/reviewOutput",method = RequestMethod.POST)
    public List<Output> ReviewOutput(@RequestBody Map<String, String> map) {
        int userId = Integer.parseInt(map.get("user_id"));
        List<Output> reviewOutput = reviewService.ReviewOutput(userId);
        return reviewOutput;
    }
}
