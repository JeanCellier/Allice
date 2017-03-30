<sf:form method="post" modelAttribute="cultureInVitro" action="${nom}">
	<fieldset>
		<legend>CULTURE IN VITRO</legend>

		<label for="dateCultureInVitro">Date :</label>
		<sf:input disabled="true" path="date" type="date" name="dateCultureInVitro"/>

		<label for="sanitaireCultureInVitro">Sanitaires :</label>
		<c:choose>
			<c:when test="${cultureInVitro.sanitaireList.size()>0}">
				<c:forEach begin="0" end="${cultureInVitro.sanitaireList.size()-1}" var="index">
					<sf:checkbox disabled="true" path="sanitaireList[${index}].nom"/>
				</c:forEach>
			</c:when>
		</c:choose>
		<br/> <br/>

		<table id="tab1">
			<tr>
				<th>Groupe</th>
				<th>Nb d'ovo<br/>ins&#233min&#233s</th>
				<th>Heure de mise en<br/>culture</th>
				<th>Nb segment&#233s</th>
				<th>% seg</th>
				<th>J5<br/>jm</th>
			</tr>
			<c:choose>
				<c:when test="${cultureInVitro.tableauCultureList.size()>0}">
					<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" var="index">
						<tr>
							<td><sf:input disabled="true" type="text"
							              path="tableauCultureList[${index}].groupe"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].nbInsemine"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].heureCulture"/>h
								<sf:input disabled="true" type="number"
								          path="tableauCultureList[${index}].minuteCulture"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].nbSegmente"/></td>
							<td><sf:input disabled="true" path="tableauCultureList[${index}].segment"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].j5JM"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>

		<br/>
		<table id="tab2">
			<tr>
				<td rowspan="2" class="headermodif">Groupe</td>
				<td colspan="6" class="headermodif">D&#233veloppement &#225 J7</td>
			</tr>
			<tr>
				<td class="headermodif">mo</td>
				<td class="headermodif">BL</td>
				<td class="headermodif">BE</td>
				<td class="headermodif">BEC</td>
				<td class="headermodif">Q1</td>
				<td class="headermodif">Nb Total</td>
			</tr>
			<c:choose>
				<c:when test="${cultureInVitro.tableauCultureList.size()>0}">
					<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" var="index">
						<tr>
							<td><sf:input disabled="true" type="text"
							              path="tableauCultureList[${index}].groupe"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].mo"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].bl"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].be"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].bec"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].q1"/></td>
							<td><sf:input disabled="true" path="tableauCultureList[${index}].nbTotal"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<br/>
		<table id="tab3">
			<tr>
				<td rowspan="2" class="headermodif">Groupe</td>
				<td colspan="3" class="headermodif">&#37 d&#233veloppement &#225 J7</td>
				<td colspan="2" class="headermodif">J8</td>
				<td rowspan="2" class="headermodif">Destination</td>
			</tr>
			<tr>
				<td class="headermodif">&#37J7</td>
				<td class="headermodif">&#37BEJ7</td>
				<td class="headermodif">&#37Q1J7</td>
				<td class="headermodif">Nb</td>
				<td class="headermodif">&#37J8</td>
			</tr>
			<c:choose>
				<c:when test="${cultureInVitro.tableauCultureList.size()>0}">
					<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" var="index">
						<tr>
							<td><sf:input disabled="true" type="text"
							              path="tableauCultureList[${index}].groupe"/></td>
							<td><sf:input disabled="true" path="tableauCultureList[${index}].pourJ7"/></td>
							<td><sf:input disabled="true" path="tableauCultureList[${index}].pourBEJ7"/></td>
							<td><sf:input disabled="true" path="tableauCultureList[${index}].pourQ1J7"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableauCultureList[${index}].J8parNb"/></td>
							<td><sf:input disabled="true" path="tableauCultureList[${index}].pourJ8"/></td>
							<td><sf:radiobutton disabled="true" path="tableauCultureList[${index}].siCryo"
							                    value="true"/>Cryo
								<sf:radiobutton disabled="true" path="tableauCultureList[${index}].siCryo"
								                value="false"/>
								D&#233truit
							</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<br/>
		<label for="remarques">Remarque :</label>
		<br/>
		<sf:textarea disabled="true" path="remarques" name="remarques" cols="40" rows="5"/><br/>
		<br/>
	</fieldset>
</sf:form>
