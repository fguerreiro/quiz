package br.unifor.ads.pin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifor.ads.pin.domain.Alternative;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.domain.QuestionAnswer;
import br.unifor.ads.pin.model.AlternativeDAO;
import br.unifor.ads.pin.model.QuestionAnswerDAO;
import br.unifor.ads.pin.model.QuestionDAO;

@WebServlet("/pages/admin/question/*")
public class QuestionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9064685302641209494L;

	private String questionDescription, alternativeDescription;
	private Integer alternativeNumber, questionDifficulty, questionType;
	private boolean isAlternativeCorrect;

	private QuestionDAO questionDAO;

	public QuestionServlet() {
		super();
	}

	ActionCommand createCommand(HttpServletRequest request)
			throws ServletException, IOException {
		String action = "list";
		if (request.getParameter("action") != null)
			action = request.getParameter("action");

		if ("list".equals(action))
			return new ListQuestionAction();
		else if ("view".equals(action))
			return new ViewQuestionAction(false);
		else if ("add".equals(action))
			return new AddQuestionAction();
		else if ("delete".equals(action))
			return new DeleteQuestionAction();
		else if ("edit".equals(action))
			return new ViewQuestionAction(true);
		else if ("update".equals(action))
			return new UpdateQuestionAction();
		else
			return null;
	}

	void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionCommand cmd = this.createCommand(request);
		if (cmd != null)
			cmd.executeAction(request, response);
		else
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// this.processRequest(request, response);
	// }

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// this.processRequest(request, response);

		String action = request.getParameter("action");
		System.out.println("action = " + action);

		/*
		 * #TODO:
		 * 
		 * setAttribute(question) sendRedirect -> JSP
		 * 
		 * no JSP: colocar includes e verificação c:if
		 */

		if ("newQuestion".equals(action)) {
			newQuestion(request, response);
			return;
		}

		if ("newAlternative".equals(action)) {

			Question question = new Question();
			question = (Question) request.getAttribute("question");
			System.out.println("Pegando Question de Parâmetro: "
					+ question.getDescription());

			int questionId = Integer.parseInt(request
					.getParameter("questionId"));
			System.out.println(questionId);
			// this.getAlternativeParameters(request, response, questionId);
		}
	}

	private void newQuestion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cond newQuestion action ");
		// ok
		this.getQuestionParameters(request, response);

		// ok
		Question question = this.setQuestion(request, response);

		// ok
		this.insertQuestionDB(request, response, question);

		// ok
		int questionId = this.getLasQuestionId(request);

		// pending
		question = this.getLastQuestion(questionId);

		// setting Question into parameter
		this.setQuestionIntoParameters(request, response, question);

		this.setParametersToFormatJSP(request, response, question);

		System.out.println("setando questionId e prosseguindo no Dispatcher : "
				+ question.getQuestionId());
		RequestDispatcher rd = request
				.getRequestDispatcher("/pages/admin/cad-quest.jsp");
		rd.forward(request, response);
		return;
	}

	private void setParametersToFormatJSP(HttpServletRequest request,
			HttpServletResponse response, Question question) {

		request.setAttribute("disabled", "disabled");

	}

	private void setQuestionIntoParameters(HttpServletRequest request,
			HttpServletResponse response, Question question) {

		request.setAttribute("questionId", question.getQuestionId());
		System.out
				.println("setQuestionIntoParameters passado questionID setAtt: "
						+ question.getQuestionId());

		request.setAttribute("questionDescription", question.getDescription());
		request.setAttribute("questionType", question.getQuestionType());
		request.setAttribute("questionDifficulty", question.getDifficulty());

	}

	private Question getLastQuestion(int questionId) {
		// TODO Auto-generated method stub

		Question question = new Question();
		questionDAO = new QuestionDAO();

		System.out.println("questionId vai ser usado, valor=" + questionId);
		question = questionDAO.getLastQuestion(questionId);

		return question;

	}

	private int getLasQuestionId(HttpServletRequest request) {

		QuestionDAO dao = new QuestionDAO();
		int questionId = dao.getLastQuestionId();

		request.setAttribute("questionId", questionId);
		System.out.println("questionId setado: "
				+ request.getAttribute("questionId") + " vindo de "
				+ questionId);

		return questionId;

	}

	void getQuestionParameters(HttpServletRequest request,
			HttpServletResponse response) {

		questionDescription = request.getParameter("questionDescription");
		questionDifficulty = Integer.parseInt(request
				.getParameter("questionDifficulty"));
		questionType = Integer.parseInt(request.getParameter("questionType"));

		System.out.println("getQuestion Parameters 3 valores: "
				+ questionDescription + " " + questionDifficulty + " "
				+ questionType);
	}

	Question setQuestion(HttpServletRequest request,
			HttpServletResponse response) {

		Question question = new Question(questionDescription,
				questionDifficulty, questionType);
		System.out.println("setQuestion question = "
				+ question.getDescription());
		return question;
	}

	void insertQuestionDB(HttpServletRequest request,
			HttpServletResponse response, Question question) {

		System.out.println("insertQuestionDB");
		questionDAO = new QuestionDAO();

		questionDAO.insert(question);

		System.out.println("inserido na tabela");

	}

	Alternative insertAlternativeDB(HttpServletRequest request,
			HttpServletResponse response, int questionId) {

		QuestionDAO questionDAO = new QuestionDAO();
		Question question = questionDAO.getLastQuestion(questionId);
		
		Alternative alternative = new Alternative();
		AlternativeDAO alternativeDAO = new AlternativeDAO();
		
		if (question.getQuestionType() == 1) {
			// faz lógica de request parameters da section 1
		
			alternative.setDescription(request.getParameter("radioBtn"));
			alternative.setCorrect(true);
			alternative.setAlternativeNumber(1);
			alternativeDAO.insert(alternative, questionId);
			
		}
		if (question.getQuestionType() == 2) {
			// faz lógica de request parameters da section 1
			
			Alternative alt1 = new Alternative();
			alt1.setDescription(request.getParameter("alt1Text"));
			alt1.setCorrect(request.getParameter("alt1Chk") != null ? true : false);
			alt1.setAlternativeNumber(1);
			alternativeDAO.insert(alt1, questionId);
			
			Alternative alt2 = new Alternative();
			alt2.setDescription(request.getParameter("alt2Text"));
			alt2.setCorrect(request.getParameter("alt2Chk") != null ? true : false);
			alt2.setAlternativeNumber(2);
			alternativeDAO.insert(alt2, questionId);
			
			Alternative alt3 = new Alternative();
			alt3.setDescription(request.getParameter("alt3Text"));
			alt3.setCorrect(request.getParameter("alt3Chk") != null ? true : false);
			alt3.setAlternativeNumber(3);
			alternativeDAO.insert(alt3, questionId);
			
			Alternative alt4 = new Alternative();
			alt4.setDescription(request.getParameter("alt4Text"));
			alt4.setCorrect(request.getParameter("alt4Chk") != null ? true : false);
			alt4.setAlternativeNumber(4);
			alternativeDAO.insert(alt4, questionId);
 			
		}
		if (question.getQuestionType() == 3) {
			// faz lógica de request parameters da section 1
			
			alternative.setDescription(request.getParameter("radioBtn"));
		}
			return alternative;
		}


	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		System.out.println("action = " + action);

		if ("newQuestion".equals(action)) {
			newQuestion(request, response);
			return;
		}

		if ("newAlternative".equals(action)) {

			newAlternative(request, response);
			return;
		}
		if ("listQuestion".equals(action)) {
			
			listQuestion(request, response);
			return;
		}

	}

	/***
	 * Método para consultar lista de perguntas e redirecionar para uma JSP: list-quest.jsp
	 * @param request
	 * @param response
	 */
	private void listQuestion(HttpServletRequest request,
				HttpServletResponse response) {

		List<QuestionAnswer> questions = new ArrayList<QuestionAnswer>();
		
		QuestionAnswerDAO dao = new QuestionAnswerDAO();
		questions = dao.getQuestionAnswerList();
		
		request.getSession().removeAttribute("questions");
		request.getSession().setAttribute("questions", questions);
		
		try {
			response.sendRedirect(request.getContextPath() + "/pages/admin/list-quest.jsp");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		
		}

	private void newAlternative(HttpServletRequest request,
			HttpServletResponse response) {

		int questionId = Integer.parseInt(request.getParameter("questionId"));
		System.out.println("new alternative got questionId = " + questionId);
		
		Question question = new Question();

		// ok
		question = this.getQuestionParametersToAlternative(request, response);

		Alternative alternative = this.insertAlternativeDB(request, response, questionId);
		
		this.listQuestion(request, response);

	}

	private Question getQuestionParametersToAlternative(HttpServletRequest request,
			HttpServletResponse response) {
		
		Integer questionId = Integer.parseInt(request.getParameter("questionId")); 
		String questionDescription =  request.getParameter("questionDescription");
		Integer questionType = Integer.parseInt(request.getParameter("questionType")); 
		Integer questionDifficulty = Integer.parseInt(request.getParameter("questionDifficulty")); 
		Question question = new Question(questionDescription, questionDifficulty, questionType);
		question.setQuestionId(questionId);

		return question;
	}
}
