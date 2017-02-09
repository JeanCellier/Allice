<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche TRA : ${nom} </h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="vache" action="${nom}">
		<fieldset>
			<legend>Identification receveuse</legend>

			<!-- Attribut proprietaire -->
			<label for="proprietaire">Propri&#233taire :</label>
			<sf:errors path="proprietaire"/>
			<sf:input path="proprietaire"/>

			</br>

			<label for="num_elevage">Numero &#233levage:</label>
			<sf:errors path="num_elevage"/>
			<sf:input path="num_elevage" type="text"/>

			</br>

			<label for="num_identification">Num&#233ro Identification :</label>
			<sf:errors path="num_identification"/>
			<sf:input path="num_identification" type="number"/>


			<label for="num_travail">Num&#233ro travail :</label>
			<sf:errors path="num_travail"/>
			<sf:input path="num_travail" type="number"/>
			<!--Rajouter ajout nouvel abattoir  -->

			<label for="race">Race :</label>
			<sf:errors path="race"/>
			<sf:input path="race" type="number"/>

			</br>

			<label for="parite">Parit&#233 :</label>
			<sf:input path="parite"/>

			<br/><br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>

</div>

<%@ include file="../../footersimplifie.jsp" %>