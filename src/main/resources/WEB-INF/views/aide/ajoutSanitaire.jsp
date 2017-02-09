<%@ include file="../header.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Sanitaire</legend>

		<sf:form modelAttribute="sanitaire" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
				<br/><br/>
				<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Sanitaire existant</legend>

		<c:forEach items="${sanitaireList}" var="element">
			-<c:out value="${element.nom}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>

<%@ include file="../footersimplifie.jsp" %>