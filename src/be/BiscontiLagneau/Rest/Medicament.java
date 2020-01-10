package be.BiscontiLagneau.Rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.BiscontiLagneau.POJO.CMedicament;

@Path("Medicament")
public class Medicament {

	@Path("recupTousMedicaments")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getAllMedicamentsJSON() {
		List<CMedicament> medocs = new ArrayList<CMedicament>();
		CMedicament cMedicament = new CMedicament();
		medocs = cMedicament.recupererTousMedicaments();
		return Response.status(Status.OK).entity(medocs).build();
	}
	@Path("chercherMedicament")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getMedicamentJSON(@QueryParam("IDMedicament") int ID_Medicament) {
		CMedicament medoc = new CMedicament();
		medoc.setID_Medicament(ID_Medicament);
		CMedicament cMedicament = new CMedicament();
		cMedicament = medoc.chercher(medoc);
		return Response.status(Status.OK).entity(cMedicament).build();
	}
}
