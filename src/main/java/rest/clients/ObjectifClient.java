package rest.clients;

import java.util.List;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import entities.Objectif;

public class ObjectifClient extends AbstractClient<Objectif> {

	public ObjectifClient() {
		super(Objectif.class, "Objectif");
	}

	@Override
	public List<Objectif> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Objectif>>() {
		});
	}
}
