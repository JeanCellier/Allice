<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../../header.jsp" %>


<main class="col-sm-9 col-md-10">
	<h1 class="page-header">Fiche OPU :</h1>

	<div class="row placeholders">
		<div class="col-sm-1 col-md-1">
			<p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
				<button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
					<span class="fa fa-plus"> Ajouter</span>
				</button>
			</p>
		</div>

		<div class="col-sm-12 col-md-12" id="contentOPU" style="padding:30px;">
			<table id="tableActes" class="table table-hover">
				<thead>
				<tr>
					<td></td>
					<td>Nom</td>
					<td>Programme</td>
					<td>N&deg;agrement</td>
					<td>Date OPU</td>
					<td>Lieu</td>
					<td>Vache</td>
					<td>N&deg;de travail</td>
					<td>Status</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${ficheOpuList}" var="ficheOpu">
					<tr>
						<td></td>
						<td>${ficheOpu.nom}</td>
						<td>${ficheOpu.programme.nom}</td>
						<td>${ficheOpu.numeroAgrement}<br></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${ficheOpu.dateHeureMinute}" /><br></td>
						<td>${ficheOpu.lieu}</td>
						<td>${ficheOpu.vache.num_identification}</td>
						<td>${fn:substring(fichesTra.vache.num_identification, 8, 12)}</td>
						<td>${ficheOpu.statut}</td>
						<td><p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-info" data-title="Details" data-id="<c:out value='${ficheOpu.id}' />" data-toggle="modal" data-target="#detail"><span class="glyphicon glyphicon-zoom-in"></span></button></p></td>
						<td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${ficheOpu.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
						<td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${ficheOpu.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	</main>

<!-- Modal delete ficheOpu -->
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

<%@ include file="./opu_ajouterModifier.jsp" %>
<%@ include file="./opu_detail.jsp" %>
<%@ include file="../../footer.jsp" %>

<script>

    var currentrow; //la row courante à delete

    /** function change nom fiche **/
    function changeNom(tab){
        var date = new Date().getFullYear();
        var num;
        if(tab.attr('id') == 'fiche_01') {  //si c'est la 1ère fiche
            console.log("lol");
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
                        nom = date.toString().substr(2, 4) + 'OPU' + numString;
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
            nom = date.toString().substr(2, 4) + 'OPU' + numString;
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

        /** ajoute une ligne à la table */
        $('#tableActes').DataTable().row.add([
            '               ',
            result.objet.nom,
            nomProgramme,
            result.objet.numeroAgrement,
            dateFiche,
            result.objet.lieu,
            result.objet.vache.num_identification,
            result.objet.vache.num_identification.substr(result.objet.vache.num_identification.length - 4),
            result.objet.statut,

            '<p data-placement="top" data-toggle="tooltip" title="Details"><button class="btn btn-primary btn-md btnDetails" data-title="details" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#details" ><span class="glyphicon glyphicon-search"></span></button></p>',
            '<p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="' + result.objet.id + '" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p>',
            '<p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/' + result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>'
        ]).draw(false);
    }

	/** init la table */
	$('#tableActes').DataTable( {
		"pgingType": "full_numbers",
		"columnDefs": [
			{"orderable": false, "targets": 0},
			{"orderable": false, "targets": 9},
			{"orderable": false, "targets": 10},
			{"orderable": false, "targets": 11}
		],"language": {
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
