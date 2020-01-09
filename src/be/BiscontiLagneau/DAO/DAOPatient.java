package be.BiscontiLagneau.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.POJO.CMedicament;
import be.BiscontiLagneau.POJO.CPatient;
import oracle.jdbc.OracleTypes;

public class DAOPatient extends DAO<CPatient>{

	public DAOPatient(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouter(CPatient patient) {
		Boolean resultAjout = false;
		 try
	        {
	        	//
	        	// AjouterPatient (var_nss NUMBER, var_nom VARCHAR2, var_prenom VARCHAR2, var_adresse VARCHAR2,
			 	// var_naissance DATE, var_sexe VARCHAR2,var_tel VARCHAR2, err_code OUT NUMBER)
	        	//
	        	String callStoreProc = "{call AjouterPatient(?,?,?,?,?,?,?,?)}";
	        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
	        	callableStatement.setLong(1,patient.getNrn());
	        	callableStatement.setString(2, patient.getNom());
	        	callableStatement.setString(3, patient.getPrenom());
	        	callableStatement.setString(4, patient.getAdresse());
	        	callableStatement.setDate(5, java.sql.Date.valueOf(patient.getDateNaissance()));
	        	callableStatement.setString(6, patient.getSexe().toString());
	        	callableStatement.setString(7, patient.getTelephone());
	        	callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);	
	        	callableStatement.execute();
	        	
	        	Integer codeResponse = (Integer) callableStatement.getObject(8);
	        	if(codeResponse != null){
	        		
	        		if (codeResponse == -1) {
						resultAjout = true;
					}
	        		if (codeResponse == 0) {
						resultAjout = false;
					}
	        	}
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	            resultAjout = false;
	        }
	        return resultAjout;
	}

	@Override
	public boolean supprimer(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CPatient chercher(CPatient obj) {
		
		CPatient Patient = new CPatient();
        try
        {
        	//
        	// trouverPatient(var_IDPatient IN INTEGER, p_cursor OUT SYS_REFCURSOR)
        	//
        	String callStoreProc = "{call trouverPatient(?,?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	callableStatement.setInt(1, obj.getID_Patient());
        	callableStatement.registerOutParameter(2, OracleTypes.CURSOR);	
        	callableStatement.execute();
        	
        	ResultSet rs = (ResultSet) callableStatement.getObject(2);
        	if (rs.next()) {
        		Patient.setID_Patient(rs.getInt("ID_Personne"));
        		Patient.setNom(rs.getString("nom"));
        		Patient.setPrenom(rs.getString("prenom"));
        		Patient.setDateNaissance(rs.getDate("naissance").toLocalDate());
        		Patient.setAdresse(rs.getString("adresse"));
        		Patient.setSexe(Genre.fromString(rs.getString("sexe").toLowerCase()));
        		Patient.setTelephone(rs.getString("telephone"));
        		Patient.setNrn(rs.getLong("nss"));
			}

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return Patient;
	}

	@Override
	public ArrayList<CPatient> recupererTout() {
		ArrayList<CPatient> ListePatients = new ArrayList<CPatient>();
        try
        {
        	//
        	// recupTousPatients(c_patients OUT SYS_REFCURSOR)
        	//
        	String callStoreProc = "{call recupTousPatients(?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	callableStatement.registerOutParameter(1, OracleTypes.CURSOR);	
        	callableStatement.execute();
        	
        	ResultSet rs = (ResultSet) callableStatement.getObject(1);
        	while (rs.next()) {
				CPatient cPatient = new CPatient();
				cPatient.setID_Patient(rs.getInt("ID_Personne"));
				cPatient.setNom(rs.getString("nom"));
				cPatient.setPrenom(rs.getString("prenom"));
				cPatient.setDateNaissance(rs.getDate("naissance").toLocalDate());
				cPatient.setAdresse(rs.getString("adresse"));
				cPatient.setSexe(Genre.fromString(rs.getString("sexe").toLowerCase()));
				cPatient.setTelephone(rs.getString("telephone"));
				cPatient.setNrn(rs.getLong("nss"));
				ListePatients.add(cPatient);
			}

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return ListePatients;
	}

}
