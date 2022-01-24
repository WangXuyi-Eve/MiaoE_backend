package com.example.wrdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private List<Input> inputList;
    private List<Output> outputList;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getUserId(){ return this.userId; }
    public void setUserId(int userId){ this.userId = userId;}

    @Basic
    @Column(name = "username")
    public String getUsername(){ return this.username; }
    public void setUsername(String username){ this.username = username; }

    @Basic
    @Column(name = "password")
    public String getPassword(){ return this.password; }
    public void setPassword(String password){ this.password = password; }

    @Basic
    @Column(name = "avatar")
    public String getAvatar(){return this.avatar;}
    public void setAvatar(String avatar){this.avatar = avatar;}

    @Basic
    @Column(name = "email")
    public String getE_mail(){ return this.email; }
    public void setE_mail(String email){ this.email = email; }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Input> getInputList() {return inputList;}
    public void setInputList(List<Input> newInputList) {this.inputList = newInputList;}

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Output> getOutputList() {return outputList;}
    public void setOutputList(List<Output> newOutputList) {this.outputList = newOutputList;}
}
