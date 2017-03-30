<%@ include file="../headersimplifie.jsp" %>

<h1>Fiche TRA : </h1>

<div class="partieCentrale">

	<c:forEach items="${ficheList}" var="fiche">
		<a href="<s:url value='/acteTechnique/tra/consultation/${fiche.nom}'/>">${fiche.nom}</a>
		<br>
	</c:forEach>

	<%--<a href="${file}" download="${file}">file</a>--%>
</div>

<%@ include file="../footersimplifie.jsp" %>