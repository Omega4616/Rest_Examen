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
@Path("Medecin")
public class Medecin {
	
	@Path("authentification")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getClientJSON(@QueryParam("inami") long inami, @QueryParam("mdp") String mdp) {
		CMedecin medecin = new CMedecin();
		CMedecin m = new CMedecin();
		m.setInami(inami);
		m.setMdp(mdp);
		medecin = medecin.recupMedecin(m);
		return Response.status(Status.OK).entity(medecin).build();
	}

}
