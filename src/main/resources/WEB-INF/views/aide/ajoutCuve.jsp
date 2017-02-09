<%@ include file="../header.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Cuve</legend>

		<sf:form modelAttribute="cuve" method="post">
			<label for="nom">Nom :</label>
			<sf:errors path="nom"/>
			<sf:input path="nom"/>
	
			<label for="nom">Designation :</label>
			<sf:errors path="designation"/>
			<sf:input path="designation"/>
			<br/><br/>
			<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>

<br/>
	<fieldset>
		<legend>Cuve existant</legend>

		<c:forEach items="${cuveList}" var="element">
			-<c:out value="${element.nom}"/> <c:out value="${element.designation}"/>
			<br/>
		</c:forEach>
	</fieldset>

</div>

<%@ include file="../footersimplifie.jsp" %>