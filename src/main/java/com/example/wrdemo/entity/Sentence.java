package com.example.wrdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sentence")
//@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Sentence {
    private int sentenceId;
    private String sentenceContent;
    private List<Vocabulary> vocabList;
    private Passage passage;

    @Id
    @Column(name = "sentence_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getSentenceId(){ return this.sentenceId; }
    public void setSentenceId(int sentenceId){ this.sentenceId = sentenceId;}

    @Basic
    @Column(name = "sentence_content")
    public String getSentenceContent(){ return this.sentenceContent; }
    public void setSentenceContent(String sentenceContent){ this.sentenceContent = sentenceContent; }

    @OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Vocabulary> getVocabList() {return vocabList;}
    public void setVocabList(List<Vocabulary> newVocabList) {this.vocabList = newVocabList;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn( name = "passage_id")
    public Passage getPassage(){ return this.passage;}
    public void setPassage(Passage passage) {this.passage = passage;}
}
