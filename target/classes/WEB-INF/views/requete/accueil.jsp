<%@ include file="../headersimplifie.jsp" %>

<h1>Actes Techniques :</h1>

<div id="partieCentraleIndex">
	<table>
		<tr>
			<td><a href="<s:url value='/requete/aba'/>">SNIG Fiche ABA</a></td>

			<td><a href="<s:url value='/requete/opu'/>">SNIG Fiche OPU</a></td>
		</tr>
		<tr>
			<td><a href="<s:url value='/requete/tra'/>">SNIG Fiche TRA</a></td>
			<td><a href="<s:url value='/requete/ia'/>">SNIG Fiche IA</a></td>
		</tr>
		<tr>
			<td><a href="<s:url value='/requete/col'/>">SNIG Fiche COL</a></td>
		</tr>
	</table>
</div>

<%@ include file="../footer.jsp" %>