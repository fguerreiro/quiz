<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<link rel="stylesheet" href="styles/main.css" type="text/css" />
<link rel="stylesheet" href="styles/cad-quest2.css" type="text/css" />

<section id="sectionAnswer2" class="section type2 section_align_right" >
 <form action="${ pageContext.request.contextPath }/pages/admin/question?action=newAlternative"  method="post" >
	<h3>Alternativas - marque as corretas</h3>
	
		<input type="checkbox" name="alt1Chk" /><label for="alt1Chk">Maque se correta</label>
		<textarea  rows="3" cols="30" name="alt1Text"></textarea>
		
		<input type="checkbox" name="alt2Chk"/><label for="alt2Chk">Maque se correta</label>
		<textarea  rows="3" cols="30" name="alt2Text"></textarea>
		
		<input type="checkbox" name="alt3Chk"/><label for="alt3">Maque se correta</label>
		<textarea  rows="3" cols="30" name="alt3Text"></textarea>
		
		<input type="checkbox" name="alt4Chk"/><label for="alt4">Maque se correta</label>
		<textarea  rows="3" cols="30" name="alt4Text"></textarea> 
		
		<input type="submit" class="submit_question" value="Criar Pergunta" />

	
	<section style="visibility:hidden">
		<input type="hidden" value="${ questionId }" name="questionId" />
		<input type="hidden" value="${ questionDescription }" name="questionDescription" />
		<input type="hidden" value="${ questionType }" name="questionType" />
		<input type="hidden" value="${ questionDifficulty }" name="questionDifficulty" />
	</section>
</form>
</section>
