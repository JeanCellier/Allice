<%@ include file="../../header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-fiche">Fiches IA</h1>

    <div class="row placeholders">
        <div class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button class="btn btn-primary btn-md" id="addFiche" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>

        </div>
        <div class="col-sm-12 col-md-12" id="contentActesIa" style="padding:30px;">
            <table id="tableActes" class="table table-hover">
                <thead>
                    <tr>
                        <td></td>
                        <td>Nom</td>
                        <td>Programme</td>
                        <td>Date</td>
                        <td>lieu</td>
                        <td>Op&eacuterateur</td>
                        <td>Vache</td>
                        <td>Num&eacutero taureau </td>
                        <td>Statut</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${fichesIaList}" var="fichesIa">
                    <tr>
                        <td></td>
                        <td>${fichesIa.nom}</td>
                        <td>${fichesIa.programme.nom}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${fichesIa.dateHeureMinute}" /></td>
                        <td>${fichesIa.lieu}</td>
                        <td>${fichesIa.insemination.operateur.nom} ${fichesIa.insemination.operateur.prenom}</td>
                        <td>${fichesIa.vache.num_identification}</td>
                        <td>${fichesIa.insemination.taureau}</td>
                        <td>${fichesIa.statut}</td>
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

<!------------------------------ Script Jquery UI--------------------------->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!------------------------------ Script Datatable--------------------------->
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.15/api/fnFindCellRowIndexes.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../../static/css/datables.bootstrap.css"/>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>

<%@ include file="ia_ajouterModifier.jsp" %>
<%@ include file="ia_detail.jsp" %>
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
                        console.log(num);
                        if (num < 10) {
                            numString = '000' + num;
                        } else if (num >= 10 && num < 100) {
                            numString = '00' + num;
                        } else {
                            numString = '0' + num;
                        }
                        nom = date.toString().substr(2, 4) + 'IA' + numString;
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


    $(document).on('click', '#addFiche', function(e) { //au clic sur le bouton add
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
        if(result.objet.dateHeureMinute != null) {
            var dateFiche = convertDate(new Date(result.objet.dateHeureMinute));
        }else{
            var dateFiche = "";
        }

        if(result.objet.programme != null){
            var nomProgramme = result.objet.programme.nom;
        }else{
            var nomProgramme = "";
        }

        var operateur = "";

        if(result.objet.insemination != null){
            if(result.objet.insemination.operateur != null) {
                operateur = result.objet.insemination.operateur.nom + " " + result.objet.insemination.operateur.prenom;
            }
        }

        if(result.objet.insemination != null){
            var taureau = result.objet.insemination.taureau;
        }else{
            var taureau = "";
        }

        /** ajoute une ligne à la table */
        $('#tableActes').DataTable().row.add([
            '      ',
            result.objet.nom,
            nomProgramme,
            dateFiche,
            result.objet.lieu,
            operateur,
            result.objet.vache.num_identification,
            taureau,
            result.objet.statut,
            '<p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p></>',
            '<p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p></>',
            '<p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/' + result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></>'
        ]).draw(false);
    }

    /** init la table */
    $('#tableActes').DataTable({
        "pagingType": "full_numbers",
        "columnDefs": [
            {"orderable": false, "targets": 0},
            {"orderable": false, "targets": 9},
            {"orderable": false, "targets": 10},
            {"orderable": false, "targets": 11},
            {"targets": [8], "visible": false, "searchable": false},
        ], "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
        },
        "pageLength": 25,
        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            if (aData[8] == "1") {
                $("td:eq(0)", nRow).css('background-color', '#DE7E00');
            } else if (aData[8] == "2") {
                $("td:eq(0)", nRow).css('background-color', '#CC3333');
            }else{
                $("td:eq(0)", nRow).css('background-color', '#068b70');
            }
        }
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