package be.Lagneau.Test;
import javax.swing.JOptionPane;

import be.BiscontiLagneau.DAO.*;

public class test {
	
	public static void main(String[] args) {
		System.out.println("ICI COUCOU");
		DAOMedecin daoMedecin = new DAOMedecin(DAOConnexion.getInstance());
		String s = daoMedecin.chercherTest();
		System.out.println("ICI " + daoMedecin.chercherTest());
	}
	
	

}
