<sf:form method="post" modelAttribute="header" action="${nom}">
	<fieldset>
		<legend>En-t&#234te</legend>

		<!-- Attribut programme -->
		<label for="programme">Programme :</label>
		<sf:input disabled="true" name="programme" path="programme.nom"/>

		<label for="date">Date :</label>
		<sf:input disabled="true" path="date" type="date"/>

		<sf:input disabled="true" path="heure" type="number" maxlength="2" size="2"/> : <sf:input disabled="true"
		                                                                                          path="minute"
		                                                                                          type="number"
		                                                                                          maxlength="2"
		                                                                                          size="2"/>

		<label for="lieu">Lieu :</label>
		<sf:errors path="lieu"/>
		<sf:input path="lieu"/>

		</br>

		<label for="operateur">Op&#233rateur :</label>
		<sf:input path="operateur.prenom" name="operateur" disabled="true"/>

		<label for="ipe">N&#176 IPE :</label>
		<sf:errors path="ipe"/>
		<sf:input path="ipe" disabled="true"/>

		<label for="ipe">Depot Semence :</label>
		<sf:errors path="depotSemence"/>
		<sf:input path="depotSemence" disabled="true"/>

		<label for="snig">Remont&eacute;e SNIG :</label>
		<sf:checkbox path="snig" disabled="true"/>

	</fieldset>
</sf:form>