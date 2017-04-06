<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Millieu MIV</legend>

		<sf:form modelAttribute="milieuMaturation" method="post">
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
		<legend>Millieu MIV existant</legend>

		<c:forEach items="${milieuMaturationList}" var="element">
			-<c:out value="${element.nom}"/> <c:out value="${element.numeroLot}"/>
			<br/>
		</c:forEach>
	</fieldset>
</div>
<%@ include file="../footersimplifie.jsp" %>