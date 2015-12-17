package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.BAP;

public class BAPClient extends AbstractClient<BAP>{
	public BAPClient(){
		super(BAP.class,"BAP");
	}

	@Override
	public List<BAP> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BAP>>() {});
	}
}
