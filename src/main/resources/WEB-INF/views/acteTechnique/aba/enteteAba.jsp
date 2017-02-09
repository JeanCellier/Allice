<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche ABA : ${nom} </h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="header" action="${nom}">
		<fieldset>
			<legend>En-t&#234te</legend>

			<!-- Attribut programme -->
			<label for="programme">Programme :</label>
			<sf:errors path="programme"/>
			<sf:select name="prog" path="programme">
				<c:forEach items="${programmeList}" var="programme">
					<option value="${programme.id}"><c:out value="${programme.nom}"/></option>
				</c:forEach>
			</sf:select>

			<!--Rajouter ajout nouveau programme  -->

			<!--N° Agrément  -->
			<label for="numeroAgrement">N&#176Agr&#233ment :</label>
			<sf:errors path="numeroAgrement"/>
			<sf:input path="numeroAgrement" type="text"/>

			<label for="date">Date :</label>
			<sf:errors path="date"/>
			<sf:input path="date" type="date"/>

			<label for="abattoir">Abattoir :</label>
			<sf:errors path="abattoir"/>
			<sf:select path="abattoir">
				<c:forEach items="${abattoirList}" var="abattoir">
					<option value="${abattoir.id}" label="${abattoir.nom}"></option>
				</c:forEach>
			</sf:select>
			<!--Rajouter ajout nouvel abattoir  -->

			<label for="operateur">Op&#233rateur :</label>
			<sf:select path="operateur">
				<c:forEach items="${operateurList}" var="operateur">
					<option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"></option>
				</c:forEach>
			</sf:select>

			<label for="temperatureArrivee">T&#176 Arriv&#233e :</label>
			<sf:input path="temperatureArrivee" type="number" size="2" maxlength="2"/>

			<label for="snig">Remont&eacute;e SNIG :</label>
			<sf:checkbox path="snig"/>

			<br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>

</div>

<%@ include file="../../footersimplifie.jsp" %>