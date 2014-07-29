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
import br.unifor.ads.pin.domain.Player;
import br.unifor.ads.pin.domain.Question;
import br.unifor.ads.pin.domain.QuestionAnswer;
import br.unifor.ads.pin.model.QuestionAnswerDAO;

/**
 * Servlet implementation class Game
 */
@WebServlet("/pages/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("action = " + action);

		Player player = new Player();
		player = (Player) request.getSession().getAttribute("player");

		if ("play".equals(action)) {

			QuestionAnswerDAO questionAnswerDAO = new QuestionAnswerDAO();
			Question question = questionAnswerDAO.checkNextQuestion(player
					.getPlayerId());

			question.setQuestionId(1);

			Alternative alt = new Alternative();
			alt.setAlternativeNumber(1);
			alt.setCorrect(true);
			alt.setDescription("É um objeto descendente de List");
			alt.setQuestion(question);

			request.setAttribute("alternative1", alt);

			if (question.getQuestionType() == 2) {

				Alternative alt2 = new Alternative();
				alt2.setAlternativeNumber(2);
				alt2.setCorrect(false);
				alt2.setDescription("É um objeto descendente de ArrayList");
				alt2.setQuestion(question);
				request.setAttribute("alternative2", alt2);

				Alternative alt3 = new Alternative();
				alt3.setAlternativeNumber(3);
				alt3.setCorrect(false);
				alt3.setDescription("É um objeto descendente de HashMap");
				alt3.setQuestion(question);
				request.setAttribute("alternative3", alt3);

				Alternative alt4 = new Alternative();
				alt4.setAlternativeNumber(4);
				alt4.setCorrect(true);
				alt4.setDescription("É um objeto descendente de Generics");
				alt4.setQuestion(question);
				request.setAttribute("alternative4", alt4);

			}
			request.setAttribute("question", question);

			String path = "/pages/play.jsp";

			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);

			return;
		}
		if ("submit".equals(action)) {

			// # TODO fazer consulta de verificação se página está correta
			// se sim, vai pra questão seguinte e soma pontos no player
			// se não, mostra resposta e vai pra próxima pergunta (sem somar
			// pontos)

			getParametersQuestionAnswer(request, response, player);

			verifyPlayerAnswer(request, response, player);

			return;
		}

	}

	private void verifyPlayerAnswer(HttpServletRequest request,
			HttpServletResponse response, Player player) {
		// TODO Auto-generated method stub

		QuestionAnswerDAO dao = new QuestionAnswerDAO();
		// dao.verifyPlayerAnswer();

	}

	private void getParametersQuestionAnswer(HttpServletRequest request,
			HttpServletResponse response, Player player) {

		Question question = getQuestionParameters(request);

		QuestionAnswerDAO questionAnswerDAO = new QuestionAnswerDAO();

		int countCorrectAlternatives = 0;

		if (question.getQuestionType() == 1) {

			String answer;
			answer = request.getParameter("answerTrue") != null ? "V" : "F";

			if (questionAnswerDAO.verifyCorrectAnswer(answer) == true) {

				// Alternativa Correta
				countCorrectAlternatives = 1;

			}
		}

		if (question.getQuestionType() == 2) {

			if (request.getParameter("alt1Chk") != null) {

				String answer1 = request.getParameter("answer1");
				if (questionAnswerDAO.verifyCorrectAnswer(answer1) == true) {
					// Alternativa Correta
					countCorrectAlternatives++;
				}
			}

			if (request.getParameter("alt2Chk") != null) {

				String answer2 = request.getParameter("answer2");

				if (questionAnswerDAO.verifyCorrectAnswer(answer2) == true) {
					// Alternativa Correta
					countCorrectAlternatives++;
				}
			}

			if (request.getParameter("alt3Chk") != null) {

				String answer3 = request.getParameter("answer3");

				if (questionAnswerDAO.verifyCorrectAnswer(answer3) == true) {

					// Alternativa Correta
					countCorrectAlternatives++;

				}
			}

			if (request.getParameter("alt4Chk") != null) {

				String answer4 = request.getParameter("answer4");

				if (questionAnswerDAO.verifyCorrectAnswer(answer4) == true) {

					// Alternativa Correta
					countCorrectAlternatives++;
				}
			}
		}

		if (question.getQuestionType() == 3) {

			String answer = request.getParameter("answer");

			if (questionAnswerDAO.verifyCorrectAnswer(answer) == true) {
				// Alternativa Correta
				countCorrectAlternatives = 1;
			}
		}

	}

	private Question getQuestionParameters(HttpServletRequest request) {
		Integer questionId = Integer.parseInt(request
				.getParameter("questionId"));
		String questionDescription = request
				.getParameter("questionDescription");
		Integer questionType = Integer.parseInt(request
				.getParameter("questionType"));
		Integer questionDifficulty = Integer.parseInt(request
				.getParameter("questionDifficulty"));

		Question question = new Question(questionDescription,
				questionDifficulty, questionType);
		question.setQuestionId(questionId);
		return question;
	}

}
