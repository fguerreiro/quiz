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
	 * 
	 */
	private static final long serialVersionUID = -5544107049222132838L;

	private boolean adminLevel;

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

			// redirecionar para uma pagina de erro
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/accessDenied.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
