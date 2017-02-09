<sf:form modelAttribute="insemination" method="post" action="${nom}">
	<fieldset>
		<legend>INSEMINATION</legend>

		<label for="operateur">Op&#233rateur :</label>
		<sf:input path="operateur.prenom" name="operateur" disabled="true"/>


		<sf:checkbox path="sexe" value="true" label="Semence sexe" disabled="true"/>
		<br/>

		<sf:input disabled="true" path="taureau.nom"/>
		<sf:input disabled="true" path="taureau.race"/>
		<sf:input disabled="true" path="taureau.num_identification"/>

		<br/>
		<label for="ficheColList">Fiche Col :</label>
		<sf:checkbox disabled="true" path="collecte" value="true"/>
		<sf:input path="ficheColList.nom" disabled="true"/>

	</fieldset>
</sf:form>