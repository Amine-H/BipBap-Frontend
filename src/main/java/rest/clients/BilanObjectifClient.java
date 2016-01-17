package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.BilanObjectif;

public class BilanObjectifClient extends AbstractClient<BilanObjectif>{

	public BilanObjectifClient() {
		super(BilanObjectif.class,"BilanObjectif");
	}
	@Override
	public List<BilanObjectif> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BilanObjectif>>() {});
	}
}
