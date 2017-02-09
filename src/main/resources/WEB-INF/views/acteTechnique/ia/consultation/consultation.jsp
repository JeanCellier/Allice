<%@ include file="../../../headersimplifie.jsp" %>

<h1>Choix de la fiche &agrave; consulter</h1>

<div id="partieCentrale">
	<datalist id="ficheIaList">
		<c:forEach items="${ficheIaList}" var="ficheIa">
			<option value="${ficheIa.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheIa">
		<sf:input path="nom" list="ficheIaList" autocomplete="on" value="2016IA-"/>
		<input type="submit" value="Valider" class="valider">
	</sf:form>
	<br/>
</div>

<%@ include file="../../../footer.jsp" %>