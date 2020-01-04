package be.BiscontiLagneau.POJO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import be.BiscontiLagneau.Enum.Specialisation;

public class CMedecin extends CPersonne implements Serializable {
	// Attributs
	private int ID_Personne;
	private String mdp;
	private List<CTraitement> l_Traitements;
	private Long inami;
	private String adresseCabinet;
	private LocalDate dateDiplome;
	private Specialisation specialisation;

	// Constructeur
	public CMedecin() {
	}
	
	//Méthodes
	@Override
	public String toString() {
		
		return "Docteur :" + this.getNom() + " " + this.getPrenom() + " numéro inami : " + this.getInami() + " adresse médecin : " + this.getAdresse();
	}

	// Accesseurs
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<CTraitement> getL_Traitements() {
		return l_Traitements;
	}

	public void setL_Traitements(List<CTraitement> l_Traitements) {
		this.l_Traitements = l_Traitements;
	}

	public String getAdresseCabinet() {
		return adresseCabinet;
	}

	public void setAdresseCabinet(String adresseCabinet) {
		this.adresseCabinet = adresseCabinet;
	}

	public LocalDate getDateDiplome() {
		return dateDiplome;
	}

	public void setDateDiplome(LocalDate dateDiplome) {
		this.dateDiplome = dateDiplome;
	}

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}
	
	public void setInami(Long inami)
	{
		this.inami = inami;
	}
	
	public Long getInami()
	{
		return inami;
	}
	

	public int getID_Personne() {
		return ID_Personne;
	}

	public void setID_Personne(int iD_Personne) {
		ID_Personne = iD_Personne;
	}
}
