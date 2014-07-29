package br.unifor.ads.pin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.utils.ConnectionTest;

public class QuestionDAO {
	
	Connection con;
	
	public void insert(Question question){
		
		try {
			con = ConnectionTest.getConnection();
			
			String sql = "INSERT into Pergunta (ds_pergunta, cd_nivel_dificuldade, cd_tipo_pergunta) values (?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, question.getDescription());
			stmt.setInt(2, question.getDifficulty());
			stmt.setInt(3, question.getQuestionType());
				
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}
	
public int getLastQuestionId(){
		
		int retorno = -1;
		try {

			con = ConnectionTest.getConnection();
			
			String sql = "select isnull(max(id_pergunta), 0) as id_pergunta from pergunta";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				retorno = rs.getInt("id_pergunta");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	public Question getLastQuestion(int questionId){
		
		Question question = null;
		try {
			
			con = ConnectionTest.getConnection();
			
			String sql = "select * from pergunta where id_pergunta=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, questionId);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				question = new Question();
				question.setQuestionId(rs.getInt("id_pergunta"));
				question.setDescription(rs.getString("ds_pergunta"));
				question.setQuestionType(rs.getInt("cd_tipo_pergunta"));
				question.setDifficulty(rs.getInt("cd_nivel_dificuldade"));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
	}


}
