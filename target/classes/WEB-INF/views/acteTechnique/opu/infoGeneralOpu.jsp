<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche OPU : ${nom}</h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="infoPIV" action="${nom}">
		<fieldset>
			<legend>INFORMATIONS GENERALES PIV</legend>
			<label id="operateurListe" for="operateurListe">Op&#233rateur :
				<c:choose>
					<c:when test="${infoPIV.operateurList.size()>0}">
						<c:forEach begin="0" end="${infoPIV.operateurList.size()-1}" var="index">
							<sf:select path="operateurList" multiple="false">
								<sf:option value="${infoPIV.operateurList[index].id}"
								           label="${infoPIV.operateurList[index].prenom} ${infoPIV.operateurList[index].nom}"/>
								<c:forEach items="${operateurList}" var="operateur">
									<sf:option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"/>
								</c:forEach>
							</sf:select>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<sf:select path="operateurList" multiple="false">
							<c:forEach items="${operateurList}" var="operateur">
								<sf:option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"/>
							</c:forEach>
						</sf:select>
					</c:otherwise>
				</c:choose>
			</label>
			<input type="button" value="+" onclick="ajoutOperateur();"/>

			<br/>
			<br/>
			<table>
			<tr>
				<td><label for="milieuMaturation">Maturation :</label></td>
				<td><sf:select path="milieuMaturation" name="mat">
					<c:forEach items="${milieu_maturationList}" var="milieuMaturation">
						<option value="${milieuMaturation.id}"><c:out value="${milieuMaturation.nom} ${milieuMaturation.numeroLot}"/></option>
					</c:forEach>
				</sf:select></td>
			</tr>
			<tr>
				<td><label for="fiv">FIV :</label></td>
				<td><sf:select path="fiv">
					<c:forEach items="${milieu_fivList}" var="milieu_fiv">
						<option value="${milieu_fiv.id}"><c:out value="${milieu_fiv.nom} ${milieu_fiv.numeroLot}"/></option>
					</c:forEach>
				</sf:select></td>
			</tr>
			<tr>
				<td><label for="fiv">Culture :</label></td>
				<td><sf:select path="typeCulture">
					<c:forEach items="${milieu_cultureList}" var="milieu_culture">
						<option value="${milieu_culture.id}"><c:out value="${milieu_culture.nom} ${milieu_culture.numeroLot}"/></option>
					</c:forEach>
				</sf:select></td>
			</tr>
			</table>
			<br/>
			<br/>

			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">

	function ajoutOperateur()
	{
		var labelOperateur = document.getElementById("operateurListe");
		var element = document.createElement("select");
		element.setAttribute("id", "operateurList");
		element.setAttribute("name", "operateurList");
		<c:forEach items="${operateurList}" var="operateur">
		var option = document.createElement("option");
		option.setAttribute("value", "${operateur.id}");
		option.setAttribute("label", "${operateur.prenom} ${operateur.nom}");
		element.appendChild(option);
		</c:forEach>
		labelOperateur.appendChild(element);
	}
</script>

<%@ include file="../../footersimplifie.jsp" %>
