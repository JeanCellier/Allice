<sf:form modelAttribute="ovocytesCollectes" method="post" action="${nom}">
	<fieldset>
		<legend>DETAILS COMPLEXE OVOCYTES-CUMULUS (COCs) COLLECTES</legend>

		<table id="tableauCollectOvocytes">
			<tr>
				<th>Nb COCs</th>
				<th>Maturit&eacute;</th>
				<th>Qualit&#233</th>
				<th>Destination</th>
				<th>Autres utilisation</th>
			</tr>

			<c:choose>
				<c:when test="${ovocytesCollectes.tableauOvocytes_collectesList.size()>0}">
					<c:forEach begin="0" end="${ovocytesCollectes.tableauOvocytes_collectesList.size()-1}"
					           varStatus="vs">
						<tr>
							<td><sf:input disabled="true" type="number"
							              path="tableauOvocytes_collectesList[${vs.current}].nb_cocs"/></td>
							<td><sf:radiobutton disabled="true"
							                    path="tableauOvocytes_collectesList[${vs.current}].mature"
							                    value="true"/>Mature<br>
								<sf:radiobutton disabled="true"
								                path="tableauOvocytes_collectesList[${vs.current}].mature"
								                value="false"/>Immature
							</td>
							<td><sf:input disabled="true"
							              path="tableauOvocytes_collectesList[${vs.current}].qualite.nom"/></td>
							<td><sf:radiobutton disabled="true" path="tableauOvocytes_collectesList[${vs.current}].fiv"
							                    value="true"/>Cryo
									<sf:radiobutton disabled="true"
									                path="tableauOvocytes_collectesList[${vs.current}].fiv"
									                value="false"/>D&#233truit
							<td><sf:input disabled="true"
							              path="tableauOvocytes_collectesList[${vs.current}].utilisation"/></td>

						</tr>
					</c:forEach>
				</c:when>
			</c:choose>

		</table>

		<br/>
		<label for="sanitaire">Sanitaire :</label>
		<sf:radiobutton path="sanitaire" value="${sanitaire.id}" label="${sanitaire.nom}"/>


		<br/><br/>
		<label for="remarqueFecondationInVitro">Remarque :</label><br/>
		<sf:textarea disabled="true" path="remarques" name="remarqueFecondationInVitro" cols="40" rows="5"/>
		<br/> <br/>
	</fieldset>
</sf:form>
