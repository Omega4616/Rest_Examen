package be.BiscontiLagneau.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.BiscontiLagneau.Enum.Specialisation;
import be.BiscontiLagneau.POJO.CMedecin;
import be.BiscontiLagneau.POJO.CPatient;

public class DAOMedecin extends DAO<CMedecin>{

	public DAOMedecin(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouter(CMedecin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(CMedecin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CMedecin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CMedecin chercher(CMedecin obj) {
		CMedecin medecin = null;
        try
        {
        	String callStoreProc = "{call authentificationmedecinP(?,?,?,?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	long numInami = 14689278354L;
        	String motdepasse = "test";
        	callableStatement.setLong(1, numInami);
        	callableStatement.setString(2, motdepasse);
        	callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
        	callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();
        	
        	String med = callableStatement.getString(3);
        	int pwd = callableStatement.getInt(4);
        	System.out.println(med + " " + pwd);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return medecin;
	}
	
	public String chercherTest() {
		CMedecin medecin = null;
		String med = "";
		int pwd = 0;
        try
        {
        	String callStoreProc = "{call authentificationmedecinP(?,?,?,?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	long numInami = 14689278354L;
        	String motdepasse = "test";
        	callableStatement.setInt(1, (int) 14689278354L);
        	callableStatement.setString(2, motdepasse);
        	callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
        	callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();
        	
        	//med = callableStatement.getString(3);
        	ResultSet resultSet = (ResultSet)callableStatement.getObject(3);
        	while (resultSet.next()) {
				med += resultSet.getString("num_inami");
				med += " ";
				med += resultSet.getString("specialisation");
			}
        	//pwd = callableStatement.getInt(4);
        	System.out.println(med);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return med;
	}
	
	public CMedecin getMedecin(int inami, String mdp)
	{
		CMedecin medecin = null;
        try
        {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Medecins M "
                    		+ "INNER JOIN Personnes P ON P.id_personne = M.id_personne "
                    		+ "WHERE num_inami = " + inami + " AND mdp = '" + mdp + "'");

            while(result.next())
            {
            	medecin = new CMedecin();
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setAdresse(result.getString("adresse"));
                //medecin.setDateNaissance(result.getDate("naissance"));
                //medecin.setDateDiplome(result.getDate("date_diplome "));
                medecin.setInami(result.getInt("inami"));
                medecin.setAdresseCabinet(result.getString("adresse_cabinet"));
                medecin.setTelephone(result.getString("telephone"));
                //sexe
                
                switch(result.getString("specialisation "))
                {
                	case "Cardiologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Cardiologie);
                		break;
                	}
                	case "Dermatologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Dermatologie);
                		break;
                	}
                	case "Generale" :
                	{
                		medecin.setSpecialisation(Specialisation.Generale);
                		break;
                	}
                	case "Gynecologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Gynecologie);
                		break;
                	}
                	case "Neurologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Neurologie);
                		break;
                	}
                	case "Ophtalmologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Ophtalmologie);
                		break;
                	}
                	case "Psychiatre" :
                	{
                		medecin.setSpecialisation(Specialisation.Psychiatre);
                		break;
                	}
                	case "Pneumologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Pneumologie);
                		break;
                	}
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return medecin;
	}

	@Override
	public List<CMedecin> recupererTout() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
