<%@ include file="../../header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-fiche">Fiches IA</h1>

    <div class="row placeholders">
        <div class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>

        </div>
        <div class="col-sm-12 col-md-12" id="contentActesIa" style="padding:30px;">
            <table id="tableActes" class="table table-hover">
                <thead>
                    <tr>
                        <td>Nom</td>
                        <td>Programme</td>
                        <td>Date</td>
                        <td>lieu</td>
                        <td>Num&eacutero IPE</td>
                        <td>Num&eacutero d&eacutepot semence</td>
                        <td>Vache</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${fichesIaList}" var="fichesIa">
                    <tr>
                        <td>${fichesIa.nom}</td>
                        <td>${fichesIa.programme.nom}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${fichesIa.dateHeureMinute}" /></td>
                        <td>${fichesIa.lieu}</td>
                        <td>${fichesIa.numIpe}</td>
                        <td>${fichesIa.numDepotSemence}</td>
                        <td>${fichesIa.vache.num_identification}</td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="<c:out value='${fichesIa.id}' />" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${fichesIa.id}' />" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${fichesIa.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>

<!-- Modal delete ficheIa -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Supprimer cette entr&#233e</h4>
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

<%@ include file="ia_ajouterModifier.jsp" %>
<%@ include file="ia_detail.jsp" %>
<%@ include file="../../footer.jsp" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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

    function convertDateWithTime(inputFormat){
        function pad(s) { return (s < 10) ? '0' + s : s; }
        var d = new Date(inputFormat);
        var dateFormat = [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');

        return dateFormat+' '+d.getHours()+'h'+d.getMinutes();
    }

    /** supprimer alert après 5s */
    function autoclose(){
        window.setTimeout(function() {
            $(".flash").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 5000);
    }

    /** function addRow */
    function addRow(result) {
        //converti date bon format
        var dateFiche = new Date(result.objet.dateHeureMinute);

        /** ajoute une ligne à la table */
        $('#tableActes').DataTable().row.add([
            result.objet.nom ,
            result.objet.programme.nom,
            convertDate(dateFiche),
            result.objet.lieu,
            result.objet.numIpe,
            result.objet.numDepotSemence,
            result.objet.vache.num_identification,

            '<p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p></>',
            '<p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p></>',
            '<p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/' + result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></>'
        ]).draw(false);
    }

    /** init la table */
    $('#tableActes').DataTable( {
        "pagingType": "full_numbers",
        "columnDefs": [
            { "orderable": false, "targets": 7},
            { "orderable": false, "targets": 8},
            { "orderable": false, "targets": 9}
        ],"language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
        },
        "pageLength": 25
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
                    $('#tableActes').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
                    $('#tableActes').DataTable().row(currentrow).remove().draw(false);
                }else{
                    $('#delete').modal('toggle'); //ferme modal
                    $('#tableActes').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                }
                autoclose();
            }
        });
    });
</script>