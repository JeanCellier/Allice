<%@ include file="../../../headersimplifie.jsp" %>

<h1>Choix de la fiche &agrave; consulter</h1>

<div id="partieCentrale">

	<datalist id="ficheAba">
		<c:forEach items="${ficheAbaList}" var="ficheAba">
			<option value="${ficheAba.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheAba">
		<sf:input path="nom" list="ficheAba" autocomplete="on" value="2016ABA-"/>
		<label>&nbsp;&nbsp;</label>
		<input type="submit" value="Valider" class="valider">
	</sf:form>

</div>

<%@ include file="../../../footer.jsp" %>