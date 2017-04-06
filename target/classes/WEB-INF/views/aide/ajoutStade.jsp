<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Stade</legend>

		<sf:form modelAttribute="stade" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
	
			<label for="numero">Numero de lot :</label>
			<sf:errors path="numero"/>
			<sf:input type="number" path="numero"/>
				<br/><br/>
				<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Stade existant</legend>

		<c:forEach items="${stadeList}" var="element">
			-<c:out value="${element.nom}"/> <c:out value="${element.numero}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>
<%@ include file="../footersimplifie.jsp" %>