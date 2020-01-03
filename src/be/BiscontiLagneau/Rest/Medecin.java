package be.BiscontiLagneau.Rest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.BiscontiLagneau.POJO.CMedecin;

public class Medecin {
	/*
	@Path("getMedecin")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getClientJSON(@QueryParam("id") int id) {

		CMedecin medecin = new CMedecin();
		
		String sql = "{? = call max(?, ?)}"; 
		CallableStatement statement = connection.prepareCall(sql, 
		          ResultSet.TYPE_FORWARD_ONLY, 
		          ResultSet.CONCUR_READ_ONLY);
		
		cli.setNom(nom);
		cli.setPrenom(prenom);
		cli.setAge(age);
		/*
		 * String chaine = "{" +"\"client\": {" +"	\"nom\": \" "+ nom + "\", "
		 * +"	\"prenom\": \" " + prenom + "\", " +"	\"age\": " + age + " " +"}"
		 * +"}";
		 */
	//	return Response.status(Status.OK).entity(cli).build();
	//}

}
