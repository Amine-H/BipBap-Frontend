package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entities.Utilisateur;
import rest.clients.BilanClient;
import rest.clients.UtilisateurClient;
import rest.wrappers.BilanWrapper;

@RequestScoped
@ManagedBean
public class Bilans implements Serializable {
	private static final long serialVersionUID = 4256290415066961372L;
	private String utilisateur;
	private List<BilanWrapper> bilans;

	@PostConstruct
	public void postConstruct() {
		// get user
		this.utilisateur = "Collaborateur";
		// setup bilans
		setUpBilans();
	}

	private void setUpBilans() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		try {
			long u_id = Integer.parseInt(params.get("id"));
			UtilisateurClient userClient = new UtilisateurClient();
			Utilisateur user = userClient.find(u_id);
			if(user == null){
				return;
			}
			this.utilisateur = user.getNom() + " " + user.getPrenom();

			BilanClient client = new BilanClient();

			this.bilans = client.getForClient(u_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BilanWrapper> getBilans() {
		return bilans;
	}

	public void setBilans(List<BilanWrapper> bilans) {
		this.bilans = bilans;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
}
