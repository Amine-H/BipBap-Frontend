package rest.clients;

import java.util.List;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import entities.Feedback;

public class FeedbackClient extends AbstractClient<Feedback> {

	public FeedbackClient() {
		super(Feedback.class, "Feedback");
	}

	@Override
	public List<Feedback> findAll() {
		WebResource res = target;
		return res.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Feedback>>() {});
	}

}
