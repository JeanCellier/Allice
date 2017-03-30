<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche OPU : ${nom}</h1>

<div id="partieCentrale">

	<sf:form method="post" modelAttribute="cultureInVitro" action="${nom}">
		<fieldset>
			<legend>CULTURE IN VITRO</legend>

			<label for="dateCultureInVitro">Date :</label>
			<sf:input path="date" type="date" name="dateCultureInVitro"/>

			<label for="sanitaireCultureInVitro">Sanitaires :</label>
			<c:forEach begin="0" end="${sanitaireList.size()-1}" varStatus="vs">
				<c:set value="" var="check"/>
				<c:if test="${fecondationInvitro.sanitaireList.contains(sanitaireList.get(vs.current))}">
					<c:set value="checked" var="check"/>
				</c:if>
				<sf:checkbox checked="${check}" path="sanitaireList[${vs.current}]"
				             value="${sanitaireList[vs.current].id}"
				             label="${sanitaireList[vs.current].nom}"/>
				<c:set value="" var="check"/>
			</c:forEach>
			<br/> <br/>

			<table id="tab1">
				<tr>
					<th>Groupe</th>
					<th>Nb d'ovo<br/>ins&#233min&#233s</th>
					<th>Heure de mise en<br/>culture</th>
					<th>Nb segment&#233s</th>
					<th>% seg</th>
					<th>J5<br/>jm</th>
				</tr>
				<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" varStatus="vs">
				<tr>
					<td><sf:input type="text" path="tableauCultureList[${vs.current}].groupe"/></td>
					<td><sf:input type="number" path="tableauCultureList[${vs.current}].nbInsemine"/></td>
					<td><sf:input type="number" path="tableauCultureList[${vs.current}].heureCulture"/>h
						<sf:input type="number" path="tableauCultureList[${vs.current}].minuteCulture"/></td>
					<td><sf:input type="number" path="tableauCultureList[${vs.current}].nbSegmente"/></td>
					<td><sf:label path="tableauCultureList[${vs.current}].segment"
					              id="tableauCultureList[${vs.current}].segment"/>
						<sf:hidden path="tableauCultureList[${vs.current}].segment"/></td>
					<!--Place pour la valeur calcul�e  -->
					<td><sf:input type="number" path="tableauCultureList[${vs.current}].j5JM"/></td>
					</c:forEach>
				</tr>
				<input type="button" value="+" onclick="ajoutLigneTab1();"/>
			</table>

			<br/>
			<table id="tab2">
				<tr>
					<td rowspan="2" class="headermodif">Groupe</td>
					<td colspan="6" class="headermodif">D&#233veloppement &#225 J7</td>
				</tr>
				<tr>
					<td class="headermodif">mo</td>
					<td class="headermodif">BL</td>
					<td class="headermodif">BE</td>
					<td class="headermodif">BEC</td>
					<td class="headermodif">Q1</td>
					<td class="headermodif">Nb Total</td>
				</tr>
				<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" varStatus="vs">
					<tr>
						<td><input type="text"/></td> <!--  = le m�me groupe qu'en au donc on ne le sauvegarde pas-->
						<td><sf:input type="number" path="tableauCultureList[${vs.current}].mo"/></td>
						<td><sf:input type="number" path="tableauCultureList[${vs.current}].bl"/></td>
						<td><sf:input type="number" path="tableauCultureList[${vs.current}].be"/></td>
						<td><sf:input type="number" path="tableauCultureList[${vs.current}].bec"/></td>
						<td><sf:input type="number" path="tableauCultureList[${vs.current}].q1"/></td>
						<td><sf:label path="tableauCultureList[${vs.current}].nbTotal"
						              id="tableauCultureList[${vs.current}].nbTotal"/>
							<sf:hidden path="tableauCultureList[${vs.current}].nbTotal"/></td> <!-- valeur calcul�e -->
					</tr>
				</c:forEach>
			</table>
			<br/>
			<table id="tab3">
				<tr>
					<td rowspan="2" class="headermodif">Groupe</td>
					<td colspan="3" class="headermodif">&#37 d&#233veloppement &#225 J7</td>
					<td colspan="2" class="headermodif">J8</td>
					<td rowspan="2" class="headermodif">Destination</td>
				</tr>
				<tr>
					<td class="headermodif">&#37J7</td>
					<td class="headermodif">&#37BEJ7</td>
					<td class="headermodif">&#37Q1J7</td>
					<td class="headermodif">Nb</td>
					<td class="headermodif">&#37J8</td>
				</tr>
				<c:forEach begin="0" end="${cultureInVitro.tableauCultureList.size()-1}" varStatus="vs">
				<tr>
					<td><input type="text"/></td> <!--  = le m�me groupe qu'en au donc on ne le sauvegarde pas-->
					<td><sf:label path="tableauCultureList[${vs.current}].pourJ7"
					              id="tableauCultureList[${vs.current}].pourJ7"/>
						<sf:hidden path="tableauCultureList[${vs.current}].pourJ7"/></td>
					<td><sf:label path="tableauCultureList[${vs.current}].pourBEJ7"
					              id="tableauCultureList[${vs.current}].pourBEJ7"/>
						<sf:hidden path="tableauCultureList[${vs.current}].pourBEJ7"/></td>
					<td><sf:label path="tableauCultureList[${vs.current}].pourQ1J7"
					              id="tableauCultureList[${vs.current}].pourQ1J7"/>
						<sf:hidden path="tableauCultureList[${vs.current}].pourQ1J7"/></td>
					<td><sf:input type="number" path="tableauCultureList[${vs.current}].J8parNb"/></td>
					<td><sf:label path="tableauCultureList[${vs.current}].pourJ8"
					              id="tableauCultureList[${vs.current}].pourJ8"/>
						<sf:hidden path="tableauCultureList[${vs.current}].pourJ8"/></td>
					<td><sf:radiobutton path="tableauCultureList[${vs.current}].siCryo" value="true"/>Cryo
						<sf:radiobutton path="tableauCultureList[${vs.current}].siCryo" value="false"/> D&#233truit
					</td>
					</c:forEach>
					<td><input type="button" value="Calcul" onclick="calcul();"/></td>
				</tr>
			</table>
			<br/>
			<label for="remarques">Remarque :</label>
			<br/>
			<sf:textarea path="remarques" name="remarques" cols="40" rows="5"/><br/>
			<br/>
			<input type="submit" value="Valider" class="valider" onclick="calcul()"/>
		</fieldset>
	</sf:form>
</div>

<script lang="text/javascript">
	function ajoutLigneTab1()
	{
		/* rajouter test pour v�rifier si les noms de groupes sont les m�mes
		 ou alors en sauvegarder qu'un */
		var tab1 = document.getElementById("tab1");
		var length = tab1.rows.length - 1;
		var ligne = tab1.insertRow(-1);

		var textTemp = document.createElement("label");
		var textTemp2 = document.createElement("label");

		var cellule = ligne.insertCell(-1);
		var input2 = document.createElement("input");
		var input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".id");
		input.setAttribute("name", "tableauCultureList[" + length + "].groupe");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".nbInsemine");
		input.setAttribute("name", "tableauCultureList[" + length + "].nbInsemine");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".id");
		input.setAttribute("name", "tableauCultureList[" + length + "].heureCulture");
		input.setAttribute("type", "number");
		textTemp.innerHTML = "h";
		input2.setAttribute("id", "tableauCultureList" + length + ".id");
		input2.setAttribute("name", "tableauCultureList[" + length + "].minuteCulture");
		input2.setAttribute("type", "number");
		cellule.appendChild(input);
		cellule.appendChild(textTemp);
		cellule.appendChild(input2);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".nbSegmente");
		input.setAttribute("name", "tableauCultureList[" + length + "].nbSegmente");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("Label");
		input.setAttribute("for", "tableauCultureList" + length + ".segment");
		input.setAttribute("id", "tableauCultureList[" + length + "].segment");
		cellule.appendChild(input);
		input = document.createElement("input");
		input.setAttribute("name", "tableauCultureList[" + length + "].segment");
		input.setAttribute("id", "tableauCultureList" + length + ".segment");
		input.setAttribute("type", "hidden");
		cellule.appendChild(input);

		cellule = ligne.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".id");
		input.setAttribute("name", "tableauCultureList[" + length + "].j5JM");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		/* tab2 */
		var tab2 = document.getElementById("tab2");
		var ligne2 = tab2.insertRow(-1);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".id");
		input.setAttribute("name", "tableauCultureList[" + length + "].groupe");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".mo");
		input.setAttribute("name", "tableauCultureList[" + length + "].mo");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".bl");
		input.setAttribute("name", "tableauCultureList[" + length + "].bl");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".be");
		input.setAttribute("name", "tableauCultureList[" + length + "].be");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".bec");
		input.setAttribute("name", "tableauCultureList[" + length + "].bec");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".q1");
		input.setAttribute("name", "tableauCultureList[" + length + "].q1");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne2.insertCell(-1);
		input = document.createElement("Label");
		input.setAttribute("for", "tableauCultureList" + length + ".nbTotal");
		input.setAttribute("id", "tableauCultureList[" + length + "].nbTotal");
		cellule.appendChild(input);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".nbTotal");
		input.setAttribute("name", "tableauCultureList[" + length + "].nbTotal");
		input.setAttribute("type", "hidden");
		cellule.appendChild(input);

		/* tab 3 */

		var tab3 = document.getElementById("tab3");
		var ligne3 = tab3.insertRow(-1);

		cellule = ligne3.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".id");
		input.setAttribute("name", "tableauCultureList[" + length + "].groupe");
		input.setAttribute("type", "text");
		cellule.appendChild(input);

		cellule = ligne3.insertCell(-1);
		input = document.createElement("Label");
		input.setAttribute("for", "tableauCultureList" + length + ".pourJ7");
		input.setAttribute("id", "tableauCultureList[" + length + "].pourJ7");
		cellule.appendChild(input);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".pourJ7");
		input.setAttribute("name", "tableauCultureList[" + length + "].pourJ7");
		input.setAttribute("type", "hidden");
		cellule.appendChild(input);

		cellule = ligne3.insertCell(-1);
		input = document.createElement("Label");
		input.setAttribute("for", "tableauCultureList" + length + ".pourBEJ7");
		input.setAttribute("id", "tableauCultureList[" + length + "].pourBEJ7");
		cellule.appendChild(input);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".pourBEJ7");
		input.setAttribute("name", "tableauCultureList[" + length + "].pourBEJ7");
		input.setAttribute("type", "hidden");
		cellule.appendChild(input);

		cellule = ligne3.insertCell(-1);
		input = document.createElement("Label");
		input.setAttribute("for", "tableauCultureList" + length + ".pourQ1J7");
		input.setAttribute("id", "tableauCultureList[" + length + "].pourQ1J7");
		cellule.appendChild(input);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".pourQ1J7");
		input.setAttribute("name", "tableauCultureList[" + length + "].pourQ1J7");
		input.setAttribute("type", "hidden");
		cellule.appendChild(input);

		cellule = ligne3.insertCell(-1);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".J8parNb");
		input.setAttribute("name", "tableauCultureList[" + length + "].J8parNb");
		input.setAttribute("type", "number");
		cellule.appendChild(input);

		cellule = ligne3.insertCell(-1);
		input = document.createElement("Label");
		input.setAttribute("for", "tableauCultureList" + length + ".pourJ8");
		input.setAttribute("id", "tableauCultureList[" + length + "].pourJ8");
		cellule.appendChild(input);
		input = document.createElement("input");
		input.setAttribute("id", "tableauCultureList" + length + ".pourJ8");
		input.setAttribute("name", "tableauCultureList[" + length + "].pourJ8");
		input.setAttribute("type", "hidden");
		cellule.appendChild(input);

		/* pb checkbox */
		cellule = ligne3.insertCell(-1);
		input = document.createElement("input");
		input.id = "tableauCultureList" + length + "siCryo1";
		input.name = "tableauCultureList[" + length + "].siCryo";
		input.type = "radio";
		input.value = "true";
		input.checked = "checked";

		input2 = document.createElement("input");
		input2.id = "tableauCultureList" + length + "siCryo2";
		input2.name = "tableauCultureList[" + length + "].siCryo";
		input2.type = "radio";
		input2.value = "false";

		textTemp.innerHTML = "Cryo";
		textTemp2.innerHTML = "D&#233truit";
		//input.appendChild(input2);

		cellule.appendChild(input);
		cellule.appendChild(textTemp);
		cellule.appendChild(input2);
		cellule.appendChild(textTemp2);
	}

	function calcul()
	{
		/* rajouter test pour Nan */
		var tab1 = document.getElementById("tab1").rows.length;
		var length;
		for (length = 0; length < tab1 - 1; length++)
		{
			var nbOvo = document.getElementById("tableauCultureList" + length + ".nbInsemine").value;
			var nbSeg = document.getElementById("tableauCultureList" + length + ".nbSegmente").value;
			var resultat = (nbSeg / nbOvo) * 100;

			var celluleResultat = document.getElementById("tableauCultureList" + length + ".segment");
			celluleResultat.innerHTML = resultat.toString();
			celluleResultat = document.getElementById("tableauCultureList[" + length + "].segment");
			celluleResultat.innerHTML = resultat.toString();

			/*Calcul Nb Total */

			var mo = document.getElementById("tableauCultureList" + length + ".mo").value;
			var bl = document.getElementById("tableauCultureList" + length + ".bl").value;
			var be = document.getElementById("tableauCultureList" + length + ".be").value;
			var bec = document.getElementById("tableauCultureList" + length + ".bec").value;
			var q1 = document.getElementById("tableauCultureList" + length + ".q1").value;

			var nbTotal = parseInt(mo) + parseInt(bl) + parseInt(be) + parseInt(bec) + parseInt(q1);

			var celluleResultatNbTotal = document.getElementById("tableauCultureList" + length + ".nbTotal");
			celluleResultatNbTotal.value = nbTotal.toString();
			celluleResultatNbTotal = document.getElementById("tableauCultureList[" + length + "].nbTotal");
			celluleResultatNbTotal.innerHTML = nbTotal.toString();

			/* Calcul % a J7*/

			var pourcenJ7 = (nbTotal / nbOvo) * 100;
			var pourcenBEJ7 = (be / nbOvo) * 100;
			var pourcenQ1J7 = (q1 / nbOvo) * 100;

			var cellulePourcenJ7 = document.getElementById("tableauCultureList" + length + ".pourJ7").innerHTML = pourcenJ7.toString();
			cellulePourcenJ7 = document.getElementById("tableauCultureList[" + length + "].pourJ7").innerHTML = pourcenJ7.toString();

			var cellulePourcenBEJ7 = document.getElementById("tableauCultureList" + length + ".pourBEJ7").innerHTML = pourcenBEJ7.toString();
			cellulePourcenBEJ7 = document.getElementById("tableauCultureList[" + length + "].pourBEJ7").innerHTML = pourcenBEJ7.toString();

			var cellulePourcenQ1J7 = document.getElementById("tableauCultureList" + length + ".pourQ1J7").innerHTML = pourcenQ1J7.toString();
			cellulePourcenQ1J7 = document.getElementById("tableauCultureList[" + length + "].pourQ1J7").innerHTML = pourcenQ1J7.toString();

			/* Calcul % J8 */

			var j8 = document.getElementById("tableauCultureList" + length + ".J8parNb").value;
			var pj8 = (j8 / nbOvo) * 100;

			var cellulePourcenJ8 = document.getElementById("tableauCultureList" + length + ".J8PourJ8").innerHTML = pj8.toString();
			cellulePourcenJ8 = document.getElementById("tableauCultureList[" + length + "].J8PourJ8").innerHTML = pj8.toString();

		}
	}

</script>

<%@ include file="../../footersimplifie.jsp" %>