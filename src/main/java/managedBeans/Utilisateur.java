package managedBeans;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import rest.clients.UtilisateurClient;

@ManagedBean
@ViewScoped
public class Utilisateur implements Serializable{
	private static final long serialVersionUID = -2794216803947290097L;
	private entities.Utilisateur utilisateur;
	private Long utilisateur_id = null;
	private String password = new String();
	@PostConstruct
	public void postConstruct(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(params.containsKey("id")){
			utilisateur_id = Long.parseLong(params.get("id"));
			UtilisateurClient client = new UtilisateurClient();
			utilisateur = client.find(utilisateur_id);
			utilisateur.setPassword("");
		}
	}
	
	public String modifier(){
		UtilisateurClient client = new UtilisateurClient();
		utilisateur.setPassword(password);
		client.update(utilisateur, utilisateur_id);
		return "dashboard";
	}
	
	public String annuler(){
		return "dashboard";
	}

	public entities.Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(entities.Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the utilisateur_id
	 */
	public Long getUtilisateur_id() {
		return utilisateur_id;
	}

	/**
	 * @param utilisateur_id the utilisateur_id to set
	 */
	public void setUtilisateur_id(Long utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
