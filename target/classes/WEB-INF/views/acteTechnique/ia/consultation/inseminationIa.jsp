<sf:form modelAttribute="insemination" method="post" action="${nom}">
	<fieldset>
		<legend>INSEMINATION</legend>

		<label for="operateur">Op&#233rateur :</label>
		<sf:input path="operateur.prenom" name="operateur" disabled="true"/>

		<sf:checkbox path="sexe" value="true" label="Semence sexe" disabled="true"/>
		<br/>

		<label for="taureauList">Nom taureau :</label>
		<sf:input disabled="true" path="taureau.nom"/>

		<label for="taureauListRace">Race :</label>
		<sf:input disabled="true" path="taureau.race"/>

		<label for="taureauListNumIdentification">N&#176 Identification :</label>
		<sf:input disabled="true" path="taureau.num_identification"/>

		<br/>
		<label for="ficheCol">Fiche Col :</label>
		<sf:checkbox disabled="true" path="collecte" value="true"/>
		<sf:input path="ficheCol.nom" disabled="true"/>

	</fieldset>
</sf:form>