/**
 * Created by fabien on 29/05/16.
 */

function ajoutLigne()
{
    var tableauCollecte = document.getElementById("tableauCollecte");
    var length = tableauCollecte.rows.length - 1;
    var ligne = tableauCollecte.insertRow(-1);

    var cellule = ligne.insertCell(-1);
    var input = document.createElement("input");
    input.setAttribute("id", "tableauCollecteList" + length + ".race_Ovaires");
    input.setAttribute("name", "tableauCollecteList[" + length + "].race_Ovaires");
    input.setAttribute("type", "number");
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCollecteList" + length + ".vache");
    input.setAttribute("name", "tableauCollecteList[" + length + "].vache");
    input.setAttribute("type", "text");
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCollecteList" + length + ".pool");
    input.setAttribute("name", "tableauCollecteList[" + length + "].pool");
    input.setAttribute("type", "checkbox");
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCollecteList" + length + ".nombre_Ovaires");
    input.setAttribute("name", "tableauCollecteList[" + length + "].nombre_Ovaires");
    input.setAttribute("type", "number");
    input.value = 0;
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCollecteList" + length + ".nombre_Ovocytes");
    input.setAttribute("name", "tableauCollecteList[" + length + "].nombre_Ovocytes");
    input.setAttribute("type", "number");
    input.value = 0;
    cellule.appendChild(input);

    cellule = ligne.insertCell(-1);
    input = document.createElement("label");
    input.setAttribute("id", "tableauCollecteList[" + length + "].taux_Collecte");
    input.setAttribute("name", "tableauCollecteList[" + length + "].taux_Collecte");
    input.setAttribute("type", "number");
    cellule.appendChild(input);
    input = document.createElement("input");
    input.setAttribute("id", "tableauCollecteList" + length + ".taux_Collecte");
    input.setAttribute("name", "tableauCollecteList[" + length + "].taux_Collecte");
    input.setAttribute("type", "hidden");
    cellule.appendChild(input);
}

function calcul()
{
    var lengthMax = document.getElementById("tableauCollecte").rows.length - 1;

    var length;
    for (length = 0; length < lengthMax; length++)
    {
        var nbOvaire = document.getElementById("tableauCollecteList" + length + ".nombre_Ovaires").value;
        var nbOvocyte = document.getElementById("tableauCollecteList" + length + ".nombre_Ovocytes").value;
        var resultat = nbOvaire / nbOvocyte;
        if (resultat.toString() == "NaN" || resultat.toString() == "Infinity" || resultat.toString() == "-Infinity")
        {
            resultat = 0;
        }

        var celluleResultat = document.getElementById("tableauCollecteList[" + length + "].taux_Collecte");
        celluleResultat.innerHTML = resultat.toString();
        celluleResultat = document.getElementById("tableauCollecteList" + length + ".taux_Collecte");

        celluleResultat.value = resultat;
    }

}