package com.trimax.quizapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trimax.quizapp.model.Question;

@Repository
public interface questionDao extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :noQ", nativeQuery=true)
	List<Question> findRamdomQuestionByCategory(String category, int noQ);

}
