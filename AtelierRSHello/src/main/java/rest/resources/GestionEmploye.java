package rest.resources;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rest.entities.Employe;

@Path("employes")
@Api
public class GestionEmploye {

	private static List<Employe> employees=new ArrayList<Employe>();
	
	
	public GestionEmploye() {
		employees.add(new Employe("123456"," Ali", "Mohammed"));
	}
	
	// Fonction Afficher
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="Get All Employes")
	 @ApiResponses({
		 @ApiResponse(code=200, message="Success")
		 })
	
	//@Produces(MediaType.APPLICATION_XML)(à utiliser avec postman )
	
	//@Path("test")
	//on a utilisé Response car on a 2 types de retour
	public Response displayEmployeesList(){
		
		if(employees.size()!=0) {
			//GenericEntity<List<Employe>> malist =new GenericEntity<List<Employe>>(employees){};
		return Response.status(Status.ACCEPTED).entity(employees).build();}
		else
			return Response.status(Status.NOT_FOUND).entity(" ").build();
		
	}
	// Fonction Ajouter
	@POST
	
	@Consumes(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.TEXT_PLAIN)
	
	//@Consumes(MediaType.APPLICATION_XML)
	public Response addEmploye(Employe e) {
		
		
		if(employees.add(e))
			return Response.status(Status.OK).entity("add successful").build();
		
		return Response.status(Status.NOT_FOUND).entity("Echec add").build();
			
	}
	// Fonction Modifier
	@PUT
	//@Consumes(MediaType.TEXT_PLAIN)
	
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateEmploye(Employe e) {
		
	for(Employe emp:employees) {
		
		if(emp.getCin().equals(e.getCin()))
				{
			
			   int index=employees.indexOf(emp);
			   employees.set(index, e);
			   
			   return Response.status(Status.OK).entity("update successful").build();
				}
		
	}
	return Response.status(Status.NOT_FOUND).entity("Echec update").build();
	
	}
	
	//Fonction Recherche par CIN
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.TEXT_PLAIN)
	
	@Path("{cin}")
	
	public Response searchEmployeByCIN(@PathParam("cin") String cin) {
		
		for(Employe emp:employees) {
			
			if(emp.getCin().equals(cin))
					{
				
				   
				   
				   return Response.status(Status.FOUND).entity(emp).build();
					}
			
		}
		return Response.status(Status.NOT_FOUND).entity("Employee not found").build();
		
		
	
	}
	// Fonction Supprimer par CIN
	
	@DELETE
	
	@Path("{cin}")
	public Response deleteEmploye(@PathParam("cin") String cin) {
		
		for(Employe emp:employees) {
			
			if(emp.getCin().equals(cin))
					{
				
				   //int index=employees.indexOf(emp);
				   employees.remove(emp);
				   
				   return Response.status(Status.OK).entity("Employee deleted").build();
					}
			
			}
		return Response.status(Status.NOT_FOUND).entity("Employee not found").build();
		
	}
	
	
}
