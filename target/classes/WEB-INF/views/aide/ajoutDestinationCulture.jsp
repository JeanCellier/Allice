<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Destination Culture</legend>

		<sf:form modelAttribute="destinationCulture" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
			<br/><br/>
			<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Destination Culture existante</legend>

		<c:forEach items="${destinationCultureList}" var="element">
			-<c:out value="${element.nom}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>
<%@ include file="../footersimplifie.jsp" %>