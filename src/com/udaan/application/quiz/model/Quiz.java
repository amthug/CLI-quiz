package com.udaan.application.quiz.model;

import java.util.List;

public class Quiz {

	private String name;
	private List<Question> questions;
	private User user;

	public Quiz(String name, List<Question> questions, User user) {
		this.name = name;
		this.questions = questions;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
