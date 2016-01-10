package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.ManagerRH;

public class ManagerRHClient extends AbstractClient<ManagerRH> {

	public ManagerRHClient() {
		super(ManagerRH.class, "ManagerRH");
	}

	@Override
	public List<ManagerRH> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<ManagerRH>>() {
		});
	}
}
