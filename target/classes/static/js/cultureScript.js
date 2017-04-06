function ajoutLigneTab1()
{
    var tab1 = document.getElementById("tab1");
    var length = tab1.rows.length - 1;
    var ligne = tab1.insertRow(-1);

    var textTemp = document.createElement("label");
    var textTemp2 = document.createElement("label");

    var cellule = ligne.insertCell(-1);
    var input2 = document.createElement("input");
    var input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".id");
    input.setAttribute("name", "tableauCultureList[" + length + "].groupe");
    input.setAttribute("type", "text");
    input.setAttribute("value", (length + 1).toString());
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".nbInsemine");
    input.setAttribute("name", "tableauCultureList[" + length + "].nbInsemine");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".id");
    input.setAttribute("name", "tableauCultureList[" + length + "].heureCulture");
    input.setAttribute("type", "number");
    input.value = document.getElementById("tableauCultureList0.heureCulture").value;

    var heure = document.createElement("label");
    heure.innerHTML = " h ";
    input2.setAttribute("id", "tableauCultureList" + length + ".id");
    input2.setAttribute("name", "tableauCultureList[" + length + "].minuteCulture");
    input2.setAttribute("type", "number");
    input2.value = document.getElementById("tableauCultureList0.minuteCulture").value;
    cellule.appendChild(input);
    cellule.appendChild(heure);
    cellule.appendChild(input2);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".nbSegmente");
    input.setAttribute("name", "tableauCultureList[" + length + "].nbSegmente");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("Label");
    input.setAttribute("for", "tableauCultureList" + length + ".segment");
    input.setAttribute("id", "tableauCultureList[" + length + "].segment");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("name", "tableauCultureList[" + length + "].segment");
    input.setAttribute("id", "tableauCultureList" + length + ".segment");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".id");
    input.setAttribute("name", "tableauCultureList[" + length + "].j5JM");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    /* tab2 */
    var tab2 = document.getElementById("tab2");
    var ligne2 = tab2.insertRow(-1);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".id");
    input.setAttribute("name", "tableauCultureList[" + length + "].groupe");
    input.setAttribute("type", "text");
    input.disabled = true;
    input.value = length + 1;
    cellule.appendChild(input);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".mo");
    input.setAttribute("name", "tableauCultureList[" + length + "].mo");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".bl");
    input.setAttribute("name", "tableauCultureList[" + length + "].bl");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".be");
    input.setAttribute("name", "tableauCultureList[" + length + "].be");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".bec");
    input.setAttribute("name", "tableauCultureList[" + length + "].bec");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".q1");
    input.setAttribute("name", "tableauCultureList[" + length + "].q1");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne2.insertCell(-1);
    input = document.createElement("Label");
    input.setAttribute("for", "tableauCultureList" + length + ".nbTotal");
    input.setAttribute("id", "tableauCultureList[" + length + "].nbTotal");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".nbTotal");
    input.setAttribute("name", "tableauCultureList[" + length + "].nbTotal");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);

    /* tab 3 */

    var tab3 = document.getElementById("tab3");
    var ligne3 = tab3.insertRow(-1);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".id");
    input.setAttribute("name", "tableauCultureList[" + length + "].groupe");
    input.setAttribute("type", "text");
    input.disabled = true;
    input.value = length + 1;
    cellule.appendChild(input);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("Label");
    input.setAttribute("for", "tableauCultureList" + length + ".pourJ7");
    input.setAttribute("id", "tableauCultureList[" + length + "].pourJ7");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".pourJ7");
    input.setAttribute("name", "tableauCultureList[" + length + "].pourJ7");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("Label");
    input.setAttribute("for", "tableauCultureList" + length + ".pourBEJ7");
    input.setAttribute("id", "tableauCultureList[" + length + "].pourBEJ7");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".pourBEJ7");
    input.setAttribute("name", "tableauCultureList[" + length + "].pourBEJ7");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("Label");
    input.setAttribute("for", "tableauCultureList" + length + ".pourQ1J7");
    input.setAttribute("id", "tableauCultureList[" + length + "].pourQ1J7");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".pourQ1J7");
    input.setAttribute("name", "tableauCultureList[" + length + "].pourQ1J7");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".J8parNb");
    input.setAttribute("name", "tableauCultureList[" + length + "].J8parNb");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("Label");
    input.setAttribute("for", "tableauCultureList" + length + ".pourJ8");
    input.setAttribute("id", "tableauCultureList[" + length + "].pourJ8");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCultureList" + length + ".pourJ8");
    input.setAttribute("name", "tableauCultureList[" + length + "].pourJ8");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);

    cellule = ligne3.insertCell(-1);
    input = document.createElement("input");
    input.id = "tableauCultureList" + length + "siCryo1";
    input.name = "tableauCultureList[" + length + "].siCryo";
    input.type = "radio";
    input.value = "true";
    input.checked = "checked";

    input2 = document.createElement("input");
    input2.id = "tableauCultureList" + length + "siCryo2";
    input2.name = "tableauCultureList[" + length + "].siCryo";
    input2.type = "radio";
    input2.value = "false";

    textTemp.innerHTML = "Cryo";
    textTemp2.innerHTML = "D&#233truit";

    cellule.appendChild(input);
    cellule.appendChild(textTemp);
    cellule.appendChild(input2);
    cellule.appendChild(textTemp2);
}

function calcul()
{
    /* rajouter test pour NaN */
    var tab1 = document.getElementById("tab1").rows.length;
    var length;
    for (length = 0; length < tab1 - 1; length++)
    {
        var groupe = document.getElementById("tableauCultureList" + length + ".groupe");
        var nbOvo = document.getElementById("tableauCultureList" + length + ".nbInsemine").value;
        var nbSeg = document.getElementById("tableauCultureList" + length + ".nbSegmente").value;
        var resultat = (nbSeg / nbOvo) * 100;
        if (resultat.toString() == "NaN")
        {
            resultat = 0;
        }
        var celluleResultat = document.getElementById("tableauCultureList" + length + ".segment");
        celluleResultat.value = resultat.toString();
        celluleResultat = document.getElementById("tableauCultureList[" + length + "].segment");
        celluleResultat.innerHTML = resultat.toString();

        /*Calcul Nb Total */

        var mo = document.getElementById("tableauCultureList" + length + ".mo").value;
        var bl = document.getElementById("tableauCultureList" + length + ".bl").value;
        var be = document.getElementById("tableauCultureList" + length + ".be").value;
        var bec = document.getElementById("tableauCultureList" + length + ".bec").value;
        var q1 = document.getElementById("tableauCultureList" + length + ".q1").value;

        var nbTotal = parseInt(mo) + parseInt(bl) + parseInt(be) + parseInt(bec) + parseInt(q1);
        if (nbTotal.toString() == "NaN")
        {
            nbTotal = 0;
        }

        var celluleResultatNbTotal = document.getElementById("tableauCultureList" + length + ".nbTotal");
        celluleResultatNbTotal.value = nbTotal.toString();
        celluleResultatNbTotal = document.getElementById("tableauCultureList[" + length + "].nbTotal");
        celluleResultatNbTotal.innerHTML = nbTotal.toString();

        /* Calcul % a J7*/

        var pourcenJ7 = (nbTotal / nbOvo) * 100;
        if (pourcenJ7.toString() == "NaN")
        {
            pourcenJ7 = 0;
        }

        var pourcenBEJ7 = (be / nbOvo) * 100;
        if (pourcenBEJ7.toString() == "NaN")
        {
            pourcenBEJ7 = 0;
        }

        var pourcenQ1J7 = (q1 / nbOvo) * 100;
        if (pourcenQ1J7.toString() == "NaN")
        {
            pourcenQ1J7 = 0;
        }

        var cellulePourcenJ7 = document.getElementById("tableauCultureList" + length + ".pourJ7").value = pourcenJ7.toString();
        cellulePourcenJ7 = document.getElementById("tableauCultureList[" + length + "].pourJ7").innerHTML = pourcenJ7.toString();

        var cellulePourcenBEJ7 = document.getElementById("tableauCultureList" + length + ".pourBEJ7").value = pourcenBEJ7.toString();
        cellulePourcenBEJ7 = document.getElementById("tableauCultureList[" + length + "].pourBEJ7").innerHTML = pourcenBEJ7.toString();

        var cellulePourcenQ1J7 = document.getElementById("tableauCultureList" + length + ".pourQ1J7").value = pourcenQ1J7.toString();
        cellulePourcenQ1J7 = document.getElementById("tableauCultureList[" + length + "].pourQ1J7").innerHTML = pourcenQ1J7.toString();

        /* Calcul % J8 */

        var j8 = document.getElementById("tableauCultureList" + length + ".J8parNb").value;
        var pj8 = (j8 / nbOvo) * 100;
        if (pj8.toString() == "NaN")
        {
            pj8 = 0;
        }

        var cellulePourcenJ8 = document.getElementById("tableauCultureList" + length + ".pourJ8").value = pj8.toString();
        cellulePourcenJ8 = document.getElementById("tableauCultureList[" + length + "].pourJ8").innerHTML = pj8.toString();

    }
}