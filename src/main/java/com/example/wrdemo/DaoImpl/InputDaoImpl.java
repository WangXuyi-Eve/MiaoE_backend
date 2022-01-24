package com.example.wrdemo.DaoImpl;

import com.example.wrdemo.Dao.InputDao;
import com.example.wrdemo.entity.*;
import com.example.wrdemo.repository.*;
import com.sun.tools.corba.se.idl.constExpr.Times;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Repository
public class InputDaoImpl implements InputDao {
    @Autowired
    private PassageRepository passageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VocabularyRepository vocabularyRepository;

    @Autowired
    private InputRepository inputRepository;

    @Override
    public List<Sentence> GetPassage(int passageId){
        Passage passage = passageRepository.findByPassageId(passageId);
        return passage.getSentenceList();
    }

    @Override
    public List<JSONObject> GetPassageByType(int passageType){
        List<JSONObject> passages = new LinkedList<>();
        List<Passage> passageList = passageRepository.findByPassageType(passageType);
        for (int i = 0; i < passageList.size(); ++i){
            Passage passage = passageList.get(i);
            JSONObject obj = new JSONObject();
            obj.put("passage_id", passage.getPassageId());
            obj.put("passage_title", passage.getPassageTitle());
            passages.add(obj);
        }
        return passages;
    }

    @Override
    public JSONObject GetVocab(int vocab_id){
        JSONObject vocab = new JSONObject();
        Vocabulary vocabulary = vocabularyRepository.findByVocabularyId(vocab_id);
        vocab.put("word",vocabulary.getWord());
        vocab.put("meaning",vocabulary.getMeaning());
        vocab.put("phonetics",vocabulary.getPhonetics());
        Sentence sentence = vocabulary.getSentence();
        vocab.put("sentence", sentence.getSentenceContent());
        return vocab;
    }

    @Override
    public void SaveInput(int user_id, int input, Timestamp time){
        User user = userRepository.findByUserId(user_id);
        Passage passage = passageRepository.findByPassageId(input);
        Input newInput = new Input();
        newInput.setPassage(passage);
        newInput.setUser(user);
        newInput.setInputDate(time);
        inputRepository.save(newInput);
    }
}
