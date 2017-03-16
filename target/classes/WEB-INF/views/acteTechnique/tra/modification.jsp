<%@ include file="../../headersimplifie.jsp" %>

<div class="partieCentrale">
	<datalist id="ficheTraList">
		<c:forEach items="${ficheTraList}" var="ficheTraList">
			<option value="${ficheTraList.nom}" label=""></option>
		</c:forEach>
	</datalist>

	<sf:form method="post" modelAttribute="ficheTra">
		<sf:input path="nom" list="ficheTraList" autocomplete="on" value="2016TRA-"/>
		<input type="submit">
	</sf:form>
	<br/>
</div>

<%@ include file="../../footer.jsp" %>