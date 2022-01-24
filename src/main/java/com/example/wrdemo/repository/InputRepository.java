package com.example.wrdemo.repository;

import com.example.wrdemo.entity.Input;
import com.example.wrdemo.entity.Output;
import com.example.wrdemo.entity.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InputRepository extends JpaRepository<Input, Integer> {

}
