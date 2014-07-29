package br.unifor.ads.pin.domain;

import java.io.Serializable;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2104401830570411302L;
	private Integer questionId;
	private String description;
	private Integer difficulty;
	private Integer questionType;
	
	public Question() {
	}

	public Question(String description, Integer difficulty, Integer questionType) {
		super();
		this.description = description;
		this.setDifficulty(difficulty);
		this.setQuestionType(questionType);
	}
	
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
}
