package com.example.wrdemo.repository;

import com.example.wrdemo.entity.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassageRepository extends JpaRepository<Passage, Integer> {
    Passage findByPassageId(int passageId);
    List<Passage> findByPassageType(int passageType);
}
