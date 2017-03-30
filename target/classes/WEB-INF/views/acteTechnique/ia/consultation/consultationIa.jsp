<%@ include file="../../../headersimplifie.jsp" %>

<h1>Fiche IA :</h1>

<div id="partieCentrale">

	<%@ include file="enteteIa.jsp" %>
	<%@ include file="vacheIa.jsp" %>
	<%@ include file="inseminationIa.jsp" %>
	<%@ include file="traitementDonneuseIa.jsp" %>
	<%@ include file="gestationIa.jsp" %>

	<fieldset>
		<label>Remarques :</label><br>
		<textarea cols="40" rows="5" disabled="true">${remarques}</textarea>
	</fieldset>

</div>

<%@ include file="../../../footersimplifie.jsp" %>

