package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unifor.ads.pin.domain.Session;
import br.unifor.ads.pin.utils.ConnectionTest;

public class SessionDAO {

	Connection con;

	public void insert(Session session, Integer playerId) {

		try {
			con = ConnectionTest.getConnection();

			String sql = "INSERT (id_jogador, nr_sessao, dt_inicio, dt_fim) values (?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, playerId);
			stmt.setInt(2, session.getSessionNumber());
			stmt.setTimestamp(3, session.getBeginsAt());
			stmt.setTimestamp(4, session.getEndsAt());

			stmt.execute();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Session session, Integer playerId) {

		try {

			String sql = "UPDATE session SET "
					+ "( id_jogador=?, dt_inicio=?, dt_fim=? WHERE nr_sessao=?)";

			con = ConnectionTest.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, playerId);
			stmt.setTimestamp(2, session.getBeginsAt());
			stmt.setTimestamp(3, session.getEndsAt());
			stmt.setInt(4, session.getSessionNumber());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Session session) {
		try {

			String sql = "DELETE FROM session WHERE nr_sessao=?";

			con = ConnectionTest.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, session.getSessionNumber());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Session> getSessionListForPlayerId(Integer playerId) {

		List<Session> sessions = null;
		try {

			String sql = "SELECT * FROM sessao where id_jogador=?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, playerId);

			ResultSet rs = stmt.executeQuery();

			sessions = new ArrayList<Session>();

			while (rs.next()) {
				Session session = new Session();

				session.setSessionNumber(rs.getInt("nr_sessao"));
				session.setBeginsAt(rs.getTimestamp("dt_inicio"));
				session.setEndsAt(rs.getTimestamp("dt_fim"));
				sessions.add(session);
			}

			rs.close();
			stmt.close();

			return sessions;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessions;
	}
}
