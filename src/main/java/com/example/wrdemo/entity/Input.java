package com.example.wrdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_input_passage")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Input {
    private int inputId;
    private Passage passage;
    private Timestamp inputDate;
    private User user;

    @Id
    @Column(name = "input_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getInputId(){ return this.inputId; }
    public void setInputId(int inputId){ this.inputId = inputId;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn( name = "user_id")
    public User getUser(){ return this.user;}
    public void setUser(User user) {this.user = user;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name ="passage_id")
    public Passage getPassage(){return this.passage;}
    public void setPassage(Passage passage){this.passage = passage;}

    @Column(name ="input_date")
    public Timestamp getInputDate(){return this.inputDate;}
    public void setInputDate(Timestamp input_date){this.inputDate=inputDate;}
}
