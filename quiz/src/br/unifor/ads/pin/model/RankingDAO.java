package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.domain.Session;
import br.unifor.ads.pin.domain.SessionAnswer;
import br.unifor.ads.pin.utils.ConnectionTest;

public class RankingDAO {
	
	Connection con;
	
	public void getPointsForPlayerId(Player player){
		
		try {
			con = ConnectionTest.getConnection();
			
			String sql = "SELECT Count(NR_alternativa) As Acertos "
					+" FROM Sessao_Resposta sr, Sessao se, Alternativa alt, Jogador jog "
					+" where jog.id_jogador=? "
					+ " and sr.id_alternativa = alt.id_alternativa "	
					+ " and sr.id_sessao = se.id_sessao "
					+ " and se.id_jogador = jog.id_jogador "
					+ " and alt.is_correta = TRUE "
					;
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, player.getPlayerId());
			stmt.execute();
			stmt.close();
					
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
