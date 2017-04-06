<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche Tra : ${nom} </h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="fiche" action="${nom}">
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

			<!--N� Agr�ment  -->
			<label for="numeroAgrement">N&#176Agr&#233ment :</label>
			<sf:errors path="numeroAgrement"/>
			<sf:input path="numeroAgrement" type="text"/>

			<label for="lieu">Lieu :</label>
			<sf:errors path="lieu"/>
			<sf:input path="lieu"/>

			</br>

			<label for="date">Date :</label>
			<sf:errors path="date"/>
			<sf:input path="date" type="date"/>

			<label for="date">Heure :</label>
			<sf:input path="heure" type="number" maxlength="2" size="2"/> : <sf:input path="minute" type="number"
			                                                                          maxlength="2" size="2"/>

			<label for="operateur">Op&#233rateur :</label>
			<sf:select path="operateur">
				<c:forEach items="${operateurList}" var="operateur">
					<option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"></option>
				</c:forEach>
			</sf:select>

			<label for="snig">Remont&eacute;e SNIG :</label>
			<sf:checkbox path="snig"/>

			<br/><br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>

</div>

<%@ include file="../../footersimplifie.jsp" %>