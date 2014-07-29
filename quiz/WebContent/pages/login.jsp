<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<title>Quiz</title>

<link rel="stylesheet" href="styles/main.css" type="text/css" />
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>
<script type="text/javascript">
	function testPasswordMatch() {

		//alert('entrou no javascript');
		
		var pass1 = document.getElementById("password-register-1").value;
		var pass2 = document.getElementById("password-register-2").value;
		var span = document.getElementById("span-erro-senha");
		
		if (String(pass1) === String(pass2)) {
			//alert(pass1 + " e " + pass2 + " Coincidem");
			form.submit();
		} else {
			//alert(pass1 + " e " + pass2 + " nao Coincidem");
			span.innerHTML = "Senhas não coincidem.";
		}
	}
	
	function onSubmit(id, action){

		var form = document.getElementById("form-login");
		var id_input = document.getElementById("usuario_id");
		var action_input = document.getElementById("action");

		if (action ==="delete" && confirm('Deseja Excluir este usuario?')){
			// joga pro método Delete
		}

		alert(form.action);
		
		id_input.value = id;
		action_input.value = action;
		form.submit();

	}

</script>
<body class="body">
	<section class="section section-major">
		<header class="mainHeader">
				<jsp:include page="logo.jsp"></jsp:include>
		</header>
		<article>
			<header>
				<h1 class="h1 h1-align-left">Faça o login</h1>
			</header>
			<section class="section section-align-left">
				<h3>Página de Login</h3>
				<c:set var="action" scope="request" value="enter" />
				<form method="post" action="${ pageContext.request.contextPath }/pages/login?action=enter">
				
					<label>Login: </label>
					<input type="text" name="login" /> 
					<label>Senha:</label>
					<input type="password" name="password" /> 
					<input type="submit" class="btn_submit" value="Entrar" />
					<c:if test="${ failed }">
						<span class="span span-error">Usuário ou senha incorreto!</span>
					</c:if>
				
				</form>
			</section>

			<section class="section section-align-right">

				<header>
					<h2>Novo Usuário</h2>
				</header>

				<form method="post" action="${ pageContext.request.contextPath }/pages/login?action=new">
					<div>
						<label>Login: </label> 
						<input type="text" name="login" /> 
						<label>Senha:</label>
						<input type="password" name="password-register-1" id="password-register-1" /> 
						<label>Repita sua Senha: </label> 
						<input type="password" name="password-register-2" id="password-register-2" /> 
						<span class="span span-error" id="span-erro-senha"></span>
						<input type="submit" value="Registrar-se" />
					</div>
				</form>
					<form id="form-login" action="/pages/login" method="post" style="display:none">
					<input style="hidden" value="id" />
					<input style="hidden" value="action" />
				</form>
			</section>
		</article>
	</section>
</body>
</html>