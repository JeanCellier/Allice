<%@ include file="../header.jsp" %>

<main class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
    <h1 class="page-header">Pharmacie</h1>

    <div class="row placeholders">
        <div class="col-sm-5 col-md-4">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Rechercher...">
                <span class="input-group-btn">
					<button class="btn btn-default" type="button">OK</button>
				</span>
            </div>
        </div>
        <div class="sm-1 col-md-1 col-md-offset-1">
            <p data-placement="top" data-toggle="tooltip" title="add">
                <button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="glyphicon glyphicon-plus"> Ajouter</span>
                </button>
            </p>

        </div>
        <div class="col-md-12" style="padding:30px;">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>Id</td>
                    <td>Nom</td>
                    <td>Designation</td>
                    <td>Canisters</td>
                </tr>
                </thead>
                <tbody>

                    <tr>
         <%--ajouter controller et récupérer les infos de la bdd pour affichage--%>
                    </tr>

                </tbody>
            </table>
            <nav aria-label="Page navigation table">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</main>
<!-- Modal add new product -->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Ajouter un nouveau produit</h4>
            </div>

            <div class="modal-body">
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Nom du produit">
                </div>
                <div class="form-group">
                    <input class="form-control datepicker" type="text" placeholder="Date de d&#233livrance">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Fournisseur">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Projet">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Responsable">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Quantit&#233 entrante">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Quantit&#233 restante">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Num&#233ro du lot">
                </div>
                <div class="form-group">
                    <input class="form-control datepicker" type="text" placeholder="Date de p&#233remption">
                </div>
            </div>

            <div class="modal-footer ">
                <button type="button" class="btn btn-success btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Ajouter</button>
            </div>
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
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Modifier le produit</h4>
            </div>

            <div class="modal-body">
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="">
                </div>
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="">
                </div>
                <div class="form-group">
                    <textarea rows="2" class="form-control" placeholder=""></textarea>
                </div>
            </div>

            <div class="modal-footer ">
                <button type="button" class="btn btn-success btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Modifier</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- Modal delete product -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Supprimer cette entr&#233e</h4>
            </div>

            <div class="modal-body">
                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Voulez vous vraiment supprimer cette entr&#233e ?</div>
            </div>

            <div class="modal-footer ">
                <button type="button" class="btn btn-danger" ><span class="glyphicon glyphicon-ok-sign"></span> Oui</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Non</button>
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
<script>
    $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );

    $( function() {
        $( ".datepicker" ).each(function() {
            $( this ).datepicker();
        });
    } );
</script>