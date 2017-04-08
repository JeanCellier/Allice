<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog  modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Renseigner une nouvelle fiche TRA</h4>
            </div>

            <div class="modal-body">
                <ul class="nav nav-tabs" role="tablist" style="margin-bottom: 20px;">
                    <li class="active tab"><a href="#fiche_01" data-toggle="tab">Nouvelle fiche</a><span>x</span></li>
                    <li><a href="#" class="add-fiche">+ Nouvelle fiche</a></li>
                </ul>

                <div class="tab-content" style="margin-top: 20px;">
                    <div class="tab-pane active" id="fiche_01">
                        <form name="add" id="addForm" novalidate method="post" action="./add">
                            <div class="step1 frm">
                                <fieldset name="identification">
                                    <legend>&Eacute;tape 1/5  -  IDENTIFICATION FICHE</legend>
                                    <div class="form-group">
                                        <input class="form-control nom" name="nom" required type="text" placeholder="Nom de la fiche">
                                    </div>
                                    <div class="form-group col-sm-11">
                                        <select class="form-control" name="programme">
                                            <option value="" selected disabled>Programme</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-1">
                                        <button type="button" class="btn btn-primary btn-md addProgramme" data-title="addProgramme" data-toggle="modal" data-target="#addProgramme" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="numAgrement" type="text" placeholder="Num&#233ro d'agr&#233ment">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="lieu" type="text" placeholder="Lieu">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control datepickerTime" name="date" type="text" placeholder="Date">
                                    </div>
                                    <div class="form-group col-sm-11">
                                        <select class="form-control" id="operateur" name="operateur">
                                            <option value="" selected disabled>Op&#233rateur</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-1">
                                        <button type="button" class="btn btn-primary btn-md addOperateur" data-title="addOperateur" data-toggle="modal" data-target="#addOperateur" >
                                            <span class="fa fa-plus"></span>
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" id="vache" name="vache">
                                            <option value="" selected disabled>Vache</option>
                                        </select>
                                    </div>
                                    <button class="btn btn-primary open1" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step2 frm" style="display: none;">
                                <fieldset name="traitement">
                                    <legend>&Eacute;tape 2/5  -  TRAITEMENT RECEVEUSE</legend>

                                    <div class="form-group">
                                        <input class="form-control datepicker"  name="dateChaleur" required type="text" placeholder="Date chaleur de r&#233f&#233rence">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="typeChaleur" type="text" placeholder="Type chaleur de r&#233f&#233rence">
                                    </div>
                                    <div id="tabTraitement" class="tabTraitement">
                                        <div class="form-group col-sm-3">
                                            <input class="form-control datepicker" name="dateTraitement[]" type="text" placeholder="Date">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <select class="form-control" name="produit[]">
                                                <option value="" selected disabled>Produit</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <input class="form-control" name="quantite[]" type="number" placeholder="Quantite">
                                        </div>
                                        <div class="form-group col-sm-3">
                                            <input class="form-control" name="modeTraitement[]" type="text" placeholder="Mode de traitement">
                                        </div>
                                    </div>

                                    <div class="form-group col-sm-1">
                                        <button class="btn btn-primary addTabTraitement" type="button"><span class="fa fa-plus"></span></button>
                                    </div>

                                    <button class="btn btn-warning back2" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open2" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step3 frm" style="display: none;">
                                <fieldset name="corpsJaune">
                                    <legend>&Eacute;tape 3/5  -  &Eacute;VALUATION DU CORPS JAUNE</legend>
                                    <div class="form-group">
                                        <input class="form-control" name="methodeEvaluation" required type="text" placeholder="M&#233thode d'&#233valuation">
                                    </div>
                                    <div class="form-group">
                                        <label>Image(s) &#233chographie : </label>
                                        <label class="radio-inline"><input type="radio" name="optradioEcho">Oui</label>
                                        <label class="radio-inline"><input type="radio" name="optradioEcho">Non</label>
                                    </div>
                                    <div class="form-group">
                                        <label>Cot&#233 du corps jaune : </label>
                                        <label class="radio-inline"><input type="radio" name="optradioCote">Droit</label>
                                        <label class="radio-inline"><input type="radio" name="optradioCote">Gauche</label>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" id="qualite" name="qualite">
                                            <option value="" selected disabled>Qualit&#233</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                    </div>
                                    <button class="btn btn-warning back3" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open3" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step4 frm" style="display: none;">
                                <fieldset name="embryon">
                                    <legend>&Eacute;tape 4/5  -  EMBRYON(S) TRANSF&Eacute;R&Eacute;S</legend>
                                    <div class="form-group">
                                        <input class="form-control" name="referenceExperience" type="text" placeholder="R&#233f&#233rence de l'exp&#233rience">
                                    </div>
                                    <div class="form-group">
                                        <label>Semence sex&#233e : </label>
                                        <label class="radio-inline"><input type="radio" name="optradioSexee">Oui</label>
                                        <label class="radio-inline"><input type="radio" name="optradioSexee">Non</label>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="numEmbryon" type="text" placeholder="Num&#233ro d'embryon">
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" id="vacheEmbryon" name="vacheEmbryon">
                                            <option value="" selected disabled>Taureau</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Cot&#233 transfert : </label>
                                        <label class="radio-inline"><input type="radio" name="optradioCoteTransf">Oui</label>
                                        <label class="radio-inline"><input type="radio" name="optradioCoteTransf">Non</label>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="emplacementCorne" type="text" placeholder="Emplacement dans la corne ut&#233rine">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="faciliteProgression" type="text" placeholder="Facilit&#233 de progression">
                                    </div>
                                    <button class="btn btn-warning back4" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button class="btn btn-primary open4" type="button">Suivant <span class="fa fa-arrow-right"></span></button>
                                </fieldset>
                            </div>

                            <div class="step5 frm" style="display: none;">
                                <fieldset name="gestation">
                                    <legend>&Eacute;tape 5/5  -  SUIVI DE GESTATION</legend>
                                    <div id="tabGestation" class="tabGestation">
                                        <div class="form-group col-sm-3">
                                            <input class="form-control datepicker" name="dateMethode[]" type="text" placeholder="Date">
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <select class="form-control" name="methode[]">
                                                <option value="" selected disabled>M&#233thode</option>
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

                                    <button class="btn btn-warning back5" type="button"><span class="fa fa-arrow-left"></span> Pr&#233c&#233dent</button>
                                    <button type="submit" class="btn btn-success"><span class="fa fa-check"></span> Ajouter</button>
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

<div class="modal fade" id="addProgramme" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingProgramme">Ajouter un nouveau programme</h4>
            </div>

            <form id="addProgrammeForm" action="./addProgramme" method="POST">
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


<div class="modal fade" id="addOperateur" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingOperateur">Ajouter un nouvel op&#233rateur</h4>
            </div>

            <form id="addOperateurForm" action="./addOperateur" method="POST">
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
    $(document).ready(function() {
        /****** function init calendrier avec heure ******/
        $('.datepickerTime').datetimepicker({
            sideBySide : true,
            locale: 'fr',
            toolbarPlacement:'top',
            showClose:true
        });

        /****** function init calendrier sans heure ******/
        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement:'top',
            showClose:true
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

        $(document).on( 'click', ".open4", function(){
            $(event.target).closest('form').find(".frm").hide("fast");
            $(event.target).closest('form').find(".step5").show("slow");
        });

        $(document).on( 'click', ".back4", function(){
            $(event.target).closest('form').find(".frm").hide("fast");
            $(event.target).closest('form').find(".step3").show("slow");
        });

        $(document).on( 'click', ".back5", function(){
            $(event.target).closest('form').find(".frm").hide("fast");
            $(event.target).closest('form').find(".step4").show("slow");
        });
    });

    /****** Système d'onglet ******/
    $(".nav-tabs").on("click", "a", function (e) {
        e.preventDefault();
        if (!$(this).hasClass('add-fiche')) {
            $(this).tab('show');
        }
    })
        .on("click", "span", function () {
            var anchor = $(this).siblings('a');
            $(anchor.attr('href')).remove();
            $(this).parent().remove();
            $(".nav-tabs li").children('a').first().click();
        });

    $('.add-fiche').click(function (e) {
        e.preventDefault();
        var id = $(".nav-tabs").children().length;
        var tabId = 'fiche_' + id;
        $(this).closest('li').before('<li class="tab"><a href="#fiche_' + id + '">Nouvelle fiche</a><span> x </span></li>');
        $template = $('#addForm');
        $clone = $template.clone().removeAttr('id'); //remove l'id
        $clone.find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement
        $clone.find('.tabGestation').not(':first').remove();
        $clone.find('input').val(""); //reinit values input
        $clone.find('.frm').hide(); //cache les form ouvert
        $clone.find('.step1').show(); //affiche l'étape 1 par defaut
        // ajoute les divs a l'arbre html
        $('.tab-content').append('<div class="tab-pane" id="' + tabId + '"></div>');
        $('#'+tabId).append($clone);
        $('.nav-tabs li:nth-child(' + id + ') a').click();

        $('.datepickerTime').datetimepicker({
            sideBySide : true,
            locale: 'fr',
            toolbarPlacement:'top',
            showClose:true
        });

        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement:'top',
            showClose:true
        });
    });

    /******* Ajoute une ligne tableau traitement donneuse ******/
    $(document).on( 'click', ".addTabTraitement", function(){
        $template = $('#tabTraitement');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.insertAfter($("div.tabTraitement").last());
        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement:'top',
            showClose:true
        });
    });

    /******* Ajoute une ligne tableau gestation ******/
    $(document).on( 'click', ".addTabGestation", function(){
        $template = $('#tabGestation'); //tableau a copier
        $clone = $template.clone().removeAttr('id'); //supprime l'id sur la copie
        $clone.find('input').val(""); //reinit les values
        $clone.insertAfter($("div.tabGestation").last()); //insert après le dernier object de class tabGestation
        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement:'top',
            showClose:true
        });
    });

    /****** Change le nom de l'onglet ******/
    $(document).on( 'keyup', ".nom", function(){
        $("li.active.tab").children('a').text($(this).closest(".nom").val());
    });
</script>