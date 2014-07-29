package br.unifor.ads.pin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.model.QuestionDAO;

public class DeleteQuestionAction implements ActionCommand {

	
	@Override
	public void executeAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer questionId = null;
		if (request.getParameter("id") != null)
			questionId = Integer.parseInt(request.getParameter("id"));
		
		if (questionId != null) {
			Question question = new Question();
			question.setQuestionId(questionId);
			QuestionDAO dao = new QuestionDAO();

			RequestDispatcher disp = request.getRequestDispatcher("/pages/question-list.jsp");
			disp.forward(request, response);
		} else
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

}
