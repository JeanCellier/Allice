package phenotypage.model.donneesExistantes.operateur;

import phenotypage.model.informationsPIV.Informations_PIV;

import java.util.List;

/**
 * @author fabien
 */
public interface OperateurService
{
	Operateur createOperateur(String nom, String prenom);

	Operateur addOperateur(Operateur operateur);

	List<Operateur> findAllOperateur();

	Operateur findOperateurByNom(String nom);

	Operateur findOperateurByPrenom(String prenom);

	Operateur newOperateur();

	void addInformationsPIV(Informations_PIV informations_piv);
}

