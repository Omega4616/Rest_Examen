package be.BiscontiLagneau.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import be.BiscontiLagneau.POJO.CTraitement;

public abstract class DAOTraitement extends DAO<CTraitement>{

	public DAOTraitement(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public int ajouterTraitement(int inami, int nss, String cause)
	{
		int id_traitement = 0;
		String callStoreProc = "{call ajoutertraitementpatient(?,?,?,?,?)}";
    	try
    	{
    		CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);

        	callableStatement.setLong(1, nss);
        	callableStatement.setLong(2, inami);
        	callableStatement.setString(3, cause);
        	callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
        	callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();   
        	id_traitement = callableStatement.getInt(5);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		
    	}
    	return id_traitement;
	}
}
