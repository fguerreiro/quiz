<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<title>Quiz Game</title>

<script>
	function teste() {

	}
</script>

<link rel="stylesheet" href="../styles/cad-player.css" type="text/css" />
<link rel="stylesheet" href="../styles/main.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body class="body">
	<section class="section section-major">
		<!--  header: contÃ©m o logo do site -->
		<header class="mainHeader">
	<jsp:include page="../logo.jsp"></jsp:include>
	<jsp:include page="../menu.jsp"></jsp:include>

		</header>
		<article>
			<div class="fragment-master">
				<header>
					<div class="block_align_left">
						<p>Perguntas</p>
					</div>
					<div class="block_align_right">
						<a href="${ pageContext.request.contextPath }/pages/admin/cad-quest.jsp">Cadastrar</a>
					</div>
				</header>

				<table>
					<tr>
						<th>Id</th>
						<th>Pergunta</th>
						<th>Tipo Pergunta</th>
						<th>Resposta</th>
					</tr>
					
					<c:forEach var="question" items="${ questions }">
					<tr>
						<td>${question.id}</td>
						<td>${question.question }</td>
						<c:if test="${question.questionType  == 0 }">
						<td>V ou F</td>
						</c:if>
						<c:if test="${question.questionType  == 1 }">
						<td>Alternativas</td>
						</c:if>
						<c:if test="${question.questionType  == 2 }">
						<td>Palavra</td>
						</c:if>
						<td>${question.answer }</td>
						<!--  <td>
							<button  class="btn btn-submit-excluir" onclick="onSubmit('${player.playerId}', 'delete');">Excluir</button>
						</td>
						<td>
							<button  class="btn btn-submit-editar" onclick="onSubmit('${player.playerId}', 'edit');">Editar</button>
						</td>
						</tr>-->
					</c:forEach>
				</table>

				<form>
					<input type="submit" value="Primeiro"></input> <input type="submit"
						value="Anterior"></input> <input type="submit" value="Próximo"></input>
					<input type="submit" value="Ãltimo"></input>

				</form>
			</div>
		</article>
		<form id="form-cadastro" action="/jogadores" method="post" style="">
			<input type="hidden" value="jogador_id" /> <input type="hidden"
				value="action" />
		</form>
	</section>

</body>
</html>