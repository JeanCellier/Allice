<%@ include file="header.jsp" %>

<main class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
    <h1 class="page-header">Import &amp; Export</h1>
    <div class="row placeholders">

        <div class="col-sm-1 col-md-1">
            <div class="dropdown">
                <a class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Importer
                    <span class="caret"></span></a>
                <ul class="dropdown-menu dropdown-menu-left">
                    <li><a href="#">ABA</a></li>
                    <li><a href="#">COL</a></li>
                    <li><a href="#">IA</a></li>
                    <li><a href="#">OPU</a></li>
                    <li><a href="#">TRA</a></li>
                </ul>
            </div>
        </div>
        <div class="col-sm-12 col-md-12" id="list-fiche-cards" style="margin-top: 10px;">
            <ul class="list-group">
                <c:forEach items="${ficheList}" var="fiche">
                    <div class="list-group-item list-group-item-linkable" data-link="#">
                        <div class="row">
                            <div class="col-sm-11 col-md-11 col-lg-11">
                                <h4 class="list-group-item-heading">${fiche.name}</h4>
                                <p class="list-group-item-text">${fiche.header.date}</p>
                            </div>
                            <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                <a href="#" target="_blank" class="btn btn-default bottom-right">Exporter</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </ul>
        </div>
    </div>
</main>

<%@ include file="footer.jsp" %>

<link rel="stylesheet" href="<c:url value="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>