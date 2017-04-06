<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<sf:form modelAttribute="traitementDonneuse" method="post" action="${nom}">
	<fieldset>
		<legend>TRAITEMENT DONNEUSE</legend>

		<label for="date_ref_chaleur">Date d'entr&eacute;e en chaleur :</label>
		<sf:input path="date_ref_chaleur" type="date" disabled="true"/>

		<label for="naturel">Naturel :</label>
		<sf:checkbox path="naturel" value="true" disabled="true"/>

		<br/> <br/>

		<table id="tableauTraitementDonneuse">
			<tr>
				<th>Date</th>
				<th>Produit<br></th>
				<th>Quantit&eacute;<br></th>
				<th>Mode<br></th>
			</tr>
			<c:choose>
				<c:when test="${traitementDonneuse.tableau_pharmacie.size()>0}">
					<c:forEach begin="0" end="${traitementDonneuse.tableau_pharmacie.size()-1}" varStatus="vs">
						<tr>
							<td><sf:input type="date" path="tableau_pharmacie[${vs.current}].date"
							              disabled="true"/></td>
							<td><sf:input path="tableau_pharmacie[${vs.current}].produit.nom" disabled="true"/></td>
							<td><sf:input type="number" path="tableau_pharmacie[${vs.current}].quantite"
							              disabled="true"/></td>
							<td><sf:input type="text" path="tableau_pharmacie[${vs.current}].mode"
							              disabled="true"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>

		<label for="nb_follicules">Nb follicules :</label>
		<sf:input path="nb_follicules" type="number" disabled="true"/>

		<label for="nb_droite">Droite :</label>
		<sf:input path="nb_droite" type="number" disabled="true"/>

		<label for="nb_gauche">Gauche :</label>
		<sf:input path="nb_gauche" type="number" disabled="true"/>

		<br/>

		<label for="typeFSH">Type FSH:</label>
		<sf:input path="typeFSH" type="text" disabled="true"/>

		<br/>

		<label for="pourc_dose">% de la dose totale FSH :</label>
		<sf:input path="pourc_dose" type="number" disabled="true"/>

		<br/>

		<table id="tableauTraitementDonneuseSuper">
			<tr>
				<th>Date</th>
				<th>Matin<br></th>
				<th>Apr&eacute;s-midi</th>
			</tr>
			<c:choose>
				<c:when test="${traitementDonneuse.tableau_pharmacie.size()>0}">
					<c:forEach begin="0" end="${traitementDonneuse.tableau_pharmacie.size()-1}" varStatus="vs">
						<tr>
							<td><sf:input type="date"
							              path="tableau_pharmacie_superovulation_medicament[${vs.current}].date"
							              disabled="true"/></td>
							<td><sf:input list="text"
							              path="tableau_pharmacie_superovulation_medicament[${vs.current}].matin"
							              disabled="true"/></td>
							<td><sf:input type="text"
							              path="tableau_pharmacie_superovulation_medicament[${vs.current}].apresMidi"
							              disabled="true"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<label for="operateur">Op&#233rateur :</label>
		<sf:input path="operateur.nom" disabled="true"/>

		<sf:checkbox path="semenceSexe" label="Semence sexe" disabled="true"/>
		<br/>
		<br/> <br/>
	</fieldset>
</sf:form>
