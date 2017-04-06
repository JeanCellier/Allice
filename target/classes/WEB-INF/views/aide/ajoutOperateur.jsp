<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Op&eacuterateur</legend>

		<sf:form modelAttribute="operateur" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
			<label for="prenom">Pr&eacutenom :</label>
			<sf:errors path="prenom"/>
			<sf:input path="prenom"/>
				<br/><br/>
				<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Op&eacuterateur existant</legend>

		<c:forEach items="${operateurList}" var="element">
			-<c:out value="${element.prenom} ${element.nom}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>

<%@ include file="../footersimplifie.jsp" %>