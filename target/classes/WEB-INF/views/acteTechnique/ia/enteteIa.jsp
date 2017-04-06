<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche IA : ${nom} </h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="fiche" action="${nom}">
		<fieldset>
			<legend>En-t&#234te</legend>

			<label for="date">Date :</label>
			<sf:errors path="date"/>
			<sf:input path="date" type="date"/>

			<sf:input path="heure" type="number" maxlength="2" size="2" /> : <sf:input path="minute" type="number" maxlength="2" size="2"/>

			<label for="lieu">Lieu :</label>
			<sf:errors path="lieu"/>
			<sf:input path="lieu" disabled="true"/>

			</br>
			<!-- Attribut programme -->
			<label for="programme">Programme :</label>
			<sf:errors path="programme"/>
			<sf:select name="prog" path="programme">
				<c:forEach items="${programmeList}" var="programme">
					<option value="${programme.id}"><c:out value="${programme.nom}"/></option>
				</c:forEach>
			</sf:select>

			<label for="ipe">N&#176 IPE :</label>
			<sf:errors path="ipe"/>
			<sf:input path="ipe" type="text"/>

			<label for="ipe">Depot Semence :</label>
			<sf:errors path="depotSemence"/>
			<sf:input path="depotSemence" type="text"/>

			<label for="snig">Remont&eacute;e SNIG :</label>
			<sf:checkbox path="snig"/>

			</br>
			<br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>

</div>

<%@ include file="../../footer.jsp" %>