
	<sf:form method="post" modelAttribute="collecte" action="${nom}">

		<fieldset>
			<legend>COLLECTE & MATURATION IN VITRO</legend>

			<label id="test" for="date">Date :</label>
			<sf:input path="date" type="date" disabled="true"/>

			<br/>

			<table id="tableauCollecte">
				<tr>
					<th>Race ovaires</th>
					<th>N&#176 femelle</th>
					<th>Pool</th>
					<th>Nb ovaires</th>
					<th>Nb ovocytes</th>
					<th>Taux collecte</th>
				</tr>
				<c:choose>
					<c:when test="${cultureInVitro.tableauCultureList.size()>0}">
						<c:forEach begin="0" end="${collecte.tableauCollecteList.size()-1}" varStatus="vs">
							<tr>
								<td><sf:input disabled="true" type="number"
								              path="tableauCollecteList[${vs.current}].race_Ovaires"/></td>
								<td><sf:input disabled="true" autocomplete="on"
								              path="tableauCollecteList[${vs.current}].vache"/></td>
								<td><sf:checkbox disabled="true" path="tableauCollecteList[${vs.current}].pool"/></td>
								<td><sf:input disabled="true" type="number"
								              path="tableauCollecteList[${vs.current}].nombre_Ovaires"/></td>
								<td><sf:input disabled="true" type="number"
								              path="tableauCollecteList[${vs.current}].nombre_Ovocytes"/></td>
								<td><sf:input disabled="true" type="number"
								              path="tableauCollecteList[${vs.current}].taux_Collecte"/></td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</fieldset>
	</sf:form>