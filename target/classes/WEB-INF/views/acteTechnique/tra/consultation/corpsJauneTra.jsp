<sf:form method="post" modelAttribute="corpsJaune" action="${nom}">
		<fieldset>
			<legend>&#201valuation du corps jaune</legend>

			<label for="mode_evaluation">M&#233thode d'&#233valuation :</label>
			<sf:input disabled="true" path="mode_evaluation" type="text"/>
			
			<br/>
			
			<label for="imageEcho">Image(s) &#233chographie :</label>
			<sf:checkbox path="imageEcho" value="Oui" disabled="true"/>
			
			<label for="coteCorpsJaune">C&#244t&#233 du corps jaune :</label>
			<sf:radiobutton disabled="true" path="coteCorpsJaune" value="true"/>Droit
			<sf:radiobutton disabled="true" path="coteCorpsJaune" value="false"/>Gauche
			
			<br/>

			<label for="">Qualit&#233 selon jugement opérateur</label>
			<sf:input disabled="true" path="qualite.nom"/>
			
			<br/>
		</fieldset>
	</sf:form>