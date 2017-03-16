<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche COL : ${nom}</h1>

<div id="partieCentrale">
	<sf:form modelAttribute="traitementDonneuse" method="post" action="${nom}">
		<fieldset>
			<legend>TRAITEMENT DONNEUSE</legend>

			<label for="date_ref_chaleur">Date d'entree en chaleur :</label>
			<sf:errors path="date_ref_chaleur"/>
			<sf:input path="date_ref_chaleur" type="date"/>

			<label for="naturel">Naturel :</label>
			<sf:checkbox path="naturel" value="true"/>

			<br/> <br/>

			<table id="tableauTraitementDonneuse">
				<tr>
					<th>Date</th>
					<th>Produit<br></th>
					<th>Quantite<br></th>
					<th>Mode<br></th>
				</tr>
				<c:forEach begin="0" end="${traitementDonneuse.tableau_pharmacie.size()-1}" varStatus="vs">
				<tr>
					<td><sf:input type="date" path="tableau_pharmacie[${vs.current}].date"/></td>
					<td><sf:select list="listProduit" path="tableau_pharmacie[${vs.current}].produit">
						<c:forEach items="${produitList}" var="produit">
							<sf:option value="${produit.id}" label="${produit.nom}"/>
						</c:forEach>
					</sf:select></td>
					<td><sf:input type="number" path="tableau_pharmacie[${vs.current}].quantite"/></td>
					<td><sf:input type="text" path="tableau_pharmacie[${vs.current}].mode"/></td>
				</tr>
				</c:forEach>
				<input type="button" value="+" onclick="ajoutLigne();"/>
			</table>

			<label for="nb_follicules">Nb follicules :</label>
			<sf:errors path="nb_follicules"/>
			<sf:input path="nb_follicules" type="number"/>

			<label for="nb_droite">Droite :</label>
			<sf:errors path="nb_droite"/>
			<sf:input path="nb_droite" type="number"/>

			<label for="nb_gauche">Gauche :</label>
			<sf:errors path="nb_gauche"/>
			<sf:input path="nb_gauche" type="number"/>

			<br/>

			<label for="typeFSH">Type FSH:</label>
			<sf:errors path="typeFSH"/>
			<sf:input path="typeFSH" type="text"/>

			<br/>

			<label for="pourc_dose">% de la dose totale FSH :</label>
			<sf:errors path="pourc_dose"/>
			<sf:input path="pourc_dose" type="number"/>

			<br/>

			<table id="tableauTraitementDonneuseSuper">
				<tr>
					<th>Date</th>
					<th>Matin<br></th>
					<th>Apres-midi</th>
				</tr>
				<c:forEach begin="0" end="${traitementDonneuse.tableau_pharmacie_superovulation_medicament.size()-1}"
				           varStatus="vs">
				<tr>
					<td><sf:input type="date"
					              path="tableau_pharmacie_superovulation_medicament[${vs.current}].date"/></td>
					<td><sf:input list="text"
					              path="tableau_pharmacie_superovulation_medicament[${vs.current}].matin"/></td>
					<td><sf:input type="text"
					              path="tableau_pharmacie_superovulation_medicament[${vs.current}].apresMidi"/></td>
				</tr>
				</c:forEach>
				<input type="button" value="+" onclick="ajoutLigneSuper();"/>
			</table>

			<label for="operateur">Op&#233rateur :</label>
			<sf:select path="operateur">
				<c:forEach items="${operateurList}" var="operateur">
					<option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"></option>
				</c:forEach>
			</sf:select>

			<sf:checkbox path="semenceSexe" value="true" label="Semence sexe"/>
			<br/>

			<label for="nb_follicules">Nb follicules :</label>
			<sf:input path="nb_follicules" type="number"/>

			<label for="nb_droite">Droite :</label>
			<sf:input path="nb_droite" type="number"/>

			<label for="nb_gauche">Gauche :</label>
			<sf:input path="nb_gauche" type="number"/>

			<br/> <br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">

	function ajoutLigne()
	{
		var tableauFIV = document.getElementById("tableauTraitementDonneuse");
		var length = tableauFIV.rows.length - 1;
		var ligne = tableauFIV.insertRow(-1);

		var cellule = ligne.insertCell(-1);
		var input = document.createElement("input");
		input.setAttribute("id", "tableau_pharmacie" + length + ".date");
		input.setAttribute("name", "tableau_pharmacie[" + length + "].date");
		input.setAttribute("type", "date");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("select");
		input.setAttribute("id", "tableau_pharmacie" + length + ".produit");
		input.setAttribute("name", "tableau_pharmacie[" + length + "].produit");
		input.setAttribute("list", "listProduit");
		<c:forEach items="${produitList}" var="produit">
		var option = document.createElement("option");
		option.setAttribute("value", "${produit.id}");
		option.setAttribute("label", "${produit.nom}");
		input.appendChild(option);
		</c:forEach>
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_pharmacie" + length + ".quantite");
		input.setAttribute("name", "tableau_pharmacie[" + length + "].quantite");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_pharmacie" + length + ".mode");
		input.setAttribute("name", "tableau_pharmacie[" + length + "].mode");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

	}

	function ajoutLigneSuper()
	{
		var tableauFIV = document.getElementById("tableauTraitementDonneuseSuper");
		var length = tableauFIV.rows.length - 1;
		var ligne = tableauFIV.insertRow(-1);

		var cellule = ligne.insertCell(-1);
		var input = document.createElement("input");
		input.setAttribute("id", "tableau_pharmacie_superovulation_medicament" + length + ".date");
		input.setAttribute("name", "tableau_pharmacie_superovulation_medicament[" + length + "].date");
		input.setAttribute("type", "date");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_pharmacie_superovulation_medicament" + length + ".matin");
		input.setAttribute("name", "tableau_pharmacie_superovulation_medicament[" + length + "].matin");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableau_pharmacie_superovulation_medicament" + length + ".apresMidi");
		input.setAttribute("name", "tableau_pharmacie_superovulation_medicament[" + length + "].apresMidi");
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