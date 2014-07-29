package br.unifor.ads.pin.controller;

import java.util.List;

import br.unifor.ads.pin.domain.Question;

public class QuestionTable {

	private String searchTerm;
	private List<Question> results;
	private Question newQuestion;
	private Question updatedQuestion;
	private boolean questionDeleted;
	
	public QuestionTable() {
	}

	public QuestionTable(String searchTerm, List<Question> results) {
		super();
		this.searchTerm = searchTerm;
		this.results = results;
	}

	public QuestionTable(Question newQuestion){
		this.setNewQuestion(newQuestion);
	}
	

	public String getSearchTerm() {
		return searchTerm;
	}
	public List<Question> getResults() {
		return results;
	}
	public Question getFirst() {
		if (results != null && results.size() > 0)
			return results.get(0);
		else
			return null;
	}
	public int getTotalResults() {
		if (results != null)
			return results.size();
		else
			return 0;
	}

	public Question getNewQuestion() {
		return newQuestion;
	}

	public void setNewQuestion(Question newQuestion) {
		this.newQuestion = newQuestion;
	}
	
	public boolean hasNewQuestion() {
		return (newQuestion != null);
	}


	public Question getUpdatedQuestion() {
		return updatedQuestion;
	}

	public void setUpdatedQuestion(Question updatedQuestion) {
		this.updatedQuestion = updatedQuestion;
	}
	
	public boolean hasUpdatedQuestion() {
		return (updatedQuestion != null);
	}

	public boolean isQuestionDeleted() {
		return questionDeleted;
	}

	public void setQuestionDeleted(boolean questionDeleted) {
		this.questionDeleted = questionDeleted;
		
	}
	
}
