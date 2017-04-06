<sf:form modelAttribute="fecondationInvitro" method="post" action="${nom}">
	<fieldset>
		<legend>FECONDATION IN VITRO</legend>

		<label for="date">Date :</label>
		<sf:input disabled="true" path="date" type="date" name="dateFecondationInVitro"/>

		<label for="sanitaireFecondationInVitro">Sanitaires :</label>
		<c:choose>
			<c:when test="${fecondationInvitro.sanitaireList.size()>0}">
				<c:forEach begin="0" end="${fecondationInvitro.sanitaireList.size()-1}" varStatus="vs">
					<sf:checkbox disabled="true" path="sanitaireList[${vs.current}].nom"
					             value="${fecondationInvitro.sanitaireList[vs.current].nom}"
					             label="${fecondationInvitro.sanitaireList[vs.current].nom}"/>
				</c:forEach>
			</c:when>
		</c:choose>
		<br/> <br/>

		<table id="tableauFIV">
			<tr>
				<th>Taureau</th>
				<th>Race</th>
				<th>N&#176 &#233jaculat</th>
				<th>Etat frais avant FIV (en %)</th>
				<th>Vol. FIV (&#181l)</th>
				<th>n&#176 N</th>
			</tr>

			<c:choose>
				<c:when test="${fecondationInvitro.tableau_semences.size()>0}">
					<c:forEach begin="0" end="${fecondationInvitro.tableau_semences.size()-1}" var="index">
						<tr>

							<td><sf:input disabled="true" list="taureauList"
							              path="tableau_semences[${index}].taureau"/></td>
							<td><sf:input disabled="true" list="taureauListRace"
							              path="tableau_semences[${index}].taureau.race"/></td>
							<td><sf:input disabled="true" type="text"
							              path="tableau_semences[${index}].numeroEjaculation"/></td>
							<td><sf:input disabled="true" type="text"
							              path="tableau_semences[${index}].etatFrais"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableau_semences[${index}].volume"/></td>
							<td><sf:input disabled="true" list="taureauListNumIdentification"
							              path="tableau_semences[${index}].taureau.num_identification"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<br/> <label for="remarqueFecondationInVitro">Remarque :</label><br/>
		<sf:textarea disabled="true" path="remarque" name="remarqueFecondationInVitro" cols="40" rows="5"/>
		<br/> <br/>
	</fieldset>
</sf:form>
