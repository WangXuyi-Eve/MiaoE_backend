package com.example.wrdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_output_sentence")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Output {
    private int outputId;
    private String outputContent;
    private Timestamp outputDate;
    private User user;

    @Id
    @Column(name = "output_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getOutputId(){ return this.outputId; }
    public void setOutputId(int outputId){ this.outputId = outputId;}

    @ManyToOne
    @JsonIgnore
    @JoinColumn( name = "user_id")
    public User getUser(){ return this.user;}
    public void setUser(User user) {this.user = user;}

    @Column(name ="output_content")
    public String getOutputContent(){return this.outputContent;}
    public void setOutputContent(String  outputContent){this.outputContent=outputContent;}

    @Column(name ="output_date")
    public Timestamp getOutputDate(){return this.outputDate;}
    public void setOutputDate(Timestamp outputDate){this.outputDate=outputDate;}
}
