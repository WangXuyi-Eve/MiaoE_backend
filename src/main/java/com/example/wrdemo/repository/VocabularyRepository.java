package com.example.wrdemo.repository;

import com.example.wrdemo.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    Vocabulary findByVocabularyId(int vocabularyId);
}
