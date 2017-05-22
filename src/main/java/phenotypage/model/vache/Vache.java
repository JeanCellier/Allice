package phenotypage.model.vache;

import phenotypage.model.Destinataire.Destinataire;
import phenotypage.model.programme.Programme;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vache
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Boolean present;

	@Column
	private String proprietaire;

	@Column
	private String num_elevage; // == provenance

	@Column(unique = true)
	private String num_identification; // == num national

	@Column
	private String num_travail;

	@Column
	private Integer race;

	@Column
	private Character sexe; //F = femelle M = male

	@Column
	private Date dateNaissance;

	@Column
	private Date entreeQuarantaine;

	@Column
	private Date dateDerniereMiseRepro;

	@Column
	private Date sortiePension;

	@Column
	private Date entreeStation;

	@Column
	private Date sortieStation;

	@Column
	private String parite;

	@Column
	private String EMCO;

	@Column
	private String EMVI;

	@Column
	private Float ageMois;

	@Column
	private String numPere;

	@Column
	private String venduA;

	@Column
	private String numMere;

	@Column
	private String modeReproduction;

	@Column
	private Character DG01;

	@Column
	private String destination;

	@Column
	private String remarques;

	@OneToOne
	private Programme programme;

	@OneToOne
	private Destinataire destinataire;

	public Vache() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getProprietaire()
	{
		return proprietaire;
	}

	public void setProprietaire(String proprietaire)
	{
		this.proprietaire = proprietaire;
	}

	public String getNum_elevage()
	{
		return num_elevage;
	}

	public void setNum_elevage(String num_elevage)
	{
		this.num_elevage = num_elevage;
	}

	public String getNum_identification()
	{
		return num_identification;
	}

	public void setNum_identification(String num_identification)
	{
		this.num_identification = num_identification;
	}

	public int getRace()
	{
		return race;
	}

	public void setRace(int race)
	{
		this.race = race;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Float getAgeMois() {
		return ageMois;
	}

	public void setAgeMois(float ageMois) {
		this.ageMois = ageMois;
	}

	public String getNumPere() {
		return numPere;
	}

	public void setNumPere(String numPere) {
		this.numPere = numPere;
	}

	public String getNumMere() {
		return numMere;
	}

	public void setNumMere(String numMere) {
		this.numMere = numMere;
	}

	public String getParite()
	{
		return parite;
	}

	public void setParite(String parite)
	{
		this.parite = parite;
	}

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}

	public void setRace(Integer race) {
		this.race = race;
	}

	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	public void setAgeMois(Float ageMois) {
		this.ageMois = ageMois;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public String getNum_travail() {
		return num_travail;
	}

	public void setNum_travail(String num_travail) {
		this.num_travail = num_travail;
	}

	public Date getEntreeQuarantaine() {
		return entreeQuarantaine;
	}

	public void setEntreeQuarantaine(Date entreeQuarantaine) {
		this.entreeQuarantaine = entreeQuarantaine;
	}

	public Date getEntreeStation() {
		return entreeStation;
	}

	public void setEntreeStation(Date entreeStation) {
		this.entreeStation = entreeStation;
	}

	public Date getDateDerniereMiseRepro() {
		return dateDerniereMiseRepro;
	}

	public void setDateDerniereMiseRepro(Date dateDerniereMiseRepro) {
		this.dateDerniereMiseRepro = dateDerniereMiseRepro;
	}

	public Date getSortiePension() {
		return sortiePension;
	}

	public void setSortiePension(Date sortiePension) {
		this.sortiePension = sortiePension;
	}

	public Date getSortieStation() {
		return sortieStation;
	}

	public void setSortieStation(Date sortieStation) {
		this.sortieStation = sortieStation;
	}

	public String getEMCO() {
		return EMCO;
	}

	public void setEMCO(String EMCO) {
		this.EMCO = EMCO;
	}

	public String getEMVI() {
		return EMVI;
	}

	public void setEMVI(String EMVI) {
		this.EMVI = EMVI;
	}

	public String getVenduA() {
		return venduA;
	}

	public void setVenduA(String venduA) {
		this.venduA = venduA;
	}

	public String getModeReproduction() {
		return modeReproduction;
	}

	public void setModeReproduction(String modeReproduction) {
		this.modeReproduction = modeReproduction;
	}

	public Character getDG01() {
		return DG01;
	}

	public void setDG01(Character DG01) {
		this.DG01 = DG01;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public Destinataire getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
		setDestination(destinataire.getTypeDestination());
	}
}
