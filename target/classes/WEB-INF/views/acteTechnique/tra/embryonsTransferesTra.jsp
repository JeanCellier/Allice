<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche TRA : ${nom} </h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="embryonsTransferes" action="${nom}">
		<fieldset>
			<legend>Embryon(s) transféré(s) :</legend>

			<table>
				<tr>
					<td><label for="">Référence expérience production d'embryon(s) :</label>
						<sf:errors path="refExperience"/>
						<sf:input path="refExperience" type="text"/></td>

					<td><label for="">Semence sexée :</label>
						<sf:checkbox path="sexe"/></td>
				</tr>
				<tr>
					<td><label for="">N° embryon :</label>
						<sf:input path="refEmbryons" type="text"/></td>
					<td><label for="">Race taureau :</label>
						<sf:input path="taureau.race" type="text"/></td>
					<td><label for="">N° taureau :</label>
						<sf:input path="taureau.num_identification" type="text"/></td>
				</tr>
				<tr>
					<td><label for="">Côté transfert :</label>
							<sf:radiobutton path="cote" value="true"/>Droit
							<sf:radiobutton path="cote" value="false"/>Gauche
				</tr>
				<tr>
					<td><label for="">Emplacement dans la corne utérine :</label>
						<sf:input path="tiers" type="number"/></td>
				</tr>
				<tr>
					<td><label for="">Facilité de progression :</label>
						<sf:input path="faciliteprogression" type="text"/></td>
				</tr>
			</table>


			<br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>

</div>

<%@ include file="../../footersimplifie.jsp" %>