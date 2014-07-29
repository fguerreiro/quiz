package br.unifor.ads.pin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.model.QuestionDAO;

public class AddQuestionAction implements ActionCommand {

	@Override
	public void executeAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Question question = new Question();
		question.setDescription(request.getParameter("description"));

		QuestionDAO dao = new QuestionDAO();
		
		RequestDispatcher disp = request.getRequestDispatcher("/pages/question-list.jsp");
		disp.forward(request, response);
	}

}
