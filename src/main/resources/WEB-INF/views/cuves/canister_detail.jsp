<!-- Modal details cuves -->
<div class="modal fade " id="canister" tabindex="-1" role="dialog" aria-labelledby="canister" aria-hidden="true">
    <div class="modal-dialog modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingCanister"></h4>
            </div>

            <div class="modal-body">
                <div class="row details">
                    <div class="col-sm-6">
                        <label>Visio Tube : </label><span id="visioTube"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Reference Manipulation : </label><span id="refManip"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Nombre d'embryons : </label><span id="mbEmbryons"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>&#8470; embryon : </label><span id="numEmbryon"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Couleur bouchon/jonc : </label><span id="couleurBouchon"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Projet : </label><span id="projet"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>&#8470; Agrement : </label><span id="numAgrement"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Race Femelle : </label><span id="raceFemelle"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>&#8470; Femelle : </label><span id="numFemelle"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Race Taureau : </label><span id="raceTaureau1"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>&#8470; Taureau : </label><span id="numTaureau1"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Nombre de Paillettes : </label><span id="nbPaillettes"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Stade Embryon : </label><span id="stadeEmbryon"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Qualite Embryon : </label><span id="qualiteEmbryon"></span>
                    </div>
                    <div class="col-sm-6">
                        <label>Remarques : </label><span id="remarquesEmbryon"></span>
                    </div>
                </div>



            <div class="modal-footer">
                <button class="btn btn-primary btn-md btnEdit btnEditCanister" data-title="Modifier" data-toggle="modal" data-target="#add" >Modifier</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%--<script>--%>
    <%--/** Rempli le modal details */--%>
    <%--$(document).on( 'click', ".btnDetails", function(){--%>
        <%--id = $(this).data('id');--%>

        <%--$.ajax({--%>
            <%--url: "./get/"+id,--%>
            <%--method: 'GET',--%>
            <%--success: function (result) {--%>
                <%--if(result.succes == true) {--%>
                    <%--$('#canister')--%>
                        <%--.find('#HeadingDetails').text(' D\u00e9tails de la fiche '+result.objet.nom).end()--%>
                        <%--.find('#date').text(' '+convertDateWithTime(result.objet.dateHeureMinute)).end()--%>
                        <%--.find('#lieu').text(' '+result.objet.lieu).end()--%>
                        <%--.find('#programme').text(' '+result.objet.programme.nom).end()--%>
                        <%--.find('#numIPE').text(' '+result.objet.numIpe).end()--%>
                        <%--.find('#numSemence').text(' '+result.objet.numDepotSemence).end()--%>
                        <%--.find('#proprietaire').text(' '+result.objet.vache.proprietaire).end()--%>
                        <%--.find('#numElevage').text(' '+result.objet.vache.num_elevage).end()--%>
                        <%--.find('#numIdentification').text(' '+result.objet.vache.num_identification).end()--%>
                        <%--.find('#numTravail').text(' '+result.objet.vache.num_identification.substr(result.objet.vache.num_identification.length - 4)).end()--%>
                        <%--.find('#race').text(' '+result.objet.vache.race).end()--%>
                        <%--.find('#parite').text(' '+result.objet.vache.parite).end()--%>
                        <%--.find('#operateur').text(' '+result.objet.insemination.operateur.nom+' '+result.objet.insemination.operateur.prenom).end()--%>
                        <%--.find('#nomTaureau').text(' '+result.objet.insemination.taureau.nom).end()--%>
                        <%--.find('#raceTaureau').text(' '+result.objet.insemination.taureau.race).end()--%>
                        <%--.find('#numTaureau').text(' '+result.objet.insemination.taureau.num_identification).end()--%>
                        <%--.find('#collecte').text(' '+result.objet.insemination.collecte.nom).end()--%>
                        <%--.find('#lieuSemence').text(' '+result.objet.insemination.lieuDepot).end()--%>
                        <%--.find('#facilite').text(' '+result.objet.insemination.progression).end()--%>
                        <%--.find('#typeChaleur').text(' '+result.objet.traitement_donneuse.typeChaleur).end()--%>
                        <%--.find('#remarques').text(' '+result.objet.gestation.remarques).end();--%>

                    <%--if(result.objet.insemination.semenceSexee == false) {--%>
                        <%--$('#canister').find('#semenceSexee').text(' Non');--%>
                    <%--}else{--%>
                        <%--$('#canister').find('#semenceSexee').text(' Oui');--%>
                    <%--}--%>

                    <%--$("#tableTraitement > tbody").empty();--%>
                    <%--for(iLigne = 0; iLigne < result.objet.traitement_donneuse.tableauDonneuse.length; iLigne++)--%>
                    <%--{--%>
                        <%--$('#tableTraitement > tbody:last-child').append('<tr>' +--%>
                            <%--'<td>' + convertDate(result.objet.traitement_donneuse.tableauDonneuse[iLigne].date) + '</td>' +--%>
                            <%--'<td>' + result.objet.traitement_donneuse.tableauDonneuse[iLigne].produit.nom + '</td>' +--%>
                            <%--'<td>' + result.objet.traitement_donneuse.tableauDonneuse[iLigne].quantite + '</td>' +--%>
                            <%--'<td>' + result.objet.traitement_donneuse.tableauDonneuse[iLigne].mode_traitement + '</td></tr>');--%>
                    <%--}--%>

                    <%--$("#tableGestation > tbody").empty();--%>
                    <%--for(iLigne = 0; iLigne < result.objet.gestation.tableauGestationList.length; iLigne++)--%>
                    <%--{--%>
                        <%--$('#tableGestation > tbody:last-child').append('<tr>' +--%>
                            <%--'<td>' + convertDate(result.objet.gestation.tableauGestationList[iLigne].date) + '</td>' +--%>
                            <%--'<td>' + result.objet.gestation.tableauGestationList[iLigne].methode + '</td>' +--%>
                            <%--'<td>' + result.objet.gestation.tableauGestationList[iLigne].resultat + '</td></tr>');--%>
                    <%--}--%>

                    <%--$('#canister').find('.btnEdit').attr('data-id', result.objet.id);--%>
                <%--}else{--%>
                    <%--$('#canister').modal('toggle'); //ferme modal--%>
                    <%--$('#tableActes').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert--%>
                    <%--autoclose();--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>

        <%--/******* ferme le modal details si clic sur modifier ******/--%>
        <%--$(document).on( 'click', ".btnEditDetails", function() {--%>
            <%--$('#canister').modal('toggle');--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>