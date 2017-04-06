<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Qualit&eacute</legend>

		<sf:form modelAttribute="progression" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
	
			<label for="numero">Num&eacutero de lot :</label>
			<sf:errors path="numero"/>
			<sf:input type="number" path="numero"/>
				<br/><br/>
				<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Qualit&eacute existant</legend>

		<c:forEach items="${qualiteList}" var="element">
			-<c:out value="${element.nom} ${element.numero}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>


<%@ include file="../footersimplifie.jsp" %>