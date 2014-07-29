package br.unifor.ads.pin.domain;

import java.io.Serializable;

public class QuestionAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2104401830570411302L;
	private Integer id;
	private String question;
	private Integer questionType;
	private String answer;
	
	public QuestionAnswer() {
	}

	public QuestionAnswer(Integer id, String question, Integer questionType,
			String answer) {
		super();
		this.setId(id);
		this.question = question;
		this.questionType = questionType;
		this.answer = answer;
	}

	
	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
