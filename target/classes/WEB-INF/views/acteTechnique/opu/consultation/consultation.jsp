<%@ include file="../../../headersimplifie.jsp" %>

<h1>Choix de la fiche &agrave; consulter</h1>

<div id="partieCentrale">
	<datalist id="ficheOpuList">
		<c:forEach items="${ficheOpuList}" var="ficheOpu">
			<option value="${ficheOpu.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheOpu">
		<sf:input path="nom" list="ficheOpuList" autocomplete="on" value="2016OPU-"/>
		<input type="submit" value="Valider" class="valider">
	</sf:form>
	<br/>
</div>

<%@ include file="../../../footer.jsp" %>