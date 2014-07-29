package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifor.ads.pin.domain.Alternative;
import br.unifor.ads.pin.domain.Session;
import br.unifor.ads.pin.utils.ConnectionTest;

public class SessionAnswerDAO {
	
	Connection con;
	
	public void insert(Session session, Alternative alternative){
		
		try {
			con = ConnectionTest.getConnection();
			
			String sql = "INSERT (id_sessao, id_alternativa, dt_resposta) values (?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, session.getSessionNumber());
			stmt.setInt(2, alternative.getAlternativeNumber());
			stmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			stmt.execute();
			stmt.close();
					
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
