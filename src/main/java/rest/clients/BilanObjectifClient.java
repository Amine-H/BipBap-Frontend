package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.BilanObjectif;
import entities.Collaborateur;
import entities.Feedback;

public class BilanObjectifClient extends AbstractClient<BilanObjectif>{

	public BilanObjectifClient() {
		super(BilanObjectif.class,"BilanObjectif");
	}
	@Override
	public List<BilanObjectif> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<BilanObjectif>>() {});
	}
	
	public Collaborateur getCollaborateur(long id){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/collaborateur",new Object[]{id}));
		return res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Collaborateur.class);
	}
	
	public List<Feedback> getFeedbacks(Long id){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/feedback", new Object[]{id}));
		return res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Feedback>>(){});
	}
	
	public void addFeedback(long id,Feedback entity){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/feedback",new Object[]{id}));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(entity);
	}
}
