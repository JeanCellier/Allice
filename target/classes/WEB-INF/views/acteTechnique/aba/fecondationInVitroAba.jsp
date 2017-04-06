<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche ABA : ${nom}</h1>

<div id="partieCentrale">
	<sf:form modelAttribute="fecondationInvitro" method="post" action="${nom}">
		<fieldset>
			<legend>FECONDATION IN VITRO</legend>

			<label for="date">Date :</label>
			<sf:input path="date" type="date" name="dateFecondationInVitro"/>

			<label for="sanitaireFecondationInVitro">Sanitaires :</label>
			<c:forEach begin="0" end="${sanitaireList.size()-1}" varStatus="vs">
				<c:set value="" var="check"/>
				<c:if test="${fecondationInvitro.sanitaireList.contains(sanitaireList.get(vs.current))}">
					<c:set value="checked" var="check"/>
				</c:if>
				<sf:checkbox checked="${check}" path="sanitaireList[${vs.current}]"
				             value="${sanitaireList[vs.current].id}" label="${sanitaireList[vs.current].nom}"/>
			</c:forEach>
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
				<c:forEach begin="0" end="${fecondationInvitro.tableau_semences.size()-1}" varStatus="vs">
				<tr>
					<td><sf:input list="taureauList" path="tableau_semences[${vs.current}].taureau.nom"/></td>
					<td><sf:input list="taureauListRace" path="tableau_semences[${vs.current}].taureau.race"/></td>
					<td><sf:input type="text" path="tableau_semences[${vs.current}].numeroEjaculation"/></td>
					<td><sf:input type="text" path="tableau_semences[${vs.current}].etatFrais"/></td>
					<td><sf:input type="number" step="any" path="tableau_semences[${vs.current}].volume"/></td>
					<td><sf:input type="text" list="taureauListNumIdentification"
					              path="tableau_semences[${vs.current}].taureau.num_identification"/></td>
				</tr>
				</c:forEach>
				<input type="button" value="+" onclick="ajoutLigne();"/>
			</table>
		<br/> <label for="remarqueFecondationInVitro">Remarque :</label><br/>
		<sf:textarea path="remarque" name="remarqueFecondationInVitro" cols="40" rows="5"/>
		<br/> <br/>
		<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">

	function ajoutLigne()
	{
		var tableauFIV = document.getElementById("tableauFIV");
		var length = tableauFIV.rows.length - 1;
		var ligne = tableauFIV.insertRow(-1);

		var cellule = ligne.insertCell(-1);
		var input = document.createElement("input");
		input.setAttribute("id", "tableau_semences" + length + ".taureau.nom");
		input.setAttribute("name", "tableau_semences[" + length + "].taureau.nom");
		input.setAttribute("list", "taureauList");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_semences" + length + ".taureau.race");
		input.setAttribute("name", "tableau_semences[" + length + "].taureau.race");
		input.setAttribute("list", "taureauListRace");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_semences" + length + ".numeroEjaculation");
		input.setAttribute("name", "tableau_semences[" + length + "].numeroEjaculation");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_semences" + length + ".etatFrais");
		input.setAttribute("name", "tableau_semences[" + length + "].etatFrais");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_semences" + length + ".volume");
		input.setAttribute("name", "tableau_semences[" + length + "].volume");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_semences" + length + ".taureau.num_identification");
		input.setAttribute("name", "tableau_semences[" + length + "].taureau.num_identification");
		input.setAttribute("list", "taureauListNumIdentification");
		cellule.appendChild(input);
	}
</script>

<datalist id="taureauList">
	<c:forEach items="${taureauList}" var="taureau">
		<option value="${taureau.nom}"></option>
	</c:forEach>
</datalist>

<datalist id="taureauListRace">
	<c:forEach items="${taureauList}" var="taureau">
		<option value="${taureau.race}"></option>
	</c:forEach>
</datalist>

<datalist id="taureauListNumIdentification">
	<c:forEach items="${taureauList}" var="taureau">
	<option value=${taureau.num_identification}></option>
	</c:forEach>

<%@ include file="../../footersimplifie.jsp" %>