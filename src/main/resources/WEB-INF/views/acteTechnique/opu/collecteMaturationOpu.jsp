<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche OPU : ${nom}</h1>

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
					<td><sf:input type="number" path="tableauCollecteList[${vs.current}].taux_Collecte"/></td>
				</tr>
				</c:forEach>
				<input type="button" value="+" onclick="ajoutLigne();"/>
			</table>
			<br/> <input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<datalist id="vacheListe">
	<c:forEach items="${vacheList}" var="vache">
		<option value="${vache.id}" label="${vache.num_identification}"></option>
	</c:forEach>
</datalist>

<script lang="text/javascript">

	function ajoutLigne()
	{
		var tableauCollecte = document.getElementById("tableauCollecte");
		var length = tableauCollecte.rows.length - 1;
		var ligne = tableauCollecte.insertRow(-1);

		var cellule = ligne.insertCell(-1);
		var input = document.createElement("input");
		input.setAttribute("id", "tableauCollecteList" + length + ".race_Ovaires");
		input.setAttribute("name", "tableauCollecteList[" + length + "].race_Ovaires");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCollecteList" + length + ".vache");
		input.setAttribute("name", "tableauCollecteList[" + length + "].vache");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCollecteList" + length + ".pool");
		input.setAttribute("name", "tableauCollecteList[" + length + "].pool");
		input.setAttribute("type", "checkbox");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCollecteList" + length + ".nombre_Ovaires");
		input.setAttribute("name", "tableauCollecteList[" + length + "].nombre_Ovaires");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCollecteList" + length + ".nombre_Ovocytes");
		input.setAttribute("name", "tableauCollecteList[" + length + "].nombre_Ovocytes");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCollecteList" + length + ".taux_Collecte");
		input.setAttribute("name", "tableauCollecteList[" + length + "].taux_Collecte");
		input.setAttribute("type", "number");
		cellule.appendChild(input);
	}
</script>

<%@ include file="../../footersimplifie.jsp" %>