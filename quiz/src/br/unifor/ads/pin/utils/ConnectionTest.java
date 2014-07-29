package br.unifor.ads.pin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.model.PlayerDAO;

public class ConnectionTest {

	static Connection con = null;
	static PlayerDAO dao;

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String conectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=quiz;integratedSecurity=true";
			con = DriverManager.getConnection(conectionUrl);
			if (con == null) {
				System.out.println("Connection nulo!");
			}
			System.out.println("Connected to the db");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Connection failed! Check output console");
		}
		return con;

	}

	public static Player mockNewPlayer() {

		Player player = new Player();
		player.setLogin("new player1");
		player.setPassword("123456");
		player.setLifePoints(3);
		player.setScore(799);
		player.setPrivileges(0);

		return player;

	}

	public static Player mockExistingPlayer() {

		Player player = new Player();
		player.setLogin("guerreiro2");
		player.setPassword("123456");
		player.setLifePoints(3);
		player.setScore(899);
		player.setPrivileges(0);
		player.setPlayerId(1);

		return player;
	}

	public static void insertPlayer() {

		dao = new PlayerDAO();
		dao.insert(mockNewPlayer());

	}

	public static void updatePlayer() {

		dao = new PlayerDAO();
		dao.update(mockExistingPlayer());
	}

	public static void deletePlayer() {

		dao = new PlayerDAO();
		dao.delete(mockExistingPlayer());
	}

	public static void listPlayers() {

		dao = new PlayerDAO();
		dao.getPlayerList();
	}

	public static void checkLogin() {
		dao = new PlayerDAO();
		dao.checkLogin("francisco", "123456");
	}

}