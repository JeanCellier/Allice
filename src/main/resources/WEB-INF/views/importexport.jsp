<%@ include file="header.jsp" %>

<main class="col-sm-9 col-md-10">
    <h1 class="page-header">Import &amp; Export</h1>

    <div class="row placeholders">
        <div class="col-sm-1 col-md-1">
            <div>
                <a class="btn btn-primary dropdown-toggle" type="button" data-title="Add" data-toggle="modal"
                   data-target="#import">Importer</a>
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
                                data-href="./search/" data-title="Chercher"
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

<div class="modal fade" id="import" tabindex="-1" role="dialog" aria-labelledby="import" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <span class="fa fa-remove" aria-hidden="true"></span>
                </button>
                <h4 class="modal-title custom_align" id="Heading">Importer une nouvelle fiche</h4>
            </div>

            <div class="modal-body">
                <form id="importForm" enctype="multipart/form-data"
                      action="${pageContext.request.contextPath}/importexport/import" method="POST">
                    <div class="form-group">
                        <input class="form-control" name="file" required type="file"
                               accept=".xls,.xlsx,
                               application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel">
                    </div>
                    Type de fiche :
                    <div class="form-group">
                        <label class="radio-inline">
                            <input name="type" id="ABA" type="radio" value="ABA" checked> ABA
                        </label>
                        <label class="radio-inline">
                            <input name="type" id="COL" type="radio" value="COL"> COL
                        </label>
                        <label class="radio-inline">
                            <input name="type" id="IA" type="radio" value="IA"> IA
                        </label>
                        <label class="radio-inline">
                            <input name="type" id="OPU" type="radio" value="OPU"> OPU
                        </label>
                        <label class="radio-inline">
                            <input name="type" ID="TRA" type="radio" value="TRA"> TRA
                        </label>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success btn-lg" style="width: 50%;"><span
                                class="fa fa-check"></span> Importer
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


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
        openFileDialog(".xlsx", function (e) {
            $(this).each(function () {
                var fileName = $(this).val();
                var messageJson = {type: typeFiche, filename: fileName};
                sendJson('POST', '/importexport/import', messageJson);
            });
        });
    });

    //function to
    function sendJson(method, url, data) {
        return $.ajax({
            type: method,
            url: url,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(data)
        })
    }

    // open a dialog function
    function openFileDialog(accept, callback) {
        var inputElement = document.createElement("input");
        inputElement.type = "file";
        inputElement.name = "file";
        inputElement.accept = accept;
        if (typeof callback === "function") {
            inputElement.addEventListener("change", callback);
        }
        inputElement.dispatchEvent(new MouseEvent("click"));
    }
</script>