<!-- Modal details fiche tra -->
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
                        <label>Lieu : </label><span id="lieu"></span>
                    </div>
                    <div class="col-sm-4">
                        <label>Date : </label><span id="date"></span>
                    </div>
                    <div class="col-sm-4">
                        <label>Op&eacute;rateur : </label><span id="operateur"></span>
                    </div>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>Identification receveuse</legend>
                        <div class="col-sm-6">
                            <label>Propri&eacute;taire : </label><span id="proprietaire"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>&#8470; d'&eacute;levage : </label><span id="numElevage"></span>
                        </div>
                        <div class="col-sm-4">
                            <label>&#8470; d'identification : </label><span id="numIdentification"></span>
                        </div>
                        <div class="col-sm-3">
                            <label>&#8470; de travail : </label><span id="numTravail"></span>
                        </div>
                        <div class="col-sm-2">
                            <label>Race : </label><span id="race"></span>
                        </div>
                        <div class="col-sm-3">
                            <label>Parit&eacute; : </label><span id="parite"></span>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>Traitement receveuse</legend>
                        <div class="col-sm-6">
                            <label>Date chaleur de r&eacute;f&eacute;rence : </label><span id="dateChaleur"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Type chaleur de r&eacute;f&eacute;rence : </label><span id="typeChaleur"></span>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableTraitement" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Produit</th>
                                    <th>Quantit&eacute;</th>
                                    <th>Mode de traitement</th>
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
                        <legend>&Eacute;valuation du corps jaune</legend>
                        <div class="col-sm-4">
                            <label>M&eacute;thode d'&eacute;valuation : </label><span id="methodeEvaluation"></span>
                        </div>
                        <div class="col-sm-4">
                            <label>Image(s) &eacute;chographe : </label><span id="imageEcho"></span>
                        </div>
                        <div class="col-sm-4">
                            <label>Cot&eacute; du corps jaune : </label><span id="coteCorpsJaune"></span>
                        </div>
                        <div class="col-sm-4">
                            <label>Qualit&eacute; selon jugement op&eacute;rateur : </label><span id="qualite"></span>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>Embryon(s) transf&eacute;r&eacute;(s)</legend>
                        <div class="col-sm-6">
                            <label>R&eacute;f&eacute;rence exp&eacute;rience production d'embryon(s) : </label><span id="refExperience"></span>
                        </div>
                        <div class="col-sm-2">
                            <label>Semence sex&eacute;e : </label><span id="semenceSexee"></span>
                        </div>
                        <div class="col-sm-4">
                            <label>&#8470; embryon : </label><span id="numEmbryon"></span>
                        </div>
                        <div class="col-sm-3">
                            <label>Race taureau : </label><span id="raceTaureau"></span>
                        </div>
                        <div class="col-sm-4">
                            <label>&#8470; taureau : </label><span id="numTaureau"></span>
                        </div>
                        <div class="col-sm-3">
                            <label>Cot&eacute; transfert : </label><span id="coteTransfert"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Emplacement dans la corne ut&eacute;rine : </label><span id="emplacementCorne"></span>
                        </div>
                        <div class="col-sm-6">
                            <label>Facilit&eacute; de progression : </label><span id="faciliteProgression"></span>
                        </div>
                    </fieldset>
                </div>

                <div class="row details">
                    <fieldset>
                        <legend>Suivi de gestation</legend>

                        <div class="col-sm-10 col-sm-offset-1 tableDetails">
                            <table id="tableGestation" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Nom</th>
                                    <th>Date de d&eacutelivrance</th>
                                    <th>Fournisseur</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>

                        <div class="col-sm-12">
                            <label>Remarques : </label><span id="remarques"></span>
                        </div>
                    </fieldset>
                </div>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary btn-lg btnEdit" data-title="Modifier" data-id="" data-toggle="modal" data-target="#edit" >Modifier</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<script>

</script>