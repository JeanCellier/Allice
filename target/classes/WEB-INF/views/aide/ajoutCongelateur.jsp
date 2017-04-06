<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">

<fieldset>
	<legend>Ajout Cong&eacutelateur</legend>
	
	<sf:form modelAttribute="congelateur" method="post">
		<label for="nom">Nom :</label>
		<sf:errors path="nom"/>
		<sf:input path="nom"/>
		<br/><br/>
		<input type="submit" name="Valider" class="valider"/>
	</sf:form>
</fieldset>
<br/>
<fieldset>
	<legend>Cong&eacutelateur existant</legend>

	<c:forEach items="${congelateurList}" var="element">
		-<c:out value="${element.nom}"/>
		<br/>
	</c:forEach>
</fieldset>
</div>
<%@ include file="../footersimplifie.jsp" %>