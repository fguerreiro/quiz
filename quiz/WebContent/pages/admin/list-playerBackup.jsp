<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<title>Quiz Game</title>

<script type="text/javascript" >

function teste(){
	alert('teste OK');
}

function onSubmit(receivedId, receivedAction){
	
	alert("recebendo... " + receivedId + " " + receivedAction);
	
	var form = document.getElementById("form-submit");
	
	if (!(receivedAction =="delete" && confirm('Deseja Excluir este usuario?'))){
		document.getElementById("playerId").value = receivedId;
	 	form.action = "${ pageContext.request.contextPath }/pages/admin/player?action=" + receivedAction;
	 	form.submit();
		return true;
	}
	
	//var form = document.getElementById("form-submit");
	//var id_input = document.getElementById("player-id");
	//var action_input = document.getElementById("action");

	
//	if (receivedAction ==="delete" && confirm('Deseja Excluir este usuario?')){
//		// joga pro método Delete
//		//alert(form.action);
//	
//		id_input = receivedId;
//		alert("capturando id input: " + id_input.value);
//		//action_input.setAttribute("name","delete");
//		//action_input.setAttribute("value","delete");
//		//action_input = receivedAction;
//		
//	//	alert("capturando action input: " + action);
//		
//		
//		alert("${ pageContext.request.contextPath }");
//		form.action = "${ pageContext.request.contextPath }/pages/player/" + receivedAction;
//		
//		form.submit();
	//}
}

</script>
<link rel="stylesheet" href="../styles/cad-player.css" type="text/css" />
<link rel="stylesheet" href="../styles/main.css" type="text/css" />

</head>

<body class="body">
	<section class="section section-major">
		<!--  header: contém o logo do site -->
	<header class="mainHeader">
		<jsp:include page="../logo.jsp"></jsp:include>
		<jsp:include page="../menu.jsp"></jsp:include>

		</header>
		<article>
			<div class="fragment-master">
				<header>
					<div class="block_align_left">
						<p>Lista de Jogadores</p>
					</div>
					<div class="block_align_right">
						<!-- <a href="${ pageContext.request.contextPath }/pages/cad-player.jsp">Cadastrar</a> -->
						
						<!-- <form action="${ pageContext.request.contextPath }/player" method="post">
							Lista - <input type="submit" name="listar" />
						</form> -->
					</div>
				</header>

				<table>
					<tr>
						<th>Id</th>
						<th>Jogador</th>
						<th>Privilégio</th>
						<th>Data Cadastro</th>
					</tr>
					<c:forEach var="player" items="${ players }">
						<tr>
							<td>${player.playerId }</td>
							<td>${player.login }</td>
							<c:if test="${player.privileges  == 0 }">
							<td>Administrador</td>
							</c:if>
							<c:if test="${player.privileges  == 1 }">
							<td>Jogador</td>
							</c:if>
							<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${player.registeredAt}" />
							</td>
							<td>
								<button  class="btn btn-submit-excluir" onclick="onSubmit('${player.playerId}', 'delete');">Excluir</button>
							</td>
							<td>
								<button  class="btn btn-submit-editar" onclick="onSubmit('${player.playerId}', 'edit');">Editar</button>
							</td>
						</tr>
					</c:forEach>
				</table>
				<form>
					<input type="submit" value="Primeiro"></input> 
					<input type="submit"value="Anterior"></input> <input type="submit" value="Proximo"></input>
					<input type="submit" value="Ultimo"></input>
				</form>
			</div>
		</article>
		<form id="form-submit" method="post" >
			<input type="hidden" id="playerId" name="playerId"/> 
			<input type="hidden" name="action" id="action"/>
		</form>
	</section>
</body>
</html>