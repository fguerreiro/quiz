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

<link rel="stylesheet" href="styles/sobre.css" type="text/css" />
<link rel="stylesheet" href="styles/play.css" type="text/css" />
<link rel="stylesheet" href="styles/main.css" type="text/css" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body class="body">
	<section class="section section-major">
		<header class="mainHeader">
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="menu.jsp"></jsp:include>
		</header>
		<article class="article play-article">
			<header>
				<h1>Jogo</h1>
				<h5>${ player.login } - Id: ${ player.playerId }</h5>
			</header>
				<h2>${question.description}</h2>
		
		<!--  Pergunta de V ou F -->		
		<c:if test="${ question.questionType == 1 }">
			 <form action="${ pageContext.request.contextPath }/pages/game?action=submit"  style="display: inline-flex;"method="post" >
				<input type="radio" name="answerTrue" value="V" checked />Verdadeiro
	    	     <input type="radio" name="" value="F" />Falso
				<input type="submit" class="submit_question" value="Responder" />

				<section style="visibility:hidden">
					<input type="hidden" value="${ questionId }" name="questionId" />
					<input type="hidden" value="${ questionDescription }" name="questionDescription" />
					<input type="hidden" value="${ questionType }" name="questionType" />
					<input type="hidden" value="${ questionDifficulty }" name="questionDifficulty" />
				</section>	
			</form>
		</c:if>
		
		
		<c:if test="${ question.questionType == 2 }">
			<form action="${ pageContext.request.contextPath }/pages/game?action=submit"  method="post" >
				<table>
				<tr>
					<th>Marque se correta</th>
					<th>Opção</th>
				
				</tr>
				<tr>
					<td><input type="checkbox" name="alt1Chk" /></td>
					<td><label>${alternative1.description}</label></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="alt2Chk"/></td>
					<td><label>${alternative2.description}</label></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="alt3Chk" /></td>
					<td><label>${alternative3.description}</label></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="alt4Chk" /></td>
					<td><label>${alternative4.description}</label></td>
				</tr>
				<tr><td>
					<input type="submit" class="submit_question" value="Responder" />

				</td></tr>
				</table>			
				
				<section style="visibility:hidden">
					<input type="hidden" value="${ questionId }" name="questionId" />
					<input type="hidden" value="${ questionDescription }" name="questionDescription" />
					<input type="hidden" value="${ questionType }" name="questionType" />
					<input type="hidden" value="${ questionDifficulty }" name="questionDifficulty" />
				</section>	
			
			</form>
		
		</c:if>
		<c:if test="${ questionType == 3 }">
			<form action="${ pageContext.request.contextPath }/pages/game?action=submit"  method="post" >

				<input type="text" name="answer" />
				<input type="submit" class="submit_question" value="Responder" />
	
				<section style="visibility:hidden">
					<input type="hidden" value="${ questionId }" name="questionId" />
					<input type="hidden" value="${ questionDescription }" name="questionDescription" />
					<input type="hidden" value="${ questionType }" name="questionType" />
					<input type="hidden" value="${ questionDifficulty }" name="questionDifficulty" />
				
				</section>
			</form>		
		</c:if> 
			
		</article>

		<aside class="circle aside aside-top">
			<section>
				<h2>Pergunta #${question.questionId}</h2>
				<p>56</p>
			</section>
		</aside>

		<aside class="circle aside aside-middle">
			<section>
				<h2>${player.lifePoints} Vidas</h2>
				<p>2</p>
			</section>
		</aside>

		<aside class="circle aside aside-bottom" >
			<section>
				<h2>Pontos</h2>
				<p>${player.score}</p>
			</section>
		</aside>


		<footer class="mainFooter">
			<p>Copyright 2013 Francisco Guerreiro</p>
		</footer>

	</section>
</body>
</html>