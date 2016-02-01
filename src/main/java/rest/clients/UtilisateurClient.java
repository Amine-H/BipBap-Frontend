package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.Utilisateur;

public class UtilisateurClient extends AbstractClient<Utilisateur>{
	public UtilisateurClient(){
		super(Utilisateur.class,"Utilisateur");
	}
	public Utilisateur login(String email,String password){
		Utilisateur user = null;
		WebResource res = target.path(java.text.MessageFormat.format("login/{0}/{1}", new Object[]{email,password}));
		//user = res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(UtilisateurWrapper.class);
		user = res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Utilisateur.class);
		return user;
	}
	@Override
	public List<Utilisateur> findAll() {
		WebResource res = target;
		//return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<UtilisateurWrapper>>() {});
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Utilisateur>>() {});
	}
}
