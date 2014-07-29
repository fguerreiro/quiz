package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.domain.QuestionAnswer;
import br.unifor.ads.pin.utils.ConnectionTest;

public class QuestionAnswerDAO {
	
	Connection con;
	
	public List<QuestionAnswer> getQuestionAnswerList(){
		
		List<QuestionAnswer> questionsAnswer = null;
		
		try {
			
			con = ConnectionTest.getConnection();
			
			String sql = "SELECT p.id_pergunta as id, p.ds_pergunta as pergunta, p.cd_tipo_pergunta as tipoPergunta, "
					+ " a.ds_alternativa as resposta "
					+ " FROM pergunta p"
					+ " inner join alternativa a on (p.id_pergunta = a.id_pergunta)"
					+ " where a.is_correta='true'"
					+ " order by p.id_pergunta desc";
								
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			questionsAnswer = new ArrayList<QuestionAnswer>();
			
			QuestionAnswer questionAnsw;
			while (rs.next()){
				
				questionAnsw = new QuestionAnswer();
				
				questionAnsw.setId(rs.getInt("id"));
				questionAnsw.setQuestion(rs.getString("pergunta"));
				questionAnsw.setQuestionType(rs.getInt("tipoPergunta"));
				questionAnsw.setAnswer(rs.getString("resposta"));
				
				questionsAnswer.add(questionAnsw);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionsAnswer;
	}

	public boolean verifyCorrectAnswer(String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	public Question checkNextQuestion(Integer playerId) {

		String sql = "select TOP 1 * from Pergunta where id_pergunta NOT IN (select id_pergunta from Jogador_Pergunta where id_jogador = 12";
		
		
		return null;
	}
}
