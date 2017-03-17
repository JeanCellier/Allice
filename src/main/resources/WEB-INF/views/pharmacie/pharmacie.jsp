<%@ include file="../header.jsp" %>

<main class="col-md-10">
	<h1 class="page-header">Pharmacie</h1>

	<div class="row placeholders">
		<div class="sm-1 col-md-1">
			<p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
				<button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
					<span class="fa fa-plus"> Ajouter</span>
				</button>
			</p>

		</div>
		<div class="col-md-12" id="contentPharmacie" style="padding:30px;">
			<table id="tableProduit" class="table table-hover">
				<thead>
					<tr>
						<td>Nom</td>
						<td>Date de d&eacutelivrance</td>
						<td>Fournisseur</td>
						<td>Projet</td>
						<td>Responsable</td>
						<td>Qte entrante</td>
						<td>Qte restante</td>
						<td>N&deg; de lot</td>
						<td>Date de p&eacuteremption</td>
						<td></td>
                        <td></td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${produitList}" var="produit">
					<tr>
						<td>${produit.nom}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${produit.dateDelivrance}" /><br></td>
						<td>${produit.fournisseur}<br></td>
						<td>${produit.projet}<br></td>
						<td>${produit.responsable}<br></td>
						<td>${produit.qteEntrante}<br></td>
						<td>${produit.qteRestante}<br></td>
						<td>${produit.numLot}<br></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${produit.datePeremption}" /></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${produit.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${produit.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
			<!-- Modal add new product -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
					<h4 class="modal-title custom_align" id="Heading">Ajouter un nouveau produit</h4>
				</div>

				<div class="modal-body">
					<form id="addForm" action="./add" method="POST">
							<div class="form-group">
								<input class="form-control " name="nom" required type="text" placeholder="Nom du produit">
							</div>
							<div class="form-group">
								<input class="form-control datepicker" name="dateDelivrance" type="text" placeholder="Date de d&#233livrance">
							</div>
							<div class="form-group">
								<input class="form-control " name="fournisseur" type="text" placeholder="Fournisseur">
							</div>
							<div class="form-group">
								<input class="form-control " name="projet" type="text" placeholder="Projet">
							</div>
							<div class="form-group">
								<input class="form-control " name="responsable" type="text" placeholder="Responsable">
							</div>
							<div class="form-group">
								<input class="form-control " name="qteEntrante" type="text" placeholder="Quantit&#233 entrante">
							</div>
							<div class="form-group">
								<input class="form-control " name="numLot" type="text" placeholder="Num&#233ro du lot">
							</div>
							<div class="form-group">
								<input class="form-control datepicker" name="datePeremption" type="text" placeholder="Date de p&#233remption">
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

			<!-- Modal edit product -->
    <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                    <h4 class="modal-title custom_align" id="Heading">Modifier le produit</h4>
                </div>

                <div class="modal-body">
					<form id="editForm" action="./edit" method="POST">
						<div class="form-group">
							<input class="form-control " id="nom" name="nom" required type="text" placeholder="Nom du produit">
						</div>
						<div class="form-group">
							<input class="form-control datepicker" name="dateDelivrance" type="text" placeholder="Date de d&#233livrance">
						</div>
						<div class="form-group">
							<input class="form-control " name="fournisseur" type="text" placeholder="Fournisseur">
						</div>
						<div class="form-group">
							<input class="form-control " name="projet" type="text" placeholder="Projet">
						</div>
						<div class="form-group">
							<input class="form-control " name="responsable" type="text" placeholder="Responsable">
						</div>
						<div class="form-group">
							<input class="form-control " name="qteEntrante" type="text" placeholder="Quantit&#233 entrante">
						</div>
						<div class="form-group">
							<input class="form-control " name="qteRestante" type="text" placeholder="Quantit&#233 restante">
						</div>
						<div class="form-group">
							<input class="form-control " name="numLot" type="text" placeholder="Num&#233ro du lot">
						</div>
						<div class="form-group">
							<input class="form-control datepicker" name="datePeremption" type="text" placeholder="Date de p&#233remption">
						</div>

				<div class="modal-footer ">
					<button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Modifier</button>
				</div>
					</form>
				</div>
			</div>
		</div>
        <!-- /.modal-dialog -->
    </div>

	<!-- Modal delete product -->
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
        var datedelivrance = new Date(result.objet.dateDelivrance);
        var datePeremption = new Date(result.objet.datePeremption);

        /** ajoute une ligne à la table */
        $('#tableProduit').DataTable().row.add([
            "<td>" + result.objet.nom + "</td>",
            "<td>" + convertDate(datedelivrance) + "</td>",
            "<td>" + result.objet.fournisseur + "</td>",
            "<td>" + result.objet.projet + "</td>",
            "<td>" + result.objet.responsable + "</td>",
            "<td>" + result.objet.qteEntrante + "</td>",
            "<td>" + result.objet.qteRestante + "</td>",
            "<td>" + result.objet.numLot + "</td>",
            "<td>" + convertDate(datePeremption) + "</td>",

            '<td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="'+ result.objet.id +'" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>',
            '<td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/'+ result.objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>'
        ]).draw(false);
    }


	/** init la table */
	$('#tableProduit').DataTable( {
		"pagingType": "full_numbers",
		"columnDefs": [
			{ "orderable": false, "targets": 9},
			{ "orderable": false, "targets": 10 }
		],"language": {
			"url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
		}
	});

	/************************ AJOUT *************************/

	/** Ajoute un nouveau produit */
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
					$('#tableProduit').before('<div class="alert alert-success" role="alert">'+result.message+'</div>'); //afficher alert
					addRow(result);
				}else{
					$('#addForm').before('<div class="alert alert-danger" role="alert">'+result.message+'</div>');
				}
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
						.find('[name="nom"]').val(result.objet.nom).end()
						.find('[name="dateDelivrance"]').val(convertDate(result.objet.dateDelivrance)).end()
						.find('[name="fournisseur"]').val(result.objet.fournisseur).end()
						.find('[name="projet"]').val(result.objet.projet).end()
						.find('[name="responsable"]').val(result.objet.responsable).end()
						.find('[name="qteEntrante"]').val(result.objet.qteEntrante).end()
						.find('[name="qteRestante"]').val(result.objet.qteRestante).end()
						.find('[name="numLot"]').val(result.objet.numLot).end()
						.find('[name="datePeremption"]').val(convertDate(result.objet.datePeremption)).end();

					$('#editForm').attr('action', "./edit/"+id);
				}else{
					$('#edit').modal('toggle'); //ferme modal
					$('#tableProduit').before('<div class="alert alert-warning" role="alert">'+result.message+'</div>'); //afficher alert
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
                    $('#tableProduit').before('<div class="alert alert-success" role="alert">'+result.message+'</div>');
                    $('#tableProduit').DataTable().row(currentrow).remove().draw();
                    addRow(result);
                }else{
                    $('#editForm').before('<div class="alert alert-warning" role="alert">'+result.message+'</div>');
                }
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
					$('#tableProduit').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
					$('#tableProduit').DataTable().row(currentrow).remove().draw();
				}else{
					$('#delete').modal('toggle'); //ferme modal
					$('#tableProduit').before('<div class="alert alert-warning" role="alert">'+result.message+'</div>'); //afficher alert
				}
			}
		});
    	});

		/** supprimer alert après 5s */
		window.setTimeout(function() {
			$(".flash").fadeTo(500, 0).slideUp(500, function(){
				$(this).remove();
			});
		}, 5000);
</script>