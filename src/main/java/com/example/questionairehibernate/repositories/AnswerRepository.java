package com.example.questionairehibernate.repositories;

import java.util.List;

import com.example.questionairehibernate.entities.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AnswerRepository
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

  List<Answer> findByUserId(Long id);
}