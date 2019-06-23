package com.application.quiz.model;

import java.util.Map;

public class User {

	private String name;
	private Integer score;
	private Map<Question, Answer> answered; // que -> ans

	public User(String name, Integer score, Map<Question, Answer> answered) {
		this.name = name;
		this.score = score;
		this.answered = answered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Map<Question, Answer> getAnswered() {
		return answered;
	}

	public void setAnswered(Map<Question, Answer> answered) {
		this.answered = answered;
	}

}
