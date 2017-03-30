<%@ include file="../header.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Type Culture</legend>

		<sf:form modelAttribute="typeCulture" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
	
			<label for="nom">Numero de lot :</label>
			<sf:errors path="numeroLot"/>
			<sf:input path="numeroLot"/>
				<br/><br/>
				<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Millieu CIV existant</legend>

		<c:forEach items="${typeCulturelist}" var="element">
			-<c:out value="${element.nom} ${element.numeroLot}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>

<%@ include file="../footersimplifie.jsp" %>