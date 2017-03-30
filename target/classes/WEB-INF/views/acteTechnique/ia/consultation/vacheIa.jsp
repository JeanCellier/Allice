<sf:form method="post" modelAttribute="vache" action="${nom}">
	<fieldset>
		<legend>Identification donneuse</legend>

		<!-- Attribut proprietaire -->
		<label for="proprietaire">Proprietaire :</label>
		<sf:input path="proprietaire" disabled="true"/>

		</br>

		<label for="num_elevage">Numero elevage:</label>
		<sf:input path="num_elevage" type="text" disabled="true"/>

		</br>

		<label for="num_identification">Numero Identification :</label>
		<sf:input path="num_identification" type="number" disabled="true"/>


		<label for="num_travail">Numero travail :</label>
		<sf:input path="num_travail" type="number" disabled="true"/>
		<!--Rajouter ajout nouvel abattoir  -->

		<label for="race">Race :</label>
		<sf:input path="race" type="number" disabled="true"/>

		</br>

		<label for="parite">Parit&#233; :</label>
		<sf:input path="parite" disabled="true"/>

	</fieldset>
</sf:form>