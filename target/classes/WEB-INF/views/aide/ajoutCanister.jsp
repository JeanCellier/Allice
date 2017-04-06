<%@ include file="../fiche.jsp" %>

<div id="partieCentrale">
	<fieldset>
		<legend>Ajout Canister</legend>

		<sf:form modelAttribute="canister" method="post">
			<label for="numero">Numero :</label>
			<sf:errors path="numero"/>
			<sf:input type="number" path="numero"/>
	
			<br/><br/>
			<input type="submit" name="Valider" class="valider"/>
		</sf:form>
	</fieldset>
<br/>
	<fieldset>
		<legend>Canister existant</legend>

		<c:forEach items="${millieuMaturationList}" var="element">
			<c:out value="${element.numero}"/>
			</br>
		</c:forEach>
	</fieldset>
</div>

<%@ include file="../footersimplifie.jsp" %>