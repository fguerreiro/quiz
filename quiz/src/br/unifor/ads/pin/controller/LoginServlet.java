package br.unifor.ads.pin.controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.model.PlayerDAO;

@WebServlet("/pages/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		actions(request, response);

	}

	/*
	 * #TODO: - Colocar métodos de actions agora segundo a section de login: 1)
	 * action=enter -> verificará o usuário e entrará ou não no sistema 2)
	 * action=new -> cadastrará novo usuário no banco e entra no sistema
	 */

	public void actions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PlayerDAO dao = new PlayerDAO();

		String action = req.getParameter("action");
		System.out.println("Action passada pelo JSP Login: " + action);

		if (action != null && !"/".equals(action)) {
			// action = action.split("/")[1];
		} else {
			action = "list";
		}

		if ("enter".equals(action)) {

			String login = req.getParameter("login");
			String password = req.getParameter("password");

			System.out.println("Prestes a testar o checkLogin...");
			Player player = dao.checkLogin(login, password);

			if (player != null) {
				req.getSession().setAttribute("player", player);

				String pathAfterLogin = player.getPrivileges() == 0 ? "/pages/sobre.jsp"
						: "/pages/play.jsp";

				resp.sendRedirect(req.getContextPath() + pathAfterLogin);
			} else {
				req.getSession().removeAttribute("player");
				req.getSession().setAttribute("failed", true);

				// RequestDispatcher disp =
				// request.getRequestDispatcher("/pages/cad-quest.html");
				resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
				// disp.forward(request, response);
			}

		}

		if ("new".equals(action)) {

			String login = req.getParameter("login").trim();
			String password = req.getParameter("password-register-1").trim();

			Date date = new Date();
			Player player = new Player(1, login, password, 3, 0, date);

			dao.insert(player);

			req.getSession().setAttribute("player", player);

			resp.sendRedirect(req.getContextPath() + "/pages/game.jsp");
		}
	}
}
