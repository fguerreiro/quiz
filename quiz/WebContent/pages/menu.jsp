<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" href="styles/cad-player.css" type="text/css" />
<link rel="stylesheet" href="styles/main.css" type="text/css" />
<nav>
<div class="div div-player-name" >
		<label class="label label-player-name">${player.login}</label>
		<c:if test="${player.privileges  == 0 }">
		<label class="label label-player-privileges-admin">Administrador</label>
		</c:if>
		<c:if test="${player.privileges  == 1 }">
		<label class="label label-player-privileges-player">Jogador</label>
		</c:if>
	</div>
	<ul>
		<li><a href="${ pageContext.request.contextPath }/pages/game?action=play">Jogar</a></li>
		<c:if test="${player.privileges == 0 }"> 
		<li><a href="${ pageContext.request.contextPath }/pages/admin/player">Jogadores</a></li>
		<li><a href="${ pageContext.request.contextPath }/pages/admin/question?action=listQuestion">Perguntas</a></li>
		</c:if>
		<li><a href="${ pageContext.request.contextPath }/pages/ranking.jsp">Ranking</a></li>
		<li><a href="${ pageContext.request.contextPath }/pages/sobre.jsp">Sobre</a></li>
	</ul>
	
</nav>