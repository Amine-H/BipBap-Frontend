package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.Collaborateur;
import entities.Feedback;
import entities.Qualification;

public class FeedbackClient extends AbstractClient<Feedback> {

	public FeedbackClient() {
		super(Feedback.class, "Feedback");
	}

	@Override
	public List<Feedback> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Feedback>>() {});
	}

	public List<Qualification> getQualifications(long id){
		List<Qualification> qualifications = null;
		
		WebResource res = target.path(java.text.MessageFormat.format("{0}/qualification",new Object[]{id}));
		qualifications = res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Qualification>>() {});
		
		return qualifications;
	}
	
	public Collaborateur getCollaborateur(long id){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/collaborateur",new Object[]{id}));
		return res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Collaborateur.class);
	}
	
	public void addQualification(long id,Qualification entity){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/qualification",new Object[]{id}));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(entity);
	}
	
	public void setQualifications(long id,List<Qualification> qualifications){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/qualifications",new Object[]{id}));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(qualifications);
	}
	
	public void updateQualifications(long id,List<Qualification> qualifications){
		WebResource res = target.path(java.text.MessageFormat.format("{0}/qualifications",new Object[]{id}));
		res.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(qualifications);
	}
}
