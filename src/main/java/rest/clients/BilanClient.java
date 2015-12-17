package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import rest.wrappers.BilanWrapper;

public class BilanClient extends AbstractClient<BilanWrapper> {
	public BilanClient() {
		super(BilanWrapper.class,"Bilan");
	}

	@Override
	public List<BilanWrapper> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BilanWrapper>>() {
		});
	}

	public List<BilanWrapper> getForClient(long id) {
		List<BilanWrapper> bilans = null;

		WebResource res = target.path(java.text.MessageFormat.format("collab/{0}", new Object[] { id }));
		bilans = res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BilanWrapper>>() {});

		return bilans;
	}
}
