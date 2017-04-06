<sf:form method="post" modelAttribute="collecte" action="${nom}">

	<fieldset>
		<legend>COLLECTE & MATURATION IN VITRO</legend>

		<label id="test" for="date">Date :</label>
		<sf:input disabled="true" path="date" type="date"/>

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
				<c:when test="${collecte.tableauCollecteList.size()>0}">
					<c:forEach begin="0" end="${collecte.tableauCollecteList.size()-1}" var="index">
						<tr>
							<td><sf:input disabled="true" type="number"
							              path="tableauCollecteList[${index}].race_Ovaires"/></td>
							<td><sf:input disabled="true" list="vacheListe" autocomplete="on"
							              path="tableauCollecteList[${index}].vache"/></td>
							<td><sf:checkbox disabled="true" path="tableauCollecteList[${index}].pool"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCollecteList[${index}].nombre_Ovaires"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCollecteList[${index}].nombre_Ovocytes"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCollecteList[${index}].taux_Collecte"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>

		</table>
	</fieldset>
</sf:form>


