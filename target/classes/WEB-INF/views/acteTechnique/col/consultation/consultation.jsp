<%@ include file="../../../headersimplifie.jsp" %>

<h1>Choix de la fiche &agrave; consulter</h1>

<div id="partieCentrale">
	<datalist id="ficheColList">
		<c:forEach items="${ficheColList}" var="ficheCol">
			<option value="${ficheCol.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheCol">
		<sf:input path="nom" list="ficheColList" autocomplete="on" value="2016COL-"/>
		<input type="submit" value="Valider" class="valider">
	</sf:form>
	<br/>
</div>

<%@ include file="../../../footer.jsp" %>