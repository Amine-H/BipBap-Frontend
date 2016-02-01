package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Collaborateur;
import rest.clients.CollaborateurClient;
import rest.wrappers.BilanWrapper;

@ManagedBean
@ViewScoped
public class CollaborateurBean implements Serializable {
	private static final long serialVersionUID = 4782039511731790543L;
	private Long collaborateur_id = null;
	private Collaborateur collaborateur = null;
	private List<BilanWrapper> collab_bilans;

	@PostConstruct
	public void postConstruct() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		CollaborateurClient client = new CollaborateurClient();
		try {
			if(params.containsKey("id")){
				collaborateur_id = Long.parseLong(params.get("id"));
				collaborateur = client.find(collaborateur_id);
				collab_bilans = client.getBilans(collaborateur_id);
			}else{
				String context = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
				FacesContext.getCurrentInstance().getExternalContext().redirect(context + "/app/collaborateurs.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the collab_bilans
	 */
	public List<BilanWrapper> getCollab_bilans() {
		return collab_bilans;
	}

	/**
	 * @param collab_bilans the collab_bilans to set
	 */
	public void setCollab_bilans(List<BilanWrapper> collab_bilans) {
		this.collab_bilans = collab_bilans;
	}

	/**
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur
	 *            the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the collaborateur_id
	 */
	public Long getCollaborateur_id() {
		return collaborateur_id;
	}

	/**
	 * @param collaborateur_id
	 *            the collaborateur_id to set
	 */
	public void setCollaborateur_id(Long collaborateur_id) {
		this.collaborateur_id = collaborateur_id;
	}
}
