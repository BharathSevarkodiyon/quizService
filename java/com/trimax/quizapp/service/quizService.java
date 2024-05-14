package com.trimax.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trimax.quizapp.DAO.questionDao;
import com.trimax.quizapp.DAO.quizDao;
import com.trimax.quizapp.model.Question;
import com.trimax.quizapp.model.Quiz;
import com.trimax.quizapp.model.Response;
import com.trimax.quizapp.model.questionWrapper;

@Service
public class quizService {
	
	@Autowired
	quizDao quizDao;
	@Autowired
	questionDao questionDao;

	public ResponseEntity<String> getQuizQuestion(String category, int noQ, String title) {
		List<Question> question = questionDao.findRamdomQuestionByCategory(category, noQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(question);
		quizDao.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<questionWrapper>> getQuestion(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionFromDb = quiz.get().getQuestion();
		List<questionWrapper> questionForUser = new ArrayList<>();
		for(Question q : questionFromDb) {
			questionWrapper qw = new questionWrapper(q.getId(), q.getQuestionTitle());
			questionForUser.add(qw);
		}
		return new ResponseEntity<> (questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getResult(Integer id, List<Response> response) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> question = quiz.getQuestion();
		int result = 0;
		int i = 0;
		for(Response resp : response) {
			if(resp.getResponse().equals(question.get(i).getRightAnswer())) {
				result++;
			}
			i++;
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	

}
