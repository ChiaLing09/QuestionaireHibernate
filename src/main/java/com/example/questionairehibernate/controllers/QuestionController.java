package com.example.questionairehibernate.controllers;

import com.example.questionairehibernate.entities.Question;
import com.example.questionairehibernate.entities.User;
import com.example.questionairehibernate.repositories.QuestionRepository;
import com.example.questionairehibernate.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuestionController
 */
@RestController
@RequestMapping(path = "/api")
public class QuestionController {

  @Autowired
  QuestionRepository questionRepository;
  UserRepository userRepository;

  @PostMapping(value = "/questions")
  public void addQuestion(@RequestBody Question question, @PathVariable("userId") long userId) {
    User existingUser = userRepository.findById(userId).orElse(new User());
    if (existingUser.getId() != null) {
      question.setUserId(userId);
      questionRepository.save(question);
    }
  }
}