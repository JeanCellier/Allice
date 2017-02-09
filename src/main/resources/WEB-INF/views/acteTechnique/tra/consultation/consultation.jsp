<%@ include file="../../../headersimplifie.jsp" %>

<h1>Choix de la fiche &agrave; consulter</h1>

<div id="partieCentrale">
	<datalist id="ficheTraList">
		<c:forEach items="${ficheTraList}" var="ficheTra">
			<option value="${ficheTra.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheTra">
		<sf:input path="nom" list="ficheTraList" autocomplete="on" value="2016TRA-"/>
		<input type="submit" value="Valider" class="valider">
	</sf:form>
	<br/>
</div>

<%@ include file="../../../footer.jsp" %>