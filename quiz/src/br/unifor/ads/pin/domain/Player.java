package br.unifor.ads.pin.domain;

import java.io.Serializable;
import java.util.Date;

public class Player implements Serializable {
	private static final long serialVersionUID = -3072818508667571267L;
	private Integer playerId;
	private Integer privileges;
	private String login;
	private String password;
	private Integer lifePoints;
	private Integer score;
	private Date registeredAt;

	public Player() {

	}

	public Player(Integer privileges, String login, String password,
			Integer lifePoints, Integer score, Date registeredAt) {
		super();
		this.privileges = privileges;
		this.login = login;
		this.password = password;
		this.lifePoints = lifePoints;
		this.score = score;
		this.registeredAt = registeredAt;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Integer privileges) {
		this.privileges = privileges;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Integer getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(Integer lifePoints) {
		this.lifePoints = lifePoints;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
