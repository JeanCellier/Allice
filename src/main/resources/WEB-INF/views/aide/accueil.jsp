<%@ include file="../headersimplifie.jsp"%>
<h1>Nouvelles entr&eacutees</h1>

<div id="partieCentraleIndex">

	<table>
	<tr>
		<td><a href="<s:url value='ajoutCongelateur'/>">Nouveau Cong&eacutelateur</a></td>
		<td><a href="<s:url value='ajoutProgramme'/>">Nouveau Programme</a></td>
	</tr>
	<tr>
		<td><a href="<s:url value='ajoutOperateur'/>">Nouvel Op&eacuterateur</a></td>
		<td><a href="<s:url value='ajoutSanitaire'/>">Nouveau Sanitaire</a></td>
	</tr>
	<tr>		
		<td><a href="<s:url value='ajoutAbattoir'/>">Nouvel Abattoir</a></td>
		<td><a href="<s:url value='ajoutTypeCulture'/>">Nouveau Millieu CIV</a></td>
	</tr>
	<tr>
		<td><a href="<s:url value='ajoutFIV'/>">Nouveau millieu FIV</a></td>
		<td><a href="<s:url value='ajoutMilieuMaturation'/>">Nouveau millieu MIV</a></td>
	</tr>
	<tr>		
		<td><a href="<s:url value='ajoutDestinationCulture'/>">Nouvelle Destination Culture</a></td>
		<td><a href="<s:url value='ajoutCuve'/>">Nouvelle Cuve</a></td>
	</tr>
	<tr>
		<td><a href="<s:url value='ajoutCanister'/>">Nouveau Canister</a></td>
	</tr>
	</table>
</div>

<%@ include file="../footersimplifie.jsp"%>