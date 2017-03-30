<%@ include file="../header.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Abattoir</legend>
	
		<sf:form modelAttribute="abattoir" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
			<br/><br/>
			<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Abattoir existant</legend>
	
		<c:forEach items="${abattoirList}" var="element">
			<c:out value="${element.nom}"/>
			</br>
		</c:forEach>
	</fieldset>
</div>
<
<%@ include file="../footersimplifie.jsp" %>