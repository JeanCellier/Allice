<sf:form method="post" modelAttribute="header" action="${nom}">
	<fieldset>
		<legend>En-t&#234te</legend>

		<!-- Attribut programme -->
		<label for="programme">Programme :</label>
		<sf:input disabled="true" name="programme" path="programme.nom"/>

		<!--Rajouter ajout nouveau programme  -->

		<!--N� Agr�ment  -->
		<label for="numeroAgrement">N&#176Agr&#233ment :</label>
		<sf:input disabled="true" path="numeroAgrement" type="text"/>

		<label for="date">Date :</label>
		<sf:input disabled="true" path="date" type="date"/>

		</br>

		<label for="abattoir">Abattoir :</label>
		<sf:input path="abattoir.nom" name="abattoir" disabled="true"/>
		<!--Rajouter ajout nouvel abattoir  -->

		<label for="operateur">Op&#233rateur :</label>
		<sf:input path="operateur.prenom" name="operateur" disabled="true"/>

		<label for="temperatureArrivee">T&#176 Arriv&#233e :</label>
		<sf:input disabled="true" path="temperatureArrivee" type="number" size="2" maxlength="2"/>

		<label for="snig">Remont&eacute;e SNIG :</label>
		<sf:checkbox path="snig" disabled="true"/>

		<br/>
	</fieldset>
</sf:form>