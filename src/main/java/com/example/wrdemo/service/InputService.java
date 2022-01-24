package com.example.wrdemo.service;

import com.example.wrdemo.entity.Sentence;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.List;

public interface InputService {
    List<Sentence> getPassage(int passageId);
    List<JSONObject> getPassageByType(int passageType);
    JSONObject getVocab(int vocabId);
    void saveInput(int userId, int passageId, Timestamp time);
}
