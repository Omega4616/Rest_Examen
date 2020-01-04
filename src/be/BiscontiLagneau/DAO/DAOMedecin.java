package be.BiscontiLagneau.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.Enum.Specialisation;
import be.BiscontiLagneau.POJO.CMedecin;
import be.BiscontiLagneau.POJO.CPatient;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

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
        	String callStoreProc = "{call ? = authentificationMedecin(?,?,?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	long numInami = 14689278354L;
        	String motdepasse = "test";
        	callableStatement.setLong(2, numInami);
        	callableStatement.setString(3, motdepasse);
        	callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
        	callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        	
        	
        	String med = "";
        	callableStatement.executeQuery();
        	ResultSet rs = (ResultSet)callableStatement.getObject(1);
        	while(rs.next()) {
        		med = rs.getString("SPECIALISATION");
        	}
        	//int pwd = callableStatement.getInt(3);
        	System.out.println(med + " " + "salut");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return medecin;
	}
	public CMedecin chercherTest() {
		CMedecin medecin = null;
		String med = "";
		int pwd = 0;
        try
        {
        	//
        	// authentificationM_PCursor(var_inami IN INTEGER, var_mdp IN medecins.mdp%type, m_cursor OUT SYS_REFCURSOR)
        	//
        	String callStoreProc = "{call authentificationM_PCursor(?,?,?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	long numInami = 14689278354L;
        	String motdepasse = "test";
        	callableStatement.setLong(1, numInami);
        	callableStatement.setString(2, motdepasse);
        	callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
        	
        	callableStatement.execute();
        	ResultSet rs = (ResultSet) callableStatement.getObject(3);
        	medecin = new CMedecin();
        	if (rs.next()) {
        		medecin.setID_Personne(rs.getInt("ID_Personne"));
        		medecin.setNom(rs.getString("nom"));
        		medecin.setPrenom(rs.getString("prenom"));
        		medecin.setInami(rs.getLong("num_inami"));
        		medecin.setAdresse(rs.getString("adresse"));
        		medecin.setDateDiplome(rs.getDate("date_diplome").toLocalDate());
        		medecin.setAdresseCabinet(rs.getString("adresse_cabinet"));
        		medecin.setDateNaissance(rs.getDate("naissance").toLocalDate());
        		medecin.setTelephone(rs.getString("telephone"));
        		medecin.setSexe(Genre.fromString(rs.getString("sexe")));
			}

        	System.out.println("salut");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("sql exception");
        }
        return medecin;
	}

	@Override
	public List<CMedecin> recupererTout() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
