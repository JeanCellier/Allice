<%@ include file="../header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-header">Cuve Somatique</h1>

    <div class="row placeholders">
        <div id="divAddButton" class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button id="addButton" class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>
        </div>

        <div id="viewCanisterSomatique" class="col-sm-12" style="margin-top:40px;">
            <c:forEach items="${canisterList}" var="canister">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="#" class="canisterLink panel-title pull-left" onclick="toggler('${canister.id}');">Canister numero ${canister.numero}</a>
                            <p data-placement="top" data-toggle="tooltip" title="Modifier" class="pull-right"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${canister.id}' />" data-toggle="modal" data-target="#modify" ><span class="glyphicon glyphicon-pencil"></span></button></p>
                            <p data-placement="top" data-toggle="tooltip" title="Supprimer" class="pull-right" style="margin-right:20px;"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${canister.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>
                            <p data-placement="top" data-toggle="tooltip" title="Add" class="pull-right" style="margin-right:20px;"><button class="btn btn-primary btn-md btn-md" data-title="Add" data-id="<c:out value='${canister.id}' />" data-toggle="modal" data-target="#addVisoTube" ><span class="fa fa-plus"> </span></button></p>
                            <div class="clearfix"></div>
                        </div>

                        <div id="${canister.id}" class="panel-collapse collapse">
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <td>Couleur Viso Tube</td>
                                        <td>Type Cellulaire</td>
                                        <td>Couleur Paillette</td>
                                        <td>Nombre de Pailettes</td>
                                        <td>Date de congelation </td>
                                        <td>Remarques</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${canister.visoTubeList}" var="ligne">
                                        <c:forEach items="${ligne.cellulesSomatiqueList}" var="ligne2">
                                            <tr>
                                                <td>${ligne.couleur}</td>
                                                <td>${ligne2.typeCellulaire}</td>
                                                <td>${ligne2.couleurPaillette}</td>
                                                <td>${ligne2.nbPaillettes}</td>
                                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${ligne2.dateCongelation}" /></td>
                                                <td>${ligne2.remarques}</td>
                                            </tr>
                                        </c:forEach>
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

<!-- Modal add new canister -->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="cellulesSomatiquesadd" aria-hidden="true">
    <div class="modal-dialog modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingAdd">Ajouter un nouveau canister</h4>
            </div>

            <form id="addForm" action="./cellulesSomatiques/add" method="POST">
                <div class="modal-body">
                    <div class="form-group" style="padding-left:0">
                        <input class="form-control" required name="nom" type="text" placeholder="Nom du canister">
                        <input class="form-control" required name="numero" type="text" placeholder="Numero du canister">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success btn-lg" id="addEditButton" style="width: 100%;"><span class="fa fa-check"></span> Valider</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- Modal delete traitement -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingDelete">Supprimer cette entr&#233e</h4>
            </div>

            <div class="modal-body">
                <div class="alert alert-danger"><span class="fa fa-warning-sign"></span> Voulez vous vraiment supprimer cette entr&#233e ?</div>
            </div>

            <div class="modal-footer ">
                <button type="button" id="confirmDelete" class="btn btn-danger" ><span class="fa fa-check"></span> Oui</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="fa fa-remove"></span> Non</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<%@ include file="../footer.jsp" %>

<!------------------------------ Script Jquery UI--------------------------->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<%--<!------------------------------ Script Calendrier--------------------------->--%>
<script type="text/javascript" src="/static/js/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript" src="/static/js/bower_components/moment/locale/fr.js"></script>
<script type="text/javascript" src="/static/js/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="/static/js/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />

<!------------------------------ Script Tableau --------------------------->
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../../static/css/datables.bootstrap.css"/>

<script>

    var currentrow; //la row courante à edit ou delete

    /** function convertion des dates */
    function convertDate(inputFormat) {
    function pad(s) { return (s < 10) ? '0' + s : s; }
    var d = new Date(inputFormat);
    return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
    }

    /****** function init calendrier sans heure ******/
    $('.datepicker').datetimepicker({
    locale: 'fr',
    format: 'DD/MM/YYYY',
    toolbarPlacement:'top',
    showClose:true
    });

    /******* Reinit form on click add ******/
    $(document).on('click', '#addButton', function(){
        reinit();
        $('#addForm').attr('action', './add');
    });

    /******* Ajoute une ligne modal cellule somatique ******/
    $(document).on( 'click', ".addCelluleSomatique", function(){
        $template = $('#cellulesSomatique');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delCelluleSomatique" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.cellulesSomatique").last());
    });

    /******* Supprime une ligne modal cellule somatique ******/
    $(document).on( 'click', ".delCelluleSomatique", function(){
        $(this).closest('.cellulesSomatique').remove();
    });

    /****** hide or show Cellule somatique ******/
    function toggler(divId) {
        $("#" + divId).toggle();
    }

//    /****** reinit modal add ******/
//    function reinit(){
//        $('#add').find('.cellulesSomatique').not(':first').remove(); //garde juste une ligne dans le tableau de cellulesSomatique
//        $('#add').find("select").val("");
//        $('#add').find("input[name='jour[]']").val(0);
//        $('#add').find("input[name!='jour[]']").val("");
//        $('#add').find("input[name='heure[]']").val(0);
//        $('#add').find("input[name!='heure[]']").val("");
//    }

    /****** supprimer alert après 5s ******/
    function autoclose(){
        window.setTimeout(function() {
            $(".flash").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 5000);
    }

    <%--/************************ MODIF *************************/--%>
    <%--$(document).on( 'click', ".btnEdit", function() {--%>
        <%--reinit();--%>
        <%--id = $(this).attr('data-id');--%>

        <%--$.ajax({--%>
            <%--url: "./get/"+id,--%>
            <%--method: 'GET',--%>
            <%--success: function (result) {--%>
                <%--if(result.succes == true) {--%>

                    <%--$('#addForm').attr('action', './edit/'+id);--%>

                    <%--$('#add').find("input[name='nom']").val(result.objet.nom);--%>
                    <%--//remplit modal--%>
                    <%--for(iLigne = 0; iLigne < result.objet.tableauTraitement.length; iLigne++)--%>
                    <%--{--%>
                        <%--if(iLigne == 0){--%>
                            <%--$target = $('#add').find('#tabTraitement');--%>
                        <%--}else{--%>
                            <%--$target = $('#add').find('#tabTraitement').clone().removeAttr('id');--%>
                            <%--$target.insertAfter($('#add').find("div.tabTraitement").last());--%>
                        <%--}--%>

                        <%--$target.find("input[name='jour[]']").val(result.objet.tableauTraitement[iLigne].decalageJour);--%>
                        <%--$target.find("input[name='heure[]']").val(result.objet.tableauTraitement[iLigne].decalageHeure);--%>
                        <%--$target.find("select[name='produit[]']" ).val(result.objet.tableauTraitement[iLigne].produit.id );--%>
                        <%--$target.find("input[name='quantite[]']").val(result.objet.tableauTraitement[iLigne].quantite);--%>
                        <%--$target.find("select[name='modeTraitement[]']").val(result.objet.tableauTraitement[iLigne].mode_traitement);--%>
                    <%--}--%>
                <%--}else{--%>
                    <%--$('#add').modal('toggle'); //ferme modal--%>
                    <%--$('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                    <%--autoclose();--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>

    /************************ SUPPRIMER *************************/

    /** Attribut la ligne courante et l'url de delete */
    $(document).on('click', '.btnDelete', function(e){ //au clic sur le bouton supprimer
        e.preventDefault();

        $('#delete').on('shown.bs.modal', function(e) {
            $(this).find('#confirmDelete').attr('href', $(e.relatedTarget).data('href')); //attribut l'url de delete
        });
    });

    /** Si click sur confirm => supprime la row et l'entrée */
    $(document).on('click', '#confirmDelete', function(e){
        href = $(this).attr('href')
        $.ajax({
            url: href,
            type: $(this).attr('method'),
            success: function (result) {
                if(result.succes == true){
                    $('#delete').modal('toggle'); //ferme modal
                    $('.panel-group').first().before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
                    $('#'+href.substring(9)).closest('.panel-group').remove();
                }else{
                    $('#delete').modal('toggle'); //ferme modal
                    $('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                }
                autoclose();
            }
        });
    });
</script>