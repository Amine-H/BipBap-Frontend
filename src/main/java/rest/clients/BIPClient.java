package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import entities.BIP;

public class BIPClient extends AbstractClient<BIP>{

	public BIPClient() {
		super(BIP.class,"BIP");
	}
	@Override
	public List<BIP> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BIP>>() {});
	}
}
