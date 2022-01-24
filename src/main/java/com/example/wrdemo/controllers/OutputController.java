package com.example.wrdemo.controllers;

import com.example.wrdemo.entity.Input;
import com.example.wrdemo.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class OutputController {
    @Autowired
    OutputService outputService;

    @CrossOrigin
    @RequestMapping(value = "/saveOutput",method = RequestMethod.POST)
    public void SaveOutput(@RequestBody Map<String, String> map) {
        int userId = Integer.parseInt(map.get("user_id"));
        String output = map.get("output");
        Long time = Long.parseLong(map.get("date"));
        Timestamp date = new Timestamp(time);
        outputService.SaveOutput(userId, output, date);
    }
}
