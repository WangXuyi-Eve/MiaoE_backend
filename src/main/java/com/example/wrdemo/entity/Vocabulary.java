package com.example.wrdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "vocabulary")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Vocabulary {
    private int vocabularyId;
    private String word;
    private String meaning;
    private String phonetics;
    private Sentence sentence;
    private int wordType;

    @Id
    @Column(name = "vocabulary_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getVocabularyId(){ return this.vocabularyId; }
    public void setVocabularyId(int vocabularyId){ this.vocabularyId = vocabularyId;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn( name = "sentence_id")
    public Sentence getSentence(){ return this.sentence;}
    public void setSentence(Sentence sentence) {this.sentence = sentence;}

    @Column(name ="word")
    public String getWord(){return this.word;}
    public void setWord(String word){this.word = word;}

    @Column(name ="meaning")
    public String getMeaning(){return this.meaning;}
    public void setMeaning(String meaning){this.meaning = meaning;}

    @Column(name ="phonetics")
    public String getPhonetics(){return this.phonetics;}
    public void setPhonetics(String phonetics){this.phonetics = phonetics;}

    @Column(name ="word_type")
    public int getWordType(){return this.wordType;}
    public void setWordType(int wordType){this.wordType = wordType;}
}
