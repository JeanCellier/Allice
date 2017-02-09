<%@ include file="../headersimplifie.jsp" %>

<h1>Pharmacie</h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="produit">

		<fieldset>
			<legend>Ajouter un produit</legend>

			<br/>

			<table id="tableauCollecte">
				<tr>
					<th style=""white-space:nowrap;">Nom<br></th>
					<th>Date de d&eacutelivrance<br></th>
					<th>Fournisseur<br></th>
					<th>Projet<br></th>
					<th>Responsable<br></th>
					<th>Qte entrante<br></th>
					<th>Qte restante<br></th>
					<th>N&deg; de lot<br></th>
					<th>Date de p&eacuteremption<br></th>
				</tr>
				<tr>
					<td><sf:input type="text" path="nom" size="10"/></td>
					<td><sf:input type="date" path="date_delivrance" name="dateDelivrance" size="10"/></td>
					<td><sf:input type="text" path="fournisseur" size="10"/></td>
					<td><sf:input type="text" path="projet" size="10"/></td>
					<td><sf:input type="text" path="responsable" size="10"/></td>
					<td><sf:input type="number" path="qte_entrante" style="width:50px;"/></td>					
					<td><sf:input type="number" path="qte_restante" style="width:50px;"/></td>	
					<td><sf:input type="number" path="num_lot" style="width:50px;"/></td>
					<td><sf:input type="date" path="date_peremption"/></td>
				</tr>

			</table>
			<br/> <input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>
<h1>Consultation de la pharmacie</h1>

<div id="partieCentrale">

	<fieldset>

		<legend>Les produits</legend>

		<table id="tableauPharmacie">
			<tr>
				<td>Nom</td>
				<td>Date de d&eacutelivrance<br></td>
				<td>Fournisseur<br></td>
				<td>Projet<br></td>
				<td>Responsable<br></td>
				<td>Qte entrante<br></td>
				<td>Qte restante<br></td>
				<td>N&deg; de lot<br></td>
				<td>Date de p&eacuteremption<br></td>
				<td>Modifier<br></td>
			</tr>
			<c:forEach items="${produitList}" var="produit">
				<tr>
					<th>${produit.nom}</th>
					<th>${produit.date_delivrance}<br></th>
					<th>${produit.fournisseur}<br></th>
					<th>${produit.projet}<br></th>
					<th>${produit.responsable}<br></th>
					<th>${produit.qte_entrante}<br></th>
					<th>${produit.qte_restante}<br></th>
					<th>${produit.num_lot}<br></th>
					<th>${produit.date_peremption}<br></th>
					<th><a href="pharmacie/${produit.id}">Modifier</a></th>
				</tr>

			</c:forEach>
		</table>
	</fieldset>
</div>

<script lang="text/javascript">

	/* function ajoutLigne()
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
		input.setAttribute("id", "tableauCollecteList" + length + ".nbFemelleOuPool");
		input.setAttribute("name", "tableauCollecteList[" + length + "].nbFemelleOuPool");
		input.setAttribute("type", "text");
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
	} */
</script>

<%@ include file="../footersimplifie.jsp" %>
