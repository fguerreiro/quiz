package br.unifor.ads.pin.domain;

public class Alternative {
	
	private Question question;
	private Integer alternativeNumber;
	private String description;
	private boolean isCorrect;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Integer getAlternativeNumber() {
		return alternativeNumber;
	}
	public void setAlternativeNumber(Integer alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
