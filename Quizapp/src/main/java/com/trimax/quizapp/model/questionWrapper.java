package com.trimax.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class questionWrapper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String questionTitle;
	
	

	public questionWrapper(int id, String questionTitle) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
		
}
