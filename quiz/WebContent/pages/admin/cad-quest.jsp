<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="/WEB-INF/pin-web.tld"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<title>Quiz</title>

<script>

<!--	Função não está sendo mais usada ao invés dela, estou usando o c:if e tratando no Servlet -->

function disableElements(){
	
	alert('teste');	
	var styleHide = "display:none";
	
	var btnShowAlternatives = document.getElementById("btnShowAlternatives");
	alert(btnShowAlternatives);
	
	btnShowAlternatives.setAttribute('style', styleHide);
	
	var selectOption = document.getElementById("selectTypeQuestion");
	alert(selectOption);
	selectOption.disabled=true;
	
}


function showSectionAnswer(){
	var styleString = "display: ''";
	var styleHide = "display:none";
	
	var buttonSubmit = document.getElementById("btnSubmitAnswer");
	//alert('passo1');
	var buttonShowTypeQuestion = document.getElementById("btnShowTypeQuestion");
	
	//alert(buttonShowTypeQuestion);
	buttonSubmit.setAttribute('style', styleString);
	buttonShowTypeQuestion.setAttribute('style', styleHide);
	
	var selectOption = document.getElementById("selectTypeQuestion");
	//alert(selectOption);

	var typeQuestion = selectOption.options[selectOption.selectedIndex].value;
	
	selectOption.disabled=true;
	
	var	 section = document.getElementById("sectionAnswer1");
	var section2 = document.getElementById("sectionAnswer2");
	var section3 = document.getElementById("sectionAnswer3");
	
	
	if(typeQuestion == 1){
	//	alert('typeQuestion cond 1');
		
		section.setAttribute('style', styleString);
		section2.setAttribute('style', styleHide);
		section3.setAttribute('style', styleHide);
	}
	if(typeQuestion == 2){
		//alert('typeQuestion cond 2');
		section.setAttribute('style', styleHide);
		section2.setAttribute('style', styleString);
		section3.setAttribute('style', styleHide);
	}
	if(typeQuestion == 3){
	//	alert('typeQuestion cond 3');
		section.setAttribute('style', styleHide);
		section2.setAttribute('style', styleHide);
		section3.setAttribute('style', styleString);
	}
}

</script>

<link rel="stylesheet" href="../styles/main.css" type="text/css" />
<link rel="stylesheet" href="../styles/cad-quest2.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<sec:security-check adminLevel="true"/>

<body class="body">
	<section class="section section-major">
		<header class="mainHeader">
			<jsp:include page="../logo.jsp"></jsp:include>
			<jsp:include page="../menu.jsp"></jsp:include>
		</header>

		<article>
			<header>
				<h1 class="block_align_left">Cadastrar Pergunta</h1>
			</header>
			<section class="section_align_left">

				 <form method="post" action="${ pageContext.request.contextPath }/pages/admin/question?action=newQuestion">
					<h3>Descrição</h3>
					<textarea ${ disabled } name="questionDescription" rows=4 cols="40"
						 style="resize:none" placeholder="${ questionDescription }"></textarea>
					<label>Tipo Pergunta: </label> 
					<select ${ disabled } id="selectTypeQuestion" name="questionType">
						<option value="1">Verdadeiro ou Falso</option>
						<option value="2">Alternativas</option>
						<option value="3">Palavras</option>
					</select>
					<label>Nível de Dificuldade: </label>
					<select ${ disabled } name="questionDifficulty" id="selectDifQuestion" style="display: ''">
						<option value="1">Fácil</option>
						<option value="2">Médio</option>
						<option value="3">Difícil</option>
						<option value="4">Muito Difícil</option>
					</select>
					<label>type: ${ question.questionType }</label>
					<!-- <button id="btnShowTypeQuestion" style="display:''"  name="btn-answer" value="btn-answer" onclick="showSectionAnswer()">Preencher Resposta</button> -->
					
					
					<input type="submit" ${ disabled } id="btnShowAlternatives" style="margin-left: 20px; display: block;" value="Cadastrar Pergunta" name="cad-resposta"/>
				</form>
				
			</section>
			
<!-- 
			<section ${disableSection1} id="sectionAnswer1" class="section type1 section_align_right" >
 <form action="${ pageContext.request.contextPath }/pages/admin/question?action=newAlternative"  method="post" >
	<h3>Resposta Verdadeiro ou Falso</h3>
	<fieldset>
         <input type="radio" name="animal" value="V" />Verdadeiro<br />
         <input type="radio" name="animal" value="F" />Falso<br />
         <input type="submit" value="OK" />
		<input type="hidden" value="${ questionId }" name="questionId" />

     </fieldset>
     </form>
</section>

<section ${disableSection2} id="sectionAnswer2" class="section type2 section_align_right" >
 <form action="${ pageContext.request.contextPath }/pages/admin/question?action=newAlternative"  method="post" >
	<h3>Alternativas - marque as corretas</h3>
		<input type="checkbox" name="alt1"/><textarea  rows="4" cols="40" name="alt1-text"></textarea>
		<input type="checkbox" name="alt2"/><textarea  rows="4" cols="40" name="alt2-text"></textarea>
		<input type="checkbox" name="alt3"/><textarea  rows="4" cols="40" name="alt3-text"></textarea>
		<input type="checkbox" name="alt4"/><textarea  rows="4" cols="40" name="alt4-text"></textarea> 
</form>
</section>

<section ${disableSection3} id="sectionAnswer3" class="section type3 section_align_right" >
 <form action="${ pageContext.request.contextPath }/pages/admin/question?action=newAlternative"  method="post" >
	<h3>Resposta por extenso 3:</h3>
	<textarea name="textarea" rows=4 cols="30" placeholder="Digite aqui..."></textarea>]
	</form>
</section> -->
		
		<c:if test="${ questionType == 1 }">
			<jsp:include page="cad-quest-type1.jsp"></jsp:include>
		</c:if>
		<c:if test="${ questionType == 2 }">
			<jsp:include page="cad-quest-type2.jsp"></jsp:include>
		</c:if>
		<c:if test="${ questionType == 3 }">
			<jsp:include page="cad-quest-type3.jsp"></jsp:include>
		</c:if> 
		
		</article>
	</section>
	
</body>
</html>