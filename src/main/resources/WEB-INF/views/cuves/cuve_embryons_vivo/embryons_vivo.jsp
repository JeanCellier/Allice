<%@ include file="../../header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-header">Cuve Embryons In Vivo</h1>

    <div class="row placeholders">
        <div id="divAddButton" class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button id="addButton" class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>
        </div>

        <div id="viewCanisterSemence" class="col-sm-12" style="margin-top:40px;">
            <c:forEach items="${canisterList}" var="canister">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="#" class="canisterLink panel-title pull-left" onclick="toggler('${canister.id}');">Canister numero ${canister.numero}</a>
                            <p data-placement="top" data-toggle="tooltip" title="Modifier" class="pull-right"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${canister.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p>
                            <p data-placement="top" data-toggle="tooltip" title="Supprimer" class="pull-right" style="margin-right:20px;"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${canister.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>
                                <%--<p data-placement="top" data-toggle="tooltip" title="Details" class="pull-right" style="margin-right:20px;"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="<c:out value='${canister.id}' />" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p>--%>
                            <div class="clearfix"></div>
                        </div>

                        <div id="${canister.id}" class="panel-collapse collapse">
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <td>Couleur Viso Tube</td>
                                        <td>Race Taureau</td>
                                        <td>Numero Taureau</td>
                                        <td>Nom Taureau</td>
                                        <td>Nombre de Paillettes</td>
                                        <td>Couleur Paillette</td>
                                        <td></td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${canister.visoTubeList}" var="ligne">
                                        <tr>
                                            <td>${ligne.couleur}</td>
                                            <td>${ligne.semence.raceTaureau}</td>
                                            <td>${ligne.semence.numTaureau}</td>
                                            <td>${ligne.semence.nomTaureau}</td>
                                            <td>${ligne.semence.nbPaillettes}</td>
                                            <td>${ligne.semence.couleurPaillette}</td>
                                            <td><p data-placement="top" data-toggle="tooltip" title="Supprimer Viso Tube"><button class=" btnDeleteViso btn btn-danger btn-md" data-href="./deleteviso/<c:out value='${ligne.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#deleteviso" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<%--<!-- Modal add new canister -->--%>
<%--<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="semencesFIVadd" aria-hidden="true">--%>
    <%--<div class="modal-dialog modal-large">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="HeadingAdd">Ajouter un nouveau canister</h4>--%>
            <%--</div>--%>

            <%--<form id="addForm" action="./semences_fiv/add" method="POST">--%>
                <%--<div class="modal-body">--%>
                    <%--<div class="form-group" style="padding-left:0">--%>
                        <%--<input class="form-control" required name="nom" type="text" placeholder="Nom du canister">--%>
                        <%--<input class="form-control" required name="numero" type="text" placeholder="Numero du canister">--%>
                    <%--</div>--%>

                    <%--<div class="semencesFIV" id="semencesFIV">--%>
                        <%--<div class="form-group col-sm-2" style="padding-left:0">--%>
                            <%--<input class="form-control"  name="couleur[]" type="text" placeholder="Couleur du Viso Tube">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2" style="padding-left:0">--%>
                            <%--<input class="form-control"  name="raceTaureau[]" type="text" placeholder="Race Taureau">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2" style="padding-left:0">--%>
                            <%--<input class="form-control"  name="numTaureau[]" type="text" placeholder="Numero Taureau">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2">--%>
                            <%--<input class="form-control"  name="nomTaureau[]" type="text" placeholder="Nom Taureau">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2">--%>
                            <%--<input class="form-control"  name="nbpaillette[]" step="1" type="number" placeholder="Nombre de Paillettes">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2">--%>
                            <%--<input class="form-control"  name="couleurpaillette[]" type="text" placeholder="Couleur Paillette">--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<label>Semence sex&#233e : </label>--%>
                            <%--<label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioSexee">Oui</label>--%>
                            <%--<label class="radio-inline"><input type="radio" class="radio" value="non" checked name="optradioSexee">Non</label>--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-11">--%>
                            <%--<input class="form-control"  name="remarques[]" type="text" placeholder="Remarques">--%>
                        <%--</div>--%>

                    <%--</div>--%>
                    <%--<div class="form-group col-sm-1">--%>
                        <%--<button class="btn btn-primary addSemencesFIV" type="button"><span class="fa fa-plus"></span></button>--%>
                    <%--</div>--%>


                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="submit" class="btn btn-success btn-lg" id="addEditButton" style="width: 100%;"><span class="fa fa-check"></span> Valider</button>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--<!-- /.modal-content -->--%>
    <%--</div>--%>
    <%--<!-- /.modal-dialog -->--%>
<%--</div>--%>

<%--<!-- Modal edit new canister -->--%>
<%--<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="semencesFIVedit" aria-hidden="true">--%>
    <%--<div class="modal-dialog modal-large">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="HeadingEdit">Editer un canister</h4>--%>
            <%--</div>--%>

            <%--<form id="editForm" action="./semences_fiv/edit" method="POST">--%>
                <%--<div class="modal-body">--%>
                    <%--<div class="form-group" style="padding-left:0">--%>
                        <%--<input class="form-control" required name="nom" type="text" placeholder="Nom du canister">--%>
                        <%--<input class="form-control" required name="numero" type="text" placeholder="Numero du canister">--%>
                    <%--</div>--%>

                    <%--<div class="semencesFIV" id="semencesFIV">--%>
                        <%--<div class="form-group col-sm-2" style="padding-left:0">--%>
                            <%--<input class="form-control"  name="couleur[]" type="text" placeholder="Couleur du Viso Tube">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2" style="padding-left:0">--%>
                            <%--<input class="form-control"  name="raceTaureau[]" type="text" placeholder="Race Taureau">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2" style="padding-left:0">--%>
                            <%--<input class="form-control"  name="numTaureau[]" type="text" placeholder="Numero Taureau">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2">--%>
                            <%--<input class="form-control"  name="nomTaureau[]" type="text" placeholder="Nom Taureau">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2">--%>
                            <%--<input class="form-control"  name="nbpaillette[]" step="1" type="number" placeholder="Nombre de Paillettes">--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-2">--%>
                            <%--<input class="form-control"  name="couleurpaillette[]" type="text" placeholder="Couleur Paillette">--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<label>Semence sex&#233e : </label>--%>
                            <%--<label class="radio-inline"><input type="radio" class="radio" value="oui" name="optradioSexee">Oui</label>--%>
                            <%--<label class="radio-inline"><input type="radio" class="radio" value="non" checked name="optradioSexee">Non</label>--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-sm-11">--%>
                            <%--<input class="form-control" required name="remarques[]" type="text" placeholder="Remarques">--%>
                        <%--</div>--%>

                    <%--</div>--%>
                    <%--<div class="form-group col-sm-1">--%>
                        <%--<button class="btn btn-primary editSemencesFIV" type="button"><span class="fa fa-plus"></span></button>--%>
                    <%--</div>--%>


                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="submit" class="btn btn-success btn-lg" id="EditButton" style="width: 100%;"><span class="fa fa-check"></span> Valider</button>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--<!-- /.modal-content -->--%>
    <%--</div>--%>
    <%--<!-- /.modal-dialog -->--%>
<%--</div>--%>

<%--<!-- Modal delete Canister -->--%>
<%--<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="HeadingDelete">Supprimer cette entr&#233e</h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<div class="alert alert-danger"><span class="fa fa-warning-sign"></span> Voulez vous vraiment supprimer cette entr&#233e ?</div>--%>
            <%--</div>--%>

            <%--<div class="modal-footer ">--%>
                <%--<button type="button" id="confirmDelete" class="btn btn-danger" ><span class="fa fa-check"></span> Oui</button>--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal"><span class="fa fa-remove"></span> Non</button>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<!-- /.modal-content -->--%>
    <%--</div>--%>
    <%--<!-- /.modal-dialog -->--%>
<%--</div>--%>

<%--<!-- Modal delete Viso Tube -->--%>
<%--<div class="modal fade" id="deleteviso" tabindex="-1" role="dialog" aria-labelledby="deleteviso" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="HeadingDeleteViso">Supprimer cette entr&#233e</h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<div class="alert alert-danger"><span class="fa fa-warning-sign"></span> Voulez vous vraiment supprimer cette entr&#233e ?</div>--%>
            <%--</div>--%>

            <%--<div class="modal-footer ">--%>
                <%--<button type="button" id="confirmDeleteViso" class="btn btn-danger" ><span class="fa fa-check"></span> Oui</button>--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal"><span class="fa fa-remove"></span> Non</button>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<!-- /.modal-content -->--%>
    <%--</div>--%>
    <%--<!-- /.modal-dialog -->--%>
<%--</div>--%>

<%--&lt;%&ndash;<!-- Modal details fiche tra -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="modal fade " id="details" tabindex="-1" role="dialog" aria-labelledby="details" aria-hidden="true">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="modal-dialog modal-large">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="modal-content">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="modal-header">&ndash;%&gt;--%>
<%--&lt;%&ndash;<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h4 class="modal-title custom_align" id="HeadingDetails"></h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="modal-body">&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="row details">&ndash;%&gt;--%>
<%--&lt;%&ndash;<fieldset>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Couleur Viso Tube : </label><span id="couleur[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Race Taureau : </label><span id="raceTaureau[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Nom taureau : </label><span id="nomTaureau[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Numero Taureau : </label><span id="numTaureau[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Nombre de Paillettes : </label><span id="nbpaillette[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-6">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Couleur Paillette: </label><span id="couleurpaillette[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Semence sex&eacute;e : </label><span id="semenceSexee[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-sm-6">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label>Remarques : </label><span id="remarques[]"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;</fieldset>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- /.modal-content -->&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- /.modal-dialog -->&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--<%@ include file="../../footer.jsp" %>--%>

<%--<!------------------------------ Script Jquery UI--------------------------->--%>
<%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
<%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>

<%--&lt;%&ndash;&lt;%&ndash;<!------------------------------ Script Calendrier--------------------------->&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<script type="text/javascript" src="/static/js/bower_components/moment/min/moment.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script type="text/javascript" src="/static/js/bower_components/moment/locale/fr.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script type="text/javascript" src="/static/js/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<link rel="stylesheet" href="/static/js/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />&ndash;%&gt;--%>

<%--<!------------------------------ Script Tableau --------------------------->--%>
<%--<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>--%>
<%--<link rel="stylesheet" type="text/css" media="all" href="../../static/css/datables.bootstrap.css"/>--%>

<%--<script>--%>

    <%--var currentrow; //la row courante à edit ou delete--%>


    <%--/******* Reinit form on click add ******/--%>
    <%--$(document).on('click', '#addButton', function(){--%>
<%--//        reinit();--%>
        <%--$('#addForm').attr('action', './semences_fiv/add');--%>
    <%--});--%>

    <%--/******* Ajoute une ligne modal semences FIV ******/--%>
    <%--$(document).on( 'click', ".addSemencesFIV", function(){--%>
        <%--$template = $('#semencesFIV');--%>
        <%--$clone = $template.clone().removeAttr('id');--%>
        <%--$clone.find('input').val("");--%>
        <%--$clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delSemencesFIV" type="button"><span class="fa fa-minus"></span></button></div>');--%>
        <%--$clone.insertAfter($("div.semencesFIV").last());--%>
    <%--});--%>

    <%--/******* Ajoute une ligne modal semences FIV ******/--%>
    <%--$(document).on( 'click', ".editSemencesFIV", function(){--%>
        <%--$template = $('#semencesElevage');--%>
        <%--$clone = $template.clone().removeAttr('id');--%>
        <%--$clone.find('input').val("");--%>
        <%--$clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delSemencesFIV" type="button"><span class="fa fa-minus"></span></button></div>');--%>
        <%--$clone.insertAfter($("div.semencesFIV").last());--%>
    <%--});--%>

    <%--/******* Supprime une ligne modal semences FIV  ******/--%>
    <%--$(document).on( 'click', ".delSemencesFIV", function(){--%>
        <%--$(this).closest('.semencesFIV').remove();--%>
    <%--});--%>

    <%--/****** hide or show semences FIV  ******/--%>
    <%--function toggler(divId) {--%>
        <%--$("#" + divId).toggle();--%>
    <%--}--%>

    <%--//    /****** reinit modal add ******/--%>
    <%--//    function reinit(){--%>
    <%--//        $('#add').find('.semencesFIV').not(':first').remove(); //garde juste une ligne dans le tableau de viso tube--%>
    <%--//        $('#add').find("select").val("");--%>
    <%--//    }--%>

    <%--/****** supprimer alert apr�s 5s ******/--%>
    <%--function autoclose(){--%>
        <%--window.setTimeout(function() {--%>
            <%--$(".flash").fadeTo(500, 0).slideUp(500, function(){--%>
                <%--$(this).remove();--%>
            <%--});--%>
        <%--}, 5000);--%>
    <%--}--%>

    <%--/************************ MODIF *************************/--%>
    <%--$(document).on( 'click', ".btnEdit", function() {--%>
<%--//        reinit();--%>
        <%--id = $(this).attr('data-id');--%>

        <%--$.ajax({--%>
            <%--url: "./get/"+id,--%>
            <%--method: 'GET',--%>
            <%--success: function (result) {--%>
                <%--if(result.succes == true) {--%>

                    <%--$('#editForm').attr('action', './edit/'+id);--%>
                    <%--$('#edit').find("input[name='nom']").val(result.objet.nom);--%>
                    <%--$('#edit').find("input[name='numero']").val(result.objet.numero);--%>
                    <%--//remplit modal--%>
                    <%--for(iLigne = 0; iLigne < result.objet.visoTubeList.length; iLigne++)--%>
                    <%--{--%>
                        <%--if(iLigne == 0){--%>
                            <%--$target = $('#edit').find('#semencesFIV');--%>
                        <%--}else{--%>
                            <%--$target = $('#edit').find('#semencesFIV').clone().removeAttr('id');--%>
                            <%--$target.insertAfter($('#edit').find("div.semencesFIV").last());--%>
                        <%--}--%>
                        <%--$target.find("input[name='couleur[]']").val(result.objet.visoTubeList[iLigne].couleur);--%>
                        <%--$target.find("input[name='raceTaureau[]']").val(result.objet.visoTubeList[iLigne].semence.raceTaureau);--%>
                        <%--$target.find("input[name='numTaureau[]']" ).val(result.objet.visoTubeList[iLigne].semence.numTaureau);--%>
                        <%--$target.find("input[name='nomTaureau[]']").val(result.objet.visoTubeList[iLigne].semence.nomTaureau);--%>
                        <%--$target.find("input[name='nbpaillette[]']").val(result.objet.visoTubeList[iLigne].semence.nbPaillettes);--%>
                        <%--$target.find("input[name='couleurpaillette[]']").val(result.objet.visoTubeList[iLigne].semence.couleurPaillette);--%>
                        <%--if(result.objet.visoTubeList[iLigne].semence.sexee == false) {--%>
                            <%--$target.find('#semenceSexee').text(' Non');--%>
                        <%--}--%>
                        <%--if(result.objet.visoTubeList[iLigne].semence.sexee == true) {--%>
                            <%--$target.find('#semenceSexee').text(' Oui');--%>
                        <%--}--%>
<%--//                        $target.find("input[name='sexee[]']").val(result.objet.visoTubeList[iLigne].semence.sexee);--%>
                        <%--$target.find("input[name='remarques[]']").val(result.objet.visoTubeList[iLigne].semence.remarques);--%>

                    <%--}--%>
                <%--}else{--%>
                    <%--$('#edit').modal('toggle'); //ferme modal--%>
                    <%--$('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                    <%--autoclose();--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>

    <%--/************************ SUPPRIMER *************************/--%>

    <%--/** Attribut la ligne courante et l'url de delete */--%>
    <%--$(document).on('click', '.btnDelete', function(e){ //au clic sur le bouton supprimer--%>
        <%--e.preventDefault();--%>

        <%--$('#delete').on('shown.bs.modal', function(e) {--%>
            <%--$(this).find('#confirmDelete').attr('href', $(e.relatedTarget).data('href')); //attribut l'url de delete--%>
        <%--});--%>
    <%--});--%>

    <%--/** Si click sur confirm => supprime la row et l'entr�e */--%>
    <%--$(document).on('click', '#confirmDelete', function(e){--%>
        <%--href = $(this).attr('href')--%>
        <%--$.ajax({--%>
            <%--url: href,--%>
            <%--type: $(this).attr('method'),--%>
            <%--success: function (result) {--%>
                <%--if(result.succes == true){--%>
                    <%--$('#delete').modal('toggle'); //ferme modal--%>
                    <%--$('.panel-group').first().before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                    <%--$('#'+href.substring(9)).closest('.panel-group').remove();--%>
                <%--}else{--%>
                    <%--$('#delete').modal('toggle'); //ferme modal--%>
                    <%--$('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                <%--}--%>
                <%--autoclose();--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>

    <%--/************************ SUPPRIMER VISO TUBE*************************/--%>

    <%--/** Attribut la ligne courante et l'url de delete */--%>
    <%--$(document).on('click', '.btnDeleteViso', function(e){ //au clic sur le bouton supprimer--%>
        <%--e.preventDefault();--%>
        <%--currentrow = $(e.target).closest('tr');--%>

        <%--$('#deleteviso').on('shown.bs.modal', function(e) {--%>
            <%--$(this).find('#confirmDeleteViso').attr('href', $(e.relatedTarget).data('href')); //attribut l'url de delete--%>
        <%--});--%>
    <%--});--%>

    <%--/** Si click sur confirm => supprime la row et l'entr�e */--%>
    <%--$(document).on('click', '#confirmDeleteViso', function(e){--%>
        <%--href = $(this).attr('href')--%>
        <%--$.ajax({--%>
            <%--url: href,--%>
            <%--type: $(this).attr('method'),--%>
            <%--success: function (result) {--%>
                <%--if(result.succes == true){--%>
                    <%--$('#deleteviso').modal('toggle'); //ferme modal--%>
                    <%--$('.panel-body').first().before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                    <%--currentrow.remove();--%>

                <%--}else{--%>
                    <%--$('#deleteviso').modal('toggle'); //ferme modal--%>
                    <%--$('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                <%--}--%>
                <%--autoclose();--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>

    <%--//    /** Rempli le modal details */--%>
    <%--//    $(document).on( 'click', ".btnDetails", function(){--%>
    <%--//        id = $(this).attr('data-id');--%>
    <%--//--%>
    <%--//        $.ajax({--%>
    <%--//            url: "./get/"+id,--%>
    <%--//            method: 'GET',--%>
    <%--//            success: function (result) {--%>
    <%--//                if(result.succes == true) {--%>
    <%--//--%>
    <%--//                    for(iLigne = 0; iLigne < result.objet.visoTubeList.length; iLigne++)--%>
    <%--//                    {--%>
    <%--//                        $('#details')--%>
    <%--//                            .find('#HeadingDetails').text(' D\u00e9tails du canister ' + result.objet.nom).end()--%>
    <%--//                            .find('#couleur[]').text(' ' + convertDateWithTime(val(result.objet.visoTubeList[iLigne].couleur)).end()--%>
    <%--//                            .find('#raceTaureau[]').text(' ' + result.objet.visoTubeList[iLigne].semence.raceTaureau).end()--%>
    <%--//                            .find('#nomTaureau[]').text(' ' + result.objet.visoTubeList[iLigne].semence.nomTaureau).end()--%>
    <%--//                            .find('#numTaureau[]').text(' ' + result.objet.visoTubeList[iLigne].semence.numTaureau).end()--%>
    <%--//                            .find('#nbpaillette[]').text(' ' + result.objet.visoTubeList[iLigne].semence.nbPaillettes).end()--%>
    <%--//                            .find('#couleurpaillette[]').text(' ' + result.objet.visoTubeList[iLigne].semence.couleurPaillette).end()--%>
    <%--//                            .find('#remarques[]').text(' ' + result.objet.visoTubeList[iLigne].semence.remarques).end()--%>
    <%--//--%>
    <%--//                        if (result.objet.insemination.semenceSexee == false) {--%>
    <%--//                            $('#details').find('#semenceSexee[]').text(' Non');--%>
    <%--//                        }--%>
    <%--//                        if (result.objet.insemination.semenceSexee == true) {--%>
    <%--//                            $('#details').find('#semenceSexee[]').text(' Oui');--%>
    <%--//                        }--%>
    <%--//--%>
    <%--//                    }--%>
    <%--//                }else{--%>
    <%--//                    $('#details').modal('toggle'); //ferme modal--%>
    <%--//                    $('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
    <%--//                    autoclose();--%>
    <%--//                }--%>
    <%--//            }--%>
    <%--//        });--%>
    <%--//    });--%>

<%--</script>--%>