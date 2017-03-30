<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche ABA : ${nom}</h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="collecte" action="${nom}">

		<fieldset>
			<legend>COLLECTE & MATURATION IN VITRO</legend>

			<label id="test" for="date">Date :</label>
			<sf:input path="date" type="date"/>

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

				<c:forEach begin="0" end="${collecte.tableauCollecteList.size()-1}" varStatus="vs">
				<tr>
					<td><sf:input type="number" path="tableauCollecteList[${vs.current}].race_Ovaires"/></td>
					<td><sf:input list="vacheListe" autocomplete="on"
					              path="tableauCollecteList[${vs.current}].vache"/></td>
					<td><sf:checkbox path="tableauCollecteList[${vs.current}].pool"/></td>
					<td><sf:input type="number" path="tableauCollecteList[${vs.current}].nombre_Ovaires"/></td>
					<td><sf:input type="number" path="tableauCollecteList[${vs.current}].nombre_Ovocytes"/></td>
					<td><sf:label path="tableauCollecteList[${vs.current}].taux_Collecte"
					              id="tableauCollecteList[${vs.current}].taux_Collecte">
						${collecte.tableauCollecteList[vs.current].taux_Collecte}</sf:label>
						<sf:hidden path="tableauCollecteList[${vs.current}].taux_Collecte"/></td>
					</c:forEach>
					<td><input type="button" value="Calcul" onclick="calcul();"/></td>
				</tr>

				<input type="button" value="+" onclick="ajoutLigne();"/>
			</table>
			<br/> <input type="submit" value="Valider" class="valider" onclick="calcul()"/> <br/>
		</fieldset>
	</sf:form>
</div>

<datalist id="vacheListe">
	<c:forEach items="${vacheList}" var="vache">
		<option value="${vache.id}" label="${vache.num_identification}"></option>
	</c:forEach>
</datalist>

<script src="../../../../static/js/collecteScript.js" lang="text/javascript"></script>

<%@ include file="../../footersimplifie.jsp" %>