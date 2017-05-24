<%@ include file="../header.jsp" %>

<main class="col-sm-9 col-md-10">
	<h1 class="page-header">Pharmacie</h1>

	<div class="row placeholders">
		<div class="col-sm-12 col-md-12">
			<p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
				<button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
					<span class="fa fa-plus"> Ajouter</span>
				</button>
			</p>
		</div>
		<div class="col-sm-12 col-md-12" style="padding-left:30px;padding-top:10px;">
			<label for="cboxProd">Montrer les produits &eacutepuis&eacutes  </label>
			<input type="checkbox" id="cboxProd">
		</div>

		<div class="col-sm-12 col-md-12" id="contentPharmacie" style="padding:30px;">
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
						<td>Indication</td>
						<td></td>
                        <td></td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${produitList}" var="produit">
					<tr>
						<td>${produit.nom}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${produit.dateDelivrance}" /></td>
						<td>${produit.fournisseur}</td>
						<td>${produit.projet}</td>
						<td>${produit.responsable}</td>
						<td>${produit.qteEntrante}</td>
						<td>${produit.qteRestante}</td>
						<td>${produit.numLot}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${produit.datePeremption}" /></td>
						<td>${produit.indication}</td>
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
					<h4 class="modal-title custom_align" id="HeadingAdd">Ajouter un nouveau produit</h4>
				</div>

				<form id="addForm" action="./add" method="POST">
					<div class="modal-body">
							<div class="form-group">
								<input class="form-control nom" name="nom" required type="text" placeholder="Nom du produit">
							</div>
							<div class="form-group">
								<input class="form-control datepicker" name="dateDelivrance" type="text" placeholder="Date de d&#233livrance">
							</div>
							<div class="form-group">
								<input class="form-control fournisseur" name="fournisseur" type="text" placeholder="Fournisseur">
							</div>
							<div class="form-group">
								<input class="form-control projet" name="projet" type="text" placeholder="Projet">
							</div>
							<div class="form-group">
								<input class="form-control responsable" name="responsable" type="text" placeholder="Responsable">
							</div>
							<div class="form-group">
								<input class="form-control " name="qteEntrante" type="number" step="0.01" placeholder="Quantit&#233 entrante">
							</div>
							<div class="form-group">
								<input class="form-control " name="numLot" type="text" placeholder="Num&#233ro du lot">
							</div>
							<div class="form-group">
								<input class="form-control datepicker" name="datePeremption" type="text" placeholder="Date de p&#233remption">
							</div>
							<div class="form-group">
								<input class="form-control" name="indication" type="text" placeholder="Indication">
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
                    <h4 class="modal-title custom_align" id="HeadingEdit">Modifier le produit</h4>
                </div>

				<form id="editForm" action="./edit" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<input class="form-control nom" id="nom" name="nom" required type="text" placeholder="Nom du produit">
						</div>
						<div class="form-group">
							<input class="form-control datepicker" name="dateDelivrance" type="text" placeholder="Date de d&#233livrance">
						</div>
						<div class="form-group">
							<input class="form-control fournisseur" name="fournisseur" type="text" placeholder="Fournisseur">
						</div>
						<div class="form-group">
							<input class="form-control projet" name="projet" type="text" placeholder="Projet">
						</div>
						<div class="form-group">
							<input class="form-control responsable" name="responsable" type="text" placeholder="Responsable">
						</div>
						<div class="form-group">
							<input class="form-control " name="qteEntrante" type="number" step="0.01" placeholder="Quantit&#233 entrante">
						</div>
						<div class="form-group">
							<input class="form-control " name="qteRestante" type="number" step="0.01" placeholder="Quantit&#233 restante">
						</div>
						<div class="form-group">
							<input class="form-control " name="numLot" type="text" placeholder="Num&#233ro du lot">
						</div>
						<div class="form-group">
							<input class="form-control datepicker" name="datePeremption" type="text" placeholder="Date de p&#233remption">
						</div>
						<div class="form-group">
							<input class="form-control" name="indication" type="text" placeholder="Indication">
						</div>
					</div>

					<div class="modal-footer ">
						<button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Modifier</button>
					</div>
				</form>
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

    /** function addRow */
    function addRow(objet) {
        //converti date bon format
        var datedelivrance = new Date(objet.dateDelivrance);
        var datePeremption = new Date(objet.datePeremption);

        /** ajoute une ligne à la table */
        row = $('#tableProduit').DataTable().row.add([
            objet.nom,
           convertDate(datedelivrance),
            objet.fournisseur,
            objet.projet,
            objet.responsable,
            objet.qteEntrante,
            objet.qteRestante,
            objet.numLot,
            convertDate(datePeremption),
            objet.indication,

            '<p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="'+ objet.id +'" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p>',
            '<p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/'+ objet.id + '" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>'
        ]).draw(false);
    }

	/** init la table */
	$('#tableProduit').DataTable({
		"pagingType": "full_numbers",
		"columnDefs": [
			{ "orderable": false, "targets": 10},
			{ "orderable": false, "targets": 11 }
		],"language": {
			"url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
		},
        "pageLength": 25,
        "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) { //function executer à chaque draw
            if(aData[6] == "0.0" || aData[6] == "0"){
                $(nRow).addClass("epuise");
                $(nRow).toggle($("#cboxProd").is(':checked'));
			}else{
                $(nRow).removeClass("epuise");
			}
        }
	});

	/** load produit out of stock dans datatable on check **/
    $("#cboxProd").change(function(){
        var self = this;
        if(this.checked && !$("#cboxProd").hasClass('OutOfStockLoaded')){
            $.ajax({
                url: '${pageContext. request. contextPath}/pharmacie/get/OutOfStock',
                type: 'GET',
                success: function(result) {
                    for(iElmnt = 0; iElmnt < result.length; iElmnt++){
                        addRow(result[iElmnt]);
					}

                    $("#cboxProd").addClass('OutOfStockLoaded');
                }
            });
		}
        $("#tableProduit tr.epuise").toggle(self.checked);
    }).change();

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
					$('#tableProduit').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
					addRow(result.objet);
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
						.find('[name="nom"]').val(result.objet.nom).end()
						.find('[name="dateDelivrance"]').val(convertDate(result.objet.dateDelivrance)).end()
						.find('[name="fournisseur"]').val(result.objet.fournisseur).end()
						.find('[name="projet"]').val(result.objet.projet).end()
						.find('[name="responsable"]').val(result.objet.responsable).end()
						.find('[name="qteEntrante"]').val(result.objet.qteEntrante).end()
						.find('[name="qteRestante"]').val(result.objet.qteRestante).end()
						.find('[name="numLot"]').val(result.objet.numLot).end()
						.find('[name="datePeremption"]').val(convertDate(result.objet.datePeremption)).end()
                        .find('[name="indication"]').val(result.objet.indication).end()

					$('#editForm').attr('action', "./edit/"+id);
				}else{
					$('#edit').modal('toggle'); //ferme modal
					$('#tableProduit').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
				}
			}
		});
	});

	/** Effectue les modifs si validation */
    $('#editForm').on('submit', function(e) {
        e.preventDefault();

        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: $(this).serialize(),
            success: function (result) {
                if(result.succes == true){
                    $('input').val('');
                    $('#edit').modal('toggle');
                    $('#tableProduit').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>');
                    $('#tableProduit').DataTable().row(currentrow).remove();
                    addRow(result.objet);
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
						$('#tableProduit').before('<div class="alert alert-success flash" role="alert">'+result.message+'</div>'); //afficher alert
					$('#tableProduit').DataTable().row(currentrow).remove().draw();
				}else{
					$('#delete').modal('toggle'); //ferme modal
					$('#tableProduit').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
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
    $( ".nom" ).autocomplete({
        source: '${pageContext. request. contextPath}/pharmacie/get/names'
    });

    $( ".fournisseur" ).autocomplete({
        source: '${pageContext. request. contextPath}/pharmacie/get/fournisseurs'
    });

    $( ".projet" ).autocomplete({
        source: '${pageContext. request. contextPath}/pharmacie/get/projets'
    });

    $( ".responsable" ).autocomplete({
        source: '${pageContext. request. contextPath}/pharmacie/get/responsables'
    });

    /** resize le menu si le tableau depasse la hauteur **/
    $.when($('#tableProduit').on( 'change')).done(function() {
        if($(window).width() > 768) {
            $('.sidebar').height($(document).height());
        }
    });
</script>