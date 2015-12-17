package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import rest.wrappers.UtilisateurWrapper;

public class UtilisateurClient extends AbstractClient<UtilisateurWrapper>{
	public UtilisateurClient(){
		super(UtilisateurWrapper.class,"Utilisateur");
	}
	public UtilisateurWrapper login(String email,String password){
		UtilisateurWrapper user = null;
		WebResource res = target.path(java.text.MessageFormat.format("login/{0}/{1}", new Object[]{email,password}));
		res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(UtilisateurWrapper.class);
		return user;
	}
	@Override
	public List<UtilisateurWrapper> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<UtilisateurWrapper>>() {});
	}
}
