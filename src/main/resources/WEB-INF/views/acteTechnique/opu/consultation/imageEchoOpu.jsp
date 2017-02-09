<sf:form modelAttribute="imageEcho" method="post" action="${nom}">
	<fieldset>
		<legend>TRAITEMENT DONNEUSE</legend>

		<label>Image &eacute;cographe :</label>
		<table id="tableauImageEcho">
			<tr>
				<th>Ovaires</th>
				<th>D&eacute;nombr&eacute;s<br></th>
				<th>Aspir&eacute;s</th>
			</tr>
			<tr>
				<td>Droit</td>
				<td><sf:input disabled="true" type="number" path="nb_ovaire_denombre_droit"/></td>
				<td><sf:input disabled="true" type="number" path="nb_ovaire_aspire_droit"/></td>
			</tr>
			<tr>
				<td>Gauche</td>
				<td><sf:input disabled="true" path="nb_ovaire_denombre_gauche"/></td>
				<td><sf:input disabled="true" type="text" path="nb_ovaire_aspire_gauche"/></td>
			</tr>
		</table>

		<label>Nb de COCs retrouv&eacute;s</label>
		<sf:input disabled="true" path="nb_cocs" type="number"/>

		<label>Taux de collecte (%) : </label>
		<sf:input path="taux_collecte" disabled="true"/>

		<br/>
		<label for="remarque">Remarque :</label><br/>
		<sf:textarea disabled="true" path="remarques" name="remarqueFecondationInVitro" cols="40" rows="5"/>
		=
	</fieldset>
</sf:form>
