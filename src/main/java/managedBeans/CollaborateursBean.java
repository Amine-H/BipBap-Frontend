package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Collaborateur;
import rest.clients.CollaborateurClient;

@ManagedBean
@ViewScoped
public class CollaborateursBean implements Serializable{
	private static final long serialVersionUID = 1743017759733429447L;
	private List<Collaborateur> collaborateurs;
	
	@PostConstruct
	public void postConstruct(){
		try{
			CollaborateurClient client = new CollaborateurClient();
			collaborateurs = client.findAll();
		}catch(Exception e){e.printStackTrace();}
	}
	
	/**
	 * @return the collaborateurs
	 */
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}
	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}	
}
