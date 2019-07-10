package com.example.questionairehibernate.controllers;

import com.example.questionairehibernate.entities.Answer;
import com.example.questionairehibernate.entities.Question;
import com.example.questionairehibernate.entities.User;
import com.example.questionairehibernate.repositories.AnswerRepository;
import com.example.questionairehibernate.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnswerController
 */
@RestController
@RequestMapping(path = "/api")
public class AnswerController {

  @Autowired
  AnswerRepository answerRepository;
  UserRepository userRepository;

  @PostMapping(value = "/answers/{id}")
  public void updateAnswer(@RequestBody Answer answer, @PathVariable("id") long id) {
    Answer existingAnswer = answerRepository.findById(id).orElse(new Answer());
    if (existingAnswer.getId() != null) {
      answer.setId(id);
      answerRepository.save(answer);
    }
  }

  @PostMapping(value = "/questions/{id}/answers")
  public void addAnswer(@RequestBody Answer answer, @PathVariable("questionId") long questionId) {
    Question question = questionRepository.findById(questionId).orElse(new Question());
    if (question.getId() != null) {
      answer.setQuestionId(questionId);
      answerRepository.save(answer);
    }
  }
}