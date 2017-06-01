<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog  modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingAdd">Renseigner ou modifier une fiche TRA</h4>
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
                                        <input class="form-control" name="numAgrement" type="text" value="FR TB/PB 370" placeholder="Num&#233ro d'agr&#233ment">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="lieu" type="text" value="Allice Nouzilly" placeholder="Lieu">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Date">
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control operateurSelect" id="operateur" name="operateur">
                                            <option value="">Op&#233rateur</option>
                                            <c:forEach items="${operateursList}" var="operateur">
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
                                    <legend>&Eacute;tape 2/5  -  TRAITEMENT RECEVEUSE</legend>

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
                                                <option value="" selected>Produit</option>
                                                <c:forEach items="${produitsList}" var="produit">
                                                    <option value="${produit.id}">${produit.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="quantite[]" step="0.01" type="number" placeholder="Quantite">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="modeTraitement[]">
                                                <option value="" selected>Mode de traitementActe</option>
                                                <option value="IM">IM</option>
                                                <option value="IV">IV</option>
                                                <option value="IVA">IVA</option>
                                                <option value="SC">SC</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2 col-sm-offset-2" style="padding-top:5px;padding-left:50px">
                                            <span>OU</span>
                                        </div>
                                        <div class="form-group col-sm-7 ">
                                            <input class="form-control" name="acte[]" type="text" placeholder="Acte">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabTraitement" type="button"><span class="fa fa-plus"></span></button>
                                    </div>

                                    <button class="btn btn-primary back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step3 frm" style="display: none;">
                            <form name="addPart3" class="addOrUpdatePart" method="post" action="./addOrUpdatePart3">
                                <fieldset name="corpsJaune">
                                    <legend>&Eacute;tape 3/5  -  &Eacute;VALUATION DU CORPS JAUNE</legend>
                                    <div class="form-group">
                                        <label>M&#233thode d'&#233valuation: </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="palpation" name="methodeEvaluation">Palpation</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="echographie" name="methodeEvaluation">&Eacute;chographie</label>
                                    </div>
                                    <div class="form-group">
                                        <label>Image(s) &#233chographie : </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioEcho">Oui</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="non" name="optradioEcho">Non</label>
                                    </div>
                                    <div class="form-group">
                                        <label>Cot&#233 du corps jaune : </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="gauche" name="optradioCote">Gauche</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="droit" name="optradioCote">Droit</label>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" id="qualite" name="qualite">
                                            <option value="" selected disabled>Qualit&#233</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </div>
                                    <button class="btn btn-primary back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step4 frm" style="display: none;">
                            <form name="addPart4" class="addOrUpdatePart" method="post" action="./addOrUpdatePart4">
                                <fieldset name="embryon">
                                    <legend>&Eacute;tape 4/5  -  EMBRYON(S) TRANSF&Eacute;R&Eacute;S</legend>
                                    <div class="form-group">
                                        <input class="form-control" name="numEmbryon" type="text" placeholder="Num&#233ro d'embryon">
                                    </div>
                                    <div class="form-group">
                                        <label>Cot&#233 transfert : </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="gauche" name="optradioCoteTransf">Gauche</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="droit" name="optradioCoteTransf">Droit</label>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="emplacementCorne">
                                            <option value="" selected disabled>Emplacement dans la corne ut&#233rine</option>
                                            <option value="1erTiers">1er tiers</option>
                                            <option value="2emeTiers">2&egrave;me tiers</option>
                                            <option value="3emeTiers">3&egrave;me tiers</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="faciliteProgression">
                                            <option value="" selected disabled>Facilit&#233 de progression</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </div>
                                    <button class="btn btn-primary back4" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open4" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step5 frm" style="display: none;">
                            <form name="addPart5" class="addOrUpdatePart" method="post" action="./addOrUpdatePart5">
                                <fieldset name="gestation">
                                    <legend>&Eacute;tape 5/5  -  SUIVI DE GESTATION</legend>
                                    <div id="tabGestation" class="tabGestation">
                                        <div class="form-group col-sm-3" style="padding-left:0">
                                            <input class="form-control datepicker" name="dateMethode[]" type="text" placeholder="Date">
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <select class="form-control" name="methode[]">
                                                <option value="" selected disabled>M&#233thode</option>
                                                <option value="&Eacute;cho">&Eacute;cho</option>
                                                <option value="Palpation">Palpation</option>
                                                <option value="PSPB">PSPB</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <select class="form-control" name="resultat[]">
                                                <option value="" selected disabled>R&#233sultat</option>
                                                <option value="douteux">Douteux</option>
                                                <option value="gestante">Gestante</option>
                                                <option value="nonGestante">Non gestante</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabGestation" type="button"><span class="fa fa-plus"></span></button>
                                    </div>

                                    <div class="form-group">
                                        <textarea class="form-control" name="remarques" rows="5" placeholder="Remarques"></textarea>
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
        form.find('form[name="addPart2"]').attr('action', './addOrUpdatePart2');
        form.find('form[name="addPart3"]').attr('action', './addOrUpdatePart3');
        form.find('form[name="addPart4"]').attr('action', './addOrUpdatePart4');
        form.find('form[name="addPart5"]').attr('action', './addOrUpdatePart5');

        form.find('form').removeClass('EditForm');
        form.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
        form.find('.tabGestation').not(':first').remove();

        // reinit formulaire
        form.find('input').not(':radio').val("");
        form.find('input').removeClass('dateTraitementFirst');
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
        var active = $('div.tab-pane.active');
        if(active.find('select[name="traitementActe"] option:selected').val() != ""){
            $.ajax({
                url: '${pageContext. request. contextPath}/traitement/get/'+this.value,
                type: 'GET',
                success: function (result) {
                    var minDate = 65536;
                    var minHour = 65536;
                    var index = 0;
                    if (result.succes == true) {
                        active.find("input.dateTraitementFirst").removeClass('dateTraitementFirst');

                        active.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
                        for(iLigne = 0; iLigne < result.objet.tableauTraitement.length; iLigne++)
                        {
                            if(iLigne == 0){
                                $target = active.find('.tabTraitement');
                                $target.find('input').val("");
                                $target.find("select").val("");
                            }else{
                                $target = active.find('#tabTraitement').clone().removeAttr('id');
                                $target.find('input').val("");
                                $target.find("select").val("");
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter(active.find("div.tabTraitement").last());
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

                            if(minDate >= result.objet.tableauTraitement[iLigne].decalageJour && minHour >= result.objet.tableauTraitement[iLigne].decalageHeure){
                                index = iLigne;
                                minDate = result.objet.tableauTraitement[iLigne].decalageJour;
                                minHour = result.objet.tableauTraitement[iLigne].decalageHeure;
                            }
                        }

                        for(iLigneActe = 0; iLigneActe < result.objet.acteTraitements.length; iLigneActe++)
                        {
                            if(iLigneActe == 0 && result.objet.tableauTraitement.length == 0){
                                $target = active.find('.tabTraitement');
                                $target.find('input').val("");
                                $target.find("select").val("");
                            }else{
                                $target = active.find('#tabTraitement').clone().removeAttr('id');
                                $target.find('input').val("");
                                $target.find("select").val("");
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter(active.find("div.tabTraitement").last());
                            }

                            $target.find("input[name='dateTraitement[]']").datetimepicker({
                                locale: 'fr',
                                format: 'DD/MM/YYYY',
                                toolbarPlacement: 'top',
                                showClose: true
                            });

                            $target.find("input[name='acte[]']").val(result.objet.acteTraitements[iLigneActe].acte);

                            if(minDate >= result.objet.acteTraitements[iLigneActe].decalageJour && minHour >= result.objet.acteTraitements[iLigneActe].decalageHeure){
                                index = iLigne + iLigneActe;
                                minDate = result.objet.acteTraitements[iLigneActe].decalageJour;
                                minHour = result.objet.acteTraitements[iLigneActe].decalageHeure;
                            }

                        }

                        active.find("input[name='dateTraitement[]']:eq("+index+")").addClass('dateTraitementFirst');
                    }
                }
            });
        }
    });

    $(document).on( 'blur', "input.dateTraitementFirst", function() {
        Date.prototype.addDays = function(days) { //ajoute des jours
            var dat = new Date(this.valueOf());
            dat.setDate(dat.getDate() + days);
            return dat;
        }
        function parseDate(input) { // fr to en
            var parts = input.split('/');
            return new Date(parts[2]+"/"+parts[1]+"/"+parts[0]); // Note: months are 0-based
        }
        var active = $('div.tab-pane.active');
        var select = active.find('select[name="traitementActe"] option:selected');

        if(select.val() != ""){
            $.ajax({
                url: '${pageContext. request. contextPath}/traitement/get/'+select.val(),
                type: 'GET',
                success: function (result) {
                    if (result.succes == true) {
                        var acte = 0;
                        var traitement = 0;
                        iLigne = 0;
                        active.find('input[name="dateTraitement[]"]').each(function() {
                            if($(this).closest(".tabTraitement").find("input[name='quantite[]']").val() != ""){
                                if(!$(this).hasClass('dateTraitementFirst')) {
                                    var date = new Date(parseDate(active.find("input.dateTraitementFirst").val())).addDays(result.objet.tableauTraitement[traitement].decalageJour);
                                    active.find("input[name='dateTraitement[]']:eq(" + iLigne + ")").data("DateTimePicker").date(date);
                                }
                                traitement++;
                            }else{
                                if(!$(this).hasClass('dateTraitementFirst')) {
                                    var date = new Date(parseDate(active.find("input.dateTraitementFirst").val())).addDays(result.objet.acteTraitements[acte].decalageJour);
                                    active.find("input[name='dateTraitement[]']:eq(" + iLigne + ")").data("DateTimePicker").date(date);
                                }
                                acte++;
                            }

                            iLigne++;
                        });
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

    /******* Ajoute une ligne tableau gestation ******/
    $(document).on( 'click', ".addTabGestation", function(){
        $template = $('#tabGestation'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabGestation" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabGestation").last()); //insert après le dernier object de class tabGestation
        createDatePicker();
    });

    /******* Supprime une ligne modal traitement ******/
    $(document).on( 'click', ".delTabTraitement", function(){
        $(this).closest('.tabTraitement').remove();
    });

    /******* Supprime une ligne modal gestation ******/
    $(document).on( 'click', ".delTabGestation", function(){
        $(this).closest('.tabGestation').remove();
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
                                $target.find('input').val("");
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

                        for(iLigne = 0; iLigne < result.objet.traitement_donneuse.tableauActe.length; iLigne++)
                        {
                            if(iLigne == 0 && result.objet.traitement_donneuse.tableauActe.length == 0){
                                $target = $activeTab.find('.tabTraitement');
                            }else{
                                $target = $activeTab.find('#tabTraitement').clone().removeAttr('id');
                                $target.find('input').val("");
                                $target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
                                $target.insertAfter($activeTab.find("div.tabTraitement").last());
                            }

                            $target.find("input[name='dateTraitement[]']").datetimepicker({
                                locale: 'fr',
                                format: 'DD/MM/YYYY',
                                toolbarPlacement: 'top',
                                showClose: true
                            });

                            $target.find("input[name='dateTraitement[]']").data("DateTimePicker").date(new Date(result.objet.traitement_donneuse.tableauActe[iLigne].date));
                            $target.find("input[name='acte[]']").val(result.objet.traitement_donneuse.tableauActe[iLigne].acte);
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