package rest.utilities;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
@ApplicationPath("/api")
public class RestActivator extends Application{


	public RestActivator() {
		super();
		 BeanConfig beanConfig = new BeanConfig();
		 beanConfig.setVersion("1.0.0");
		 beanConfig.setSchemes(new String[]{"http"});
		 beanConfig.setHost("localhost:8082");
		 beanConfig.setBasePath("GestionEmploye/api");
		 beanConfig.setResourcePackage("rest.resources");
		 beanConfig.setScan(true);
		
		
	}
	
	
}
