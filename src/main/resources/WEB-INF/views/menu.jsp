<div class="container-fluid" style="padding-left:0;padding-right:0">
    <nav class="sidebar sidebar-container navbar-default col-xs-12 col-sm-3 col-md-2"  role="navigation" style="margin-bottom: 0; padding-right:0; padding-left:0;">
        <div class="navbar-fiche">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="sidebar sidebar-content collapse navbar-collapse" id="sidebar" style="padding-right:0; padding-left:0">
            <div class="hidden-xs"style="height:170px;">
                <div class="col-sm-3 col-md-2" style="padding-top:10px">
                    <img src="../../static/images/logo_allice.png" class="center-block" alt="allice_icon">
                </div>
            </div>

            <ul class="nav nav-stacked">
                <li><a href="<s:url value='/animaux/animaux'/>">ANIMAUX</a></li>
                <li><a href="<s:url value='/pharmacie/pharmacie'/>">PHARMACIE</a></li>
                <li><a href="#listFiche" data-toggle="collapse">ACTES TECHNIQUES</a>
                    <ul id="listFiche" class="collapse nav" style="padding-left:40px;">
                        <li><a href="#">ABA</a></li>
                        <li><a href="<s:url value='/acteTechnique/col/col'/>">COL</a></li>
                        <li><a href="<s:url value='/acteTechnique/ia/ia'/>">IA</a></li>
                        <li><a href="#">OPU</a></li>
                        <li><a href="<s:url value='/acteTechnique/tra/tra'/>">TRA</a></li>
                    </ul>
                </li>
                <li><a href="#listCuves" data-toggle="collapse">CUVES</a></li>
                    <ul id="listCuves" class="collapse nav" style="padding-left:40px;">
                        <li><a href="<s:url value='/cuves/cellules_somatiques'/>">Cellules Somatiques</a></li>
                        <li><a href="<s:url value='/cuves/embryons_vitro'/>">Embryons Vitro</a></li>
                        <li><a href="<s:url value='/cuves/embryons_vivo'/>">Embryons Vivo</a></li>
                        <li><a href="<s:url value='/cuves/embryons_elevage'/>">Semances Elevage</a></li>
                        <li><a href="<s:url value='/cuves/semances_fiv'/>">Semances FIV</a></li>
                    </ul>
                <li><a href="<s:url value='/traitement/traitement'/>">TRAITEMENTS</a></li>
                <li><a href="#">IMPORT/EXPORT</a></li>
                <li><a href="#">PLANNING</a></li>
            </ul>
        </div>
    </nav>