<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog  modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingAdd">Renseigner ou modifier une fiche ABA</h4>
            </div>

            <div id="modal-body" class="modal-body">
                <ul class="nav nav-tabs" role="tablist" style="margin-bottom: 20px;">
                    <li class="active tab"><a href="#fiche_01" data-toggle="tab">Nouvelle fiche</a></li>
                    <li><a href="#" class="add-fiche">+ Nouvelle fiche</a></li>
                </ul>

                <div class="tab-content" style="margin-top: 20px;">
                    <div class="tab-pane active add" id="fiche_01">
                        <div class="step1 frm">
                            <form name="addPart1" class="addOrUpdatePart" method="post" action="./addOrUpdatePart1">
                                <fieldset name="identification">
                                    <legend>&Eacute;tape 1/7  -  IDENTIFICATION FICHE</legend>
                                    <div class="form-group">
                                        <input class="form-control nom" name="nom" type="text" placeholder="Nom de la fiche">
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control programmeSelect" name="programme">
                                            <option value="" selected disabled>Programme</option>
                                            <c:forEach items="${programmesList}" var="programme">
                                                <option value="${programme.id}">${programme.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-1 col-xs-1">
                                        <button type="button" class="btn btn-primary btn-md addProgramme" data-title="addProgramme" data-toggle="modal" data-target="#addProgramme" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="numAgrement" type="text" placeholder="Num&#233ro d'agr&#233ment">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="temperatureArrivee" type="text" placeholder="T&deg; Arrivee">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Date">
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control operateurSelect" id="operateur" name="operateur">
                                            <option value="" selected disabled>Op&#233rateur</option>
                                            <c:forEach items="${operateursList}" var="operateur">
                                                <option value="${operateur.id}">${operateur.nom} ${operateur.prenom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-1 col-xs-1">
                                        <button type="button" class="btn btn-primary btn-md addOperateur" data-title="addOperateur" data-toggle="modal" data-target="#addOperateur" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control required abattoir" required name="abattoir" type="text" placeholder="abattoir">
                                    </div>
                                    <button class="btn btn-primary open1" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step2 frm" style="display: none;">
                            <form name="addPart2" class="addOrUpdatePart" method="post" action="./addOrUpdatePart2">
                                <fieldset name="informationsPIV">
                                    <legend>&Eacute;tape 2/7  -  INFORMATIONS GENERALES PIV</legend>

                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control operateurSelect" id="operateurPIV" name="operateur">
                                            <option value="" selected disabled>Op&#233rateur</option>
                                            <c:forEach items="${operateursList}" var="operateur">
                                                <option value="${operateur.id}">${operateur.nom} ${operateur.prenom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div id="tableInfogenerales" class="tableInfogenerales">
                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="milieuMaturation">
                                                <option value="" selected disabled>Maturation</option>
                                                <c:forEach items="${milieuMaturationsList}" var="milieuMaturation">
                                                    <option value="${milieuMaturation.id}">${milieuMaturation.nom} ${milieuMaturation.numeroLot}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="fiv">
                                                <option value="" selected disabled>FIV</option>
                                                <c:forEach items="${fivList}" var="fiv">
                                                    <option value="${fiv.id}">${fiv.nom} ${fiv.numeroLot}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="typeCulture">
                                                <option value="" selected disabled>Type Culture</option>
                                                <c:forEach items="${typeCultureList}" var="typeCulture">
                                                    <option value="${typeCulture.id}">${typeCulture.nom} ${typeCulture.numeroLot}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addtableInfogenerales" type="button"><span class="fa fa-plus"></span></button>
                                    </div>

                                    <button class="btn btn-primary back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step3 frm" style="display: none;">
                            <form name="addPart3" class="addOrUpdatePart" method="post" action="./addOrUpdatePart3">
                                <fieldset name="collecte">
                                    <legend>&Eacute;tape 3/7  -  COLLECTE & MATURATION IN VITRO</legend>
                                    <div class="form-group">
                                        <input class="form-control datepicker"  name="date" type="text" placeholder="Date collecte">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="heureCollecte" type="text" placeholder="Heure collecte">
                                    </div>
									 <div id="tableCollecte" class="tableCollecte">
										<div class="form-group col-sm-3">
                                            <input class="form-control" name="race_Ovaires" type="text" placeholder="Race ovaires">
                                        </div>
                                         <div class="form-group">
                                             <label>N° femelle ou pool</label>
                                             <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioPool">Oui</label>
                                             <label class="radio-inline"><input type="radio" class="radio" value="non" name="optradioPool">Non</label>
                                         </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control" name="nombre_Ovaires" type="number" placeholder="Nb ovaires">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="nombre_Ovocytes" type="number" placeholder="Nb ovocytes">
                                        </div>
                                       <div class="form-group col-sm-2">
                                            <input class="form-control" name="taux_Collecte" type="number" placeholder="Taux collecte">
                                        </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control datepickerTime" name="heureDebutMaturation" type="text" placeholder="Heure d&eacute;but maturation">
                                        </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control datepickerTime" name="heureFiv" type="text" placeholder="Heure Fiv">
                                        </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control" name="groupeExperimentauxMIV" type="text" placeholder="Groupes exp&eacute;rimentaux MIV">
                                        </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control" name="nbOvocyte" type="number" placeholder="Nb d'ovocytes">
                                        </div>
                                    </div>
									<div class="form-group col-sm-1">
                                        <button class="btn btn-primary addtableCollecte" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
									
                                    <button class="btn btn-primary back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step4 frm" style="display: none;">
                            <form name="addPart4" class="addOrUpdatePart" method="post" action="./addOrUpdatePart4">
                                <fieldset name="fecondation">
                                    <legend>&Eacute;tape 4/7  -  FECONDATION IN VITRO</legend>
                                    <div class="form-group">
                                        <input class="form-control datepicker" name="dateFecondation" type="text" placeholder="Date fecondation">
                                    </div>
									<div class="form-group">
                                        <select class="form-control" id="nom" name="nom">
                                            <option value="" selected disabled>Sanitaires</option>
                                            <c:forEach items="${sanitaireList}" var="sanitaire">
                                                <option value="${sanitaire.id}">${sanitaire.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div id="tableSemence" class="tableSemence">
                                        <div class="form-group">
											<select class="form-control" id="taureau" name="taureau">
												<option value="" selected disabled>Taureau</option>
												<c:forEach items="${vachesList}" var="vache">
													<option value="${vache.id}">${vache.nom} ${vache.race}</option>
												</c:forEach>
											</select>
										</div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="numeroEjaculation" type="text" placeholder="&#8470; &eacute;jaculation">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="etatFrais" type="number" placeholder="Etat Frais avant FIV">
                                        </div>
										<div class="form-group col-sm-3">
                                            <input class="form-control" name="volume" type="number" placeholder="Volume. FIV (µl)">
                                        </div>
                                    </div>
									<div class="form-group col-sm-1">
                                        <button class="btn btn-primary addtableSemence" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
									
									<div class="form-group">
										<textarea class="form-control" name="remarque" rows="5" placeholder="Remarques"></textarea>
                                    </div>
                                    <button class="btn btn-primary back4" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open4" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step5 frm" style="display: none;">
                            <form name="addPart5" class="addOrUpdatePart" method="post" action="./addOrUpdatePart5">
                                <fieldset name="culture">
                                    <legend>&Eacute;tape 5/7  -  CULTURE IN VITRO</legend>
									<div class="form-group">
                                        <input class="form-control datepicker" name="dateCulture" type="text" placeholder="Date culture">
                                    </div>
									<div id="tableCulture" class="tableCulture">
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="groupe" type="text" placeholder="Groupe">
                                        </div>
										<div class="form-group col-sm-3">
                                            <input class="form-control" name="nbInsemine" type="number" placeholder="Nb d'ovo Insemin&eacute;s">
                                        </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control datepickerTime" name="heureCulture" type="number" placeholder="Heure de mise en culture">
                                        </div>
										<div class="form-group col-sm-3">
                                            <input class="form-control" name="nbSegmente" type="number" placeholder="Nb Segment&eacute;s">
                                        </div>
										<div class="form-group col-sm-3">
                                            <input class="form-control" name="segment" type="number" placeholder="% segment">
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <input class="form-control" name="j5JM" type="number" placeholder="j5JM">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="j6" type="number" placeholder="j6">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="JB" type="number" placeholder="JB">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="bl" type="number" placeholder="BL">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="be" type="number" placeholder="BE">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="q1" type="number" placeholder="Q1">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="nbTotal" type="number" placeholder="Nb total">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="pourJ7" type="number" placeholder="% J7">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="pourBEJ7" type="number" placeholder="% BEJ7">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="pourQ1J7" type="number" placeholder="% Q1J7">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="J8parNb" type="number" placeholder="J8parNb">
                                        </div>
										<div class="form-group col-sm-4">
                                            <input class="form-control" name="pourJ8" type="number" placeholder="%J8">
                                        </div>
										<div class="form-group col-sm-3">
                                            <input class="form-control" name="destination" type="text" placeholder="Destination(d&eacute;truits/cryo)">
                                        </div>
                                    </div>
									<div class="form-group col-sm-1">
                                        <button class="btn btn-primary addtableCulture" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
                                    <div class="form-group">
                                        <textarea class="form-control" name="remarques" rows="5" placeholder="Remarques"></textarea>
                                    </div>

                                    <button class="btn btn-primary back5" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open5" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step6 frm" style="display: none;">
                            <form name="addPart6" class="addOrUpdatePart" method="post" action="./addOrUpdatePart6">
                                <fieldset name="cryoconservation">
                                    <legend>&Eacute;tape 6/7  -  INFORMATIONS SI CRYOCONSERVATION</legend>
                                    <div class="form-group">
                                        <input class="form-control" name="ref" type="text" placeholder="R&eacute;f&eacute;rence cong&eacute;lation">
                                    </div>
									<div class="form-group col-sm-2">
                                            <input class="form-control datepickerTime" name="heureMinute[]" type="text" placeholder="Heure de cong&eacute;lation">
                                    </div>
									<div class="form-group">
                                        <select class="form-control" id="methodeCongelation" name="methodeCongelation">
                                            <option value="" selected disabled>M&eacute;thode de cong&eacute;lation</option>
                                            <c:forEach items="${methodeCongelationList}" var="methodeCongelation">
                                                <option value="${methodeCongelation.id}">${methodeCongelation.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
									<div class="form-group">
                                        <select class="form-control" id="congelateur" name="congelateur">
                                            <option value="" selected disabled>Cong&eacute;lateur utilis&eacute;</option>
                                            <c:forEach items="${congelateurList}" var="congelateur">
                                                <option value="${congelateur.id}">${congelateur.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                   <div class="form-group">
                                        <input class="form-control" name="descMethode" type="text" placeholder="Description m&eacute;thode (nom,programme,cin&eacute;tique,seeding">
                                    </div>
                                    <button class="btn btn-primary back6" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open6" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step7 frm" style="display: none;">
                            <form name="addPart7" class="addOrUpdatePart" method="post" action="./addOrUpdatePart7">
                                <fieldset name="embryons viables">
                                    <legend>&Eacute;tape 7/7  -  DETAILS EMBRYONS VIABLES</legend>
                                   <div id="tableDetails" class="tableDetails">
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="numeroEmbryon" type="text" placeholder="&#8470; embryon">
                                        </div>
                                        <div class="form-group">
											<select class="form-control" id="stade" name="stade">
												<option value="" selected disabled>Stade</option>
												<c:forEach items="${stadesList}" var="stade">
													<option value="${stade.id}">${stade.nom}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<select class="form-control" id="qualite" name="qualite">
												<option value="" selected disabled>Qualite (1 à 4)</option>
												<c:forEach items="${qualitesList}" var="qualite">
													<option value="${qualite.id}">${qualite.numero}</option>
												</c:forEach>
											</select>
										</div>
                                       <div class="form-group">
                                           <label>Cryoconserv&eacute;</label>
                                           <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioCryo">Oui</label>
                                           <label class="radio-inline"><input type="radio" class="radio" value="non" name="optradioCryo">Non</label>
                                       </div>
										<div class="form-group">
											<select class="form-control" id="cuve" name="cuve">
												<option value="" selected disabled>Cuve stockage</option>
												<c:forEach items="${cuvesList}" var="cuve">
													<option value="${cuve.id}">${cuve.nom}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<select class="form-control" id="canister" name="canister">
												<option value="" selected disabled>Canister stockage</option>
												<c:forEach items="${canistersList}" var="canister">
													<option value="${canister.id}">${canister.numero}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<select class="form-control" id="visoTube" name="visoTube">
												<option value="" selected disabled>Visotube stockage</option>
												<c:forEach items="${visoTubesList}" var="visoTube">
													<option value="${visoTube.id}">${visoTube.couleur}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-sm-2">
                                            <input class="form-control" name="jonc" type="text" placeholder="Jonc">
                                        </div>
                                       <div class="form-group">
                                           <label>Frais</label>
                                           <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioFrais">Oui</label>
                                           <label class="radio-inline"><input type="radio" class="radio" value="non" name="optradioFrais">Non</label>
                                       </div>
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="numeroReceveuse" type="text" placeholder="&#8470; receveuse">
                                        </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control" name="referenceTransfert" type="text" placeholder="R&eacute;f&eacute;rence transfert">
										</div>
                                       <div class="form-group">
                                           <label>D&eacute;truit</label>
                                           <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioDetruit">Oui</label>
                                           <label class="radio-inline"><input type="radio" class="radio" value="non" name="optradioDetruit">Non</label>
                                       </div>
										<div class="form-group col-sm-2">
                                            <input class="form-control" name="remarque" type="text" placeholder="Remarques">
                                        </div>
                                    </div>
									<div class="form-group col-sm-1">
                                        <button class="btn btn-primary addtableDetails" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
									<button class="btn btn-primary back7" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button type="submit" class="btn btn-success validButton"><span class="fa fa-check"></span> Enregistrer</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- Modal add programme -->
<div class="modal fade" id="addProgramme" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingProgramme">Ajouter un nouveau programme</h4>
            </div>

            <form id="addProgrammeForm" action="../../programme/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomProgramme" required type="text" placeholder="Nom du programme">
                    </div>
                </div>

                <div class="modal-footer ">
                    <button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Ajouter</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- Modal add operateur -->
<div class="modal fade" id="addOperateur" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingOperateur">Ajouter un nouvel op&#233rateur</h4>
            </div>

            <form id="addOperateurForm" action="../../operateur/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomOperateur" required type="text" placeholder="Nom de l'op&#233rateur">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="prenomOperateur" required type="text" placeholder="Pr&#233nom de l'op&#233rateur">
                    </div>
                </div>

                <div class="modal-footer ">
                    <button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Ajouter</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%--<!------------------------------ Script Calendrier--------------------------->--%>
<script type="text/javascript" src="/static/js/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript" src="/static/js/bower_components/moment/locale/fr.js"></script>
<script type="text/javascript" src="/static/js/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="/static/js/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />

<script>
    /****** function init calendrier avec heure ******/
    function createDateTimePicker() {
        $('.datepickerTime').datetimepicker({
            sideBySide: true,
            locale: 'fr',
            toolbarPlacement: 'top',
            showClose: true
        });
    }

    /****** function init calendrier sans heure ******/
    function createDatePicker() {
        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement: 'top',
            showClose: true
        });
    }

    /****** function reinit fiche ******/
    function reinitForm(form){
        form.find('.tableInfogenerales').not(':first').remove(); //garde juste une ligne dans le tableau 
        form.find('.tableCollecte').not(':first').remove();
		form.find('.tableSemence').not(':first').remove();
		form.find('.tableCulture').not(':first').remove();
		form.find('.tableDetails').not(':first').remove();

        // reinit formulaire
        form.find('input').not(':radio').val("");
        form.find('textarea').val('');
        form.find('.radio').prop('checked', false);
        form.find("select").val("");


        form.find('input[name="numAgrement"]').val("FR TB/PB 370");
        form.find('input[name="lieu"]').val("Allice Nouzilly");
    }

    /****** function nouvel onglet ******/
    function newTab(){
        var id = $(".nav-tabs").children().length; //init id = num de fiche +1

        while($('#fiche_'+id).length){ //tant qu'une fiche ayant le même id
            id += 1;
        }

        var tabId = 'fiche_' + id;

        $('li.tab').last().after('<li class="tab"><a href="#fiche_' + id + '">Nouvelle fiche</a><span> x </span></li>');

        $clone = $('#fiche_01').clone().removeAttr('id'); //clone et remove l'id

        reinitForm($clone); //reinitialise le clone

        // ajoute les divs a l'arbre html
        $clone.attr('id', tabId);

        changeNom($clone); //change le nom de l'onglet


        $('.tab-content').append($clone);
        $('.nav-tabs li').find('a[href="#'+tabId+'"]').click();

        $clone.find(".frm").hide("fast");
        $clone.find(".step1").show("slow");

        createDateTimePicker();
        createDatePicker();
    }

    createDateTimePicker(); //init les calendriers avec heure
    createDatePicker(); //init les calendriers sans heure

    /****** Change le nom de l'onglet ******/
    $(document).on( 'keyup', ".nom", function(){
        $("li.active.tab").children('a').text($(this).closest(".nom").val());
    });

    /****** Check champs required ******/
    function checkRequired(form){
        var required = true;

        form.find('.required').each(function(){
            if($(this).val() === '' ){
                required = false;
            }
        });

        return required;
    }

    /****** Navigation d'étape ******/
    $(document).on( 'click', ".open1", function(event){
        if(checkRequired($(this).closest('form'))) {
            $(event.target).closest('div.tab-pane.active').find('.step1').hide("fast");
            $(event.target).closest('div.tab-pane.active').find('.step2').show("slow");
        }
    });

    $(document).on( 'click', ".open2", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step2').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step3').show("slow");
    });

    $(document).on( 'click', ".back2", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step2').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step1').show("slow");
    });

    $(document).on( 'click', ".open3", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step3').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step4').show("slow");
    });

    $(document).on( 'click', ".back3", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step3').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step2').show("slow");
    });

    $(document).on( 'click', ".open4", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step4').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step5').show("slow");
    });

    $(document).on( 'click', ".back4", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step4').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step3').show("slow");
    });

    $(document).on( 'click', ".open5", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step5').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step6').show("slow");
    });

    $(document).on( 'click', ".back5", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step5').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step4').show("slow");
    });

    $(document).on( 'click', ".back6", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step6').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step5').show("slow");
    });


    /****** Système d'onglet ******/
    $(".nav-tabs").on("click", "a", function (e) { //met au premier plan un contenu d'onglet
        e.preventDefault();
        if (!$(this).hasClass('add-fiche')) { //si c'est l'onglet d'ajout d'onglet
            $(this).tab('show');
        }
    })
        .on("click", "span", function () { //close un onglet
            var anchor = $(this).siblings('a');
            $(anchor.attr('href')).remove();
            $(this).parent().remove();
            $(".nav-tabs li").children('a').first().click();
        });

    /****** evenement creer un onglet ******/
    $(document).on('click', '.add-fiche', function (e) {
        e.preventDefault();
        newTab();
    });

    /******* Ajoute une ligne tableau informations génerales ******/
    $(document).on( 'click', ".addtableInfogenerales", function(){
        $template = $('#tableInfogenerales');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableInfogenerales" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tableInfogenerales").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau collecte ******/
    $(document).on( 'click', ".addtableCollecte", function(){
        $template = $('#tableCollecte'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableCollecte" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tableCollecte").last()); //insert après le dernier object de classe
        createDatePicker();
    });

    /******* Ajoute une ligne tableau semence ******/
    $(document).on( 'click', ".addtableSemence", function(){
        $template = $('#tableSemence'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableSemence" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tableSemence").last()); //insert après le dernier object de classe
        createDatePicker();
    });

    /******* Ajoute une ligne tableau culture ******/
    $(document).on( 'click', ".addtableCulture", function(){
        $template = $('#tableCulture'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableCulture" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tableCulture").last()); //insert après le dernier object de classe
        createDatePicker();
    });

    /******* Ajoute une ligne tableau details ******/
    $(document).on( 'click', ".addtableDetails", function(){
        $template = $('#tableDetails'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableDetails" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tableDetails").last()); //insert après le dernier object de classe
        createDatePicker();
    });

    /******* Supprime une ligne modal informations génerales  ******/
    $(document).on( 'click', ".deltableInfogenerales", function(){
        $(this).closest('.tableInfogenerales').remove();
    });

    /******* Supprime une ligne modal collecte ******/
    $(document).on( 'click', ".deltableCollecte", function(){
        $(this).closest('.tableCollecte').remove();
    });

    /******* Supprime une ligne modal semence ******/
    $(document).on( 'click', ".deltableSemence", function(){
        $(this).closest('.tableSemence').remove();
    });

    /******* Supprime une ligne modal details ******/
    $(document).on( 'click', ".deltableDetails", function(){
        $(this).closest('.tableDetails').remove();
    });

    /************************ AJOUT *************************/
    $(document).on( 'submit', ".addOrUpdatePart", function(e){
        e.preventDefault();

        var $this = $(this);
        var data = $this.serialize();

        $.ajax({
            url: $this.attr('action'),
            type: $this.attr('method'),
            data: data,
            success: function (result) {
                if (result.succes != true) {
                    $('#modal-body').before('<div class="alert alert-danger flash" role="alert">' + result.message + '</div>'); //afficher alert
                    //empêche le passage à une autre étape si erreur
                    if($this.closest('div.frm').hasClass('step1')) {
                        $this.closest('div.tab-pane.active').find('.step2').hide("fast");
                        $this.closest('div.tab-pane.active').find('.step1').show("slow");
                    }
                    if($this.closest('div.frm').hasClass('step2')) {
                        $this.closest('div.tab-pane.active').find('.step3').hide("fast");
                        $this.closest('div.tab-pane.active').find('.step2').show("slow");
                    }
                    if($this.closest('div.frm').hasClass('step3')) {
                        $this.closest('div.tab-pane.active').find('.step4').hide("fast");
                        $this.closest('div.tab-pane.active').find('.step3').show("slow");
                    }
                    if($this.closest('div.frm').hasClass('step4')) {
                        $this.closest('div.tab-pane.active').find('.step5').hide("fast");
                        $this.closest('div.tab-pane.active').find('.step4').show("slow");
                    }
                    if($this.closest('div.frm').hasClass('step5')) {
                        $this.closest('div.tab-pane.active').find('.step6').hide("fast");
                        $this.closest('div.tab-pane.active').find('.step5').show("slow");
                    }
                    if($this.closest('div.frm').hasClass('step6')) {
                        $this.closest('div.tab-pane.active').find('.step7').hide("fast");
                        $this.closest('div.tab-pane.active').find('.step6').show("slow");
                    }
                }else{
                    var table = $('#tableABA').DataTable(); //init pour changer value .cell.data
                    var rowId = $('#tableABA').dataTable().fnFindCellRowIndexes(result.objet.nom, 0); // cherche fiche modifiée

                    if($this.closest('div.frm').hasClass('step1')) { //si étape 1
                        //si c'est un nouvel ajout -> ajoute row a datatable
                        if(!$this.hasClass('EditForm')){
                            addRow(result);
                        }
                        //change les actions des forms pour éditer les fiches
                        $this.closest('div.tab-pane.active').find('form').each(function() {
                            if(!$(this).hasClass('EditForm')) {
                                $(this).attr('action', $(this).attr('action') + "/" + result.objet.id);
                                $(this).addClass('EditForm');
                            }
                        });

                        if(rowId.length == 1) { //si le nom de la fiche est présent
                            /** Modifie la ligne correspondant à la fiche modifiée **/
                            if (result.objet.programme != null) {
                                table.cell(rowId, 1).data(result.objet.programme.nom).draw(false);
                            }
                            if (result.objet.dateHeureMinute != null) {
                                table.cell(rowId, 2).data(convertDateWithTime(result.objet.dateHeureMinute)).draw(false);
                            }
                            table.cell(rowId, 3).data(result.objet.numeroAgrement).draw(false);
                            table.cell(rowId, 4).data(result.objet.abattoir.nom).draw(false);
                            table.cell(rowId, 5).data(result.objet.abattoir.nom).draw(false);
                            table.cell(rowId, 5).data(result.objet.temperatureArrivee).draw(false);
                        }
                    }

                    if($this.closest('div.frm').hasClass('step7')) { //si étape 7
                        /** clear modal **/
                        reinitForm($this.closest('.tab-pane'));

                        $("li.active.tab").children('a').text(" Nouvelle fiche");

                        $this.closest('div.tab-pane.active').find(".step7").hide("fast");
                        $this.closest('div.tab-pane.active').find(".step1").show("slow");
                    }

                    if(rowId.length == 1) { //si le nom de la fiche est présent
                        //Modifie le statut
                        table.cell(rowId, 7).data(result.objet.statut).draw(false);
                    }
                    $('#modal-body').before('<div class="alert alert-success flash" role="alert">' + result.message + '</div>'); //afficher alert
                }
                autoclose();
            },
            error: function (xhr, status, error) {
                $('#modal-body').before('<div class="alert alert-danger flash" role="alert">Une erreur s\'est produite</div>');
                autoclose();
                //empêche le passage à une autre étape si erreur
                if($this.closest('div.frm').hasClass('step1')) {
                    $this.closest('div.tab-pane.active').find('.step2').hide("fast");
                    $this.closest('div.tab-pane.active').find('.step1').show("slow");
                }
                if($this.closest('div.frm').hasClass('step2')) {
                    $this.closest('div.tab-pane.active').find('.step3').hide("fast");
                    $this.closest('div.tab-pane.active').find('.step2').show("slow");
                }
                if($this.closest('div.frm').hasClass('step3')) {
                    $this.closest('div.tab-pane.active').find('.step4').hide("fast");
                    $this.closest('div.tab-pane.active').find('.step3').show("slow");
                }
                if($this.closest('div.frm').hasClass('step4')) {
                    $this.closest('div.tab-pane.active').find('.step5').hide("fast");
                    $this.closest('div.tab-pane.active').find('.step4').show("slow");
                }
                if($this.closest('div.frm').hasClass('step5')) {
                    $this.closest('div.tab-pane.active').find('.step6').hide("fast");
                    $this.closest('div.tab-pane.active').find('.step5').show("slow");
                }
                if($this.closest('div.frm').hasClass('step6')) {
                    $this.closest('div.tab-pane.active').find('.step7').hide("fast");
                    $this.closest('div.tab-pane.active').find('.step6').show("slow");
                }
            }
        });
    });


    /******* Ajoute un nouveau programme ******/
    $('#addProgrammeForm').on('submit', function(e) {
        e.preventDefault();

        var $this = $(this);

        $.ajax({
            url: $this.attr('action'),
            type: $this.attr('method'),
            data: $this.serialize(),
            success: function(result) {
                if(result.succes == true){
                    $('input').val(''); //clear modal
                    $('#addProgramme').modal('toggle'); //ferme modal

                    $('.programmeSelect').append($('<option>', {
                        value: result.objet.id,
                        text: result.objet.nom
                    }));

                    $(".tab-pane.active").find('.programmeSelect').val(result.objet.id);
                }
            }
        });
    });

    /******* Ajoute un nouvel opérateur ******/
    $('#addOperateurForm').on('submit', function(e) {
        e.preventDefault();

        var $this = $(this);

        $.ajax({
            url: $this.attr('action'),
            type: $this.attr('method'),
            data: $this.serialize(),
            success: function(result) {
                if(result.succes == true){
                    $('input').val(''); //clear modal
                    $('#addOperateur').modal('toggle'); //ferme modal

                    $('.operateurSelect').append($('<option>', {
                        value: result.objet.id,
                        text: result.objet.nom+" "+result.objet.prenom
                    }));

                    $(".tab-pane.active").find('.operateurSelect').val(result.objet.id);
                }
            }
        });
    });

    /************************ MODIF *************************/
    $(document).on( 'click', ".btnEdit", function() {
        if($('#fiche_01').find("input[name='nom']").val() ==''){
            changeNom($('#fiche_01'));
        }

        id = $(this).attr('data-id');

        $.ajax({
            url: "./get/" + id,
            method: 'GET',
            success: function (result) {
                if (result.succes == true) {
                    newTab();
                    $activeTab = $('div.tab-pane.active');

                    $activeTab.removeClass('add'); //identifie la tab comme un tab d'édition

                    $activeTab.find('form[name="addPart1"]').attr('action', $activeTab.find('form[name="addPart1"]').attr('action') + "/" + id); //attribue l'id au modal
                    $activeTab.find('form[name="addPart1"]').addClass('EditForm');

                    //change le nom de l'onglet
                    $("li.active.tab").children('a').text(result.objet.nom);

                    /*************************** REMPLI MODAL ***************************/

                    /************* STEP 1 *************/
                    $activeTab.find("input[name='nom']").val(result.objet.nom);
                    if (result.objet.programme != null) {
                        $activeTab.find("select[name='programme']").val(result.objet.programme.id);
                    }
                    if (result.objet.dateHeureMinute != null) {
                        $activeTab.find("input[name='dateHeureMinute']").data("DateTimePicker").date(new Date(result.objet.dateHeureMinute));
                    }
                    $activeTab.find("input[name='numAgrement']").val(result.objet.numeroAgrement);
                    $activeTab.find("input[name='temperatureArrivee']").val(result.objet.temperatureArrivee);
                    if (result.objet.operateur != null) {
                        $activeTab.find("select[name='operateur']").val(result.objet.operateur.id);
                    }
                    $activeTab.find("select[name='abattoir']").val(result.objet.abattoir.nom);

                    /************* STEP 2 *************/
                    if (result.objet.informations_piv != null) {

                        //remplit tableau

                        $target = $activeTab.find('#tableInfogenerales').clone().removeAttr('id');
                        $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableInfogenerales" type="button"><span class="fa fa-minus"></span></button></div>');
                        $target.insertAfter($activeTab.find("div.tableInfogenerales").last());


                        $target.find("input[name='milieuMaturation']").val(result.objet.informations_piv.milieuMaturation.id);
                        $target.find("input[name='fiv']").val(result.objet.informations_piv.fiv.id);
                        $target.find("input[name='typeCulture']").val(result.objet.result.objet.informations_piv.typeCulture.id);
                    }

                    /************* STEP 3 *************/
                    if (result.objet.collecte != null) {

                        $target.find("input[name='date']").datetimepicker({
                            locale: 'fr',
                            format: 'DD/MM/YYYY',
                            toolbarPlacement: 'top',
                            showClose: true
                        });

                        if (result.objet.collecte.date != null) {
                            $activeTab.find("input[name='date']").data("DateTimePicker").date(new Date(result.objet.collecte.date));
                        }
                        if (result.objet.collecte.heureCollecte != null) {
                            $activeTab.find("input[name='heureCollecte']").data("datepickerTime").date(new Date(result.objet.collecte.heureCollecte));
                        }

                        for (iLigne = 0; iLigne < result.objet.collecte.tableauCollecteList.length; iLigne++) {
                            if (iLigne == 0) {
                                $target = $activeTab.find('.tableCollecte');
                            } else {
                                $target = $activeTab.find('#tableCollecte').clone().removeAttr('id');
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableCollecte" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($activeTab.find("div.tableCollecte").last());
                            }

                            $target.find("input[name='race_Ovaires']").val(result.objet.collecte.tableauGestationList[iLigne].race_Ovaires);
                            if (result.objet.collecte.tableauGestationList[iLigne].pool == true) {
                                $target.find("input[name='optradioPool'][value='oui']").prop('checked', true);
                            }
                            if (result.objet.collecte.tableauGestationList[iLigne].pool == false) {
                                $target.find("input[name='optradioPool'][value='non']").prop('checked', true);
                            }
                            $target.find("input[name='nombre_Ovaires']").val(result.objet.collecte.tableauGestationList[iLigne].nombre_Ovaires);
                            $target.find("input[name='nombre_Ovocytes']").val(result.objet.collecte.tableauGestationList[iLigne].nombre_Ovocytes);
                            $target.find("input[name='taux_Collecte']").val(result.objet.collecte.tableauGestationList[iLigne].taux_Collecte);
                            if (result.objet.collecte.tableauCollecteList[iLigne].heureDebutMaturation != null) {
                                $target.find("input[name='heureDebutMaturation']").data("datepickerTime").date(new Date(result.objet.collecte.tableauCollecteList[iLigne].heureDebutMaturation));
                            }
                            if (result.objet.collecte.tableauCollecteList[iLigne].heureFiv != null) {
                                $target.find("input[name='heureFiv']").data("datepickerTime").date(new Date(result.objet.collecte.tableauCollecteList[iLigne].heureFiv));
                            }
                            $target.find("input[name='groupeExperimentauxMIV']").val(result.objet.collecte.tableauGestationList[iLigne].groupeExperimentauxMIV);
                            $target.find("input[name='nbOvocyte']").val(result.objet.collecte.tableauGestationList[iLigne].nbOvocyte);
                        }

                    }

                    /************* STEP 4 *************/
                    if (result.objet.fecondation != null) {
                        if (result.objet.fecondation.date != null) {
                            $activeTab.find("input[name='dateFecondation']").data("datepicker").date(new Date(result.objet.fecondation.date));
                        }
                        if (result.objet.fecondation.sanitaireList[0].nom != null) {
                            $activeTab.find("select[name='nom']").val(result.objet.fecondation.sanitaireList[0].nom);
                        }
                        for (iLigne = 0; iLigne < result.objet.fecondation.tableau_semences.length; iLigne++) {
                            if (iLigne == 0) {
                                $target = $activeTab.find('.tableSemence');
                            } else {
                                $target = $activeTab.find('#tableSemence').clone().removeAttr('id');
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableSemence" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($activeTab.find("div.tableSemence").last());
                            }

                            if (result.objet.fecondation.tableau_semences[iLigne].taureau != null) {
                                $target.find("select[name='taureau']").val(result.objet.fecondation.tableau_semences[iLigne].taureau.id);
                            }
                            $target.find("input[name='numeroEjaculation']").val(result.objet.fecondation.tableau_semences[iLigne].numeroEjaculation);
                            $target.find("input[name='etatFrais']").val(result.objet.fecondation.tableau_semences[iLigne].etatFrais);
                            $target.find("input[name='volume']").val(result.objet.fecondation.tableau_semences[iLigne].volume);
                        }
                    }

                    /************* STEP 5 *************/
                    if (result.objet.culture != null) {
                        if (result.objet.culture.date != null) {
                            $activeTab.find("input[name='dateCulture']").data("datepicker").date(new Date(result.objet.culture.date));
                        }
                        for (iLigne = 0; iLigne < result.objet.culture.tableauCultureList.length; iLigne++) {
                            if (iLigne == 0) {
                                $target = $activeTab.find('.tableCulture');
                            } else {
                                $target = $activeTab.find('#tableCulture').clone().removeAttr('id');
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger deltableCulture" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($activeTab.find("div.tableCulture").last());
                            }
                            $target.find("input[name='groupe']").val(result.objet.culture.tableauCultureList[iLigne].groupe);
                            $target.find("input[name='nbInsemine']").val(result.objet.culture.tableauCultureList[iLigne].nbInsemine);
                            $target.find("input[name='heureCulture']").data("datepickerTime").date(new Date(result.objet.culture.tableauCultureList[iLigne].heureCulture));
                            $target.find("input[name='nbSegmente']").val(result.objet.culture.tableauCultureList[iLigne].nbSegmente);
                            $target.find("input[name='segment']").val(result.objet.culture.tableauCultureList[iLigne].j5JM);
                            $target.find("input[name='j5JM']").val(result.objet.culture.tableauCultureList[iLigne].j6);
                            $target.find("input[name='j6']").val(result.objet.culture.tableauCultureList[iLigne].JB);
                            $target.find("input[name='JB']").val(result.objet.culture.tableauCultureList[iLigne].mo);
                            $target.find("input[name='bl']").val(result.objet.culture.tableauCultureList[iLigne].bl);
                            $target.find("input[name='be']").val(result.objet.culture.tableauCultureList[iLigne].be);
                            $target.find("input[name='q1']").val(result.objet.culture.tableauCultureList[iLigne].q1);
                            $target.find("input[name='nbTotal']").val(result.objet.culture.tableauCultureList[iLigne].nbTotal);
                            $target.find("input[name='pourJ7']").val(result.objet.culture.tableauCultureList[iLigne].pourJ7);
                            $target.find("input[name='pourBEJ7']").val(result.objet.culture.tableauCultureList[iLigne].pourBEJ7);
                            $target.find("input[name='pourQ1J7']").val(result.objet.culture.tableauCultureList[iLigne].pourQ1J7);
                            $target.find("input[name='J8parNb']").val(result.objet.culture.tableauCultureList[iLigne].J8parNb);
                            $target.find("input[name='pourJ8']").val(result.objet.culture.tableauCultureList[iLigne].pourJ8);
                            $target.find("input[name='destination']").val(result.objet.culture.tableauCultureList[iLigne].destination);
                        }
                        $activeTab.find("input[name='remarques']").val(result.objet.culture.remarques);
                    }

                    /************* STEP 6 *************/
                    if (result.objet.cryoconservation != null) {
                        $activeTab.find("input[name='ref']").val(result.objet.cryoconservation.ref);
                        $activeTab.find("input[name='heureMinute']").data("datepickerTime").date(new Date(result.objet.culture.heureMinute));
                        $activeTab.find("input[name='methodeCongelation']").val(result.objet.cryoconservation.methodeCongelation.id);
                        $activeTab.find("input[name='congelateur']").val(result.objet.cryoconservation.congelateur.id);
                        $activeTab.find("input[name='descMethode']").val(result.objet.cryoconservation.descMethode);
                    }

                    /************* STEP 7 *************/
                    for (iLigne = 0; iLigne < result.objet.tableauDetails.length; iLigne++) {
                        if (iLigne == 0) {
                            $target = $activeTab.find('.tableDetails');
                        } else {
                            $target = $activeTab.find('.tableDetails').clone().removeAttr('id');
                            $target.insertAfter($activeTab.find("div.tableDetails").last());
                        }

                        $target.find("select[name='numeroEmbryon']").val(result.objet.tableauDetails[iLigne].numeroEmbryon);
                        $target.find("select[name='stade']").val(result.objet.tableauDetails[iLigne].stade.id);
                        $target.find("select[name='qualite']").val(result.objet.tableauDetails[iLigne].qualite.id);
                        if (result.objet.tableauDetails[iLigne].cryoconserve == true) {
                            $target.find("input[name='optradioCryo'][value='oui']").prop('checked', true);
                        }
                        if (result.objet.tableauDetails[iLigne].cryoconserve == false) {
                            $target.find("input[name='optradioCryo'][value='non']").prop('checked', true);
                        }
                        $target.find("select[name='cuve']").val(result.objet.tableauDetails[iLigne].cuve.id);
                        $target.find("select[name='canister']").val(result.objet.tableauDetails[iLigne].canister.id);
                        $target.find("select[name='visoTube']").val(result.objet.tableauDetails[iLigne].visoTube.id);
                        $target.find("select[name='jonc']").val(result.objet.tableauDetails[iLigne].jonc);
                        if (result.objet.tableauDetails[iLigne].frais == true) {
                            $target.find("input[name='optradioFrais'][value='oui']").prop('checked', true);
                        }
                        if (result.objet.tableauDetails[iLigne].frais == false) {
                            $target.find("input[name='optradioFrais'][value='non']").prop('checked', true);
                        }
                        $target.find("select[name='numeroReceveuse']").val(result.objet.tableauDetails[iLigne].numeroReceveuse);
                        $target.find("select[name='referenceTransfert']").val(result.objet.tableauDetails[iLigne].referenceTransfert);
                        if (result.objet.tableauDetails[iLigne].detruit == true) {
                            $target.find("input[name='optradioDetruit'][value='oui']").prop('checked', true);
                        }
                        if (result.objet.tableauDetails[iLigne].pool == false) {
                            $target.find("input[name='optradioDetruit'][value='non']").prop('checked', true);
                        }
                        $target.find("select[name='remarque']").val(result.objet.tableauDetails[iLigne].remarque);
                    }
                } else {
                    $('#add').modal('toggle'); //ferme modal
                    $('#tableActes').before('<div class="alert alert-warning flash" role="alert">' + result.message + '</div>'); //afficher alert
                    autoclose();
                }
            }
        });
    });

</script>