<%@ include file="../../fiche.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-fiche">Fiches TRA</h1>

    <div class="row placeholders">
        <div class="col-sm-1 col-md-1">
            <p data-placement="top" data-toggle="tooltip" title="add"  style="padding-left:15px;padding-top:10px">
                <button class="btn btn-primary btn-md" data-title="Add" data-toggle="modal" data-target="#add" >
                    <span class="fa fa-plus"> Ajouter</span>
                </button>
            </p>

        </div>
        <div class="col-sm-12 col-md-12" id="contentActesTra" style="padding:30px;">
            <table id="tableActes" class="table table-hover">
                <thead>
                <tr>
                    <td>Nom</td>
                    <td>Programme</td>
                    <td>N° d'agrément</td>
                    <td>Lieu</td>
                    <td>Date</td>
                    <td>N° d'élevage</td>
                    <td>N° identification</td>
                    <td>N° travail</td>
                    <td>Race</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${fichesTraList}" var="fichesTra">
                    <tr>
                        <td>${fichesTra.nom}</td>
                        <td>${fichesTra.fiche.programme}</td>
                        <td>${fichesTra.fiche.numeroAgrement}</td>
                        <td>${fichesTra.fiche.lieu}</td>
                        <td>${fichesTra.fiche.date}</td>
                        <td>${fichesTra.vache.num_elevage}</td>
                        <td>${fichesTra.vache.num_identification}</td>
                        <td>${fichesTra.vache.num_travail}</td>
                        <td>${fichesTra.vache.race}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <%--<td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-md btnEdit" data-title="Modifier" data-id="<c:out value='${produit.id}' />" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>--%>
                        <%--<td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class=" btnDelete btn btn-danger btn-md" data-href="./delete/<c:out value='${produit.id}'/>" data-title="Supprimer" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<!-- Modal add new product -->
<%--<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-fiche">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="Heading">Ajouter un nouveau produit</h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<form id="addForm" action="./add" method="POST">--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control nom" name="nom" required type="text" placeholder="Nom du produit">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control datepicker" name="dateDelivrance" type="text" placeholder="Date de d&#233livrance">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control fournisseur" name="fournisseur" type="text" placeholder="Fournisseur">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control projet" name="projet" type="text" placeholder="Projet">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control responsable" name="responsable" type="text" placeholder="Responsable">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control " name="qteEntrante" type="text" placeholder="Quantit&#233 entrante">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control " name="numLot" type="text" placeholder="Num&#233ro du lot">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control datepicker" name="datePeremption" type="text" placeholder="Date de p&#233remption">--%>
                    <%--</div>--%>
            <%--</div>--%>

            <%--<div class="modal-footer ">--%>
                <%--<button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Ajouter</button>--%>
            <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
        <!-- /.modal-content -->
    <%--</div>--%>
    <!-- /.modal-dialog -->
<%--</div>--%>

<!-- Modal edit product -->
<%--<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-fiche">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="Heading">Modifier le produit</h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<form id="editForm" action="./edit" method="POST">--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control nom" id="nom" name="nom" required type="text" placeholder="Nom du produit">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control datepicker" name="dateDelivrance" type="text" placeholder="Date de d&#233livrance">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control fournisseur" name="fournisseur" type="text" placeholder="Fournisseur">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control projet" name="projet" type="text" placeholder="Projet">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control responsable" name="responsable" type="text" placeholder="Responsable">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control " name="qteEntrante" type="text" placeholder="Quantit&#233 entrante">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control " name="qteRestante" type="text" placeholder="Quantit&#233 restante">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control " name="numLot" type="text" placeholder="Num&#233ro du lot">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input class="form-control datepicker" name="datePeremption" type="text" placeholder="Date de p&#233remption">--%>
                    <%--</div>--%>

                    <%--<div class="modal-footer ">--%>
                        <%--<button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><span class="fa fa-check"></span> Modifier</button>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<!-- /.modal-dialog -->--%>
<%--</div>--%>

<%--<!-- Modal delete product -->--%>
<%--<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-fiche">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>--%>
                <%--<h4 class="modal-title custom_align" id="Heading">Supprimer cette entr&#233e</h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<div class="alert alert-danger"><span class="fa fa-warning-sign"></span> Voulez vous vraiment supprimer cette entr&#233e ?</div>--%>
            <%--</div>--%>

            <%--<div class="modal-footer ">--%>
                <%--<button type="button" id="confirmDelete" class="btn btn-danger" ><span class="fa fa-check"></span> Oui</button>--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal"><span class="fa fa-remove"></span> Non</button>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<!-- /.modal-content -->--%>
    <%--</div>--%>
    <%--<!-- /.modal-dialog -->--%>
<%--</div>--%>

<%@ include file="../../footer.jsp" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="../static/js/datepicker-fr.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../../static/css/datables.bootstrap.css"/>

<script>
    /** init la table */
    $('#tableProduit').DataTable( {
        "pagingType": "full_numbers",
        "columnDefs": [
            { "orderable": false, "targets": 9},
            { "orderable": false, "targets": 10 }
        ],"language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/French.json"
        },
        "pageLength": 25
    });
</script>