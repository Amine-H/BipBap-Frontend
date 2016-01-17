package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.BAP;
import entities.BilanObjectif;

public class BAPClient extends AbstractClient<BAP> implements BilanClientInterface{
	public BAPClient(){
		super(BAP.class,"BAP");
	}

	public List<BAP> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BAP>>() {});
	}
	
	public void addObjectif(long id,BilanObjectif objectif) {
		WebResource res = target.path(java.text.MessageFormat.format("{0}/objectif", new Object[] { id }));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(objectif);
	}
}
