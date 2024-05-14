package com.trimax.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trimax.quizapp.model.Quiz;

@Repository
public interface quizDao extends JpaRepository<Quiz, Integer> {

}
