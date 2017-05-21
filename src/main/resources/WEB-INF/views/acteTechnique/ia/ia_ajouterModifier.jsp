<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog  modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingAdd">Renseigner ou modifier une fiche IA</h4>
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
                                    <legend>&Eacute;tape 1/4  -  IDENTIFICATION FICHE</legend>
                                    <div class="form-group">
                                        <input class="form-control nom" name="nom" required type="text" placeholder="Nom de la fiche">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Date">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="lieu" type="text" value="Allice Nouzilly" placeholder="Lieu">
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
                                        <input class="form-control" name="numIPE" value="3715002" type="text" placeholder="Num&#233ro IPE">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="numSemence" value="37175336B" type="text" placeholder="Num&#233ro de d&#233pot semence">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control required vache" required name="vache" type="text" placeholder="vache">
                                    </div>

                                    <button class="btn btn-primary open1" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step2 frm" style="display: none;">
                            <form name="addPart2" class="addOrUpdatePart" method="post" action="./addOrUpdatePart2">
                                <fieldset name="traitementActe">
                                    <legend>&Eacute;tape 2/4  -  INSEMINATION</legend>

                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select required class="form-control operateurSelect" id="operateur" name="operateur">
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
                                        <label>Semence sex&#233e : </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioSexee">Oui</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="non" checked name="optradioSexee">Non</label>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control taureau" name="taureau" type="text" placeholder="Taureau">
                                    </div>

                                    <div class="form-group">
                                        <select class="form-control collecteSelect" id="collecte" name="collecte">
                                            <option value="" selected disabled>Collecte</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="lieuSemence">
                                            <option value="" selected disabled>Lieu de d&eacute;p&ocirc;t de la semaine</option>
                                            <option value="1erTiers">1er tiers</option>
                                            <option value="2emeTiers">2&egrave;me tiers</option>
                                            <option value="3emeTiers">3&egrave;me tiers</option>
                                            <option value="apresCol">Juste apr&egrave;s col</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <select class="form-control" name="facilite">
                                            <option value="" selected disabled>Facilit&#233 de progression</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </div>

                                    <button class="btn btn-primary back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step3 frm" style="display: none;">
                            <form name="addPart3" class="addOrUpdatePart" method="post" action="./addOrUpdatePart3">
                                <fieldset name="traitementActe">
                                    <legend>&Eacute;tape 3/4  -  TRAITEMENT FEMELLE</legend>

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

                                    <button class="btn btn-primary back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step4 frm" style="display: none;">
                            <form name="addPart4" class="addOrUpdatePart" method="post" action="./addOrUpdatePart4">
                                <fieldset name="gestation">
                                    <legend>&Eacute;tape 4/4  -  SUIVI DE GESTATION</legend>
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

                                    <button class="btn btn-primary back4" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
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
        form.find('form[name="addPart1"]').attr('action', './addOrUpdatePart1');
        form.find('form[name="addPart2"]').attr('action', './addOrUpdatePart2');
        form.find('form[name="addPart3"]').attr('action', './addOrUpdatePart3');
        form.find('form[name="addPart4"]').attr('action', './addOrUpdatePart4');

        form.find('form').removeClass('EditForm');
        form.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
        form.find('.tabGestation').not(':first').remove();

        // reinit formulaire
        form.find('input').not(':radio').val("");
        form.find('textarea').val('');
        form.find('.radio').prop('checked', false);
        form.find("select").val("");

        form.find('input[name="lieu"]').val("Allice Nouzilly");
        form.find('input[name="numIPE"]').val("3715002");
        form.find('input[name="numSemence"]').val("37175336B");
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

        $clone.find('input.taureau').autocomplete({ //active l'autompletion sur "taureau"
            minLength: 4,
            source: '${pageContext. request. contextPath}/semence/get/taureau'
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
        if(checkRequired($(this).closest('form'))) {
            $(event.target).closest('div.tab-pane.active').find('.step2').hide("fast");
            $(event.target).closest('div.tab-pane.active').find('.step3').show("slow");
        }
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

    $(document).on( 'click', ".back4", function(event){
        $(event.target).closest('div.tab-pane.active').find('.step4').hide("fast");
        $(event.target).closest('div.tab-pane.active').find('.step3').show("slow");
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
        if($('this option:selected').val() != ""){
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
                        $('div.tab-pane.active').find("input[name='dateTraitement[]']:first").addClass('dateTraitementFirst');
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

        var select = $('div.tab-pane.active').find('select[name="traitementActe"] option:selected');

        if(select.val() != ""){
            $.ajax({
                url: '${pageContext. request. contextPath}/traitement/get/'+select.val(),
                type: 'GET',
                success: function (result) {
                    if (result.succes == true) {
                        for(iLigne = 1; iLigne < result.objet.tableauTraitement.length; iLigne++) {

                            var date = new Date(parseDate($("input[name='dateTraitement[]']:first").val())).addDays(result.objet.tableauTraitement[iLigne].decalageJour);
                            $('div.tab-pane.active').find("input[name='dateTraitement[]']:eq("+iLigne+")").data("DateTimePicker").date(date);
                        }

                    }
                }
            });
        }
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

    /******************************* AUTOCOMPLETE ****************************/
    $( ".vache" ).autocomplete({
        minLength: 4,
        source: '${pageContext. request. contextPath}/animaux/get/vache'
    });

    $('.taureau').autocomplete({ //active l'autompletion sur "taureau"
        minLength: 4,
        source: '${pageContext. request. contextPath}/semence/get/taureau'
    });

    /******************************* LOAD FICHE COLLECTE DANS SELECT ****************************/
    function loadCollecte(){
        var numIdVache = $(".tab-pane.active").find('.vache').val();

        $.ajax({
            type : 'GET',
            url: '${pageContext. request. contextPath}/acteTechnique/col/get/vache/'+numIdVache,
            success: function (result) {
                if (result.succes == true) {
                    for(iFiche = 0; iFiche < result.objet.length; iFiche++) {
                        $('.collecteSelect').find('option').not(':first').remove();
                        $('.collecteSelect').append($('<option>', {
                            value: result.objet[iFiche].id,
                            text: result.objet[iFiche].nom
                        }));
                    }
                } else {
                    $('#modal-body').before('<div class="alert alert-danger flash" role="alert">'+result.message+'</div>');
                }
            }
        });
    }

    /************************ AJOUT *************************/

    /****** Ajoute une nouvelle fiche ******/
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
                                table.cell(rowId, 2).data(result.objet.programme.nom).draw(false);
                            }
                            if (result.objet.dateHeureMinute != null) {
                                table.cell(rowId, 3).data(convertDateWithTime(result.objet.dateHeureMinute)).draw(false);
                            }
                            table.cell(rowId, 4).data(result.objet.lieu).draw(false);

                            table.cell(rowId, 6).data(result.objet.vache.num_identification).draw(false);
                        }

                        loadCollecte();
                    }else if($this.closest('div.frm').hasClass('step2')) { //si étape 2
                        var rowId = $('#tableActes').dataTable().fnFindCellRowIndexes(result.objet.nom, 1); // cherche fiche modifiée

                        var table = $('#tableActes').DataTable(); //init pour changer value .cell.data
                        var rowId = $('#tableActes').dataTable().fnFindCellRowIndexes(result.objet.nom, 1); // cherche fiche modifiée

                        if(rowId.length == 1) { //si le nom de la fiche est présent
                            /** Modifie la ligne correspondant à la fiche modifiée **/
                            if(result.objet.insemination != null) {
                                if (result.objet.insemination.operateur != null) {
                                    table.cell(rowId, 5).data(result.objet.insemination.operateur.nom + " " + result.objet.insemination.operateur.prenom).draw(false);
                                }
                                table.cell(rowId, 7).data(result.objet.insemination.taureau.numTaureau).draw(false);
                            }
                        }
                    }

                    if($this.closest('div.frm').hasClass('step4')) { //si étape 4
                        /** clear modal **/
                        reinitForm($this.closest('.tab-pane'));

                        $("li.active.tab").children('a').text(" Nouvelle fiche");

                        $this.closest('div.tab-pane.active').find(".step4").hide("fast");
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
            }
        });
    });


    /************************ MODIF *************************/
    $(document).on( 'click', ".btnEdit", function() {
        id = $(this).attr('data-id');

        currentrow = $(this).closest('tr'); //get la row parent

        $.ajax({
            url: "./get/"+id,
            method: 'GET',
            success: function (result) {
                if(result.succes == true) {
                    newTab();
                    $activeTab = $('div.tab-pane.active');

                    $activeTab.find('.validButton').attr('data-id',id); //attribue l'id au modal

                    //change le nom de l'onglet
                    $("li.active.tab").children('a').text(result.objet.nom);

                    //remplit le modal
                    $activeTab.find("input[name='nom']" ).val(result.objet.nom);
                    $activeTab.find( "select[name='programme']" ).val(result.objet.programme.id);
                    $activeTab.find( "input[name='lieu']" ).val(result.objet.lieu);
                    $activeTab.find( "input[name='numIPE']" ).val(result.objet.numIpe);
                    $activeTab.find( "input[name='numSemence']" ).val(result.objet.numDepotSemence);
                    $activeTab.find( "select[name='vache']" ).val(result.objet.vache.id);
                    $activeTab.find( "select[name='operateur']" ).val(result.objet.insemination.operateur.id);
                    $activeTab.find( "select[name='taureau']" ).val(result.objet.insemination.taureau.id);
                    $activeTab.find( "select[name='collecte']" ).val(result.objet.insemination.collecte.id);
                    $activeTab.find( "input[name='lieuSemence']" ).val(result.objet.insemination.lieuDepot);
                    $activeTab.find( "input[name='facilite']" ).val(result.objet.insemination.progression);
                    $activeTab.find( "input[name='typeChaleur']" ).val(result.objet.traitement_donneuse.typeChaleur);
                    $activeTab.find( "input[name='chaleurDetection']" ).val(result.objet.traitement_donneuse.typeChaleur);
                    $activeTab.find( "textarea[name='remarques']" ).val(result.objet.gestation.remarques);
                    $activeTab.find("input[name='date']").data("DateTimePicker").date(new Date(result.objet.dateHeureMinute));

                    //remplit les radiobuttons
                    if(result.objet.insemination.semenceSexee == true) {
                        $activeTab.find("input[name='optradioSexee'][value='oui']").prop('checked', true);
                    }else{
                        $activeTab.find("input[name='optradioSexee'][value='non']").prop('checked', true);
                    }

                    //remplit tableau traitement_acte donneuse
                    for(iLigne = 0; iLigne < result.objet.traitement_donneuse.tableauDonneuse.length; iLigne++)
                    {
                        if(iLigne == 0){
                            $target = $activeTab.find('.tabTraitement');
                        }else{
                            $target = $activeTab.find('.tabTraitement').clone().removeAttr('id');
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
                        $target.find("input[name='modeTraitement[]']").val(result.objet.traitement_donneuse.tableauDonneuse[iLigne].mode_traitement);
                    }

                    //remplit tableau gestation
                    for(iLigne = 0; iLigne < result.objet.gestation.tableauGestationList.length; iLigne++)
                    {
                        if(iLigne == 0){
                            $target = $activeTab.find('.tabGestation');
                        }else{
                            $target = $activeTab.find('.tabGestation').clone().removeAttr('id');
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
                        $target.find("input[name='resultat[]']").val(result.objet.gestation.tableauGestationList[iLigne].resultat);
                    }
                }else{
                    $('#add').modal('toggle'); //ferme modal
                    $('#tableActes').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
                }
            }
        });
    });


</script>