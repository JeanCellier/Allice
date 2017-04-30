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
                    <div class="tab-pane active" id="fiche_01">
                        <form name="add" class="addForm" id="addForm" method="post" action="./addOrUpdate">
                            <div class="step1 frm">
                                <fieldset name="identification">
                                    <legend>&Eacute;tape 1/4  -  IDENTIFICATION FICHE</legend>
                                    <div class="form-group">
                                        <input class="form-control nom" name="nom" type="text" placeholder="Nom de la fiche">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Date">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="lieu" type="text" placeholder="Lieu">
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
                                        <input class="form-control" name="numIPE" type="text" placeholder="Num&#233ro IPE">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="numSemence" type="text" placeholder="Num&#233ro de d&#233pot semence">
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" id="vache" name="vache">
                                            <option value="" selected disabled>Vache</option>
                                            <c:forEach items="${vachesList}" var="vache">
                                                <option value="${vache.id}">${vache.num_identification}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <button class="btn btn-primary open1" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step2 frm" style="display: none;">
                                <fieldset name="traitementActe">
                                    <legend>&Eacute;tape 2/4  -  INSEMINATION</legend>

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
                                        <label>Semence sex&#233e : </label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioSexee">Oui</label>
                                        <label class="radio-inline"><input type="radio" class="radio" value="non" name="optradioSexee">Non</label>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" id="taureau" name="taureau">
                                            <option value="" selected disabled>Taureau</option>
                                            <c:forEach items="${vachesList}" var="vache">
                                                <option value="${vache.id}">${vache.num_identification}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control collecteSelect" id="collecte" name="collecte">
                                            <option value="" selected disabled>Collecte</option>
                                            <c:forEach items="${fichesColList}" var="ficheCol">
                                                <option value="${ficheCol.id}">${ficheCol.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="lieuSemence" type="text" placeholder="Lieu de d&#233pot de la semence">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="facilite" type="text" placeholder="Facilit&#233 de progression">
                                    </div>

                                    <button class="btn btn-primary back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step3 frm" style="display: none;">
                                <fieldset name="traitementActe">
                                    <legend>&Eacute;tape 3/4  -  TRAITEMENT FEMELLE</legend>

                                    <div class="form-group">
                                        <input class="form-control" name="typeChaleur" type="text" placeholder="Type chaleur de r&#233f&#233rence">
                                    </div>
                                    <%--<div class="form-group">--%>
                                        <%--<input class="form-control" name="chaleurDetection" type="text" placeholder="D&#233tections des chaleurs">--%>
                                    <%--</div>--%>

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
                                            <input class="form-control" name="quantite[]" type="number" placeholder="Quantite">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="modeTraitement[]" type="text" placeholder="Mode de traitementActe">
                                        </div>
                                    </div>

                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabTraitement" type="button"><span class="fa fa-plus"></span></button>
                                    </div>

                                    <button class="btn btn-primary back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step4 frm" style="display: none;">
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
                                            <input class="form-control" name="resultat[]" type="text" placeholder="R&#233sultat">
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
                            </div>
                        </form>
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
        form.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
        form.find('.tabGestation').not(':first').remove();

        // reinit formulaire
        form.find('input').not(':radio').val("");
        form.find('textarea').val('');
        form.find('.radio').prop('checked', false);
        form.find("select").val("");

        if(form.find('.validButton').removeAttr('data-id')){
            form.find('.validButton').removeAttr('data-id'); //remove l'id
        }
    }

    /****** function nouvel onglet ******/
    function newTab(){
        var id = $(".nav-tabs").children().length; //init id = num de fiche +1

        while($('#fiche_'+id).length){ //tant qu'une fiche ayant le même id
            id += 1;
        }

        var tabId = 'fiche_' + id;

        $('li.tab').last().after('<li class="tab"><a href="#fiche_' + id + '">Nouvelle fiche</a><span> x </span></li>');

        $clone = $('#addForm').clone().removeAttr('id'); //clone et remove l'id

        reinitForm($clone); //reinitialise le clone

        // ajoute les divs a l'arbre html
        $('.tab-content').append('<div class="tab-pane" id="' + tabId + '"></div>');
        $('#'+tabId).append($clone);
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

    /****** Navigation d'étape ******/
    $(document).on( 'click', ".open1", function(){
        $(event.target).closest('form').find(".frm").hide("fast");
        $(event.target).closest('form').find(".step2").show("slow");
    });

    $(document).on( 'click', ".open2", function(){
        $(event.target).closest('form').find(".frm").hide("fast");
        $(event.target).closest('form').find(".step3").show("slow");
    });

    $(document).on( 'click', ".back2", function(){
        $(event.target).closest('form').find(".frm").hide("fast");
        $(event.target).closest('form').find(".step1").show("slow");
    });

    $(document).on( 'click', ".open3", function(){
        $(event.target).closest('form').find(".frm").hide("fast");
        $(event.target).closest('form').find(".step4").show("slow");
    });

    $(document).on( 'click', ".back3", function(){
        $(event.target).closest('form').find(".frm").hide("fast");
        $(event.target).closest('form').find(".step2").show("slow");
    });

    $(document).on( 'click', ".back4", function(){
        $(event.target).closest('form').find(".frm").hide("fast");
        $(event.target).closest('form').find(".step3").show("slow");
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

    /************************ AJOUT *************************/

    /****** Ajoute une nouvelle fiche ******/
    $(document).on( 'submit', ".addForm", function(e){
        e.preventDefault();

        var $this = $(this);
        var data = $this.serialize();
        var id = $this.find('.validButton').attr('data-id');

        /** Si c'est une modif **/
        if(id != null) {
            data = data+'&id='+id
        }

        $.ajax({
            url: $this.attr('action'),
            type: $this.attr('method'),
            data: data,
            success: function (result) {
                if (result.succes == true) {
                    /** clear modal **/
                    reinitForm($this);
                    $("li.active.tab").children('a').text(" Nouvelle fiche");

                    $this.find(".step4").hide("fast");
                    $this.find(".step1").show("slow");

                    $('#modal-body').before('<div class="alert alert-success flash" role="alert">' + result.message + '</div>'); //afficher alert

                    if(id != null){ //Si c'est une modification
                        $('#tableActes').DataTable().row(currentrow).remove().draw();
                    }

                    addRow(result);
                } else {
                    $('#modal-body').before('<div class="alert alert-danger flash" role="alert">' + result.message + '</div>');
                }
                autoclose();
            },
            error: function (xhr, status, error) {
                $('#modal-body').before('<div class="alert alert-danger flash" role="alert">Une erreur s\'est produite</div>');
                autoclose();
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

    /******* Ajoute une ligne tableau traitement_acte donneuse ******/
    $(document).on( 'click', ".addTabTraitement", function(){
        $template = $('#tabTraitement');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.insertAfter($("div.tabTraitement").last());
        createDatePicker();
    });

    /******* Ajoute une ligne tableau gestation ******/
    $(document).on( 'click', ".addTabGestation", function(){
        $template = $('#tabGestation'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.insertAfter($("div.tabGestation").last()); //insert après le dernier object de class tabGestation
        createDatePicker();
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
//                    $activeTab.find( "input[name='chaleurDetection']" ).val(result.objet.traitement_donneuse.typeChaleur);
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