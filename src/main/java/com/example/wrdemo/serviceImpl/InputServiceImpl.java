package com.example.wrdemo.serviceImpl;

import com.example.wrdemo.Dao.InputDao;
import com.example.wrdemo.entity.Sentence;
import com.example.wrdemo.service.InputService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class InputServiceImpl implements InputService {
    @Autowired
    private InputDao inputDao;

    @Override
    public List<Sentence> getPassage(int passageId){return inputDao.GetPassage(passageId);}

    @Override
    public List<JSONObject> getPassageByType(int passageType){return inputDao.GetPassageByType(passageType);}

    @Override
    public JSONObject getVocab(int vocabId){return inputDao.GetVocab(vocabId);}

    @Override
    public void saveInput(int userId, int passageId, Timestamp time){ inputDao.SaveInput(userId,passageId,time);}

}
