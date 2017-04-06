<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche COL : ${nom}</h1>

<!-- <div id="partieCentrale"> -->

	<sf:form method="post" modelAttribute="cryoconservation" action="${nom}">
		<fieldset>
			<legend>INFORMATION SI CRYOCONSERVATION</legend>

			<label for="heure">Heure de cong&#233lation :</label>
			<sf:input path="heure" type="number" maxlength="2" size="2" /> : <sf:input path="minute" type="number" maxlength="2" size="2"/>
			<br/>
			<label for="methodeCongelation">M&#233thode de cong&#233lation :</label>
			<c:forEach items="${methodeCongelationList}" var="methodeCongelation">
				<sf:radiobutton path="methodeCongelation" value="${methodeCongelation.id}"/><c:out
					value="${methodeCongelation.nom}"/>
			</c:forEach>

			<br/>

			<label for="congelateur">Cong&#233lateur utilis&#233:</label>
			<c:forEach items="${congelateurList}" var="congelateur">
				<sf:radiobutton path="congelateur" value="${congelateur.id}"/><c:out
					value="${congelateur.nom}"/>
			</c:forEach>

			<br/>

			<label for="operateur">Op&#233rateur cong&#233lation :</label>
			<sf:select path="operateur">
				<c:forEach items="${operateurList}" var="operateur">
					<option value="${operateur.id}" label="${operateur.prenom} ${operateur.nom}"></option>
				</c:forEach>
			</sf:select><br/>

			<label for="descMethode">Description m&#233thode (nom programme, cin&#233tique, seeding...) :</label> <br/>
			<sf:textarea path="descMethode" name="descriptionCryoconservation" cols="80" rows="5"/>
			<br/> <br/>

			<table id="part1">
				<tr>
					<th>N&#176 Embryon</th>
					<th>Groupe</th>
					<th>Stade</th>
					<th>Qualit&#233</th>
					<th>Cuve stockage</th>
					<th>Canister Stockage</th>
					<th>VisoTube stockage</th>
					<th>Jonc</th>
					<th>Numero Receveuse</th>
					<th>R&#233f&#233rence<br/>transfert</th>
					<th>Remarque</th>
				</tr>
				<c:forEach begin="0" end="${nbLigneCryo}" varStatus="vs">
				<tr>
					<td>${vs.current}</td>

					<td><sf:input path="tableauDetailList[${vs.current}].groupe" type="number"/></td>

					<td><sf:select path="tableauDetailList[${vs.current}].stade">
						<c:forEach items="${stadeList}" var="stade">
							<option value="${stade.id}" label="${stade.nom} ${stade.numero}"></option>
						</c:forEach>
					</sf:select></td>

					<td><sf:select path="tableauDetailList[${vs.current}].qualite">
						<c:forEach items="${qualiteList}" var="qualite">
							<option value="${qualite.id}" label="${qualite.nom} ${qualite.numero}"></option>
						</c:forEach>
					</sf:select></td>

					<td><sf:select path="tableauDetailList[${vs.current}].cuve">
						<c:forEach items="${cuveList}" var="cuve">
							<option value="${cuve.id}" label="${cuve.nom} ${cuve.designation}"></option>
						</c:forEach>
					</sf:select></td>

					<td><sf:select path="tableauDetailList[${vs.current}].canister">
						<c:forEach items="${canisterList}" var="canister">
							<option value="${canister.id}" label="${canister.numero}"></option>
						</c:forEach>
					</sf:select></td>

					<td><sf:select path="tableauDetailList[${vs.current}].visoTube">
						<c:forEach items="${visoTubeList}" var="visoTube">
							<option value="${visoTube.id}" label="${visoTube.numero} ${visoTube.couleur}"></option>
						</c:forEach>
					</sf:select></td>

					<td><sf:input path="tableauDetailList[${vs.current}].jonc" type="text" size="1${vs.current}"/></td>

					<td><sf:input path="tableauDetailList[${vs.current}].numeroReceveuse" type="text" size="10"/></td>

					<td><sf:input path="tableauDetailList[${vs.current}].referenceTransfert" type="text"
					              size="10"/></td>

					<td><sf:input path="tableauDetailList[${vs.current}].remarque" type="text" size="20"/></td>

				</tr>
				</c:forEach>
			</table>

			<br/>
			<input type="submit" value="Valider" class="valider"/>
		</fieldset>
	</sf:form>

<!-- </div> -->

<%@ include file="../../footersimplifie.jsp" %>