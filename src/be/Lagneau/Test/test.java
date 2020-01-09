package be.Lagneau.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


import be.BiscontiLagneau.DAO.*;
import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.POJO.CMedecin;
import be.BiscontiLagneau.POJO.CPatient;

public class test {
	
	public static void main(String[] args) {
		System.out.println("ICI COUCOU");/*
		DAOMedecin daoMedecin = new DAOMedecin(DAOConnexion.getInstance());
		CMedecin c = daoMedecin.chercher(null);
		System.out.println(c.toString());
		System.out.println(c.getSexe());
		*/
		//DAOPatient daoPatient = new DAOPatient(DAOConnexion.getInstance());
		/*ArrayList<CPatient> p = daoPatient.recupererTout();
		for (CPatient cPatient : p) {
			System.out.println(cPatient.getNom() + "  " + cPatient.getSexe() + " " + cPatient.getNrn() );
		}*/
		/*
		LocalDate date = LocalDate.of(1952, 06, 29);
		CPatient cPatient = new CPatient();
				cPatient.setNom("VanKo");
				cPatient.setPrenom("Janine");
				cPatient.setDateNaissance(date);
				cPatient.setAdresse("Genk");
				cPatient.setNrn(52062901685L);
				cPatient.setSexe(Genre.Femme);
				cPatient.setTelephone("097654321");
		System.out.println(daoPatient.ajouter(cPatient));*/
		
		LocalDate date = LocalDate.of(2010, 05, 21);
		String dateS = date.toString();
		LocalDate date2 = LocalDate.parse("2000-08-02");
		
		System.out.println("date : " + date);
		System.out.println("dateS : " + dateS);
		System.out.println("date2 : " + date2);
	}
}
