package be.BiscontiLagneau.POJO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import be.BiscontiLagneau.DAO.DAOConnexion;
import be.BiscontiLagneau.DAO.DAOPatient;
import be.BiscontiLagneau.Enum.Genre;

public class CPatient extends CPersonne implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Attributs
	int ID_Patient;
	long nrn; //N° de registre national
	
	//Constructeurs
	public CPatient() {}
	
	public CPatient(String nom, String prenom, LocalDate dateNaissance, String telephone, Genre sexe, String adresse, int ID_Patient, long nrn) {
		super(nom, prenom, dateNaissance, telephone, sexe, adresse);
		this.ID_Patient = ID_Patient;
		this.nrn = nrn;
	}

	//Methodes
	public ArrayList<CPatient> recuperTousPatients(){
		DAOPatient daoPatient = new DAOPatient(DAOConnexion.getInstance());
		return daoPatient.recupererTout();
	}
	
	public Boolean ajouter(CPatient patient) {
		DAOPatient daoPatient = new DAOPatient(DAOConnexion.getInstance());
		return daoPatient.ajouter(patient);
	}
	//Accesseurs
	public int getID_Patient() {
		return ID_Patient;
	}

	public void setID_Patient(int iD_Patient) {
		ID_Patient = iD_Patient;
	}
	
	public long getNrn()
	{
		return nrn;
	}
	
	public void setNrn(long nrn)
	{
		this.nrn = nrn;
	}
}
