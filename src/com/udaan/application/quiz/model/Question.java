package com.udaan.application.quiz.model;

import java.util.List;

public class Question {

	private Integer id;
	private String text;
	private List<Answer> options;
	private Answer answer;

	public Question(Integer id, String text, List<Answer> options, Answer answer) {
		this.id = id;
		this.text = text;
		this.options = options;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Answer> getOptions() {
		return options;
	}

	public void setOptions(List<Answer> options) {
		this.options = options;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
