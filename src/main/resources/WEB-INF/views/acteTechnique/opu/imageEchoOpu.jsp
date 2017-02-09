<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche OPU : ${nom}</h1>

<div id="partieCentrale">
	<sf:form modelAttribute="imageEcho" method="post" action="${nom}">
		<fieldset>
			<legend>TRAITEMENT DONNEUSE</legend>

			<label>Image &eacute;cographe :</label>
			<table id="tableauImageEcho">
				<tr>
					<th>Ovaires</th>
					<th>D&eacute;nombr&eacute;s<br></th>
					<th>Aspir&eacute;s</th>
				</tr>
				<tr>
					<td>Droit</td>
					<td><sf:input type="number" path="nb_ovaire_denombre_droit"/></td>
					<td><sf:input type="number" path="nb_ovaire_aspire_droit"/></td>
				</tr>
				<tr>
					<td>Gauche</td>
					<td><sf:input type="number" path="nb_ovaire_denombre_gauche"/></td>
					<td><sf:input type="number" path="nb_ovaire_aspire_gauche"/></td>
				</tr>
			</table>

			<label>Nb de COCs retrouv&eacute;s : </label>
			<sf:input path="nb_cocs" type="number"/>

			<input type="button" value="Calculer" onclick="calcul()"/>

			<label>Taux de collecte : </label>
			<sf:errors path="taux_collecte"/>
			<sf:input path="taux_collecte" id="fakeTauxCollecte" disabled="true"/><label>%</label>
			<sf:hidden path="taux_collecte"/>

			<br/>
			<label for="remarques">Remarque :</label><br/>
			<sf:textarea path="remarques" name="remarqueFecondationInVitro" cols="40" rows="5"/>
			<br/> <br/>
			<input type="submit" value="Valider" class="valider" onsubmit="calcul()"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">
	function calcul()
	{
		var nb_ovaire_aspire_droit = document.getElementById("nb_ovaire_aspire_droit").value;
		var nb_ovaire_aspire_gauche = document.getElementById("nb_ovaire_aspire_gauche").value;
		var nb_cocs = document.getElementById("nb_cocs").value;

		var taux_de_collecte = document.getElementById("taux_collecte");
		taux_collecte.value = parseInt(nb_cocs) / (parseInt(nb_ovaire_aspire_droit) + parseInt(nb_ovaire_aspire_gauche));

		if (taux_de_collecte.value == "NaN")
		{
			taux_de_collecte.value = 0;
		}
		var fakeTaux_de_collecte = document.getElementById("fakeTauxCollecte");
		fakeTaux_de_collecte.value = taux_de_collecte.value;
	}
</script>

<%@ include file="../../footersimplifie.jsp" %>