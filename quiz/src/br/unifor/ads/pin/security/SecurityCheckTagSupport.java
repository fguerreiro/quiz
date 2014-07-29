package br.unifor.ads.pin.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import br.unifor.ads.pin.domain.Player;

public class SecurityCheckTagSupport extends TagSupport {

	/**
	 * @author Guerreiro
	 * 
	 */
	private static final long serialVersionUID = -5544107049222132838L;

	private boolean adminLevel;

	/**
	 * Verifies logged user
	 * If not logged redirects to login servlet
	 * Else, verifies path, if it's admin verifies privileges
	 * Otherwise gives access errors
	 */
	@Override
	public int doStartTag() throws JspException {

		// verifica se tem user logado
		// se nao, redireciona para pag login

		// se tem logado, verifica Path
		// se Path de admin, verifica se o user é admin
		// se nao for, vai pra pag. de acesso negado

		Player player = (Player) this.pageContext.getSession().getAttribute(
				"player");

		HttpServletRequest request = (HttpServletRequest) this.pageContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) this.pageContext
				.getResponse();

		if (player == null || player.getPrivileges() != 0) {

			// redirects to error page
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/accessDenied.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return super.doStartTag();
	}

	public boolean isAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(boolean adminLevel) {
		this.adminLevel = adminLevel;
	}

}
