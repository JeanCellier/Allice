<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche TRA : ${nom}</h1>

<div id="partieCentrale">
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
				<c:forEach begin="0" end="${gestation.tableauGestationList.size()-1}" varStatus="vs">
					<tr>
						<td><sf:input type="date"
						              path="tableauGestationList[${vs.current}].date"/></td>
						<td><sf:input list="text"
						              path="tableauGestationList[${vs.current}].methode"/></td>
						<td><sf:input type="text"
						              path="tableauGestationList[${vs.current}].resultat"/></td>
					</tr>
				</c:forEach>
				<input type="button" value="+" onclick="ajoutLigneSuper();"/>
			</table>

			<br/> <br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">

	function ajoutLigneSuper()
	{
		var tableauFIV = document.getElementById("tableauGestation");
		var length = tableauFIV.rows.length - 1;
		var ligne = tableauFIV.insertRow(-1);

		var cellule = ligne.insertCell(-1);
		var input = document.createElement("input");
		input.setAttribute("id", "tableauGestationList" + length + ".date");
		input.setAttribute("name", "tableauGestationList[" + length + "].date");
		input.setAttribute("type", "date");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauGestationList" + length + ".methode");
		input.setAttribute("name", "tableauGestationList[" + length + "].methode");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauGestationList" + length + ".resultat");
		input.setAttribute("name", "tableauGestationList[" + length + "].resultat");
		input.setAttribute("type", "text");
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