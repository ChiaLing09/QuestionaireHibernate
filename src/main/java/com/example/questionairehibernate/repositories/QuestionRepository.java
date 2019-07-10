package com.example.questionairehibernate.repositories;

import java.util.List;

import com.example.questionairehibernate.entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * QuestionRepository
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

  List<Question> findByUserId(Long id);
}