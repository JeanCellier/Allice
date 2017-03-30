<sf:form method="post" modelAttribute="infoPIV" action="${nom}">
	<fieldset>
		<legend>INFORMATIONS GENERALES PIV</legend>
		<label id="operateurListe" for="operateurListe">Op&#233rateur :
			<jsp:useBean id="infoPIV" scope="request" type="phenotypage.model.informationsPIV.Informations_PIV"/>
			<c:choose>
				<c:when test="${infoPIV.operateurList.size()>0}">
					<c:forEach begin="0" end="${infoPIV.operateurList.size()-1}" var="index">
						<sf:input path="operateurList[${index}]"
						          value="${infoPIV.operateurList[index].prenom} ${infoPIV.operateurList[index].nom}"
						          disabled="true"/>
					</c:forEach>
				</c:when>
			</c:choose>
		</label>
		<br/>
		<br/>
		<table>
			<tr>
				<td><label for="milieuMaturation">Maturation :</label></td>
				<td><sf:input disabled="true" path="milieuMaturation.nom" name="mat"/></td>
			</tr>
			<tr>
				<td><label for="fiv">FIV :</label></td>
				<td><sf:input path="fiv.nom" disabled="true"/>
			<tr>
				<td><label for="typeCulture">Culture :</label></td>
				<td><sf:input path="typeCulture.nom" disabled="true"/>
			</tr>
		</table>
		<br/>
	</fieldset>
</sf:form>
