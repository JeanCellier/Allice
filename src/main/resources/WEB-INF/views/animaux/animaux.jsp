<%@ include file="../header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-header">Animaux</h1>

    <div class="row placeholders">
        <div class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>

        </div>
        <div class="col-sm-12 col-md-12" id="contentAnimaux" style="padding:30px;">
            <table id="tableAnimaux" class="table table-hover">
                <thead>
                <tr>
                    <td>Propri&#233taire</td>
                    <td>Num&#233ro d'&#233levage</td>
                    <td>Num&#233ro d'identification</td>
                    <td>Num&#233ro de travail</td>
                    <td>Race</td>
                    <td>Date d'arriv&#233e</td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vacheList}" var="vache">
                    <tr>
                        <td>${vache.proprietaire}</td>
                        <td>${vache.num_elevage}</td>
                        <td>${vache.num_identification}</td>
                        <%--<td>${substring(vache.num_identification, 5, 15)}</td>--%>
                        <td></td>
                        <td>${vache.race}</td>
                        <%--<td><fmt:formatDate pattern="dd/MM/yyyy" value="${vache.date_arrivee}" /><br></td>--%>
                        <td></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${vache.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${vache.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<!-- Modal add new cow -->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Ajouter un nouvel animal</h4>
            </div>

            <div class="modal-body">
                <form id="addForm" action="./add" method="POST">
                    <div class="form-group">
                        <input class="form-control nom" name="proprietaire" required type="text" placeholder="Propri&#233taire">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="num_elevage" type="text" placeholder="Num&#233ro d'&#233levage">
                    </div>
                    <div class="form-group">
                        <input class="form-control fournisseur" name="num_identification" type="text" placeholder="Num&#233ro d'identification">
                    </div>
                    <div class="form-group">
                        <input class="form-control projet" name="num_travail" type="text" placeholder="Num&#233ro de travail">
                    </div>
                    <div class="form-group">
                        <input class="form-control responsable" name="race" type="text" placeholder="Race">
                    </div>
                    <div class="form-group">
                        <input class="form-control datepicker" name="date_arrivee" type="text" placeholder="Date d'arriv&#233e">
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

<!-- Modal edit animal -->
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Modifier l'animal</h4>
            </div>

            <div class="modal-body">
                <form id="editForm" action="./edit" method="POST">
                    <div class="form-group">
                        <input class="form-control nom" id="nom" name="proprietaire" required type="text" placeholder="Propri&#233taire">
                    </div>
                    <div class="form-group">
                        <input class="form-control " name="num_elevage" type="text" placeholder="Num&#233ro d'&#233levage">
                    </div>
                    <div class="form-group">
                        <input class="form-control fournisseur" name="num_identification" type="text" placeholder="Num&#233ro d'identification">
                    </div>
                    <div class="form-group">
                        <input class="form-control projet" name="num_travail" type="text" placeholder="Num&#233ro de travail">
                    </div>
                    <div class="form-group">
                        <input class="form-control responsable" name="race" type="text" placeholder="Race">
                    </div>
                    <div class="form-group">
                        <input class="form-control datepicker" name="date_arrivee" type="text" placeholder="Date d'arriv&#233e">
                    </div>

                    <div class="modal-footer ">
                        <button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal delete animal -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Supprimer cet animal</h4>
            </div>

            <div class="modal-body">
                <div class="alert alert-danger"><span class="fa fa-warning-sign"></span> Voulez vous vraiment supprimer cet animal ?</div>
            </div>

            <div class="modal-footer ">
                <button type="button" id="confirmDelete" class="btn btn-danger" ><span class="fa fa-check"></span> Oui</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="fa fa-remove"></span> Non</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="../static/js/datepicker-fr.js"></script>
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

    /** function init calendrier */
    $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );

    $( function() {
        $( ".datepicker" ).each(function() {
            $( this ).datepicker();
        });
    } );

    /** function addRow */
    function addRow(result) {
        //converti date bon format
        //var date_arrivee = new Date(result.objet.date_arrivee);

        /** ajoute une ligne à la table */
        $('#tableAnimaux').DataTable().row.add([
            "<td>" + result.objet.proprietaire + "</td>",
            "<td>" + result.objet.num_elevage + "</td>",
            "<td>" + result.objet.num_identification + "</td>",
            "<td>" + result.objet.num_identification.substr(result.objet.vache.num_identification.length - 4) + "</td>",
            "<td>" + result.objet.race + "</td>",
//            "<td>" + convertDate(date_arrivee) + "</td>",
            "<td>" + "</td>",

            '<td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="'+ result.objet.id +'" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>',
            '<td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/'+ result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>'
        ]).draw(false);
    }


    /** init la table */
    $('#tableAnimaux').DataTable( {
        "pagingType": "full_numbers",
        "columnDefs": [
            { "orderable": false, "targets": 6},
            { "orderable": false, "targets": 7 }
        ],"language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
        },
        "pageLength": 25
    });

    /************************ AJOUT *************************/

    /** Ajoute un nouvel animal */
    $('#addForm').on('submit', function(e) {
        e.preventDefault();

        var $this = $(this);

        $.ajax({
            url: $this.attr('action'),
            type: $this.attr('method'),
            data: $this.serialize(),
            success: function(result) {
                if(result.succes == true){
                    $('input').val(''); //clear modal
                    $('#add').modal('toggle'); //ferme modal
                    $('#tableAnimaux').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
                    addRow(result);
                }else{
                    $('#addForm').before('<div class="alert alert-danger flash" role="alert">'+result.message+'</div>');
                }
                autoclose();
            }
        });
    });

    /************************ Modif *************************/

    /** Attribue la ligne courante et rempli le modal */
    $(document).on( 'click', ".btnEdit", function(){
        id = $(this).data('id');
        currentrow = $(this).closest('tr'); //get la row parent

        $.ajax({
            url: "./get/"+id,
            method: 'GET',
            success: function (result) {
                if(result.succes == true) {
                    $('#edit')
                        .find('[name="proprietaire"]').val(result.objet.proprietaire).end()
                        .find('[name="num_elevage"]').val(result.objet.num_elevage).end()
                        .find('[name="num_identification"]').val(result.objet.num_identification).end()
                        .find('[name="num_travail"]').val(result.objet.num_identification.substr(result.objet.vache.num_identification.length - 4)).end()
                        .find('[name="race"]').val(result.objet.race).end()
                        .find('[name="date_arrivee"]').val(convertDate(result.objet.date_arrivee)).end();


                    $('#editForm').attr('action', "./edit/"+id);
                }else{
                    $('#edit').modal('toggle'); //ferme modal
                    $('#tableAnimaux').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
                }
            }
        });
    });

    /** Effectue les modifs si validation */
    $('#editForm').on('submit', function(e) {
        e.preventDefault();

        $.ajax({
            url: $(this).attr('action'),//+"/"+id,
            type: $(this).attr('method'),
            data: $(this).serialize(),
            success: function (result) {
                if(result.succes == true){
                    $('input').val('');
                    $('#edit').modal('toggle');
                    $('#tableAnimaux').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>');
                    $('#tableAnimaux').DataTable().row(currentrow).remove().draw();
                    addRow(result);
                }else{
                    $('#editForm').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>');
                }
                autoclose();
            }
        });
    });

    /************************ SUPPRIMER *************************/

    /** Attribut la ligne courante et l'url de delete */
    $(document).on('click', '.btnDelete', function(e){ //au clic sur le bouton supprimer
        e.preventDefault();

        currentrow = $(this).closest('tr'); //get la row parent

        $('#delete').on('shown.bs.modal', function(e) {
            $(this).find('#confirmDelete').attr('href', $(e.relatedTarget).data('href')); //attribut l'url de delete
        });
    });

    /** Si click sur confirm => supprime la row et l'entrée */
    $(document).on('click', '#confirmDelete', function(e){
        $.ajax({
            url: $(this).attr('href'),
            type: $(this).attr('method'),
            success: function (result) {
                if(result.succes == true){
                    $('#delete').modal('toggle'); //ferme modal
                    $('#tableAnimaux').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
                    $('#tableAnimaux').DataTable().row(currentrow).remove().draw();
                }else{
                    $('#delete').modal('toggle'); //ferme modal
                    $('#tableAnimaux').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert

                }
                autoclose();
            }
        });
    });

    /** supprimer alert après 5s */
    function autoclose(){
        window.setTimeout(function() {
            $(".flash").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 5000);
    }


    /******************************* AUTOCOMPLETE ****************************/
    <%--$( ".nom" ).autocomplete({--%>
        <%--source: '${pageContext. request. contextPath}/animaux/get/names'--%>
    <%--});--%>

    <%--$( ".fournisseur" ).autocomplete({--%>
        <%--source: '${pageContext. request. contextPath}/animaux/get/fournisseurs'--%>
    <%--});--%>

    <%--$( ".projet" ).autocomplete({--%>
        <%--source: '${pageContext. request. contextPath}/animaux/get/projets'--%>
    <%--});--%>

    <%--$( ".responsable" ).autocomplete({--%>
        <%--source: '${pageContext. request. contextPath}/animaux/get/responsables'--%>
    <%--});--%>

    $.when($('#tableAnimaux').on( 'change')).done(function() {
        if($(window).width() > 768) {
            $('.sidebar').height($(document).height());
        }
    });
</script>