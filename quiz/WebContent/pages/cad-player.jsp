<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<title>Quiz</title>

<link rel="stylesheet" href="styles/main.css" type="text/css" />
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body class="body">
	<section class="section section-major">
		<!--  header: contém o logo do site -->
		<header class="mainHeader">
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="menu.jsp"></jsp:include>
		</header>
		
			<article>
			<header>
				<h1 class="h1 h1-align-left">Faça o login</h1>
			</header>
			<section class="section section-align-left">
				<h3>Página de Login</h3>
				<form method="post"
					action="${ pageContext.request.contextPath }/login">
					<label>Login: </label> <input type="text" name="login" /> <label>Senha:</label>
					<input type="password" name="password" /> <input type="submit"
						class="btn_submit" value="Entrar" />
					<c:if test="${ failed }">
						<span class="span span-error">Usuário ou senha incorreto!</span>
					</c:if>
				</form>
			</section>

		</article>
		
	</section>
</body>
</html>