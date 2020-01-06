package be.BiscontiLagneau.POJO;

import java.io.Serializable;

public class CPatient extends CPersonne implements Serializable{
	//Attributs
	private static final long serialVersionUID = 1L;
	int nss; //N° sécurité sociale
	
	//Constructeurs
	public CPatient() {}
	
	//Accesseurs
	public int getNss()
	{
		return nss;
	}
	
	public void setNss(int nss)
	{
		this.nss = nss;
	}
}
