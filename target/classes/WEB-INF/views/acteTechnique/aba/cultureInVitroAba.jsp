<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche ABA : ${nom}</h1>

<div id="partieCentrale">

	<sf:form method="post" modelAttribute="cultureInVitro" action="${nom}">
	<fieldset>
		<legend>CULTURE IN VITRO</legend>

		<label for="dateCultureInVitro">Date :</label>
		<sf:input path="date" type="date" name="dateCultureInVitro"/>

 		<label for="sanitaireCultureInVitro">Sanitaires :</label>
		<c:forEach begin="0" end="${sanitaireList.size()-1}" varStatus="vs">
			<c:set value="" var="check"/>
			<c:if test="${fecondationInvitro.sanitaireList.contains(sanitaireList.get(vs.current))}">
				<c:set value="checked" var="check"/>
			</c:if>
			<sf:checkbox checked="${check}" path="sanitaireList[${vs.current}]" value="${sanitaireList[vs.current].id}"
			             label="${sanitaireList[vs.current].nom}"/>
			<c:set value="" var="check"/>
		</c:forEach>
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
			<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" varStatus="vs">
			<tr>
				<td><sf:input type="text" path="tableauCultureList[${vs.current}].groupe"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].nbInsemine"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].heureCulture"/>
					<label id="heure">h</label>
					<sf:input type="number" path="tableauCultureList[${vs.current}].minuteCulture"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].nbSegmente"/></td>
				<td><sf:label path="tableauCultureList[${vs.current}].segment"
				              id="tableauCultureList[${vs.current}].segment">
					${cultureInVitro.tableauCultureList[vs.current].segment}
				</sf:label>
					<sf:hidden path="tableauCultureList[${vs.current}].segment"/></td>
				<!--Place pour la valeur calcul�e  -->
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].j5JM"/></td>
			</tr>
			</c:forEach>
			<input type="button" value="+" onclick="ajoutLigneTab1();"/>
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
			<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" varStatus="vs">
			<tr>
				<td><input type="text" disabled="true" value="${cultureInVitro.tableauCultureList[vs.current].groupe}"/>
				</td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].mo"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].bl"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].be"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].bec"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].q1"/></td>
				<td><sf:label path="tableauCultureList[${vs.current}].nbTotal"
				              id="tableauCultureList[${vs.current}].nbTotal">
					${cultureInVitro.tableauCultureList[vs.current].nbTotal}
				</sf:label>
					<sf:hidden path="tableauCultureList[${vs.current}].nbTotal"/></td> <!-- valeur calcul�e -->
			</tr>
			</c:forEach>
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
			<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" varStatus="vs">
			<tr>
				<td><input type="text" disabled="true" value="${cultureInVitro.tableauCultureList[vs.current].groupe}"/>
				</td>
				<td><sf:label path="tableauCultureList[${vs.current}].pourJ7"
				              id="tableauCultureList[${vs.current}].pourJ7">
					${cultureInVitro.tableauCultureList[vs.current].pourJ7}
				</sf:label>
					<sf:hidden path="tableauCultureList[${vs.current}].pourJ7"/></td>
				<td><sf:label path="tableauCultureList[${vs.current}].pourBEJ7"
				              id="tableauCultureList[${vs.current}].pourBEJ7">
					${cultureInVitro.tableauCultureList[vs.current].pourBEJ7}
				</sf:label>
					<sf:hidden path="tableauCultureList[${vs.current}].pourBEJ7"/></td>
				<td><sf:label path="tableauCultureList[${vs.current}].pourQ1J7"
				              id="tableauCultureList[${vs.current}].pourQ1J7">
					${cultureInVitro.tableauCultureList[vs.current].pourQ1J7}
				</sf:label>
					<sf:hidden path="tableauCultureList[${vs.current}].pourQ1J7"/></td>
				<td><sf:input type="number" path="tableauCultureList[${vs.current}].J8parNb"/></td>
				<td><sf:label path="tableauCultureList[${vs.current}].pourJ8"
				              id="tableauCultureList[${vs.current}].pourJ8">
					${cultureInVitro.tableauCultureList[vs.current].pourJ8}
				</sf:label>
					<sf:hidden path="tableauCultureList[${vs.current}].pourJ8"/></td>
				<td><sf:radiobutton path="tableauCultureList[${vs.current}].siCryo" value="true"/>Cryo
					<sf:radiobutton path="tableauCultureList[${vs.current}].siCryo" value="false"/> D&#233truit
  				</td>
				</c:forEach>
				<td><input type="button" value="Calcul" onclick="calcul();"/></td>
			</tr>
		</table>
		<br/>
		<label for="remarques">Remarque :</label>
		<br/>
		<sf:textarea path="remarques" name="remarques" cols="40" rows="5"/><br/>
		<br/>
		<input type="submit" value="Valider" class="valider" onclick="calcul()"/>
	</fieldset>
</sf:form>
</div>

<script src="../../../../static/js/cultureScript.js" lang="text/javascript"></script>

<%@ include file="../../footersimplifie.jsp" %>