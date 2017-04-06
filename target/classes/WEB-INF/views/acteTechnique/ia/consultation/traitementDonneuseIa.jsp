<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<sf:form modelAttribute="traitementDonneuse" method="post" action="${nom}">
	<fieldset>
		<legend>TRAITEMENT DONNEUSE</legend>

		<label for="naturel">Naturel :</label>
		<sf:checkbox path="naturel" value="true" disabled="true"/>

		<label for="operateur">Op&#233rateur :</label>
		<sf:input path="operateur.nom" disabled="true"/>

		<br/> <br/>

		<table id="tableauTraitementDonneuseSuper">
			<tr>
				<th>Date</th>
				<th>Produit<br></th>
				<th>Quantit&eacute<br></th>
				<th>Mode<br></th>
			</tr>
			<c:choose>
				<c:when test="${traitementDonneuse.tableau_pharmacie.size()>0}">
					<c:forEach begin="0" end="${traitementDonneuse.tableau_pharmacie.size()-1}" varStatus="vs">
						<tr>
							<td><sf:input disabled="true" type="date"
							              path="tableau_pharmacie[${vs.current}].date"/></td>
							<td><sf:input disabled="true" path="tableau_pharmacie[${vs.current}].produit.nom"/></td>
							<td><sf:input disabled="true" type="number"
							              path="tableau_pharmacie[${vs.current}].quantite"/></td>
							<td><sf:input disabled="true" type="text"
							              path="tableau_pharmacie[${vs.current}].mode"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>


	</fieldset>
</sf:form>
