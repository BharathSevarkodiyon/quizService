package com.trimax.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trimax.quizapp.model.Response;
import com.trimax.quizapp.model.questionWrapper;
import com.trimax.quizapp.service.quizService;

@RestController
@RequestMapping("quiz")
public class quizController {
	
	@Autowired
	quizService quizService;
	
	
	@PostMapping("create")
	public ResponseEntity<String> getQuizQuestion(@RequestParam String category, @RequestParam int noQ, @RequestParam String title){
		return quizService.getQuizQuestion(category, noQ, title);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<questionWrapper>> getQuestion(@PathVariable int id){
		return quizService.getQuestion(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> getResult(@PathVariable Integer id, @RequestBody List<Response> respons){
		return quizService.getResult(id, respons);
	}
}
