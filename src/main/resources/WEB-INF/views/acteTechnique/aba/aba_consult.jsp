<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../../header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-header">Fiches ABA</h1>

    <div class="row placeholders">
        <div class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>

        </div>
        <div class="col-sm-12 col-md-12" id="contentAba" style="padding:30px;">
            <table id="tableABA" class="table table-hover">
                <thead>
                <tr>
                    <td>Nom</td>
                    <td>Programme</td>
                    <td>Date</td>
                    <td>N&deg; agrement</td>
                    <td>Abattoir</td>
                    <td>Operateur</td>
                    <td>T&deg; Arrivee</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${fichesABAList}" var="fichesABA">
                    <tr>
                        <td>${fichesABA.nom}</td>
                        <td>${fichesABA.programme.nom}<br></td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${fichesABA.dateHeureMinute}" /><br></td>
                        <td>${fichesABA.numeroAgrement}</td>
                        <td>${fichesABA.abattoir.nom}<br></td>
                        <td>${fichesABA.operateur.nom} ${fichesABA.operateur.prenom}<br></td>
                        <td>${fichesABA.temperatureArrivee}<br></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-info" data-title="Details" data-id="<c:out value='${fichesABA.id}'/>" data-toggle="modal" data-target="#detail" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${fichesABA.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${fichesABA.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>

<!-- Modal delete ficheABA -->
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

<!------------------------------ Script Jquery UI--------------------------->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!------------------------------ Script Datatable--------------------------->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../../static/css/datables.bootstrap.css"/>

<%@ include file="./aba_ajouterModifier.jsp" %>
<%@ include file="./aba_detail.jsp" %>
<%@ include file="../../footer.jsp" %>

<script>
    var currentrow; //la row courante à edit ou delete

    /** function change nom fiche **/
    function changeNom(tab){
        var date = new Date().getFullYear();
        var num;
        if(tab.attr('id') == 'fiche_01') {  //si c'est la 1ère fiche
            $.ajax({
                url: "./get/lastName",
                type: 'GET',
                success: function (result) {
                    if(result != "") {
                        num = parseInt(result.substr(5)) + 1;
                        if (num < 10) {
                            numString = '000' + num;
                        } else if (num >= 10 && num < 100) {
                            numString = '00' + num;
                        } else {
                            numString = '0' + num;
                        }
                        nom = date.toString().substr(2, 4) + 'TRA' + numString;
                        tab.find("input[name='nom']").val(nom);
                        $("li.active.tab").children('a').text(nom);
                    }
                },
            });
        }else{ //si le nom doit être récupéré sur les fiches précédentes
            num = parseInt(($('.tab-pane.add').last().find("input[name='nom']").val()).substr(5)) + 1;
            if (num < 10) {
                numString = '000' + num;
            } else if (num >= 10 && num < 100) {
                numString = '00' + num;
            } else {
                numString = '0' + num;
            }
            nom = date.toString().substr(2, 4) + 'TRA' + numString;
            tab.find("input[name='nom']").val(nom);

            $('a[href="#'+tab.attr("id")+'"]').text(nom);
        }
    }

    $(document).on('click', '#addFiche', function(e) { //au clic sur le bouton supprimer
        if($('#fiche_01').find("input[name='nom']").val() ==''){
            changeNom($('#fiche_01'));
        }
    });

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
        $('#tableABA').DataTable().row.add([
            "<td>" + result.objet.nom + "</td>",
            "<td>" + result.objet.programme.nom + "</td>",
            "<td>" + convertDate(dateFiche) + "</td>",
            "<td>" + result.objet.numeroAgrement + "</td>",
            "<td>" + result.objet.abattoir.nom + "</td>",
            "<td>" + result.objet.operateur.nom +" "+ result.objet.operateur.prenom + "</td>",
            "<td>" + result.objet.temperatureArrivee + "</td>",

            '<td><p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p></td>',
            '<td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>',
            '<td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/' + result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>'
        ]).draw(false);
    }

    /** init la table */
    $('#tableABA').DataTable( {
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
                    $('#tableABA').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
                    $('#tableABA').DataTable().row(currentrow).remove().draw();
                }else{
                    $('#delete').modal('toggle'); //ferme modal
                    $('#tableABA').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                }
                autoclose();
            }
        });
    });
</script>