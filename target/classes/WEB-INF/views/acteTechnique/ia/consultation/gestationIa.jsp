<sf:form modelAttribute="gestation" method="post" action="${nom}">
	<fieldset>
		<legend>SUIVI DE GESTATION</legend>

		<label>Retour en chaleurs &#225; J21 :</label>
		<table id="tableauGestation">
			<tr>
				<th>Date</th>
				<th>M&eacutethode<br></th>
				<th>R&eacutesultat</th>
			</tr>
			<c:choose>
				<c:when test="${gestation.tableauGestationList.size()>0}">
					<c:forEach begin="0" end="${gestation.tableauGestationList.size()-1}" varStatus="vs">
						<tr>
							<td><sf:input disabled="true" type="date"
							              path="tableauGestationList[${vs.current}].date"/></td>
							<td><sf:input disabled="true" list="text"
							              path="tableauGestationList[${vs.current}].methode"/></td>
							<td><sf:input disabled="true" type="text"
							              path="tableauGestationList[${vs.current}].resultat"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</fieldset>
</sf:form>