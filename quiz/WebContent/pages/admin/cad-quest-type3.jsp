<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<section  id="sectionAnswer3" class="section type3 section_align_right" >
 <form action="${ pageContext.request.contextPath }/pages/admin/question?action=newAlternative"  method="post" >
	<h3>Resposta por extenso 3:</h3>
	<textarea name="textarea" rows=4 cols="30" placeholder="Digite aqui..."></textarea>
		<section style="visibility:hidden">
		<input type="hidden" value="${ questionId }" name="questionId" />
		<input type="hidden" value="${ questionDescription }" name="questionDescription" />
		<input type="hidden" value="${ questionType }" name="questionType" />
		<input type="hidden" value="${ questionDifficulty }" name="questionDifficulty" />
		<input type="submit" class="submit_question" value="Criar Pergunta" />
	</section>
	</form>
</section>
