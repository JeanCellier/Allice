<sf:form method="post" modelAttribute="resultat" action="${nom}">

	<fieldset>
		<legend>RESULTAT COLLECTE</legend>

		<br/>

		<table id="tableauCollecte">
			<tr>
				<th>Viables</th>
				<th>Degeneres</th>
				<th>Non Fecondes</th>
				<th>Total Collectes</th>
			</tr>
			<tr>
				<td><sf:input type="number" path="nombre_Embryons_Viables" disabled="true"/></td>
				<td><sf:input type="number" path="nombre_Embryons_Degeneres" disabled="true"/></td>
				<td><sf:input type="number" path="nombre_Embryons_NonFecondes" disabled="true"/></td>
				<td><sf:input type="number" path="nombre_Embryons_Total" disabled="true"/>
			</tr>
		</table>

		<label for="nombre_CorpsJ_droite">Droite :</label>
		<sf:input path="nombre_CorpsJ_droite" type="number" disabled="true"/>


		<label for="nombre_CorpsJ_gauche">Gauche :</label>
		<sf:input path="nombre_CorpsJ_gauche" type="number" disabled="true"/>

		</br>

		<label for="taux_de_collecte">Taux de collecte estime :</label>
		<sf:input path="taux_de_collecte" disabled="true"/>

		<label for="sanitaire">Sanitaire :</label>
		<sf:radiobutton path="sanitaire" disabled="true"/>

		<br/>

		<br/>

		<label for="remarques">Remarque :</label>
		<br/>
		<sf:textarea path="remarques" name="remarques" cols="40" rows="5" disabled="true"/>

		<br/></br>

	</fieldset>
</sf:form>