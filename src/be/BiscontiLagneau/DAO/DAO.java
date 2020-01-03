package be.BiscontiLagneau.DAO;

import java.sql.*;
import java.util.List;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean ajouter(T obj);
	
	public abstract boolean supprimer(T obj);
	
	public abstract boolean modifier(T obj);
	
	public abstract T chercher(T obj);
	
	public abstract List<T> recupererTout();
}
