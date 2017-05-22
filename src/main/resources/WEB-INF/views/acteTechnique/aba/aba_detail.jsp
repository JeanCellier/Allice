<!-- Modal details fiche aba -->
<div class="modal fade " id="details" tabindex="-1" role="dialog" aria-labelledby="details" aria-hidden="true">
    <div class="modal-dialog modal-large">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="fa fa-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="HeadingDetails"></h4>
            </div>

            <div class="modal-body">
                <div class="row details">
                    <div class="col-sm-5">
                        <label>Programme : </label><span id="programme"></span>
                    </div>
                    <div class="col-sm-3">
                        <label>&#8470; d'agr&eacute;ment : </label><span id="numAgrement"></span>
                    </div>

                    <div class="col-sm-4">
                        <label>Date : </label><span id="dateHeureMinute"></span>
                    </div>
                  
                    <div class="col-sm-4">
                        <label>Abattoir : </label><span id="abattoir"></span>
                    </div>

                    <div class="col-sm-4">
                        <label>Op&eacute;rateur : </label><span id="operateur"></span>
                    </div>
                    <div class="col-sm-4">
                        <label>T° arriv&eacute;e : </label><span id="temperatureArrivee"></span>
                    </div>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>INFORMATIONS GENERALES PIV</legend>
                        <div class="col-sm-4">
                            <label>Op&eacute;rateur : </label><span id="operateurPIV"></span>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableInfogenerales" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Maturation</th>
                                    <th>FIV</th>
                                    <th>Type Culture</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>COLLECTE & MATURATION IN VITRO</legend>
                        <div class="col-sm-6">
                            <label>Date collecte : </label><span id="date"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Heure collecte : </label><span id="heureCollecte"></span>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableCollecte" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>race_Ovaires</th>
                                    <th>&#8470; femelle ou pool</th>
                                    <th>Nb Ovaires</th>
                                    <th>Nb Ovocytes</th>
                                    <th>Taux collecte</th>
                                    <th>Heure debut maturation</th>
                                    <th>Heure Fiv</th>
                                    <th>Groupes exp&eacute;rimentaux MIV</th>
                                    <th>Nb d'ovocytes</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>FECONDATION IN VITRO</legend>
                        <div class="col-sm-6">
                            <label>Date fecondation : </label><span id="dateFecondation"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Sanitaires : </label><span id="nom"></span>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableSemence" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Taureau</th>
                                    <th>&#8470; &eacute;jaculation</th>
                                    <th>Etat Frais avant FIV</th>
                                    <th>Volume. FIV (µl)</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-sm-6">
                            <label>Remarques : </label><span id="remarque"></span>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>CULTURE IN VITRO</legend>
                        <div class="col-sm-6">
                            <label>Date culture : </label><span id="dateCulture"></span>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableCulture" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Groupe</th>
                                    <th>Nb d'ovo Insemin&eacute;s</th>
                                    <th>Heure de mise en culture</th>
                                    <th>Nb Segment&eacute;s</th>
                                    <th>% segment</th>
                                    <th>j5JM</th>
                                    <th>j6</th>
                                    <th>JB</th>
                                    <th>mo</th>
                                    <th>BL</th>
                                    <th>BE</th>
                                    <th>Q1</th>
                                    <th>Nb total</th>
                                    <th>% J7</th>
                                    <th>% BEJ7</th>
                                    <th>% Q1J7</th>
                                    <th>J8parNb</th>
                                    <th>%J8</th>
                                    <th>Destination(d&eacute;truits/cryo)</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-sm-6">
                            <label>Remarques : </label><span id="remarques"></span>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>INFORMATIONS SI CRYOCONSERVATION</legend>
                        <div class="col-sm-6">R&eacute;f&eacute;
                            <label>R&eacute;f&eacute;rence cong&eacute;lation : </label><span id="ref"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Heure de cong&eacute;lation : </label><span id="heureMinute"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>M&eacute;thode de cong&eacute;lation : </label><span id="methodeCongelation"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Cong&eacute;lateur utilis&eacute; : </label><span id="congelateur"></span>
                        </div>
                        
                        <div class="col-sm-6">
                            <label>Description m&eacute;thode (nom,programme,cin&eacute;tique,seeding : </label><span id="descMethode"></span>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>DETAILS EMBRYONS VIABLES</legend>
                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableDetails" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>&#8470; embryon</th>
                                    <th>Stade</th>
                                    <th>Qualite (1 à 4)</th>
                                    <th>Cryoconserv&eacute;</th>
                                    <th>Cuve stockage</th>
                                    <th>Canister stockage</th>
                                    <th>Visotube stockage</th>
                                    <th>Jonc</th>
                                    <th>Frais</th>
                                    <th>&#8470; receveuse</th>
                                    <th>R&eacute;f&eacute;rence transfert</th>
                                    <th>D&eacute;truit</th>
                                    <th>Remarques</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary btn-md btnEdit btnEditDetails" data-title="Modifier" data-toggle="modal" data-target="#add" >Modifier</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<script>
    /** Rempli le modal details */
    $(document).on( 'click', ".btnDetails", function(){
        id = $(this).data('id');

        $.ajax({
            url: "./get/"+id,
            method: 'GET',
            success: function (result) {
                if(result.succes == true) {

                    if(result.objet.programme != null){
                        var nomProgramme = result.objet.programme.nom;
                    }else{
                        var nomProgramme = "";
                    }
                    if(result.objet.operateur != null){
                        var nomOperateur = result.objet.operateur.nom+' '+result.objet.operateur.prenom;
                    }else{
                        var nomOperateur = "";
                    }

                    $('#details')
                        .find('#HeadingDetails').text(' D\u00e9tails de la fiche '+result.objet.nom).end()
                        .find('#programme').text(' '+result.objet.programme.nom).end()
                        .find('#numAgrement').text(' '+result.objet.numeroAgrement).end()
                        .find('#dateHeureMinute').text(' '+convertDateWithTime(result.objet.dateHeureMinute)).end()
                        .find('#abattoir').text(' '+result.objet.abattoir.nom).end()
                        .find('#operateur').text(' '+result.objet.operateur.nom+' '+result.objet.operateur.prenom).end()
                        .find('#temperatureArrivee').text(' '+result.objet.temperatureArrivee).end()
                        .find('#operateurPIV').text(' '+result.objet.operateur.nom+' '+result.objet.operateur.prenom).end()
                        .find('#date').text(' '+convertDateWithTime(result.objet.collecte.date)).end()
                        .find('#heureCollecte').text(' '+result.objet.collecte.heureCollecte).end()
                        .find('#dateFecondation').text(' '+convertDateWithTime(result.objet.fecondation.date)).end()
                        .find('#nom').text(' '+result.objet.fecondation.sanitaireList[0].nom).end()
                        .find('#remarque').text(' '+result.objet.fecondation.remarque).end()
                        .find('#dateCulture').text(' '+result.objet.culture.date).end()
                        .find('#remarques').text(' '+result.objet.culture.remarques).end()
                        .find('#ref').text(' '+result.objet.cryoconservation.ref).end()
                        .find('#heureMinute').text(' '+result.objet.cryoconservation.heureMinute).end()
                        .find('#methodeCongelation').text(' '+result.objet.cryoconservation.methodeCongelation.nom).end()
                        .find('#congelateur').text(' '+result.objet.cryoconservation.congelateur.nom).end()
                        .find('#descMethode').text(' '+result.objet.cryoconservation.descMethode).end()


                    $("#tableInfogenerales > tbody").empty();
                   
                        $('#tableInfogenerales > tbody:last-child').append('<tr>' +
                            '<td>' + result.objet.informations_piv.milieuMaturation.nom + ' '+result.objet.informations_piv.milieuMaturation.numeroLot + '</td>' +
							'<td>' + result.objet.informations_piv.fiv.nom + ' '+ result.objet.informations_piv.fiv.numeroLot + '</td>' +
							'<td>' + result.objet.informations_piv.typeCulture.nom + '</td>' + ' '+ result.objet.informations_piv.typeCulture.numeroLot + '</td></tr>');
                    

                    $("#tableCollecte > tbody").empty();
                    for(iLigne = 0; iLigne < result.objet.collecte.tableauCollecteList.length; iLigne++)
                    {
                        $('#tableCollecte > tbody:last-child').append('<tr>' +
                            '<td>' + result.objet.collecte.tableauGestationList[iLigne].race_Ovaires + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].pool + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].nombre_Ovaires + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].nombre_Ovocytes + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].taux_Collecte + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].heureDebutMaturation + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].heureFiv + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].groupeExperimentauxMIV + '</td>' +
                            '<td>' + result.objet.collecte.tableauCollecteList[iLigne].nbOvocyte + '</td></tr>');
                    }

					$("#tableSemence > tbody").empty();
                    for(iLigne = 0; iLigne < result.objet.fecondation.tableau_semences.length; iLigne++)
                    {
                        $('#tableSemence > tbody:last-child').append('<tr>' +
                            '<td>' + result.objet.fecondation.tableau_semences[iLigne].taureau.nom + ' '+ result.objet.fecondation.tableau_semences[iLigne].taureau.race + '</td>' +
                            '<td>' + result.objet.fecondation.tableau_semences[iLigne].numeroEjaculation + '</td>' +
                            '<td>' + result.objet.fecondation.tableau_semences[iLigne].etatFrais + '</td>' +
                            '<td>' + result.objet.fecondation.tableau_semences[iLigne].volume + '</td></tr>');
                    }
					
					$("#tableCulture > tbody").empty();
                    for(iLigne = 0; iLigne < result.objet.culture.tableauCultureList.length; iLigne++)
                    {
                        $('#tableCulture > tbody:last-child').append('<tr>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].groupe + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].nbInsemine + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].heureCulture + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].nbSegmente + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].j5JM + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].j6 + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].JB + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].mo + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].bl + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].be + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].q1 + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].nbTotal + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].pourJ7 + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].pourBEJ7 + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].pourQ1J7 + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].J8parNb + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].pourJ8 + '</td>' +
                            '<td>' + result.objet.culture.tableauCultureList[iLigne].destination + '</td></tr>');
                    }
					
					$("#tableDetails > tbody").empty();
                    for(iLigne = 0; iLigne < result.objet.tableauDetails.length; iLigne++)
                    {
                        $('#tableDetails > tbody:last-child').append('<tr>' +
                            '<td>' + result.objet.tableauDetails[iLigne].numeroEmbryon + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].stade.nom + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].qualite.numero + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].cryoconserve + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].cuve.nom + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].canister.numero + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].visoTube.couleur + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].jonc + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].frais + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].numeroReceveuse + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].referenceTransfert + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].detruit + '</td>' +
                            '<td>' + result.objet.tableauDetails[iLigne].remarque + '</td></tr>');
                    }
					
                    $('#details').find('.btnEdit').attr('data-id', result.objet.id);
                }else{
                    $('#details').modal('toggle'); //ferme modal
                    $('#tableABA').before('<div class="alert alert-warning flash" role="alert">'+result.message+'</div>'); //afficher alert
                    autoclose();
                }
            }
        });

        /******* ferme le modal details si clic sur modifier ******/
        $(document).on( 'click', ".btnEditDetails", function() {
            $('#details').modal('toggle');
        });
    });
</script>