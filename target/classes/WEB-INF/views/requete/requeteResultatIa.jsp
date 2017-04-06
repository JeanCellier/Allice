<%@ include file="../headersimplifie.jsp" %>

<h1>Fiche IA : </h1>

<div class="partieCentrale">

	<c:forEach items="${ficheList}" var="fiche">
		<a href="<s:url value='/acteTechnique/ia/consultation/${fiche.nom}'/>">${fiche.nom}</a>
		<br>
	</c:forEach>

</div>

<%@ include file="../footersimplifie.jsp" %>