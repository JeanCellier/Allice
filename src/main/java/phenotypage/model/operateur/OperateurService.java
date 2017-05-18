package phenotypage.model.operateur;

import phenotypage.model.informationsPIV.Informations_PIV;

import java.util.List;

/**
 * @author fabien
 */
public interface OperateurService
{
	List<Operateur> findAll();

	Operateur createOperateur(String nom, String prenom);

	Operateur addOperateur(Operateur operateur);

	Operateur findOperateurByNom(String nom);

	Operateur findOperateurByPrenom(String prenom);

	Operateur newOperateur();

	void addInformationsPIV(Informations_PIV informations_piv);
}

