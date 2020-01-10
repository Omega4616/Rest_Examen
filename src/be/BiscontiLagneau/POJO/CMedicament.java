package be.BiscontiLagneau.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.BiscontiLagneau.DAO.DAOConnexion;
import be.BiscontiLagneau.DAO.DAOMedicament;

public class CMedicament implements Serializable {
	// Attributs
	private static final long serialVersionUID = 1L;
	private int ID_Medicament;
	private String nom;
	private String type;
	private String description;
	private String dosage_jour_max;

	// Constructeurs
	public CMedicament() {

	}

	public CMedicament(String nom, String type, String description, String dosage_jour_max) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.setDosage_jour_max(dosage_jour_max);
	}
	
	//Méthodes
	public ArrayList<CMedicament> recupererTousMedicaments() {
		DAOMedicament daoMedicament = new DAOMedicament(DAOConnexion.getInstance());
		return daoMedicament.recupererTout();
	}
	public CMedicament chercher(CMedicament medicament) {
		DAOMedicament daoMedicament= new DAOMedicament(DAOConnexion.getInstance());
		return daoMedicament.chercher(medicament);
	}
	
	// Accesseurs
	
	public int getID_Medicament() {
		return ID_Medicament;
	}

	public void setID_Medicament(int iD_Medicament) {
		ID_Medicament = iD_Medicament;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDosage_jour_max() {
		return dosage_jour_max;
	}

	public void setDosage_jour_max(String dosage_jour_max) {
		this.dosage_jour_max = dosage_jour_max;
	}


	


}
