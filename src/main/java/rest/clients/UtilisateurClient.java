package rest.clients;

import com.sun.jersey.api.client.WebResource;

import entities.Utilisateur;

public class UtilisateurClient extends AbstractClient<Utilisateur>{
	public UtilisateurClient(){
		super(Utilisateur.class);
	}
	public Utilisateur login(String email,String password){		
		WebResource res = target.path(java.text.MessageFormat.format("login/{0}/{1}", new Object[]{email,password}));
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(entityClass);
	}
}
