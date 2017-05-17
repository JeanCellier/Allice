<%@ include file="../header.jsp" %>

<main class="col-sm-9 col-md-10">
	<h1 class="page-header">Traitements</h1>

	<div class="row placeholders">
		<div id="divAddButton" class="col-sm-1 col-md-1">
			<p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
				<button id="addButton" class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
					<span class="fa fa-plus"> Ajouter</span>
				</button>
			</p>
		</div>

		<div id="viewTraitements" class="col-sm-12" style="margin-top:40px;">
			<c:forEach items="${traitementList}" var="traitement">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a href="#" class="traitementLink panel-title pull-left" onclick="toggler('${traitement.id}');">${traitement.nom}</a>
							<p data-placement="top" data-toggle="tooltip" title="Modifier" class="pull-right"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${traitement.id}' />" data-toggle="modal" data-target="#add" ><span class="glyphicon glyphicon-pencil"></span></button></p>
							<p data-placement="top" data-toggle="tooltip" title="Supprimer" class="pull-right" style="margin-right:20px;"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${traitement.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p>
							<div class="clearfix"></div>
						</div>

						<div id="${traitement.id}" class="panel-collapse collapse">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
									<tr>
										<td>Jour</td>
										<td>Produit</td>
										<td>Quantit&#233</td>
										<td>Mode</td>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${traitement.tableauTraitement}" var="ligne">
										<tr>
											<td>${ligne.decalage}</td>
											<td>${ligne.produit.nom}</td>
											<td>${ligne.quantite}</td>
											<td>${ligne.mode_traitement}</td>
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

<!-- Modal add new traitement -->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
	<div class="modal-dialog modal-large">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
				<h4 class="modal-title custom_align" id="HeadingAdd">Ajouter un nouveau traitement</h4>
			</div>

			<form id="addForm" action="./add" method="POST">
				<div class="modal-body">
					<div class="form-group" style="padding-left:0">
						<input class="form-control" required name="nom" type="text" placeholder="Nom du traitement">
					</div>

					<div class="tabTraitement" id="tabTraitement">
						<div class="form-group col-sm-3" style="padding-left:0">
							<input class="form-control" required name="jour[]" type="number" value="0" placeholder="Jour">
						</div>

						<div class="form-group col-sm-3">
							<select class="form-control" required name="produit[]">
								<option value="" selected disabled>Produit</option>
								<c:forEach items="${produitsList}" var="produit">
									<option value="${produit.id}">${produit.nom}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group col-sm-2">
							<input class="form-control" required name="quantite[]" step="0.01" type="number" placeholder="Quantite">
						</div>

						<div class="form-group col-sm-3">
							<select class="form-control" required name="modeTraitement[]">
								<option value="" selected disabled>Mode de traitementActe</option>
								<option value="IM">IM</option>
								<option value="IV">IV</option>
								<option value="IVA">IVA</option>
								<option value="SC">SC</option>
							</select>
						</div>
					</div>
					<div class="form-group col-sm-1">
						<button class="btn btn-primary addTabTraitement" type="button"><span class="fa fa-plus"></span></button>
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

<script>
	/******* Reinit form on click add ******/
	$(document).on('click', '#addButton', function(){
        reinit();
        $('#addForm').attr('action', './add');
	});

    /******* Ajoute une ligne modal traitement ******/
    $(document).on( 'click', ".addTabTraitement", function(){
        $template = $('#tabTraitement');
        $clone = $template.clone().removeAttr('id');
        $clone.find('input').val("");
        $clone.append('<div class="form-group col-sm-1"><button class="btn btn-danger delTabTraitement" type="button"><span class="fa fa-minus"></span></button></div>');
        $clone.insertAfter($("div.tabTraitement").last());
    });

    /******* Supprime une ligne modal traitement ******/
    $(document).on( 'click', ".delTabTraitement", function(){
        $(this).closest('.tabTraitement').remove();
    });

    /****** hide or show traitement ******/
	function toggler(divId) {
		$("#" + divId).toggle();
	}

	/****** reinit modal add ******/
	function reinit(){
        $('#add').find('.tabTraitement').not(':first').remove(); //garde juste une ligne dans le tableau de traitement_acte
        $('#add').find("select").val("");
        $('#add').find("input[name='jour[]']").val(0);
        $('#add').find("input[name!='jour[]']").val("");
	}

    /****** supprimer alert après 5s ******/
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

                    $('#addForm').attr('action', './edit/'+id);

                    $('#add').find("input[name='nom']").val(result.objet.nom);
                    //remplit modal
                    for(iLigne = 0; iLigne < result.objet.tableauTraitement.length; iLigne++)
                    {
                        if(iLigne == 0){
                            $target = $('#add').find('#tabTraitement');
                        }else{
                            $target = $('#add').find('#tabTraitement').clone().removeAttr('id');
                            $target.insertAfter($('#add').find("div.tabTraitement").last());
                        }

                        $target.find("input[name='jour[]']").val(result.objet.tableauTraitement[iLigne].decalage);
                        $target.find("select[name='produit[]']" ).val(result.objet.tableauTraitement[iLigne].produit.id );
                        $target.find("input[name='quantite[]']").val(result.objet.tableauTraitement[iLigne].quantite);
                        $target.find("select[name='modeTraitement[]']").val(result.objet.tableauTraitement[iLigne].mode_traitement);
                    }
                }else{
                    $('#add').modal('toggle'); //ferme modal
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