package br.unifor.ads.pin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectController {

	public RedirectController(String path, String action,
			Boolean isSendRedirect, HttpServletRequest request,
			HttpServletResponse response) {

		action = (action == null || action == "") ? "" : "?action=";

		if (isSendRedirect) {
			try {
				response.sendRedirect(path + action);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			RequestDispatcher rd = request.getRequestDispatcher(path + action);

			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
