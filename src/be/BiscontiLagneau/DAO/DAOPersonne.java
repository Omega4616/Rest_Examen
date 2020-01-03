package be.BiscontiLagneau.DAO;

import java.sql.Connection;

import be.BiscontiLagneau.POJO.CPersonne;

public abstract class DAOPersonne extends DAO<CPersonne> {

	public DAOPersonne(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

}
