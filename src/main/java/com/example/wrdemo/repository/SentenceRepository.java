package com.example.wrdemo.repository;

import com.example.wrdemo.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenceRepository extends JpaRepository<Sentence, Integer> {
    Sentence findBySentenceId(int sentenceId);
}
