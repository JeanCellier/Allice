<sf:form method="post" modelAttribute="cryoconservation" action="${nom}">
	<fieldset>
		<legend>INFORMATION SI CRYOCONSERVATION</legend>

		<label for="heure">Heure de cong&#233lation :</label>
		<sf:input disabled="true" path="heure" type="number" maxlength="2" size="2"/> : <sf:input disabled="true"
		                                                                                          path="minute"
		                                                                                          type="number"
		                                                                                          maxlength="2"
		                                                                                          size="2"/>
		<br/>
		<label for="methodeCongelation">M&#233thode de cong&#233lation :</label>
		<sf:input disabled="true" path="methodeCongelation.nom"/>

		<br/>
		<label for="congelateur">Cong&#233lateur utilis&#233:</label>
		<sf:input disabled="true" path="congelateur.nom"/>

		<br/>

		<label for="operateur">Op&#233rateur cong&#233lation :</label>
		<sf:input path="operateur.nom" disabled="true"/>

		<label for="descMethode">Description m&#233thode (nom programme, cin&#233tique, seeding...) :</label> <br/>
		<sf:textarea disabled="true" path="descMethode" name="descriptionCryoconservation" cols="80" rows="5"/>
		<br/> <br/>

		<table id="part1">
			<tr>
				<th>N&#176 Embryon</th>
				<th>Groupe</th>
				<th>Stade</th>
				<th>Qualit&#233</th>
				<th>Cuve stockage</th>
				<th>Canister Stockage</th>
				<th>VisoTube stockage</th>
				<th>Jonc</th>
				<th>Numero Receveuse</th>
				<th>R&#233f&#233rence<br/>transfert</th>
				<th>Remarque</th>
			</tr>
			<jsp:useBean id="cryoconservation" scope="request"
			             type="phenotypage.model.cryoconservation.Cryoconservation"/>
			<c:choose>
				<c:when test="${cryoconservation.tableauDetailList.size()>0}">
					<c:forEach begin="0" end="${cryoconservation.tableauDetailList.size()-1}" var="index">
						<tr>
							<td>${index}</td>
							<td><sf:input path="tableauDetailList[${index}].groupe" type="number"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].stade.nom"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].progression"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].cuve"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].canister"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[0].visoTube"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].jonc" type="text"
							              size="10"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].numeroReceveuse"
							              type="text" size="10"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].referenceTransfert"
							              type="text" size="10"/></td>
							<td><sf:input disabled="true" path="tableauDetailList[${index}].remarque" type="text"
							              size="20"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<br/>
	</fieldset>
</sf:form>
</div>
