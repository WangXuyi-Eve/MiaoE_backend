package com.example.wrdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "passage")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Passage {
    private String passageTitle;
    private List<Sentence> sentenceList;
    private int passageId;
    private int passageType;
    private List<Input> inputList;

    @Id
    @Column(name = "passage_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getPassageId(){ return this.passageId; }
    public void setPassageId(int passageId){ this.passageId = passageId;}

    @Basic
    @Column(name = "passage_title")
    public String getPassageTitle(){ return this.passageTitle; }
    public void setPassageTitle(String passageTitle){ this.passageTitle = passageTitle; }

    @OneToMany(mappedBy = "passage", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Input> getInputList() {return inputList;}
    public void setInputList(List<Input> newInputList) {this.inputList = newInputList;}


    @OneToMany(mappedBy = "passage", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Sentence> getSentenceList() {return sentenceList;}
    public void setSentenceList(List<Sentence> newSentenceList) {this.sentenceList = newSentenceList;}

    @Basic
    @Column(name = "passage_type")
    public int getPassageType(){return this.passageType;}
    public void setPassageType(int passageType){this.passageType = passageType;}

}
