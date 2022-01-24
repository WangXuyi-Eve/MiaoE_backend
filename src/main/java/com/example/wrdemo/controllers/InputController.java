package com.example.wrdemo.controllers;

import com.example.wrdemo.entity.Sentence;
import com.example.wrdemo.service.InputService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class InputController {
    @Autowired
    InputService inputService;

    @CrossOrigin
    @RequestMapping(value = "/autoInput",method = RequestMethod.POST)
    public List<Sentence> AutoInput() {
        int passage_id = 1;
        //此处可以添加自动推荐语篇的算法，当前demo尚未开发此功能，故默认为1
        return inputService.getPassage(passage_id);
    }

    @CrossOrigin
    @RequestMapping(value = "/appointedInput",method = RequestMethod.POST)
    public List<Sentence> AppointedInput(@RequestBody Map<String, String> map) {
        int passageId = Integer.parseInt(map.get("passage_id"));
        return inputService.getPassage(passageId);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////查语料
    @CrossOrigin
    @RequestMapping(value = "/getPassageByType",method = RequestMethod.POST)
    public List<JSONObject> GetPassageByType(@RequestBody Map<String, String> map) {
        int passageType = Integer.parseInt(map.get("passage_type"));
        return inputService.getPassageByType(passageType);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////查单词
    @CrossOrigin
    @RequestMapping(value = "/getVocab",method = RequestMethod.POST)
    public JSONObject GetVocab(@RequestBody Map<String, String> map) {
        int vocabId = Integer.parseInt(map.get("vocab_id"));
        return inputService.getVocab(vocabId);
    }
    //////////////////////////////////////////////////////////////////////
    @CrossOrigin
    @RequestMapping(value = "/saveInput",method = RequestMethod.POST)
    public void SaveInput(@RequestBody Map<String, String> map) {
        int userId = Integer.parseInt(map.get("user_id"));
        int input = Integer.parseInt(map.get("input"));
        Long time = Long.parseLong(map.get("date"));
        Timestamp timestamp = new Timestamp(time);
        inputService.saveInput(userId, input, timestamp);
    }


}
