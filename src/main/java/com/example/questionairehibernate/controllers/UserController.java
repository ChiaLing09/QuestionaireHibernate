package com.example.questionairehibernate.controllers;

import java.util.List;

import com.example.questionairehibernate.entities.Answer;
import com.example.questionairehibernate.entities.Question;
import com.example.questionairehibernate.entities.User;
import com.example.questionairehibernate.repositories.AnswerRepository;
import com.example.questionairehibernate.repositories.QuestionRepository;
import com.example.questionairehibernate.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(path = "/api")
public class UserController {

  @Autowired
  UserRepository userRepository;
  QuestionRepository questionRepository;
  AnswerRepository answerRepository;

  @PostMapping(value = "/users")
  public void addUser(@RequestBody User user) {
    userRepository.save(user);
  }

  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable("id") long id) {
    User user = userRepository.findById(id).orElse(new User());
    if (user.getId() != null) {
      List<Question> questions = questionRepository.findByUserId(user.getId());
      List<Answer> answers = answerRepository.findByUserId(user.getId());
      questionRepository.deleteAll(questions);
      answerRepository.deleteAll(answers);
      userRepository.delete(user);
    }
  }
}