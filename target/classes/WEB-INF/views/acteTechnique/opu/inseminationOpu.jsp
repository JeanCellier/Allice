<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche OPU : ${nom}</h1>

<div id="partieCentrale">
	<sf:form modelAttribute="insemination" method="post" action="${nom}">
		<fieldset>
			<legend>INSEMINATION</legend>

			<label for="operateur">Op&#233rateur :</label>
			<sf:select path="operateur">
				<c:forEach items="${operateurList}" var="operateur">
					<option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"></option>
				</c:forEach>
			</sf:select>

			<sf:checkbox path="sexe" value="true"/> <label>Semence sex&#233e</label>
			<br/>

			<label for="taureauList">Nom taureau :</label>
			<sf:input list="taureauList" path="taureau.nom"/>

			<label for="taureauListRace">Race :</label>
			<sf:input list="taureauListRace" path="taureau.race"/>

			<label for="taureauListNumIdentification">N&#176 Identification :</label>
			<sf:input list="taureauListNumIdentification" path="taureau.num_identification"/>

			<br/>
			<label for="ficheColList">Fiche Col :</label>
			<sf:checkbox path="collecte" value="true"/>
			<sf:select path="ficheColList">
				<c:forEach items="${ficheColList}" var="ficheColList">
					<option value="${ficheColList.id}" label="${ficheColList.nom}"></option>
				</c:forEach>
			</sf:select>
			<br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<datalist id="taureauList">
	<c:forEach items="${taureauList}" var="taureau">
		<option value="${taureau.nom}"></option>
	</c:forEach>
</datalist>

<datalist id="taureauListRace">
	<c:forEach items="${taureauList}" var="taureau">
		<option value="${taureau.race}"></option>
	</c:forEach>
</datalist>

<datalist id="taureauListNumIdentification">
	<c:forEach items="${taureauList}" var="taureau">
	<option value=${taureau.num_identification}></option>
	</c:forEach>

<%@ include file="../../footersimplifie.jsp" %>