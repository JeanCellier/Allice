<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog  modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingAdd">Saisir ou modifier un animal</h4>
            </div>

            <div id="modal-body" class="modal-body">
                <ul class="nav nav-tabs" role="tablist" style="margin-bottom: 20px;">
                    <li class="active tab"><a href="#vache_01" data-toggle="tab">Nouvel animal</a></li>
                    <li><a href="#" class="add-vache">+ Nouvel animal</a></li>
                </ul>

                <div class="tab-content" style="margin-top: 20px;">
                    <div class="tab-pane active add" id="fiche_01">
                        <div class="step1 frm">
                            <form name="addPart1" class="addOrUpdatePart" method="post" action="./addOrUpdatePart1">
                                <fieldset name="identification">
                                    <legend>&Eacute;tape 1/5  -  IDENTIFICATION ANIMAL</legend>
                                    <div class="form-group">
                                        <input class="form-control nom required" required name="numeroIdentification" required type="text" placeholder="Num&#233ro d'identification">
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
                                        <input class="form-control" name="race" type="number" required placeholder="Race">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="dateNaissance" required type="text" placeholder="Date naissance">
                                    </div>
                                    <div class="form-group">
                                        <label>Pr&#233sent : </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="oui" name="present">Oui</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="non" name="present">Non</label>
                                    </div>
                                    <button class="btn btn-primary open1" type="submit">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step2 frm" style="display: none;">
                            <form name="addPart2" class="addOrUpdatePart" method="post" action="./addOrUpdatePart2">
                                <fieldset name="origineAnimal">
                                    <legend>&Eacute;tape 2/5  -  ORIGINE ANIMAL</legend>

                                    <div class="form-group">
                                        <input class="form-control" name="num_pere" type="text" placeholder="Num&#233ro père">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="num_mere" type="text" placeholder="Num&#233ro mère">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="provenance" type="text" value="FR" placeholder="Provenance">
                                    </div>

                                    <button class="btn btn-primary back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step3 frm" style="display: none;">
                            <form name="addPart3" class="addOrUpdatePart" method="post" action="./addOrUpdatePart3">
                                <fieldset name="entreeRepro">
                                    <legend>&Eacute;tape 3/5  -  ENTR&Eacute;E ET REPRODUCTION</legend>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="entreeQuarantaine" type="text" placeholder="Date d'entr&#233e en quarantaine">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="entreeStation" type="text" placeholder="Date d'entr&#233e à la station">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="derniereMiseRepro" type="text" placeholder="Date dernière mise à la reproduction">
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="modeReproduction">
                                            <option value="" selected disabled>Mode de reproduction</option>
                                            <option value="IA">IA</option>
                                            <option value="TE">TE</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>DG: </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="0" name="dg">0</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="1" name="dg">1</label>
                                    </div>
                                    <button class="btn btn-primary back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step4 frm" style="display: none;">
                            <form name="addPart4" class="addOrUpdatePart" method="post" action="./addOrUpdatePart4">
                                <fieldset name="Destination">
                                    <legend>&Eacute;tape 4/5  -  DESTINATION</legend>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="sortieStation" type="text" placeholder="Date de sortie station">
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="destinaton">
                                            <option value="" selected disabled>Destination</option>
                                            <option value="boucherie">Boucherie</option>
                                            <option value="mort">Mort</option>
                                            <option value="equarissage">Equarissage</option>
                                            <option value="pension">Pension</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-sm-11 col-xs-11" style="padding-left:0">
                                        <select class="form-control destinataireSelect" name="destinataire">
                                            <option value="" selected disabled>Destinataire</option>
                                            <c:forEach items="${destinataireList}" var="destinataire">
                                                <option value="${destinataire.id}">${destinataire.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-1 col-xs-1">
                                        <button type="button" class="btn btn-primary btn-md addDestinataire" data-title="addDestinataire" data-toggle="modal" data-target="#addDestinataire" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="sortiePension" type="text" placeholder="Date de sortie de pension">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="venduA" type="text" placeholder="Vendu à">
                                    </div>
                                    <button class="btn btn-primary back4" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open4" type="submit">Enregistrer <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </form>
                        </div>

                        <div class="step5 frm" style="display: none;">
                            <form name="addPart5" class="addOrUpdatePart" method="post" action="./addOrUpdatePart5">
                                <fieldset name="remarques">
                                    <legend>&Eacute;tape 5/5  -  REMARQUES</legend>
                                    <div class="form-group">
                                        <textarea class="form-control" name="remarques" rows="5" placeholder="Remarques"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="emco" type="text" placeholder="EMCO">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="emvi" type="text" placeholder="EMVI">
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
<div class="modal fade" id="addDestinataire" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingDestinataire">Ajouter un nouveau destinataire</h4>
            </div>

            <form id="addDestinataireForm" action="../../destinataire/add" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <input class="form-control" name="nomDestinataire" type="text" placeholder="Nom du destinataire">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="adresseDestinataire" type="text" placeholder="Adresse du destinataire">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="typeDestination" type="text" placeholder="Type de destination">
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
        /*form.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
        form.find('.tabGestation').not(':first').remove();*/

        // reinit formulaire
        form.find('input').not(':radio').val("");
        form.find('textarea').val('');
        form.find('.radio').prop('checked', false);
        form.find("select").val("");

        /*form.find('input[name="numAgrement"]').val("FR TB/PB 370");
        form.find('input[name="lieu"]').val("Allice Nouzilly");*/
    }

    /****** function nouvel onglet ******/
    <%--function newTab(){--%>
        <%--var id = $(".nav-tabs").children().length; //init id = num de fiche +1--%>

        <%--while($('#vache_'+id).length){ //tant qu'une fiche ayant le même id--%>
            <%--id += 1;--%>
        <%--}--%>

        <%--var tabId = 'vache_' + id;--%>

        <%--$('li.tab').last().after('<li class="tab"><a href="#fiche_' + id + '">Nouvel animal</a><span> x </span></li>');--%>

        <%--$clone = $('#vache_01').clone().removeAttr('id'); //clone et remove l'id--%>

        <%--reinitForm($clone); //reinitialise le clone--%>

        <%--// ajoute les divs a l'arbre html--%>
        <%--$clone.attr('id', tabId);--%>

        <%--changeNom($clone); //change le nom de l'onglet--%>

        <%--&lt;%&ndash;$clone.find('input.vache').autocomplete({ //active l'autompletion sur "vache"&ndash;%&gt;--%>
            <%--&lt;%&ndash;minLength: 4,&ndash;%&gt;--%>
            <%--&lt;%&ndash;source: '${pageContext. request. contextPath}/animaux/get/vache'&ndash;%&gt;--%>
        <%--&lt;%&ndash;});&ndash;%&gt;--%>

        <%--$('.tab-content').append($clone);--%>
        <%--$('.nav-tabs li').find('a[href="#'+tabId+'"]').click();--%>

        <%--$clone.find(".frm").hide("fast");--%>
        <%--$clone.find(".step1").show("slow");--%>

        <%--createDateTimePicker();--%>
        <%--createDatePicker();--%>
    <%--}--%>

    createDateTimePicker(); //init les calendriers avec heure
    createDatePicker(); //init les calendriers sans heure

    /****** Change le nom de l'onglet ******/
//    $(document).on( 'keyup', ".nom", function(){
//        $("li.active.tab").children('a').text($(this).closest(".nom").val());
//    });

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
//    $(".nav-tabs").on("click", "a", function (e) { //met au premier plan un contenu d'onglet
//        e.preventDefault();
//        if (!$(this).hasClass('add-vache')) { //si c'est l'onglet d'ajout d'onglet
//            $(this).tab('show');
//        }
//    })
//        .on("click", "span", function () { //close un onglet
//            var anchor = $(this).siblings('a');
//            $(anchor.attr('href')).remove();
//            $(this).parent().remove();
//            $(".nav-tabs li").children('a').first().click();
//        });
//
//    /****** evenement creer un onglet ******/
//    $(document).on('click', '.add-vache', function (e) {
//        e.preventDefault();
//        newTab();
//    });

    <%--$(document).on( 'change', 'select[name="acteDonneuse"]', function(event){--%>
        <%--if($('select[name="acteDonneuse"] option:selected').val() != ""){--%>
            <%--$.ajax({--%>
                <%--url: '${pageContext. request. contextPath}/traitement/get/'+this.value,--%>
                <%--type: 'GET',--%>
                <%--success: function (result) {--%>
                    <%--if (result.succes == true) {--%>
                        <%--$('div.tab-pane.active').find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte--%>
                        <%--for(iLigne = 0; iLigne < result.objet.tableauTraitement.length; iLigne++)--%>
                        <%--{--%>
                            <%--if(iLigne == 0){--%>
                                <%--$target = $('div.tab-pane.active').find('.tabTraitement');--%>
                                <%--$target.find('input').val("");--%>
                                <%--$target.find("select").val("");--%>
                            <%--}else{--%>
                                <%--$target = $('div.tab-pane.active').find('#tabTraitement').clone().removeAttr('id');--%>
                                <%--$target.find('input').val("");--%>
                                <%--$target.find("select").val("");--%>
                                <%--$target.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');--%>
                                <%--$target.insertAfter($('div.tab-pane.active').find("div.tabTraitement").last());--%>
                            <%--}--%>

                            <%--$target.find("input[name='dateTraitement[]']").datetimepicker({--%>
                                <%--locale: 'fr',--%>
                                <%--format: 'DD/MM/YYYY',--%>
                                <%--toolbarPlacement: 'top',--%>
                                <%--showClose: true--%>
                            <%--});--%>

                            <%--$target.find("select[name='produit[]']" ).val(result.objet.tableauTraitement[iLigne].produit.id );--%>
                            <%--$target.find("input[name='quantite[]']").val(result.objet.tableauTraitement[iLigne].quantite);--%>
                            <%--$target.find("select[name='modeTraitement[]']").val(result.objet.tableauTraitement[iLigne].mode_traitement);--%>
                        <%--}--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>
    <%--});--%>

    <%--$(document).on( 'blur', "input[name='dateTraitement[]']:first", function() {--%>
        <%--Date.prototype.addDays = function(days) { //ajoute des jours--%>
            <%--var dat = new Date(this.valueOf());--%>
            <%--dat.setDate(dat.getDate() + days);--%>
            <%--return dat;--%>
        <%--}--%>
        <%--function parseDate(input) { // fr to en--%>
            <%--var parts = input.split('/');--%>
            <%--return new Date(parts[2]+"/"+parts[1]+"/"+parts[0]); // Note: months are 0-based--%>
        <%--}--%>

        <%--if($('select[name="acteDonneuse"] option:selected').val() != ""){--%>
            <%--$.ajax({--%>
                <%--url: '${pageContext. request. contextPath}/traitement/get/'+$('select[name="acteDonneuse"]').val(),--%>
                <%--type: 'GET',--%>
                <%--success: function (result) {--%>
                    <%--if (result.succes == true) {--%>
                        <%--for(iLigne = 1; iLigne < result.objet.tableauTraitement.length; iLigne++) {--%>
                            <%--var date = new Date(parseDate($("input[name='dateTraitement[]']:first").val())).addDays(result.objet.tableauTraitement[iLigne].decalage);--%>
                            <%--$("input[name='dateTraitement[]']:eq("+iLigne+")").data("DateTimePicker").date(date);--%>
                        <%--}--%>

                    <%--}--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>
    <%--});--%>

//    /******* Ajoute une ligne tableau traitement_acte donneuse ******/
//    $(document).on( 'click', ".addTabTraitement", function(){
//        $template = $('#tabTraitement');
//        $clone = $template.clone().removeAttr('id');
//        $clone.find('input').val("");
//        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
//        $clone.insertAfter($("div.tabTraitement").last());
//        createDatePicker();
//    });
//
//    /******* Ajoute une ligne tableau gestation ******/
//    $(document).on( 'click', ".addTabGestation", function(){
//        $template = $('#tabGestation'); //tableau a copier
//        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
//        $clone.find('input').val(""); //reinit les values
//        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabGestation" type="button"><span class="fa fa-minus"></span></button></div>');
//        $clone.insertAfter($("div.tabGestation").last()); //insert après le dernier object de class tabGestation
//        createDatePicker();
//    });
//
//    /******* Supprime une ligne modal traitement ******/
//    $(document).on( 'click', ".delTabTraitement", function(){
//        $(this).closest('.tabTraitement').remove();
//    });
//
//    /******* Supprime une ligne modal gestation ******/
//    $(document).on( 'click', ".delTabGestation", function(){
//        $(this).closest('.tabGestation').remove();
//    });

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
                    var table = $('#tableAnimaux').DataTable(); //init pour changer value .cell.data
                    var rowId = $('#tableAnimaux').dataTable().fnFindCellRowIndexes(result.objet.num_identification, 0); // cherche fiche modifiée

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
                                table.cell(rowId, 5).data(result.objet.programme.nom).draw(false);
                            }
                            table.cell(rowId, 1).data(result.objet.num_identification).draw(false);
                            table.cell(rowId, 2).data(result.objet.num_travail).draw(false);
                            table.cell(rowId, 3).data(result.objet.vache.race).draw(false);
                            table.cell(rowId, 4).data(result.objet.vache.ageMois).draw(false);
                        }
                    }

                    if($this.closest('div.frm').hasClass('step5')) { //si étape 5
                        /** clear modal **/
                        reinitForm($this.closest('.tab-pane'));

                        $("li.active.tab").children('a').text(" Nouvel animal");

                        $this.closest('div.tab-pane.active').find(".step5").hide("fast");
                        $this.closest('div.tab-pane.active').find(".step1").show("slow");
                    }

//                    if(rowId.length == 1) { //si le nom de la fiche est présent
//                        //Modifie le statut
//                        table.cell(rowId, 7).data(result.objet.statut).draw(false);
//                    }
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

    /******* Ajoute un nouveau destinataire ******/
    $('#addDestinataireForm').on('submit', function(e) {
        e.preventDefault();

        var $this = $(this);

        $.ajax({
            url: $this.attr('action'),
            type: $this.attr('method'),
            data: $this.serialize(),
            success: function(result) {
                if(result.succes == true){
                    $('#addDestinataire').find('input').val(''); //clear modal
                    $('#addDestinataire').modal('toggle'); //ferme modal

                    $('.destinataireSelect').append($('<option>', {
                        value: result.objet.id,
                        text: result.objet.nom
                    }));

                    $(".tab-pane.active").find('.destinataireSelect').val(result.objet.id);
                }
            }
        });
    });

    /************************ MODIF *************************/
    $(document).on( 'click', ".btnEdit", function() {
        if($('#vache_01').find("input[name='nom']").val() ==''){
            changeNom($('#vache_01'));
        }

        id = $(this).attr('data-id');

        $.ajax({
            url: "./get/"+id,
            method: 'GET',
            success: function (result) {
                if(result.succes == true) {
                    //newTab();
                    $activeTab = $('div.tab-pane.active');

                    $activeTab.removeClass('add'); //identifie la tab comme un tab d'édition

                    $activeTab.find('form[name="addPart1"]').attr('action', $activeTab.find('form[name="addPart1"]').attr('action')+"/"+id); //attribue l'id au modal
                    $activeTab.find('form[name="addPart1"]').addClass('EditForm');

                    //change le nom de l'onglet
                    $("li.active.tab").children('a').text(result.objet.nom);

                    /*************************** REMPLI MODAL ***************************/

                    /************* STEP 1 *************/
                    $activeTab.find("input[name='numeroIdentification']" ).val(result.objet.num_identification);
                    if(result.objet.programme != null) {
                        $activeTab.find("select[name='programme']").val(result.objet.programme.id);
                    }

                    $activeTab.find( "input[name='race']" ).val(result.objet.race);
                    if(result.objet.dateNaissance != null) {
                        $activeTab.find("input[name='dateNaissance']").data("DateTimePicker").date(new Date(result.objet.dateNaissance));
                    }

                    if(result.objet.present === 0) {
                        $activeTab.find("input[name='present'][value='non']").prop('checked', true);
                    }
                    if(result.objet.present === 1) {
                        $activeTab.find("input[name='present'][value='oui']").prop('checked', true);
                    }

                    /************* STEP 2 *************/

                    $activeTab.find( "input[name='num_pere']" ).val(result.objet.numPere);
                    $activeTab.find( "input[name='num_mere']" ).val(result.objet.numMere);
                    $activeTab.find( "input[name='provenance']" ).val(result.objet.num_elevage);
                    $activeTab.find( "input[name='race']" ).val(result.objet.race);

                    /************* STEP 3 *************/
                    if(result.objet.dateDerniereMiseRepro != null) {
                        $activeTab.find("input[name='derniereMiseRepro']").data("DateTimePicker").date(new Date(result.objet.dateNaissance));
                    }
                    if(result.objet.entreeStation != null) {
                        $activeTab.find("input[name='entreeStation']").data("DateTimePicker").date(new Date(result.objet.entreeStation));
                    }
                    if(result.objet.entreeQuarantaine != null) {
                        $activeTab.find("input[name='entreeQuarantaine']").data("DateTimePicker").date(new Date(result.objet.entreeQuarantaine));
                    }
                    if(result.objet.DG01 === 0) {
                        $activeTab.find("input[name='dg'][value='0']").prop('checked', true);
                    }
                    if(result.objet.DG01 === 1) {
                        $activeTab.find("input[name='dg'][value='1']").prop('checked', true);
                    }
                    $activeTab.find( "select[name='modeReproduction']" ).val(result.objet.modeReproduction);

                    /************* STEP 4 *************/
                    if(result.objet.sortieStation != null) {
                        $activeTab.find("input[name='sortieStation']").data("DateTimePicker").date(new Date(result.objet.sortieStation));
                    }
                    $activeTab.find( "input[name='destination']" ).val(result.objet.destination);
                    if(result.objet.sortiePension != null) {
                        $activeTab.find("input[name='sortiePension']").data("DateTimePicker").date(new Date(result.objet.sortiePension));
                    }
                    $activeTab.find( "input[name='venduA']" ).val(result.objet.venduA);
                    if(result.objet.destinataire != null) {
                        $activeTab.find("select[name='destinataire']").val(result.objet.destinataire.id);
                    }

                    /************* STEP 5 *************/
                    $activeTab.find( "input[name='remarques']" ).val(result.objet.remarques);
                    $activeTab.find( "input[name='emco']" ).val(result.objet.EMCO);
                    $activeTab.find( "input[name='emvi']" ).val(result.objet.EMVI);
                }else{
                    $('#add').modal('toggle'); //ferme modal
                    $('#tableAnimaux').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
                }
            }
        });
    });

    /******************************* AUTOCOMPLETE ****************************/
    <%--$( ".vache" ).autocomplete({--%>
        <%--minLength: 4,--%>
        <%--source: '${pageContext. request. contextPath}/animaux/get/vache'--%>
    <%--});--%>

</script>