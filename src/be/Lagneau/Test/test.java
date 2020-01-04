package be.Lagneau.Test;
import javax.swing.JOptionPane;

import be.BiscontiLagneau.DAO.*;
import be.BiscontiLagneau.POJO.CMedecin;

public class test {
	
	public static void main(String[] args) {
		System.out.println("ICI COUCOU");
		DAOMedecin daoMedecin = new DAOMedecin(DAOConnexion.getInstance());
		CMedecin c = daoMedecin.chercher(null);
		System.out.println(c.toString());
		System.out.println(c.getSexe());
	}
}
