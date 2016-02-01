package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Collaborateur;
import entities.Feedback;
import rest.clients.BilanObjectifClient;

@ManagedBean
@ViewScoped
public class FeedbacksBean implements Serializable{
	private static final long serialVersionUID = 1732062094589144915L;
	private Long objectif_id;
	private List<Feedback> feedbacks;
	private Collaborateur collaborateur;
	
	@PostConstruct
	public void postConstruct() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		BilanObjectifClient client = new BilanObjectifClient();

		if (params.containsKey("o_id")) {
			this.objectif_id = Long.parseLong(params.get("o_id"));
			this.feedbacks = client.getFeedbacks(objectif_id);
			this.collaborateur = client.getCollaborateur(objectif_id);
		}
	}

	/**
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the feedbacks
	 */
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	/**
	 * @param feedbacks
	 *            the feedbacks to set
	 */
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	/**
	 * @return the objectif_id
	 */
	public Long getObjectif_id() {
		return objectif_id;
	}

	/**
	 * @param objectif_id
	 *            the objectif_id to set
	 */
	public void setObjectif_id(Long objectif_id) {
		this.objectif_id = objectif_id;
	}
}
