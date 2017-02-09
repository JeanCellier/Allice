<%@ include file="../../headersimplifie.jsp" %>

<div class="partieCentrale">
	<datalist id="ficheAba">
		<c:forEach items="${ficheAbaList}" var="ficheAba">
			<option value="${ficheAba.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheAba">
		<sf:input path="nom" list="ficheAba" autocomplete="on" value="2016ABA-"/>
		<input type="submit">
	</sf:form>
	<br/>
</div>

<%@ include file="../../footer.jsp" %>