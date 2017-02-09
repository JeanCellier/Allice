<%@ include file="../../headersimplifie.jsp" %>

<h1>Fiche TRA : ${nom} </h1>

<div id="partieCentrale">
	<sf:form method="post" modelAttribute="corpsJaune" action="${nom}">
		<fieldset>
			<legend>&#201valuation du corps jaune</legend>

			<label for="mode_evaluation">M&#233thode d'&#233valuation :</label>
			<sf:errors path="mode_evaluation"/>
			<sf:input path="mode_evaluation" type="text"/>

			<br/>

			<label for="imageEcho">Image(s) &#233chographie :</label>
			<sf:errors path="imageEcho"/>
			<sf:checkbox path="imageEcho" value="Oui"/>

			<label for="coteCorpsJaune">C&#244t&#233 du corps jaune :</label>
			<sf:errors path="coteCorpsJaune"/>
			<sf:radiobutton path="coteCorpsJaune" value="true"/>Droit
			<sf:radiobutton path="coteCorpsJaune" value="false"/>Gauche

			<br/>

			<label for="">Qualit&#233 selon jugement op&eacute;rateur</label>
			<sf:select path="qualite">
				<c:forEach items="${qualiteList}" var="qualite">
					<option value="${qualite.id}" label="${qualite.nom} ${qualite.numero}"></option>
				</c:forEach>
			</sf:select>

			<br/>
			<input type="submit" value="Valider" class="valider"/> <br/>
		</fieldset>
	</sf:form>
</div>

<%@ include file="../../footersimplifie.jsp" %>