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

<link rel="stylesheet" href="styles/cad-player.css" type="text/css" />
<link rel="stylesheet" href="styles/main.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body class="body">
	<section class="section section-major">
		<!--  header: contÃ©m o logo do site -->
		<header class="mainHeader">
			<h1 class="logo">
				<a title=".: Projeto Integrador: Quiz :." href="cad-player.jsp">
					<span></span>
				</a>
			</h1>
			<jsp:include page="menu.jsp"></jsp:include>

		</header>
		<article>
			<div class="fragment-master">
				<header>
					<div class="block_align_left">
						<p>Ranking</p>
					</div>
					<div class="block_align_right">
						<p></p>
					</div>
				</header>

				<table>
					<tr>
						<th>Ranking</th>
						<th>Jogador</th>
						<th>Tempo Jogo</th>
						<th>Pontos</th>
					</tr>
					<tr>
						<td>1st</td>
						<td>Francisco Guerreiro</td>
						<td>29:47 h</td>
						<td>989</td>
					</tr>

					<tr>
						<td>2nd</td>
						<td>Diane K. Fields</td>
						<td>21:20 h</td>
						<td>455</td>
					<tr>
						<td>3rd</td>
						<td>Brian Basham</td>
						<td>16:56 h</td>
						<td>388</td>
					<tr>
						<td>4th</td>
						<td>Kathy Sierra</td>
						<td>11:25 h</td>
						<td>379</td>
					<tr>
						<td>5th</td>
						<td>Bert Bates</td>
						<td>08:13 h</td>
						<td>244</td>
						</tr>
				</table>

				<form>
					<input type="submit" value="Primeiro"></input> <input type="submit"
						value="Anterior"></input> <input type="submit" value="PrÃ³ximo"></input>
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