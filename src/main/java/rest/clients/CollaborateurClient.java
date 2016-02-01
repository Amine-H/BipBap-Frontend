package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.BIP;
import entities.Collaborateur;
import rest.wrappers.BilanWrapper;

public class CollaborateurClient extends AbstractClient<Collaborateur> {

	public CollaborateurClient() {
		super(Collaborateur.class, "Collaborateur");
	}

	@Override
	public List<Collaborateur> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Collaborateur>>() {
		});
	}

	public List<BilanWrapper> getBilans(long id) {
		List<BilanWrapper> list = null;
		WebResource res = target.path(java.text.MessageFormat.format("/{0}/bilans", new Object[] { id }));

		list = res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BilanWrapper>>() {
		});

		return list;

	}
	
	public void addBIP(Long id,BIP entity){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/bip",new Object[]{id}));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(entity);
	}
}
