<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<section id="sectionAnswer1" class="section type1 section_align_right" >
 <form action="${ pageContext.request.contextPath }/pages/admin/question?action=newAlternative"  method="post" >

	<h3>Resposta Verdadeiro ou Falso</h3>
	<fieldset>
         <input type="radio" name="radioBtn" value="V" />Verdadeiro<br/>
         <input type="radio" name="radioBtn" value="F" />Falso<br />
		<input type="submit" class="submit_question" value="Cadastrar Alternativas" />
     </fieldset>
     	<section style="visibility:hidden">
		<input type="hidden" value="${ questionId }" name="questionId" />
		<input type="hidden" value="${ questionDescription }" name="questionDescription" />
		<input type="hidden" value="${ questionType }" name="questionType" />
		<input type="hidden" value="${ questionDifficulty }" name="questionDifficulty" />
	</section>
    
     </form>
</section>
