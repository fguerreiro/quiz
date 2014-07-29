package br.unifor.ads.pin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.model.QuestionDAO;

public class ViewQuestionAction implements ActionCommand {
	
	private boolean editMode;
	
	public ViewQuestionAction(boolean editMode) {
		this.editMode = editMode;
	}
	
	

	@Override
	public void executeAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		QuestionDAO dao = new QuestionDAO();
		Integer questionId = null;
		if (request.getParameter("id") != null)
			questionId = Integer.parseInt(request.getParameter("id"));
	}

}
