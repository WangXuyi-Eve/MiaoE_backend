package com.example.wrdemo.Dao;

import com.example.wrdemo.entity.Sentence;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.List;

public interface InputDao {
    List<Sentence> GetPassage(int passageId);
    List<JSONObject> GetPassageByType(int passageType);
    JSONObject GetVocab(int vocabId);
    void SaveInput(int userId, int input, Timestamp time);
}
