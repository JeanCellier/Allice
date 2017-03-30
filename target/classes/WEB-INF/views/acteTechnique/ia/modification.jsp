<%@ include file="../../headersimplifie.jsp" %>

<div class="partieCentrale">
	<datalist id="ficheIaList">
		<c:forEach items="${ficheIaList}" var="ficheIaList">
			<option value="${ficheIaList.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheIaList">
		<sf:input path="nom" list="ficheIaList" autocomplete="on" value="2016IA-"/>
		<input type="submit">
	</sf:form>
	<br/>
</div>

<%@ include file="../../footer.jsp" %>