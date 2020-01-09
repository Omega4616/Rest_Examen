package be.BiscontiLagneau.Rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.POJO.CPatient;

@Path("Patient")
public class Patient {
	
	@Path("recupTousPatients")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getAllPatientsJSON() {
		List<CPatient> patients = new ArrayList<CPatient>();
		CPatient cPatient = new CPatient();
		patients = cPatient.recuperTousPatients();
		return Response.status(Status.OK).entity(patients).build();
	}
	
	@Path("ajouterPatient")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response addPatientJSON(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("naissance") String naissance
								 , @QueryParam("adresse") String adresse, @QueryParam("nrn") long nrn, @QueryParam("sexe") String sexe
								 , @QueryParam("telephone") String telephone ) {
		Boolean estAjouter;
		LocalDate date = LocalDate.parse(naissance);
		CPatient cPatient = new CPatient();
				cPatient.setNom(nom);
				cPatient.setPrenom(prenom);
				cPatient.setDateNaissance(date);
				cPatient.setAdresse(adresse);
				cPatient.setNrn(nrn);
				cPatient.setSexe(Genre.fromString(sexe.toLowerCase()));
				cPatient.setTelephone(telephone);
				
		estAjouter = cPatient.ajouter(cPatient);
				
		
		return Response.status(Status.OK).entity(estAjouter).build();
	}
	

}
