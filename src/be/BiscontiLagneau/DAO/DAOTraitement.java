package be.BiscontiLagneau.DAO;

import java.sql.Connection;

import be.BiscontiLagneau.POJO.CTraitement;

public abstract class DAOTraitement extends DAO<CTraitement>{

	public DAOTraitement(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

}
