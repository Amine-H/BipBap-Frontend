package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import entities.BIP;
import entities.BilanObjectif;

public class BIPClient extends AbstractClient<BIP> implements BilanClientInterface{

	public BIPClient() {
		super(BIP.class,"BIP");
	}
	@Override
	public List<BIP> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BIP>>() {});
	}
	
	public void addObjectif(long id,BilanObjectif objectif) {
		WebResource res = target.path(java.text.MessageFormat.format("{0}/objectif", new Object[] { id }));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(objectif);
	}
}
