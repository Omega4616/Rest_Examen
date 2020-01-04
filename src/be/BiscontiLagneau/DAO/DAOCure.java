package be.BiscontiLagneau.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import be.BiscontiLagneau.Enum.Prise;
import be.BiscontiLagneau.POJO.CCure;

public abstract class DAOCure extends DAO<CCure>{

	public DAOCure(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public int ajouterTraitement(int id_traitement, int duree, String medicament, int dosage, Prise prise)
	{
		int code;
		String callStoreProc = "{call ajoutercure(?,?,?,?,?,?)}";
    	try
    	{
    		CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);

        	callableStatement.setInt(1, id_traitement);
        	callableStatement.setInt(2, duree);
        	callableStatement.setString(3, medicament);
        	callableStatement.setInt(4, dosage);
        	callableStatement.setString(5, prise.toString());
        	callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();   
        	code = callableStatement.getInt(6);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		code = 1;
    	}
    	return code;
	}
}
