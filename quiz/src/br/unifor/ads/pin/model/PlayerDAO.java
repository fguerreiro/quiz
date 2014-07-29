package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.utils.ConnectionTest;

public class PlayerDAO {

	Connection con;

	public void insert(Player player) {

		try {
			con = ConnectionTest.getConnection();

			String sql = "INSERT into Jogador (nm_login, nm_senha, nr_vidas, nr_pontos, cd_privilegio, dt_cadastro) values (?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, player.getLogin());
			stmt.setString(2, player.getPassword());
			stmt.setInt(3, player.getLifePoints());
			stmt.setInt(4, player.getScore());
			stmt.setInt(5, player.getPrivileges());
			stmt.setDate(6, new java.sql.Date(new java.util.Date().getTime()));

			stmt.execute();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Player player) {

		try {

			String sql = "UPDATE jogador SET "
					+ " nm_login=?, nm_senha=?, cd_privilegio=?  WHERE id_jogador=?";

			con = ConnectionTest.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, player.getLogin());
			stmt.setString(2, player.getPassword());
			stmt.setInt(3, player.getPrivileges());
			stmt.setInt(4, player.getPlayerId());

			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Player player) {
		try {

			String sql = "DELETE FROM jogador WHERE id_jogador=?";

			con = ConnectionTest.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, player.getPlayerId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Player getPlayerById(int playerId) {
		Player player = null;
		try {

			player = new Player();

			con = ConnectionTest.getConnection();

			String sql = "SELECT * FROM jogador WHERE id_jogador=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, playerId);
			stmt.execute();

			ResultSet rs = stmt.executeQuery();

			// players = new ArrayList<Player>();

			if (rs.next()) {

				player.setPlayerId(rs.getInt("id_jogador"));
				player.setLogin(rs.getString("nm_login"));
				player.setPassword(rs.getString("nm_senha"));
				player.setLifePoints(rs.getInt("nr_vidas"));
				player.setScore(rs.getInt("nr_pontos"));
				player.setPrivileges(rs.getInt("cd_privilegio"));
				player.setRegisteredAt(rs.getDate("dt_cadastro"));

				System.out.println("encontrado player "
						+ (rs.getString("nm_login")));
			}

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	public List<Player> getPlayerList() {

		List<Player> players = new ArrayList<Player>();
		Player player = null;
		try {
			con = ConnectionTest.getConnection();

			String sql = "SELECT * FROM jogador";
			System.out.println("consulta " + sql);
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				player = new Player();
				player.setPlayerId(rs.getInt("id_jogador"));
				player.setLogin(rs.getString("nm_login"));
				player.setPassword(rs.getString("nm_senha"));
				player.setLifePoints(rs.getInt("nr_vidas"));
				player.setScore(rs.getInt("nr_pontos"));
				player.setPrivileges(rs.getInt("cd_privilegio"));

				player.setRegisteredAt(rs.getDate("dt_cadastro"));

				System.out.println("encontrado player "
						+ (rs.getString("nm_login")));
				players.add(player);

			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return players;
	}

	public Player checkLogin(String login, String password) {

		Player player = null;
		try {

			con = ConnectionTest.getConnection();

			String sql = "SELECT * FROM jogador where nm_login=? and nm_senha=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				player = new Player();
				player.setPlayerId(rs.getInt("id_jogador"));
				player.setLogin(rs.getString("nm_login"));
				player.setPassword(rs.getString("nm_senha"));
				player.setLifePoints(rs.getInt("nr_vidas"));
				player.setScore(rs.getInt("nr_pontos"));
				player.setPrivileges(rs.getInt("cd_privilegio"));
				player.setRegisteredAt(rs.getDate("dt_cadastro"));

				System.out.println("encontrado player "
						+ (rs.getString("nm_login")));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
}
