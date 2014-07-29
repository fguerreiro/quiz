package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifor.ads.pin.domain.Alternative;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.utils.ConnectionTest;

public class AlternativeDAO {
	
	Connection con;
	
	public void insert(Alternative alternative, int questionId){
		
		try {
			con = ConnectionTest.getConnection();
			
			String sql = "INSERT INTO Alternativa (id_pergunta, nr_alternativa, ds_alternativa, is_correta) values (?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, questionId);
			stmt.setInt(2, alternative.getAlternativeNumber());
			stmt.setString(3, alternative.getDescription());
			stmt.setBoolean(4, alternative.isCorrect());
				
			stmt.execute();
			stmt.close();
					
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void update(Question question){
		
		try {
			
			String sql = "UPDATE pergunta SET (ds_pergunta=?, cd_nivel_dificuldade=?, cd_tipo_pergunta=? WHERE id_pergunta=?)";
			
			con = ConnectionTest.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, question.getDescription());
			stmt.setInt(2, question.getDifficulty());
			stmt.setInt(3, question.getQuestionType());
			stmt.setInt(4, question.getQuestionId());
				
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void delete(Question question){
		
		try {
			String sql = "DELETE FROM pergunta WHERE id_pergunta=?";
			
			con = ConnectionTest.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, question.getQuestionId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public List<Question> getQuestionList(){
		
		List<Question> questions = null;
		
		try {

			String sql = "SELECT * FROM pergunta";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			questions = new ArrayList<Question>();
			
			while (rs.next()){
				Question question = new Question();
				question.setQuestionId(rs.getInt("id_pergunta"));
				question.setDescription(rs.getString("ds_pergunta"));
				question.setQuestionType(rs.getInt("cd_tipo_pergunta"));
				question.setDifficulty(rs.getInt("cd_nivel_dificuldade"));
				
				questions.add(question);
			}
			
			rs.close();
			stmt.close();
			
			return questions;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
	}
}
