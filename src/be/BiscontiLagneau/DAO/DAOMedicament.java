package be.BiscontiLagneau.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.Enum.Specialisation;
import be.BiscontiLagneau.POJO.CMedecin;
import be.BiscontiLagneau.POJO.CMedicament;
import oracle.jdbc.OracleTypes;

public class DAOMedicament extends DAO<CMedicament> {

	public DAOMedicament(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouter(CMedicament obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(CMedicament obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CMedicament obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CMedicament chercher(CMedicament medicament) {
		CMedicament Medicament = new CMedicament();
        try
        {
        	//
        	// trouverMedicament(var_IDMedicament IN INTEGER, m_cursor OUT SYS_REFCURSOR)
        	//
        	String callStoreProc = "{call trouverMedicament(?,?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	callableStatement.setInt(1, medicament.getID_Medicament());
        	callableStatement.registerOutParameter(2, OracleTypes.CURSOR);	
        	callableStatement.execute();
        	
        	ResultSet rs = (ResultSet) callableStatement.getObject(2);
        	if (rs.next()) {
        		Medicament.setID_Medicament(rs.getInt("ID_Medicament"));
        		Medicament.setNom(rs.getString("nom"));
        		Medicament.setDescription(rs.getString("description"));
        		Medicament.setType(rs.getString("type"));
        		Medicament.setDosage_jour_max(rs.getString("dosage_jour_max"));
			}
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return Medicament;
	}

	@Override
	public ArrayList<CMedicament> recupererTout() {
		ArrayList<CMedicament> ListeMedicaments = new ArrayList<CMedicament>();
        try
        {
        	//
        	// recupTousMedicaments(c_medicaments OUT SYS_REFCURSOR)
        	//
        	String callStoreProc = "{call recupTousMedicaments(?)}";
        	CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);
        	callableStatement.registerOutParameter(1, OracleTypes.CURSOR);	
        	callableStatement.execute();
        	
        	ResultSet rs = (ResultSet) callableStatement.getObject(1);
        	while (rs.next()) {
				CMedicament cMedicament = new CMedicament();
				cMedicament.setID_Medicament(rs.getInt("ID_Medicament"));
				cMedicament.setNom(rs.getString("nom"));
				cMedicament.setDescription(rs.getString("description"));
				cMedicament.setType(rs.getString("type"));
				cMedicament.setDosage_jour_max(rs.getString("dosage_jour_max"));
				ListeMedicaments.add(cMedicament);
			}

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return ListeMedicaments;
	}

}
