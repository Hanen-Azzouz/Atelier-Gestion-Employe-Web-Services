package rest.resources;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("greetings")
public class HelloRessource {
	
	/*fonction simple (" fonction commentée: voir fonction avec qury param ")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello From JAX-RS";
	}*/

	//fonction paramétrée les valeurs dans le path
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{name}/{firstname}")
	public String hello(@PathParam("name")String nom,@PathParam("firstname")String prenom) {
		return "Hello  "+ " "+   nom+" "+prenom;
	}
	//fonction paramétrée les valeurs via query param 
	//http://localhost:8082/AtelierRSHello/rest/greetings?name=Hanen&firstname=Azzouz->pour executer dans navigateur
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String hello2(@QueryParam("name")String nom,@QueryParam("firstname")String prenom) {
		
		if(nom==null && prenom== null)
			return "Hello From JAX-RS";
		else
		return "Hello  "+ " "+   nom+" "+prenom;
	}
	
	
	//fonction paramétrée les valeurs via query param
	
}
