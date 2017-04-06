<sf:form method="post" modelAttribute="fiche" action="${nom}">
	<fieldset>
		<legend>En-t&#234te</legend>

		<label for="programme">Programme :</label>
		<sf:input disabled="true" name="programme" path="programme.nom"/>

		<label for="numeroAgrement">N&#176Agr&#233ment :</label>
		<sf:input disabled="true" path="numeroAgrement" type="text"/>

		<label for="lieu">Lieu :</label>
		<sf:input disabled="true" path="lieu" type="lieu"/>

		</br>

		<label for="date">Date :</label>
		<sf:input disabled="true" path="date" type="date"/>

		<sf:input disabled="true" path="heure" type="number" maxlength="2" size="2"/> : <sf:input disabled="true"
		                                                                                          path="minute"
		                                                                                          type="number"
		                                                                                          maxlength="2"
		                                                                                          size="2"/>


		<label for="operateur">Op&eacute;rateur :</label>
		<sf:input path="operateur.nom" disabled="true"/>

		<label for="snig">Remont&eacute;e SNIG :</label>
		<sf:checkbox path="snig" disabled="true"/>

		<br/>
	</fieldset>
</sf:form>