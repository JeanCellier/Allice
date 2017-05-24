<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    <td>Num&#233ro d'identification</td>
                    <td>Num&#233ro de travail</td>
                    <td>Race</td>
                    <td>Age(mois)</td>
                    <td>Projet concern&#233</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vacheList}" var="vache">
                    <tr>
                        <td>${vache.num_identification}</td>
                        <td>${vache.num_travail}</td>
                        <td>${vache.race}</td>
                        <td>${vache.ageMois}</td>
                        <td>${vache.programme.nom}</td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="<c:out value='${vache.id}' />" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${vache.id}' />" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${vache.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>

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

<!------------------------------ Script Jquery UI--------------------------->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!------------------------------ Script Datatable--------------------------->
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.15/api/fnFindCellRowIndexes.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../../static/css/datables.bootstrap.css"/>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>

<%@ include file="./animaux_ajouterModifier.jsp" %>
<%@ include file="./animaux_detail.jsp" %>
<%@ include file="../footer.jsp" %>

<script>
    console.log("ALALLLLLAAL");

    var currentrow; //la row courante à delete

    /** function convertion des dates */
    function convertDate(inputFormat) {
        function pad(s) { return (s < 10) ? '0' + s : s; }
        var d = new Date(inputFormat);
        return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
    }

    console.log("ALALLLLLAAL");


    /** function init calendrier */
    $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );

    $( function() {
        $( ".datepicker" ).each(function() {
            $( this ).datepicker();
        });
    } );
    console.log("ALALLLLLAAL");

    /** supprimer alert après 5s */
    function autoclose(){
        window.setTimeout(function() {
            $(".flash").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 5000);
    }
    console.log("ALALLLLLAAL");

    /** function addRow */
    function addRow(result) {
        //converti date bon format
        //var date_arrivee = new Date(result.objet.date_arrivee);

        /** ajoute une ligne à la table */
        $('#tableAnimaux').DataTable().row.add([
            result.objet.num_identification ,
            result.objet.num_travail,
            result.objet.race ,
            result.objet.ageMois,
            result.objet.programme.nom ,

            '<p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p>',
            '<p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="'+ result.objet.id +'" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p>',
            '<p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/'+ result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>'
        ]).draw(false);
    }

    console.log("ALALLLLLAAL");

    /** init la table */
    $('#tableAnimaux').DataTable( {
        "pagingType": "full_numbers",
        "columnDefs": [
            { "orderable": false, "targets": 4},
            { "orderable": false, "targets": 5 }
        ],"language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
        },
        "pageLength": 25
    });

    console.log("ALALLLLLAAL");


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
        console.log("ALOOOOOOOOOOOOOOO");
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
</script>