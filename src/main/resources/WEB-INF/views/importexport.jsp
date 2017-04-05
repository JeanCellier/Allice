<%@ include file="header.jsp" %>

<main class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
    <h1 class="page-header">Import &amp; Export</h1>
    <div class="row placeholders">

        <div class="col-sm-1 col-md-1">
            <div class="dropdown">
                <a class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Importer
                    <span class="caret"></span></a>
                <ul class="dropdown-menu dropdown-menu-left">
                    <li value="ABA" class="fiche-file"><a href="#">ABA</a></li>
                    <li value="COL" class="fiche-file"><a href="#">COL</a></li>
                    <li value="IA" class="fiche-file"><a href="#">IA</a></li>
                    <li value="OPU" class="fiche-file"><a href="#">OPU</a></li>
                    <li value="TRA" class="fiche-file"><a href="#">TRA</a></li>
                    <li value="Carriere" class="fiche-file"><a href="#">Carriere</a></li>
                </ul>
            </div>
        </div>
        <div class="col-sm-12 col-md-12" id="list-fiche-cards" style="margin-top: 10px;">
            <div class="row">
                <div class="col-sm-3">
                    <label style="font-weight: normal; text-align: left; white-space: nowrap;">
                        Type de fiches :
                        <select class="form-control input-sm" style="display: inline-block;">
                            <option value="ALL">Tous</option>
                            <option value="ABA">ABA</option>
                            <option value="COL">COL</option>
                            <option value="IA">IA</option>
                            <option value="OPU">OPU</option>
                            <option value="TRA">TRA</option>
                        </select>
                    </label>
                </div>
                <div class="col-sm-3">
                    <div class="form-group">
                        <input class="form-control datepicker" name="dateDebut" type="text"
                               placeholder="Date debut">
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="form-group">
                        <input class="form-control datepicker" name="dateFin" type="text"
                               placeholder="Date fin">
                    </div>
                </div>
                <div class="col-sm-3">
                    <p data-placement="top" data-toggle="tooltip" title="Supprimer">
                        <button class="btnSearch btn btn-search btn-md"
                                data-href="./search/<c:out value='${produit.id}'/>" data-title="Chercher"
                                data-toggle="modal" data-target="#search"><span
                                class="glyphicon glyphicon-search"></span></button>
                    </p>
                </div>
            </div>
            <c:choose>
                <c:when test="${ficheList.size()==0}">
                    <br><br><br><br><br><br>
                    <img src="../../static/images/mail-inbox-empty.png" class="center-block" style="width: 100px;"/>
                    <h3 class="text-center">Aucune fiche n'a &eacute;t&eacute; trouv&eacute;e</h3>
                </c:when>
                <c:otherwise>
                    <ul class="list-group">
                        <c:forEach items="${ficheList}" var="fiche">
                            <div class="list-group-item list-group-item-linkable" data-link="#">
                                <div class="row">
                                    <div class="col-sm-11 col-md-11 col-lg-11">
                                        <h4 class="list-group-item-heading">${fiche.nom}</h4>
                                        <p class="list-group-item-text">${fiche.nom}</p>
                                    </div>
                                    <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                        <a href="#" target="_blank" class="btn btn-default bottom-right">Exporter</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</main>

<%@ include file="footer.jsp" %>

<link rel="stylesheet" href="<c:url value="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="../../static/js/datepicker-fr.js"></script>
<script>
    /** function init calendrier */
    $.datepicker.setDefaults($.datepicker.regional["fr"]);

    $(function () {
        $(".datepicker").each(function () {
            $(this).datepicker();
        });
    });

    $(".fiche-file").click(function () {
        var typeFiche = $(this).attr('value');
        var fileName;
        openFileDialog("text/plain", function (e) {
            $(this).each(function () {
                fileName = $(this).val();
            });
        });
    });

    // open a dialog function
    function openFileDialog(accept, callback) {
        var inputElement = document.createElement("input");
        inputElement.type = "file";
        inputElement.accept = accept;
        if (typeof callback === "function") {
            inputElement.addEventListener("change", callback);
        }
        inputElement.dispatchEvent(new MouseEvent("click"));
    }
</script>