package br.unifor.ads.pin.domain;

import java.sql.Timestamp;

public class Session {

	private Integer sessionNumber;
	private Timestamp beginsAt;
	private Timestamp endsAt;

	public Integer getSessionNumber() {
		return sessionNumber;
	}
	public void setSessionNumber(Integer sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	public Timestamp getBeginsAt() {
		return beginsAt;
	}
	public void setBeginsAt(Timestamp beginsAt) {
		this.beginsAt = beginsAt;
	}
	public Timestamp getEndsAt() {
		return endsAt;
	}
	public void setEndsAt(Timestamp endsAt) {
		this.endsAt = endsAt;
	}
}
