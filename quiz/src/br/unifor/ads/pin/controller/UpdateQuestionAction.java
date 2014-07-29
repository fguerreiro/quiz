package br.unifor.ads.pin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateQuestionAction implements ActionCommand {

	@Override
	public void executeAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer questionId = null;

		if (request.getParameter("id") != null)
			questionId = Integer.parseInt(request.getParameter("id"));

	}

}
