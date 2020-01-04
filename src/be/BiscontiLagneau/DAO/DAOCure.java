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
	
	public int ajouterCure(int id_traitement, int duree, String medicament, int dosage, Prise prise)
	{
		int code;
		String callStoreProc = "{call ajoutercure(?,?,?,?,?,?)}";
    	try
    	{
    		CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);

        	callableStatement.setInt(1, id_traitement);
        	callableStatement.setString(2, medicament);
        	callableStatement.setInt(3, duree);  
        	callableStatement.setInt(4, dosage);
        	callableStatement.setString(5, prise.toString());
        	callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();   
        	code = callableStatement.getInt(6);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		code = 2;
    	}
    	return code;
	}
	
	public int modifierCure(int id_traitement, int duree, String medicament, int dosage, Prise prise)
	{
		int code;
		String callStoreProc = "{call modifierCure(?,?,?,?,?,?)}";
    	try
    	{
    		CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);

        	callableStatement.setInt(1, id_traitement);
        	callableStatement.setString(2, medicament);
        	callableStatement.setInt(3, duree);   
        	callableStatement.setString(4, prise.toString());
        	callableStatement.setInt(5, dosage);      	
        	callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();   
        	code = callableStatement.getInt(6);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		code = 2;
    	}
    	return code;
	}
	
	public int supprimerCure(int id_traitement, String medicament)
	{
		int code;
		String callStoreProc = "{call supprimerCure(?,?)}";
    	try
    	{
    		CallableStatement callableStatement = this.connect.prepareCall(callStoreProc);

        	callableStatement.setInt(1, id_traitement);
        	callableStatement.setString(2, medicament);     	
        	callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
        	
        	callableStatement.executeUpdate();   
        	code = callableStatement.getInt(6);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		code = 2;
    	}
    	return code;
	}
}
