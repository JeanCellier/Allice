<sf:form method="post" modelAttribute="embryonsTransferes" action="${nom}">
		<fieldset>
			<legend>Embryon(s) transféré(s) :</legend>

			<table>
				<tr>
					<td><label for="">Référence expérience production d'embryon(s) :</label>
						<sf:input disabled="true" path="refExperience" type="text"/></td>

					<td><label for="">Semence sexée :</label>
						<sf:checkbox disabled="true" path="sexe"/></td>
				</tr>
				<tr>
					<td><label for="refEmbryons">N° embryon :</label>
						<sf:input disabled="true" path="refEmbryons" type="text"/></td>
					<td><label for="taureau">Race taureau :</label>
						<sf:input disabled="true" path="taureau.race" type="text"/></td>
					<td><label for="taureau">N° taureau :</label>
						<sf:input disabled="true" path="taureau.num_identification" type="text"/></td>
				</tr>
				<tr>
					<td><label for="">Côté transfert :</label>
							<sf:radiobutton disabled="true" path="cote" value="true"/>Droit
							<sf:radiobutton disabled="true" path="cote" value="false"/>Gauche
				</tr>
				<tr>
					<td><label for="">Emplacement dans la corne utérine :</label>
						<sf:input disabled="true" path="tiers" type="number"/></td>
				</tr>
				<tr>
					<td><label for="">Facilité de progression :</label>
						<sf:input disabled="true" path="faciliteprogression" type="text"/></td>
				</tr>
			</table>


			<br/>
		</fieldset>
	</sf:form>
