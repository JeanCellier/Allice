<%@ include file="../../header.jsp" %>

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
                            <p data-placement="top" data-toggle="tooltip" title="Modifier" class="pull-right"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${canister.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p>
                            <p data-placement="top" data-toggle="tooltip" title="Supprimer" class="pull-right" style="margin-right:20px;"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${canister.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>
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
                                        <td></td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${canister.visoTubeList}" var="ligne">
                                        <tr>
                                            <td>${ligne.couleur}</td>
                                            <td>${ligne.celluleSomatique.typeCellulaire}</td>
                                            <td>${ligne.celluleSomatique.couleurPaillette}</td>
                                            <td>${ligne.celluleSomatique.nbPaillettes}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${ligne.celluleSomatique.dateCongelation}" /></td>
                                            <td>${ligne.celluleSomatique.remarques}</td>
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

                    <div class="cellulesSomatique" id="cellulesSomatique">
                        <div class="form-group col-sm-2" style="padding-left:0">
                            <input class="form-control" required name="couleur[]" type="text" placeholder="Couleur du Viso Tube">
                        </div>

                        <div class="form-group col-sm-2" style="padding-left:0">
                            <input class="form-control" required name="type[]" type="text" placeholder="Type cellulaire">
                        </div>

                        <div class="form-group col-sm-2" style="padding-left:0">
                            <input class="form-control"  name="couleurpaillette[]" type="text" placeholder="Couleur Paillette">
                        </div>

                        <div class="form-group col-sm-2">
                            <input class="form-control"  name="nbpaillette[]" step="1" type="number" placeholder="Nombre Paillettes">
                        </div>

                        <div class="form-group col-sm-2">
                            <input class="form-control datepicker"  name="date[]" type="date" placeholder="Date congelation">
                        </div>

                        <div class="form-group col-sm-11">
                            <input class="form-control"  name="remarques[]" type="text" placeholder="Remarques">
                        </div>

                    </div>
                    <div class="form-group col-sm-1">
                        <button class="btn btn-primary addCelluleSomatique" type="button"><span class="fa fa-plus"></span></button>
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

<!-- Modal edit new canister -->
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="cellulesSomatiquesedit" aria-hidden="true">
    <div class="modal-dialog modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingEdit">Editer un canister</h4>
            </div>

            <form id="editForm" action="./cellulesSomatiques/edit" method="POST">
                <div class="modal-body">
                    <div class="form-group" style="padding-left:0">
                        <input class="form-control" required name="nom" type="text" placeholder="Nom du canister">
                        <input class="form-control" required name="numero" type="text" placeholder="Numero du canister">
                    </div>

                    <div class="cellulesSomatique" id="cellulesSomatique">
                        <div class="form-group col-sm-2" style="padding-left:0">
                            <input class="form-control" required name="couleur[]" type="text" placeholder="Couleur du Viso Tube">
                        </div>

                        <div class="form-group col-sm-2" style="padding-left:0">
                            <input class="form-control" required name="type[]" type="text" placeholder="Type cellulaire">
                        </div>

                        <div class="form-group col-sm-2" style="padding-left:0">
                            <input class="form-control" required name="couleurpaillette[]" type="text" placeholder="Couleur Paillette">
                        </div>

                        <div class="form-group col-sm-2">
                            <input class="form-control" required name="nbpaillette[]" step="1" type="number" placeholder="Nombre Paillettes">
                        </div>

                        <div class="form-group col-sm-2">
                            <input class="form-control datepicker" required name="date[]" type="date" placeholder="Date congelation">
                        </div>

                        <div class="form-group col-sm-11">
                            <input class="form-control" required name="remarques[]" type="text" placeholder="Remarques">
                        </div>

                    </div>
                    <div class="form-group col-sm-1">
                        <button class="btn btn-primary editCelluleSomatique" type="button"><span class="fa fa-plus"></span></button>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success btn-lg" id="EditButton" style="width: 100%;"><span class="fa fa-check"></span> Valider</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- Modal delete Canister -->
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

<!-- Modal delete Viso Tube -->
<div class="modal fade" id="deleteviso" tabindex="-1" role="dialog" aria-labelledby="deleteviso" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingDeleteViso">Supprimer cette entr&#233e</h4>
            </div>

            <div class="modal-body">
                <div class="alert alert-danger"><span class="fa fa-warning-sign"></span> Voulez vous vraiment supprimer cette entr&#233e ?</div>
            </div>

            <div class="modal-footer ">
                <button type="button" id="confirmDeleteViso" class="btn btn-danger" ><span class="fa fa-check"></span> Oui</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="fa fa-remove"></span> Non</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%@ include file="../../footer.jsp" %>

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
        $('#addForm').attr('action', './cellulesSomatiques/add');
    });

    /******* Ajoute une ligne modal cellule somatique ******/
    $(document).on( 'click', ".addCelluleSomatique", function(){
        $template = $('#cellulesSomatique');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delCelluleSomatique" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.cellulesSomatique").last());
        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement:'top',
            showClose:true
        });
    });

    /******* Ajoute une ligne modal cellule somatique ******/
    $(document).on( 'click', ".editCelluleSomatique", function(){
        $template = $('#cellulesSomatique');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delCelluleSomatique" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.cellulesSomatique").last());
        $('.datepicker').datetimepicker({
            locale: 'fr',
            format: 'DD/MM/YYYY',
            toolbarPlacement:'top',
            showClose:true
        });
    });

    /******* Supprime une ligne modal cellule somatique ******/
    $(document).on( 'click', ".delCelluleSomatique", function(){
        $(this).closest('.cellulesSomatique').remove();
    });

    /****** hide or show Cellule somatique ******/
    function toggler(divId) {
        $("#" + divId).toggle();
    }

    /****** reinit modal add ******/
    function reinit(){
        $('#add').find('.cellulesSomatique').not(':first').remove(); //garde juste une ligne dans le tableau de viso tube
        $('#add').find("select").val("");
        $('#add').find("input[name='jour[]']").val(0);
        $('#add').find("input[name!='jour[]']").val("");
        $('#add').find("input[name='heure[]']").val(0);
        $('#add').find("input[name!='heure[]']").val("");
    }

    /****** supprimer alert apr�s 5s ******/
    function autoclose(){
        window.setTimeout(function() {
            $(".flash").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 5000);
    }

    /************************ MODIF *************************/
    $(document).on( 'click', ".btnEdit", function() {
        reinit();
        id = $(this).attr('data-id');

        $.ajax({
            url: "./get/"+id,
            method: 'GET',
            success: function (result) {
                if(result.succes == true) {

                    $('#editForm').attr('action', './edit/'+id);
                    $('#edit').find("input[name='nom']").val(result.objet.nom);
                    $('#edit').find("input[name='numero']").val(result.objet.numero);
                    //remplit modal
                    for(iLigne = 0; iLigne < result.objet.visoTubeList.length; iLigne++)
                    {
                        if(iLigne == 0){
                            $target = $('#edit').find('#cellulesSomatique');
                        }else{
                            $target = $('#edit').find('#cellulesSomatique').clone().removeAttr('id');
                            $target.insertAfter($('#edit').find("div.cellulesSomatique").last());
                        }
                        $target.find("input[name='couleur[]']").val(result.objet.visoTubeList[iLigne].couleur);
                        $target.find("input[name='type[]']").val(result.objet.visoTubeList[iLigne].celluleSomatique.typeCellulaire);
                        $target.find("input[name='couleurpaillette[]']" ).val(result.objet.visoTubeList[iLigne].celluleSomatique.couleurPaillette);
                        $target.find("input[name='nbpaillette[]']").val(result.objet.visoTubeList[iLigne].celluleSomatique.nbPaillettes);
                        $target.find("input[name='date[]']").val(convertDate(result.objet.visoTubeList[iLigne].celluleSomatique.dateCongelation));
                        $target.find("input[name='remarques[]']").val(result.objet.visoTubeList[iLigne].celluleSomatique.remarques);
                    }
                }else{
                    $('#edit').modal('toggle'); //ferme modal
                    $('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
                }
            }
        });
    });

    /************************ SUPPRIMER *************************/

    /** Attribut la ligne courante et l'url de delete */
    $(document).on('click', '.btnDelete', function(e){ //au clic sur le bouton supprimer
        e.preventDefault();

        $('#delete').on('shown.bs.modal', function(e) {
            $(this).find('#confirmDelete').attr('href', $(e.relatedTarget).data('href')); //attribut l'url de delete
        });
    });

    /** Si click sur confirm => supprime la row et l'entr�e */
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

    /************************ SUPPRIMER VISO TUBE*************************/

    /** Attribut la ligne courante et l'url de delete */
    $(document).on('click', '.btnDeleteViso', function(e){ //au clic sur le bouton supprimer
        e.preventDefault();
        currentrow = $(e.target).closest('tr');

        $('#deleteviso').on('shown.bs.modal', function(e) {
            $(this).find('#confirmDeleteViso').attr('href', $(e.relatedTarget).data('href')); //attribut l'url de delete
        });
    });

    /** Si click sur confirm => supprime la row et l'entr�e */
    $(document).on('click', '#confirmDeleteViso', function(e){
        href = $(this).attr('href')
        $.ajax({
            url: href,
            type: $(this).attr('method'),
            success: function (result) {
                if(result.succes == true){
                    $('#deleteviso').modal('toggle'); //ferme modal
                    $('.panel-body').first().before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
                    currentrow.remove();

                }else{
                    $('#deleteviso').modal('toggle'); //ferme modal
                    $('.panel-group').first().before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                }
                autoclose();
            }
        });
    });
</script>