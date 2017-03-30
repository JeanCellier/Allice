<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche COL : ${nom}</h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="resultat" action="${nom}">

		<fieldset>
			<legend>RESULTAT COLLECTE</legend>

			<br/>

			<table id="tableauCollecte">
				<tr>
					<th>Viables</th>
					<th>Degeneres</th>
					<th>Non Fecondes</th>
					<th>Total Collectes</th>
				</tr>
				<tr>
					<td><sf:input type="number" path="nombre_Embryons_Viables"/></td>
					<td><sf:input type="number" path="nombre_Embryons_Degeneres"/></td>
					<td><sf:input type="number" path="nombre_Embryons_NonFecondes"/></td>
					<td><sf:input type="number" path="nombre_Embryons_Total" id="fakeNombre_Embryons_Total"
					              disabled="true"/>
						<sf:hidden path="nombre_Embryons_Total"/></td>
				</tr>
			</table>

			<label for="nombre_CorpsJ_droite">Droite :</label>
			<sf:errors path="nombre_CorpsJ_droite"/>
			<sf:input path="nombre_CorpsJ_droite" type="number"/>


			<label for="nombre_CorpsJ_gauche">Gauche :</label>
			<sf:errors path="nombre_CorpsJ_gauche"/>
			<sf:input path="nombre_CorpsJ_gauche" type="number"/>

			</br>

			<label for="taux_de_collecte">Taux de collecte estime :</label>
			<sf:errors path="taux_de_collecte"/>
			<sf:input path="taux_de_collecte" id="fakeTauxCollecte" disabled="true"/>
			<sf:hidden path="taux_de_collecte"/>

			<label for="sanitaire">Sanitaire :</label>
			<c:forEach items="${sanitaireList}" var="sanitaire" varStatus="vs">
				<sf:radiobutton path="sanitaire" value="${sanitaire.id}"/><c:out value="${sanitaire.nom}"/>
			</c:forEach>

			<br/>

			<input type="button" value="Calcul" onclick="calcul();"/>
			<br/>

			<label for="remarques">Remarque :</label>
			<br/>
			<sf:textarea path="remarques" name="remarques" cols="40" rows="5"/>

			<br/></br>

			<br/> <input onsubmit="calcul()" type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">
	function calcul()
	{
		var nombre_Embryons_Viables = document.getElementById("nombre_Embryons_Viables").value;
		var nombre_Embryons_Degeneres = document.getElementById("nombre_Embryons_Degeneres").value;
		var nombre_Embryons_NonFecondes = document.getElementById("nombre_Embryons_NonFecondes").value;
		var nombre_Embryons_Total = document.getElementById("nombre_Embryons_Total");
		nombre_Embryons_Total.value = parseInt(nombre_Embryons_Viables) + parseInt(nombre_Embryons_Degeneres) + parseInt(nombre_Embryons_NonFecondes);
		var fakeNombre_Embryons_Total = document.getElementById("fakeNombre_Embryons_Total");
		fakeNombre_Embryons_Total.value = nombre_Embryons_Total.value;

		var taux_de_collecte = document.getElementById("taux_de_collecte");
		var nombre_CorpsJ_droite = document.getElementById("nombre_CorpsJ_droite").value;
		var nombre_CorpsJ_gauche = document.getElementById("nombre_CorpsJ_gauche").value;

		taux_de_collecte.value = (nombre_Embryons_Total.value / (parseInt(nombre_CorpsJ_gauche) + parseInt(nombre_CorpsJ_droite)));
		if (taux_de_collecte.value == "NaN")
		{
			taux_de_collecte.value = 0;
		}
		var fakeTaux_de_collecte = document.getElementById("fakeTauxCollecte");
		fakeTaux_de_collecte.value = taux_de_collecte.value;
	}

</script>

<%@ include file="../../footersimplifie.jsp" %>