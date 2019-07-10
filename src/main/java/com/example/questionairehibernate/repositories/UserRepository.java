package com.example.questionairehibernate.repositories;

import com.example.questionairehibernate.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

}