<%@ include file="../headersimplifie.jsp" %>

<h1>Consultation de la pharmacie</h1>

<div id="partieCentrale">

	<fieldset>
	
		<legend>Les produits </legend>	
		
		<a href="pharmacie/" style="width:250px;" >Ajouter un produit</a>
		</br>	

	<table id="tableauCollecte">
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
					<th  ><a href="pharmacie/${produit.id}" >Modifier</a></th>
				</tr>
			
		</c:forEach>
	</table>
	</fieldset>
</div>

<%@ include file="../footer.jsp" %>