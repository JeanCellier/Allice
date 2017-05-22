<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog  modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingAdd">Renseigner ou modifier une fiche Opu</h4>
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
                                    <legend>&Eacute;tape 1/5  -  IDENTIFICATION FICHE</legend>
                                    <div class="form-group">
                                        <input class="form-control nom required" required name="nom" type="text" placeholder="Nom de la fiche">
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control programmeSelect" name="programme">
                                            <option value="" selected disabled>Programme</option>
                                            <c:forEach items="${programmeList}" var="programme">
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
                                        <input class="form-control" name="numAgrement" type="text" value="FR TB/PB 370" placeholder="Num&#233ro d'agr&#233ment">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="lieu" type="text" value="Allice Nouzilly" placeholder="Lieu">
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control typeOpuSelect" id="typeOpu" name="typeOpu">
                                            <option value="" selected disabled>Type OPU</option>
                                            <c:forEach items="${typeOpuList}" var="typeOpu">
                                                <option value="${typeOpu.id}">${typeOpu.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-1 col-xs-1">
                                        <button type="button" class="btn btn-primary btn-md addTypeOpu" data-title="addTypeOpu" data-toggle="modal" data-target="#addTypeOpu" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Date">
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control operateurSelect" id="operateur" name="operateur">
                                            <option value="">Op&#233rateur</option>
                                            <c:forEach items="${operateurList}" var="operateur">
                                                <option value="${operateur.id}" ${(operateur.nom == 'Desnoes') && (operateur.prenom=='Olivier') ? 'selected' : ''}>${operateur.nom} ${operateur.prenom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-1 col-xs-1">
                                        <button type="button" class="btn btn-primary btn-md addOperateur" data-title="addOperateur" data-toggle="modal" data-target="#addOperateur" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control required vache" required name="vache" type="text" placeholder="vache">
                                    </div>
                                    <button class="btn btn-primary open1" type="submit">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step2 frm" style="display: none;">
                            <form name="addPart2" class="addOrUpdatePart" method="post" action="./addOrUpdatePart2">
                                <fieldset name="traitementActe">
                                    <legend>&Eacute;tape 2/5  -  TRAITEMENT DONNEUSE</legend>

                                    <div class="form-group">
                                        <input class="form-control datepicker"  name="dateChaleur" type="text" placeholder="Date chaleur de r&#233f&#233rence">
                                    </div>
                                    <div class="form-group">
                                        <label>Type chaleur de r&#233f&#233rence: </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="naturelle" name="typeChaleur">Naturelle</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="induite" name="typeChaleur">Induite</label>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="traitementActe">
                                            <option value="" selected>Traitement type - Aucun</option>
                                            <c:forEach items="${traitementsList}" var="traitement_acte">
                                                <option value="${traitement_acte.id}">${traitement_acte.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div id="tabTraitement" class="tabTraitement">
                                        <div class="form-group col-sm-3" style="padding-left:0">
                                            <input class="form-control datepicker" name="dateTraitement[]" type="text" placeholder="Date">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="produit[]">
                                                <option value="" selected disabled>Produit</option>
                                                <c:forEach items="${produitsList}" var="produit">
                                                    <option value="${produit.id}">${produit.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="quantite[]" step="0.01" type="number" placeholder="Quantite">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="modeTraitement[]">
                                                <option value="" selected disabled>Mode de traitementActe</option>
                                                <option value="IM">IM</option>
                                                <option value="IV">IV</option>
                                                <option value="IVA">IVA</option>
                                                <option value="SC">SC</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabTraitement" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
                                    <div>
                                        <label>Ponction du ou des follicules dominants (> 8 mm): </label><br>
                                        <div class="form-group col-sm-4">
                                            <input class="form-control nb_follicules required" required name="nb_follicules" type="number" placeholder="Nb de follicules aspir&#233s">
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <input class="form-control droites" name="droites" type="number" placeholder="droites">
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <input class="form-control gauches" name="gauches" type="number" placeholder="gauches">
                                        </div>
                                        <div class="form-group">
                                            <label>Image(s) &#233chographe: </label>
                                            <label class="radio-inline"><input type="radio" class="radio" value="1" name="ImageEcho">Oui</label>
                                            <label class="radio-inline"><input type="radio" class="radio" value="0" name="ImageEcho">Non</label>
                                        </div>
                                        <div class="form-group">
                                            <label>Traitement superovulation: </label>
                                            <label class="radio-inline"><input type="radio" class="radio" value="1" name="TSuper">Oui</label>
                                            <label class="radio-inline"><input type="radio" class="radio" value="0" name="TSuper">Non</label>
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <input class="form-control typeFSH" name="typsFSH" type="text" placeholder="Type FSH">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <input class="form-control pour_dose" name="pour_dose" type="number" placeholder="% de la dose totale FSH">
                                        </div>
                                        <div id="tabTraitementOpu" class="tabTraitementOpu">

                                            <div class="form-group col-sm-3" style="padding-left:0">
                                                <input class="form-control datepicker" name="dateTraitement[]" type="text" placeholder="Date">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <input class="form-control matin" name="matin" type="text" placeholder="Matin(7h30)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <input class="form-control matin" name="matin" type="text" placeholder="Apr&#233s-midi (19h30)">
                                            </div>
                                        </div>
                                        <div class="form-group col-sm-1">
                                            <button class="btn btn-primary addTabTraitementOpu" type="button"><span class="fa fa-plus"></span></button>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Image(s) &#233chographe(droite):</label><br>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control droite_denombre_8" name="droite_denombre_8" type="number" placeholder="D&#233nombr&#233(<8mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control droite_aspire_8" name="droite_aspire_8" type="number" placeholder="aspir&#233(<8mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control droite_denombre_15" name="droite_denombre_15" type="number" placeholder="D&#233nombr&#233(8-15mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control droite_aspire_15" name="droite_aspire_15" type="number" placeholder="aspir&#233(8-15mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control droite_denombre_15plus" name="droite_denombre_15plus" type="number" placeholder="D&#233nombr&#233(>15mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control droite_aspire_15plus" name="droite_aspire_15plus" type="number" placeholder="aspir&#233(>15mm)">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Image(s) &#233chographe(gauche):</label><br>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control gauche_denombre_8" name="gauche_denombre_8" type="number" placeholder="D&#233nombr&#233(<8mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control gauche_aspire_8" name="gauche_aspire_8" type="number" placeholder="aspir&#233(<8mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control gauche_denombre_15" name="gauche_denombre_15" type="number" placeholder="D&#233nombr&#233(8-15mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control gauche_aspire_15" name="gauche_aspire_15" type="number" placeholder="aspir&#233(8-15mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control gauche_denombre_15plus" name="gauche_denombre_15plus" type="number" placeholder="D&#233nombr&#233(>15mm)">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control gauche_aspire_15plus" name="gauche_aspire_15plus" type="number" placeholder="aspir&#233(>15mm)">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-group col-sm-6">
                                            <input class="form-control nb_coc" name="nb_coc" type="number" placeholder="Nb de COCs retrouv&#233s">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <input class="form-control taux_collecte" name="taux_collecte" type="number" placeholder="Taux de collecte %">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control remarque_echo" name="remarque_echo" type="text" placeholder="Remarques">
                                        </div>
                                    </div>

                                    <button class="btn btn-primary back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step3 frm" style="display: none;">
                            <form name="addPart3" class="addOrUpdatePart" method="post" action="./addOrUpdatePart3">
                                <fieldset name="ovocytes">
                                    <legend>&Eacute;tape 3/5  -  OVOCYTES-CUMULUS (COCs) COLLECTES</legend>
                                    <div class="form-group">
                                        <div id="tabOvocytes" class="tabOvocytes">
                                            <div class="form-group col-sm-2">
                                                <input class="form-control nb_de_cocs" name="nb_de_cocs" type="number" placeholder="Nb de COCs">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <select class="form-control" name="matureOvocytes[]">
                                                    <option value="" selected disabled>Mature(M)/Immature(I)</option>
                                                    <option value="mature_item">M</option>
                                                    <option value="immature_item">I</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <select class="form-control" name="qualiteOvocytes[]">
                                                    <option value="" selected disabled>Qualit&#233</option>
                                                    <option value="qualite_1">1</option>
                                                    <option value="qualite_2">2</option>
                                                    <option value="qualite_3">3</option>
                                                    <option value="qualite_4">4</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <select class="form-control" name="modeTraitement[]">
                                                    <option value="" selected disabled>FIV/Detruit</option>
                                                    <option value="IM">FIV</option>
                                                    <option value="IV">Detruit</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-sm-3">
                                                <input class="form-control autre_utilisation" name="autre_utilisation" type="text" placeholder="Autre utilisations">
                                            </div>
                                        </div>
                                        <div class="form-group col-sm-1">
                                            <button class="btn btn-primary addTabOvocytes" type="button"><span class="fa fa-plus"></span></button>
                                        </div>

                                    </div>
                                    <div class="form-group col-sm-4">
                                        <select class="form-control" name="sanitaireSelect">
                                            <option value="" selected>Sanitaire</option>
                                            <c:forEach items="${sanitaireList}" var="sanitaire">
                                                <option value="${sanitaire.id}">${sanitaire.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-sm-8">
                                        <input class="form-control remarque_ovocytes" name="remarque_ovocytes" type="text" placeholder="Remarques">
                                    </div>
                                    <button class="btn btn-primary back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step4 frm" style="display: none;">
                            <form name="addPart4" class="addOrUpdatePart" method="post" action="./addOrUpdatePart4">
                                <fieldset name="vitro">
                                    <legend>&Eacute;tape 4/5  -  INFORMATIONS IN VITRO</legend>
                                    <div class="form-group" id="information_piv">
                                        <label>INFORMATIONS PIV</label><br>
                                        <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                            <select class="form-control operateurSelect" id="operateur_piv" name="operateur_piv">
                                                <option value="">Op&#233rateur</option>
                                                <c:forEach items="${operateurList}" var="operateur">
                                                    <option value="${operateur.id}" ${(operateur.nom == 'Desnoes') && (operateur.prenom=='Olivier') ? 'selected' : ''}>${operateur.nom} ${operateur.prenom}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                            <select class="form-control maturationSelect" id="maturation_piv" name="maturation_piv">
                                                <option value="">Maturation</option>
                                                <c:forEach items="${maturationList}" var="maturation">
                                                    <option value="${maturation.id}" >${maturation.nom} ${maturation.numeroLot}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-sm-1 col-xs-1">
                                            <button type="button" class="btn btn-primary btn-md addMaturation" data-title="addMaturation" data-toggle="modal" data-target="#addMaturation" >
                                                <span class="fa fa-plus"></span>
                                            </button>
                                        </div>
                                        <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                            <select class="form-control cultureSelect" id="culture_piv" name="culture_piv">
                                                <option value="">Culture</option>
                                                <c:forEach items="${cultureList}" var="culture">
                                                    <option value="${culture.id}" >${culture.nom} ${culture.numeroLot}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-sm-1 col-xs-1">
                                            <button type="button" class="btn btn-primary btn-md addCulture" data-title="addCulture" data-toggle="modal" data-target="#addCulture" >
                                                <span class="fa fa-plus"></span>
                                            </button>
                                        </div>
                                        <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                            <select class="form-control fivSelect" id="fiv_piv" name="fiv_piv">
                                                <option value="">FIV</option>
                                                <c:forEach items="${fivList}" var="maturation">
                                                    <option value="${fiv.id}" >${fiv.nom} ${fiv.numeroLot}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-sm-1 col-xs-1">
                                            <button type="button" class="btn btn-primary btn-md addFIV" data-title="addFIV" data-toggle="modal" data-target="#addFIV" >
                                                <span class="fa fa-plus"></span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="form-group", id="maturation_vitro">
                                        <label>MATURATION IN VITRO</label><br>
                                        <div class="form-group">
                                            <input class="form-control datepickerTime" name="date" type="text" placeholder="Date Et Heure">
                                        </div>
                                        <div id="tabMaturationVitro" class="tabMaturationVitro">
                                            <div class="form-group col-sm-2">
                                                <input class="form-control nb_de_cocs" name="nb_de_cocs_maturation" type="number" placeholder="Nb de COCs">
                                            </div>
                                            <div class="form-group col-sm-3">
                                                <input class="form-control datepickerTime" name="debut_maturation" type="text" placeholder="Heure D&#233but maturation">
                                            </div>
                                            <div class="form-group col-sm-3">
                                                <input class="form-control datepickerTime" name="fin_maturation" type="text" placeholder="Heure Fin maturation">
                                            </div>
                                            <div class="form-group col-sm-3">
                                                <input class="form-control nb_de_cocs_mature" name="nb_de_cocs_mature" type="number" placeholder="Nb COCs matures">
                                            </div>
                                        </div>
                                        <div class="form-group col-sm-1">
                                            <button class="btn btn-primary addMaturationVitro" type="button"><span class="fa fa-plus"></span></button>
                                        </div>
                                    </div>

                                    <div class="form-group", id="fecondation_vitro">
                                        <label>FECONDATION IN VITRO</label><br>
                                        <div class="form-group col-sm-6">
                                            <input class="form-control datepickerTime" name="date" type="text" placeholder="Date Et Heure">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <select class="form-control" name="sanitaireSelect">
                                                <option value="" selected>Sanitaire</option>
                                                <c:forEach items="${sanitaireList}" var="sanitaire">
                                                    <option value="${sanitaire.id}">${sanitaire.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div id="tabFecondationVitro" class="tabFecondationVitro">
                                            <div class="form-group col-sm-2">
                                                <input class="form-control required vache" required name="vache" type="text" placeholder="vache">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control" name="race_vitro" type="text" placeholder="Race">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control datepickerTime" name="ejaculat" type="text" placeholder="N &#233jaculat">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control etat_frais" name="etat_frais" type="number" placeholder="Etat frais avant FIV">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control vol_fiv" name="vol_fiv" type="number" placeholder="Vol. FIV (µl)">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control" name="numero_vitro" type="text" placeholder="NUMERO">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group", id="culture_vitro">
                                        <label>CULTURE IN VITRO</label><br>
                                        <div class="form-group col-sm-6">
                                            <input class="form-control datepickerTime" name="date" type="text" placeholder="Date Et Heure">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <select class="form-control" name="sanitaireSelect">
                                                <option value="" selected>Sanitaire</option>
                                                <c:forEach items="${sanitaireList}" var="sanitaire">
                                                    <option value="${sanitaire.id}">${sanitaire.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div id="tabCultureVitro1" class="tabCultureVitro1">
                                            <div class="form-group col-sm-2">
                                                <input class="form-control" name="groupe" type="text" placeholder="GROUPE">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control insemine" name="insemine" type="number" placeholder="Nb d'ovo insemines">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control heure_culture" name="heure_culture" type="number" placeholder="Heure de mise en culture">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control nb_segmente" name="nb_segmente" type="number" placeholder="Nb segment&#233s">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control pour_segmente" name="pour_segmente" type="number" placeholder="% segment&#233s">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control J6" name="J6" type="number" placeholder="J6">
                                            </div>
                                        </div>
                                        <div id="tabCultureVitro2" class="tabCultureVitro2">
                                            <div class="form-group col-sm-2">
                                                <input class="form-control" name="groupe" type="text" placeholder="GROUPE">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <input class="form-control JB" name="JB" type="number" placeholder="JB">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <input class="form-control BL" name="BL" type="number" placeholder="BL">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <input class="form-control BE" name="BE" type="number" placeholder="BE">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <input class="form-control Q1" name="Q1" type="number" placeholder="Q1">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <input class="form-control nb_total" name="nb_total" type="number" placeholder="total">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <input class="form-control pour_J7" name="pour_J7" type="number" placeholder="%J7">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control pour_BEJ7" name="pour_BEJ7" type="number" placeholder="%BEJB">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control pour_Q1J7" name="pour_Q1J7" type="number" placeholder="%Q1J7">
                                            </div>
                                        </div>
                                        <div id="tabCultureVitro3" class="tabCultureVitro3">
                                            <div class="form-group col-sm-2">
                                                <input class="form-control" name="groupe" type="text" placeholder="GROUPE">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control nbJ8" name="nbJ8" type="number" placeholder="Nb J8">
                                            </div>
                                            <div class="form-group col-sm-2">
                                                <input class="form-control pour_J8" name="pour_J8" type="number" placeholder="%J8">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" name="remarque_culture" type="text" placeholder="Remarques">
                                        </div>
                                    </div>

                                    <button class="btn btn-primary back4" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open4" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step5 frm" style="display: none;">
                            <form name="addPart5" class="addOrUpdatePart" method="post" action="./addOrUpdatePart5">
                                <fieldset name="gestation">
                                    <legend>&Eacute;tape 5/5  -  DETAILS EMBRYONS VIABLES</legend>
                                    <label>Tableau Embryons:</label><br>
                                    <div id="tabEmbryons" class="tabEmbryons">
                                        <div class="form-group col-sm-2">
                                            <select class="form-control" name="stade[]">
                                                <option value="" selected disabled>Stade(BE)</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-1">
                                            <select class="form-control" name="qualite[]">
                                                <option value="" selected disabled>QUALITE</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <select class="form-control" name="Cryoconserve[]">
                                                <option value="" selected disabled>Cryoconserv&#233</option>
                                                <option value="oui">Oui</option>
                                                <option value="non">Non</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="cuve_storage" type="text" placeholder="Cuve Stockage", value="embryons in vitro">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control canister" name="canister" type="number" placeholder="Canister stockage">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="visotube_storage" type="text" placeholder="Visotube stockage", value="GRIS">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabEmbryons" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
                                    <label>Tableau Embryons(suite):</label><br>
                                    <div id="tabEmbryonsSuite" class="tabEmbryonsSuite">
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="jonc" type="text" placeholder="Jonc", value="JAUNE">
                                        </div>
                                        <div class="form-group col-sm-1">
                                            <select class="form-control" name="Frais[]">
                                                <option value="" selected disabled>Frais</option>
                                                <option value="oui">Oui</option>
                                                <option value="non">Non</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="n_receveuse" type="text" placeholder="Numero Receveuse">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="n_reference" type="text" placeholder="Reference transfert">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <select class="form-control" name="Detruit[]">
                                                <option value="" selected disabled>Detruit</option>
                                                <option value="oui">Oui</option>
                                                <option value="non">Non</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="remarque_embryons" type="text" placeholder="Remarques">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabEmbryonsSuite" type="button"><span class="fa fa-plus"></span></button>
                                    </div>
                                    <label>INFORMATIONS CRYOCONSERVATION :</label><br>
                                    <div class="form-group col-sm-6">
                                        <input class="form-control" name="reference_congelation" type="text" placeholder="R&#233f&#233rence cong&#233lation">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Heure de cong&#233lation :">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <input class="form-control" name="methode_congelation" type="text" placeholder="M&#233thode de cong&#233lation">
                                    </div>
                                    <div class="form-group col-sm-6" style="padding-left:0">
                                        <select class="form-control operateurSelect" id="operateur_embryons" name="operateur_embryons">
                                            <option value="">Op&#233rateur</option>
                                            <c:forEach items="${operateurList}" var="operateur">
                                                <option value="${operateur.id}" ${(operateur.nom == 'Desnoes') && (operateur.prenom=='Olivier') ? 'selected' : ''}>${operateur.nom} ${operateur.prenom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="description_congelation" type="text" placeholder="Descriptions">
                                    </div>


                                    <button class="btn btn-primary back5" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
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
                        <input class="form-control" name="nomProgramme" type="text" placeholder="Nom du programme">
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

<!-- Modal add maturation -->
<div class="modal fade" id="addMaturation" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingMaturation">Ajouter une nouvelle maturation</h4>
            </div>

            <form id="addMaturationForm" action="../../maturation/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomMaturation" type="text" placeholder="Nom de la maturation">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="lotMaturation" type="text" placeholder="Lot de la maturation">
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

<!-- Modal add maturation -->
<div class="modal fade" id="addCulture" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingCulture">Ajouter une nouvelle culture</h4>
            </div>

            <form id="addCultureForm" action="../../culture/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomCulture" type="text" placeholder="Nom de la culture">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="lotCulture" type="text" placeholder="Lot de la culture">
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

<!-- Modal add maturation -->
<div class="modal fade" id="addFIV" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingFIV">Ajouter une nouvelle maturation</h4>
            </div>

            <form id="addFIVForm" action="../../fiv/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomFIV" type="text" placeholder="Nom de la FIV">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="lotFIV" type="text" placeholder="Lot de la FIV">
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

<!-- Modal add type Opu -->
<div class="modal fade" id="addTypeOpu" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingTypeOpu">Ajouter un nouvel type opu</h4>
            </div>

            <form id="addTypeOpuForm" action="../../typeOpu/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomTypeOpu" type="text" placeholder="Nom de type Opu">
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
                        <input class="form-control" name="prenomOperateur" type="text" placeholder="Pr&#233nom de l'op&#233rateur">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="nomOperateur" type="text" placeholder="Nom de l'op&#233rateur">
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
        form.find('form[name="addPart1"]').attr('action', './addOrUpdatePart1');
        form.find('form').removeClass('EditForm');
        form.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
        form.find('.tabGestation').not(':first').remove();

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

        $clone.find('input.vache').autocomplete({ //active l'autompletion sur "vache"
            minLength: 4,
            source: '${pageContext. request. contextPath}/animaux/get/vache'
        });

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

    $(document).on( 'click', ".back5", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step5').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step4').show("slow");
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

    $(document).on( 'change', 'select[name="traitementActe"]', function(event){
        if($('select[name="traitementActe"] option:selected').val() != ""){
            $.ajax({
                url: '${pageContext. request. contextPath}/traitement/get/'+this.value,
                type: 'GET',
                success: function (result) {
                    if (result.succes == true) {
                        $('div.tab-pane.active').find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
                        for(iLigne = 0; iLigne < result.objet.tableauTraitement.length; iLigne++)
                        {
                            if(iLigne == 0){
                                $target = $('div.tab-pane.active').find('.tabTraitement');
                                $target.find('input').val("");
                                $target.find("select").val("");
                            }else{
                                $target = $('div.tab-pane.active').find('#tabTraitement').clone().removeAttr('id');
                                $target.find('input').val("");
                                $target.find("select").val("");
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($('div.tab-pane.active').find("div.tabTraitement").last());
                            }

                            $target.find("input[name='dateTraitement[]']").datetimepicker({
                                locale: 'fr',
                                format: 'DD/MM/YYYY',
                                toolbarPlacement: 'top',
                                showClose: true
                            });

                            $target.find("select[name='produit[]']" ).val(result.objet.tableauTraitement[iLigne].produit.id );
                            $target.find("input[name='quantite[]']").val(result.objet.tableauTraitement[iLigne].quantite);
                            $target.find("select[name='modeTraitement[]']").val(result.objet.tableauTraitement[iLigne].mode_traitement);
                        }
                    }
                }
            });
        }
    });

    $(document).on( 'blur', "input[name='dateTraitement[]']:first", function() {
        Date.prototype.addDays = function(days) { //ajoute des jours
            var dat = new Date(this.valueOf());
            dat.setDate(dat.getDate() + days);
            return dat;
        }
        function parseDate(input) { // fr to en
            var parts = input.split('/');
            return new Date(parts[2]+"/"+parts[1]+"/"+parts[0]); // Note: months are 0-based
        }

        if($('select[name="traitementActe"] option:selected').val() != ""){
            $.ajax({
                url: '${pageContext. request. contextPath}/traitement/get/'+$('select[name="traitementActe"]').val(),
                type: 'GET',
                success: function (result) {
                    if (result.succes == true) {
                        for(iLigne = 1; iLigne < result.objet.tableauTraitement.length; iLigne++) {
                            var date = new Date(parseDate($("input[name='dateTraitement[]']:first").val())).addDays(result.objet.tableauTraitement[iLigne].decalage);
                            $("input[name='dateTraitement[]']:eq("+iLigne+")").data("DateTimePicker").date(date);
                        }

                    }
                }
            });
        }
    });

    /******* Ajoute une ligne tableau traitement_acte donneuse ******/
    $(document).on( 'click', ".addTabTraitement", function(){
        $template = $('#tabTraitement');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabTraitement").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau traitement opu ******/
    $(document).on( 'click', ".addTabTraitementOpu", function(){
        $template = $('#tabTraitementOpu');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitementOpu" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabTraitementOpu").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau Embryons ******/
    $(document).on( 'click', ".addTabEmbryons", function(){
        $template = $('#tabEmbryons');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabEmbryons" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabEmbryons").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau Embryons suite ******/
    $(document).on( 'click', ".addTabEmbryonsSuite", function(){
        $template = $('#tabEmbryonsSuite');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabEmbryonsSuite" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabEmbryonsSuite").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau ovocytes ******/
    $(document).on( 'click', ".addTabOvocytes", function(){
        $template = $('#tabOvocytes');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabOvocytes" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabOvocytes").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau gestation ******/
    $(document).on( 'click', ".addTabGestation", function(){
        $template = $('#tabGestation'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabGestation" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabGestation").last()); //insert après le dernier object de class tabGestation
        createDatePicker();
    });

    /******* Ajoute une ligne tableau maturation vitro ******/
    $(document).on( 'click', ".addMaturationVitro", function(){
        $template = $('#tabMaturationVitro'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabMaturationVitro" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabMaturationVitro").last()); //insert après le dernier object de class tabGestation
        createDatePicker();
    });

    /******* Supprime une ligne modal traitement ******/
    $(document).on( 'click', ".delTabTraitement", function(){
        $(this).closest('.tabTraitement').remove();
    });

    /******* Supprime une ligne modal traitement opu ******/
    $(document).on( 'click', ".delTabTraitementOpu", function(){
        $(this).closest('.tabTraitementOpu').remove();
    });

    /******* Supprime une ligne modal embryons ******/
    $(document).on( 'click', ".delTabEmbryons", function(){
        $(this).closest('.tabEmbryons').remove();
    });

    /******* Supprime une ligne modal embryons suite ******/
    $(document).on( 'click', ".delTabEmbryonsSuite", function(){
        $(this).closest('.tabEmbryonsSuite').remove();
    });

    /******* Supprime une ligne modal ovocytes ******/
    $(document).on( 'click', ".delTabOvocytes", function(){
        $(this).closest('.tabOvocytes').remove();
    });

    /******* Supprime une ligne modal gestation ******/
    $(document).on( 'click', ".delTabGestation", function(){
        $(this).closest('.tabGestation').remove();
    });

    /******* Supprime une ligne maturation vitro ******/
    $(document).on( 'click', ".delTabMaturationVitro", function(){
        $(this).closest('.tabMaturationVitro').remove();
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
                }else{
                    var table = $('#tableActes').DataTable(); //init pour changer value .cell.data
                    var rowId = $('#tableActes').dataTable().fnFindCellRowIndexes(result.objet.nom, 1); // cherche fiche modifiée

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
                            table.cell(rowId, 4).data(result.objet.lieu).draw(false);
                            table.cell(rowId, 5).data(result.objet.vache.num_identification).draw(false);
                            table.cell(rowId, 6).data(result.objet.vache.num_identification.substr(result.objet.vache.num_identification.length - 4)).draw(false);
                        }
                    }

                    if($this.closest('div.frm').hasClass('step5')) { //si étape 5
                        /** clear modal **/
                        reinitForm($this.closest('.tab-pane'));

                        $("li.active.tab").children('a').text(" Nouvelle fiche");

                        $this.closest('div.tab-pane.active').find(".step5").hide("fast");
                        $this.closest('div.tab-pane.active').find(".step1").show("slow");
                    }

                    if(rowId.length == 1) { //si le nom de la fiche est présent
                        //Modifie le statut
                        table.cell(rowId, 8).data(result.objet.statut).draw(false);
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
                    $('#addProgramme').find('input').val(''); //clear modal
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
                    $('#addOperateur').find('input').val(''); //clear modal
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
            url: "./get/"+id,
            method: 'GET',
            success: function (result) {
                if(result.succes == true) {
                    newTab();
                    $activeTab = $('div.tab-pane.active');

                    $activeTab.removeClass('add'); //identifie la tab comme un tab d'édition

                    $activeTab.find('form[name="addPart1"]').attr('action', $activeTab.find('form[name="addPart1"]').attr('action')+"/"+id); //attribue l'id au modal
                    $activeTab.find('form[name="addPart1"]').addClass('EditForm');

                    //change le nom de l'onglet
                    $("li.active.tab").children('a').text(result.objet.nom);

                    /*************************** REMPLI MODAL ***************************/

                    /************* STEP 1 *************/
                    $activeTab.find("input[name='nom']" ).val(result.objet.nom);
                    if(result.objet.programme != null) {
                        $activeTab.find("select[name='programme']").val(result.objet.programme.id);
                    }

                    $activeTab.find( "input[name='numAgrement']" ).val(result.objet.numeroAgrement);
                    $activeTab.find( "input[name='lieu']" ).val(result.objet.lieu);
                    if(result.objet.dateHeureMinute != null) {
                        $activeTab.find("input[name='date']").data("DateTimePicker").date(new Date(result.objet.dateHeureMinute));
                    }

                    if(result.objet.operateur != null) {
                        $activeTab.find("select[name='operateur']").val(result.objet.operateur.id);
                    }

                    $activeTab.find( "input[name='vache']" ).val(result.objet.vache.num_identification);

                    /************* STEP 2 *************/
                    if(result.objet.traitement_donneuse != null){
                        if(result.objet.traitement_donneuse.date_ref_chaleur != null) {
                            $activeTab.find("input[name='dateChaleur']").data("DateTimePicker").date(new Date(result.objet.traitement_donneuse.date_ref_chaleur));
                        }

                        if(result.objet.traitement_donneuse.typeChaleur == "naturelle") {
                            $activeTab.find("input[name='typeChaleur'][value='naturelle']").prop('checked', true);
                        }
                        if(result.objet.traitement_donneuse.typeChaleur == "induite") {
                            $activeTab.find("input[name='typeChaleur'][value='induite']").prop('checked', true);
                        }

                        //remplit tableau traitement_acte donneuse
                        for(iLigne = 0; iLigne < result.objet.traitement_donneuse.tableauDonneuse.length; iLigne++)
                        {
                            if(iLigne == 0){
                                $target = $activeTab.find('.tabTraitement');
                            }else{
                                $target = $activeTab.find('#tabTraitement').clone().removeAttr('id');
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($activeTab.find("div.tabTraitement").last());
                            }

                            $target.find("input[name='dateTraitement[]']").datetimepicker({
                                locale: 'fr',
                                format: 'DD/MM/YYYY',
                                toolbarPlacement: 'top',
                                showClose: true
                            });

                            $target.find("input[name='dateTraitement[]']").data("DateTimePicker").date(new Date(result.objet.traitement_donneuse.tableauDonneuse[iLigne].date));
                            $target.find("select[name='produit[]']" ).val(result.objet.traitement_donneuse.tableauDonneuse[iLigne].produit.id );
                            $target.find("input[name='quantite[]']").val(result.objet.traitement_donneuse.tableauDonneuse[iLigne].quantite);
                            $target.find("select[name='modeTraitement[]']").val(result.objet.traitement_donneuse.tableauDonneuse[iLigne].mode_traitement);
                        }
                    }

                    /************* STEP 3 *************/
                    if(result.objet.corpsJaune != null) {
                        $activeTab.find("select[name='qualite']").val(result.objet.corpsJaune.qualite);

                        if(result.objet.corpsJaune.mode_evaluation === true) {
                            $activeTab.find("input[name='methodeEvaluation'][value='palpation']").prop('checked', true);
                        }
                        if(result.objet.corpsJaune.mode_evaluation === false) {
                            $activeTab.find("input[name='methodeEvaluation'][value='echographie']").prop('checked', true);
                        }
                        if(result.objet.corpsJaune.imageEcho === true) {
                            $activeTab.find("input[name='optradioEcho'][value='oui']").prop('checked', true);
                        }
                        if(result.objet.corpsJaune.imageEcho === false) {
                            $activeTab.find("input[name='optradioEcho'][value='non']").prop('checked', true);
                        }
                        if(result.objet.corpsJaune.coteCorpsJaune === 'G') {
                            $activeTab.find("input[name='optradioCote'][value='gauche']").prop('checked', true);
                        }
                        if(result.objet.corpsJaune.coteCorpsJaune === 'D') {
                            $activeTab.find("input[name='optradioCote'][value='droit']").prop('checked', true);
                        }
                    }

                    /************* STEP 4 *************/
                    if(result.objet.embryonsTransferes != null) {
                        $activeTab.find( "input[name='numEmbryon']" ).val(result.objet.embryonsTransferes.refEmbryons);
                        $activeTab.find( "select[name='emplacementCorne']" ).val(result.objet.embryonsTransferes.emplacementColUterine);
                        $activeTab.find( "select[name='faciliteProgression']" ).val(result.objet.embryonsTransferes.faciliteprogression);

                        if(result.objet.embryonsTransferes.cote === 'G') {
                            $activeTab.find("input[name='optradioCoteTransf'][value='gauche']").prop('checked', true);
                        }
                        if(result.objet.embryonsTransferes.cote === 'D') {
                            $activeTab.find("input[name='optradioCoteTransf'][value='droit']").prop('checked', true);
                        }
                    }

                    /************* STEP 5 *************/
                    if(result.objet.gestation != null) {
                        $activeTab.find( "textarea[name='remarques']" ).val(result.objet.gestation.remarques);

                        //remplit tableau gestation
                        for(iLigne = 0; iLigne < result.objet.gestation.tableauGestationList.length; iLigne++)
                        {
                            if(iLigne == 0){
                                $target = $activeTab.find('.tabGestation');
                            }else{
                                $target = $activeTab.find('#tabGestation').clone().removeAttr('id');
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabGestation" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($activeTab.find("div.tabGestation").last());
                            }

                            $target.find("input[name='dateMethode[]']").datetimepicker({
                                locale: 'fr',
                                format: 'DD/MM/YYYY',
                                toolbarPlacement: 'top',
                                showClose: true
                            });

                            $target.find("input[name='dateMethode[]']").data("DateTimePicker").date(new Date(result.objet.gestation.tableauGestationList[iLigne].date));
                            $target.find( "select[name='methode[]']" ).val(result.objet.gestation.tableauGestationList[iLigne].methode );
                            $target.find("select[name='resultat[]']").val(result.objet.gestation.tableauGestationList[iLigne].resultat);
                        }
                    }
                }else{
                    $('#add').modal('toggle'); //ferme modal
                    $('#tableActes').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
                }
            }
        });
    });

    /******************************* AUTOCOMPLETE ****************************/
    $( ".vache" ).autocomplete({
        minLength: 4,
        source: '${pageContext. request. contextPath}/animaux/get/vache'
    });

</script>