<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche OPU : ${nom}</h1>

<div id="partieCentrale">
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
				<c:forEach begin="0" end="${ovocytesCollectes.tableauOvocytes_collectesList.size()-1}" varStatus="vs">
					<tr>
						<td><sf:input type="number" path="tableauOvocytes_collectesList[${vs.current}].nb_cocs"/></td>
						<td><sf:radiobutton path="tableauOvocytes_collectesList[${vs.current}].mature" value="true"/>Mature<br>
							<sf:radiobutton path="tableauOvocytes_collectesList[${vs.current}].mature"
							                value="false"/>Immature
						</td>
						<td><sf:select path="tableauOvocytes_collectesList[${vs.current}].qualite">
							<c:forEach items="${qualiteList}" var="qualite">
								<option value="${qualite.id}" label="${qualite.nom} ${qualite.numero}"></option>
							</c:forEach>
						</sf:select></td>
						<td><sf:radiobutton path="tableauOvocytes_collectesList[${vs.current}].fiv" value="true"/>Cryo
								<sf:radiobutton path="tableauOvocytes_collectesList[${vs.current}].fiv" value="false"/>D&#233truit
						<td><sf:input path="tableauOvocytes_collectesList[${vs.current}].utilisation"/></td>

					</tr>
				</c:forEach>
				<input type="button" value="+" onclick="ajoutLigne();"/>
			</table>

			<br/>
			<label for="sanitaire">Sanitaire :</label>
			<c:forEach items="${sanitaireList}" var="sanitaire" varStatus="vs">
				<sf:radiobutton path="sanitaire" value="${sanitaire.id}"/><c:out value="${sanitaire.nom}"/>
			</c:forEach>

			<br/><br/>
			<label for="remarqueFecondationInVitro">Remarque :</label><br/>
			<sf:textarea path="remarques" name="remarqueFecondationInVitro" cols="40" rows="5"/>
			<br/> <br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">

	function ajoutLigne()
	{
		var tableauFIV = document.getElementById("tableauCollectOvocytes");
		var length = tableauFIV.rows.length - 1;
		var ligne = tableauFIV.insertRow(-1);

		var cellule = ligne.insertCell(-1);
		var input = document.createElement("input");

		var textTemp = document.createElement("label");
		var textTemp2 = document.createElement("label");

		input.setAttribute("id", "tableauOvocytes_collectesList" + length + ".nb_cocs");
		input.setAttribute("name", "tableauOvocytes_collectesList[" + length + "].nb_cocs");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.id = "tableauOvocytes_collectesList" + length + ".mature";
		input.name = "tableauOvocytes_collectesList[" + length + "].mature";
		input.type = "radio";
		input.value = "true";

		var input2 = document.createElement("input");
		input2.id = "tableauOvocytes_collectesList" + length + ".mature";
		input2.name = "tableauOvocytes_collectesList[" + length + "].mature";
		input2.type = "radio";
		input2.value = "false";
		input2.checked = "checked";

		textTemp.innerHTML = "Mature";
		textTemp2.innerHTML = "Immature";

		cellule.appendChild(textTemp);
		cellule.appendChild(input);
		cellule.appendChild(document.createElement("br"));
		cellule.appendChild(input2);
		cellule.appendChild(textTemp2);

		cellule = ligne.insertCell(-1);
		input = document.createElement("select");
		input.setAttribute("id", "tableauOvocytes_collectesList" + length + ".qualite");
		input.setAttribute("name", "tableauOvocytes_collectesList[" + length + "].qualite");
		<c:forEach items="${qualiteList}" var="qualite">
		var option = document.createElement("option");
		option.setAttribute("value", "${qualite.id}");
		option.setAttribute("label", "${qualite.nom} ${qualite.numero}");
		input.appendChild(option);
		</c:forEach>
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.id = "tableauOvocytes_collectesList" + length + ".fiv";
		input.name = "tableauOvocytes_collectesList[" + length + "].fiv";
		input.type = "radio";
		input.value = "true";
		input.checked = "checked";

		input2 = document.createElement("input");
		input2.id = "tableauOvocytes_collectesList" + length + ".fiv";
		input2.name = "tableauOvocytes_collectesList[" + length + "].fiv";
		input2.type = "radio";
		input2.value = "false";

		textTemp.innerHTML = "Cryo";
		textTemp2.innerHTML = "D&#233truit";

		cellule.appendChild(input);
		cellule.appendChild(textTemp);
		cellule.appendChild(input2);
		cellule.appendChild(textTemp2);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauOvocytes_collectesList" + length + ".utilisation");
		input.setAttribute("name", "tableauOvocytes_collectesList[" + length + "].utilisation");
		cellule.appendChild(input);
	}
</script>

<%@ include file="../../footersimplifie.jsp" %>