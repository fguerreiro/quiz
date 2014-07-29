<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section>
<article>
<h1>Editar Jogador</h1>
<form method="post" action="${ pageContext.request.contextPath }/pages/player?action=editSubmit">
	Id: <input type="hidden" value="${ player.playerId }" name="playerId" />
	Login: <input type="text" value="${ player.login }" name="playerLogin"/>
	Senha: <input type="text" value="${ player.password }" name="playerPassword"/>
	Privilégio de Administrador: <input type="checkbox" ${ player.privileges == '0' ? 'checked' : ''} name="playerPrivileges"/>Admin  
	<input type="submit" />
</form>
</article>
</section>

</body>
</html>