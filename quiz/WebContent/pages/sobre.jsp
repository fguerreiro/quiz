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
<link rel="stylesheet" href="styles/main.css" type="text/css" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body class="body">
	<section class="section section-major">
		<!--  header: contÃ©m o logo do site -->
		<header class="mainHeader">
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="menu.jsp"></jsp:include>
		</header>
		<article>
			<header>
				<h1>Sobre o Quiz Generator</h1>
			</header>
			<p>Este jogo foi idealizado por Francisco Guerreiro e feito na
				nota da disciplina Projeto Integrador: Desenvolvimento Web,
				Professor Glauco Aquino.</p>
			<footer>
				<h4>Dúvidas ou sugestões ?</h4>
			</footer>
		</article>

		<aside class="aside aside-top">
			<section>
				<h2>Top sidebar</h2>
				<p>"Lorem ipsum dolor sit amet"</p>
			</section>
		</aside>

		<aside class="aside aside-middle">
			<section>
				<h2>Middle sidebar</h2>
				<p>"Lorem ipsum dolor sit amet"</p>
			</section>
		</aside>

		<aside class="aside aside-bottom">
			<section>
				<h2>Bottom sidebar</h2>
				<p>"Lorem ipsum dolor sit amet"</p>
			</section>
		</aside>


		<footer class="mainFooter">
			<p>Copyright 2013 Francisco Guerreiro</p>
		</footer>

	</section>
</body>
</html>