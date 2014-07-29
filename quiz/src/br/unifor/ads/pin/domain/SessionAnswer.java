package br.unifor.ads.pin.domain;

public class SessionAnswer {
	
	private Session session;
	private Question question;
	private Alternative alternative;
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Alternative getAlternative() {
		return alternative;
	}
	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}
	
}
