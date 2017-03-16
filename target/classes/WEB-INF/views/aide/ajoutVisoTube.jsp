<%@ include file="../header.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Viso Tube</legend>

			<sf:form modelAttribute="visoTube" method="post">
				<label for="numero">Numero :</label>
				<sf:errors path="numero"/>
				<sf:input type="number" path="numero"/>
		
				<label for="couleur">Couleur :</label>
				<sf:errors path="couleur"/>
				<sf:input path="couleur"/>
					<br/><br/>
					<input type="submit" name="Valider" class="valider"/>
			</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Viso Tube existant</legend>

			<c:forEach items="${visoTubeList}" var="element">
				-<c:out value="${element.couleur} ${element.numero}"/>
				<br/>
			</c:forEach>
	</fieldset>
</div>

<%@ include file="../footersimplifie.jsp" %>