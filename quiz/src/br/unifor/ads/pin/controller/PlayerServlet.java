
package br.unifor.ads.pin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.model.PlayerDAO;

@WebServlet("/pages/player/*")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Entrou no doPost");

		actions(req, resp);
	}
	
	public void actions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("entrou em ACTIONS()");
		PlayerDAO dao = new PlayerDAO();
		List<Player> players = new ArrayList<Player>();

		String action = request.getParameter("action") == null ? ""
				+ "" : request.getParameter("action");
		System.out.println("action enquanto getParameter= " + action);
		
		String id = request.getParameter("playerId");
		System.out.println("player id: " + id);
		

		if ("list".equals(action) || "".equals(action)) {
			
			players = dao.getPlayerList();

			
			request.getSession().setAttribute("players", players);

			response.sendRedirect(request.getContextPath()
					+ "/pages/admin/list-player.jsp");
			return;
		}
		if ("edit".equals(action)) {

				Player player = dao.getPlayerById(Integer.parseInt(id));
				
				System.out.println(player.getPrivileges());
				
				request.setAttribute("playerId", id);
				request.getSession().setAttribute("player", player);

				response.sendRedirect(request.getContextPath()
						+ "/pages/admin/edit-player.jsp");
				return;
			}
		
		if ("editSubmit".equals(action)) {
			
				String login = request.getParameter("playerLogin").trim();
				String password = request.getParameter("playerPassword").trim();
				int privileges = request.getParameter("playerPrivileges") == null ? 1 : 0;
				
				Player player = dao.getPlayerById(Integer.parseInt(id));
				
				player.setLogin(login);
				player.setPassword(password);
				player.setPrivileges(privileges);
				
				dao.update(player);
				
				response.sendRedirect(request.getContextPath()
						+ "/pages/admin/player/list");
				return;
			}
		if ("delete".equals(action)) {
				
				Player player = new Player();
				
				System.out.println(id);
				
				Integer idInt = Integer.parseInt(id);
				
						
				player.setPlayerId(idInt);
				
				System.out.println(player.getPlayerId());
				
				dao.delete(player);

				request.getSession().setAttribute("players", players);

				response.sendRedirect(request.getContextPath()
						+ "/pages/admin/player?action=list");
				return;
			}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		actions(req, resp);
	
	}
	
}
