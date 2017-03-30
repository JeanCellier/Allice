<%@ include file="../../headersimplifie.jsp" %>

<div class="partieCentrale">
	<datalist id="ficheColList">
		<c:forEach items="${ficheColList}" var="ficheColList">
			<option value="${ficheColList.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheCol">
		<sf:input path="nom" list="ficheColList" autocomplete="on" value="2016COL-"/>
		<input type="submit">
	</sf:form>
	<br/>
</div>

<%@ include file="../../footer.jsp" %>