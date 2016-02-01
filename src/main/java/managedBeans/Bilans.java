package managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entities.BIP;
import entities.Collaborateur;
import rest.clients.CollaborateurClient;
import rest.wrappers.BilanWrapper;

@RequestScoped
@ManagedBean
public class Bilans implements Serializable {
	private static final long serialVersionUID = 4256290415066961372L;
	private String utilisateur;
	private List<BilanWrapper> bilans;
	private Long collaborateur_id = null;
	private Collaborateur collaborateur;
	@PostConstruct
	public void postConstruct() {
		// get user
		this.utilisateur = "Collaborateur";
		// setup bilans
		setUpBilans();
	}
	//this function will get the id parameter then it will display the data
	private void setUpBilans() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		try {
			if(params.containsKey("id")){
				collaborateur_id = Long.parseLong(params.get("id"));
				CollaborateurClient userClient = new CollaborateurClient();
				collaborateur = userClient.find(collaborateur_id);
				if(collaborateur == null){
					return;
				}
				this.utilisateur = collaborateur.getNom() + " " + collaborateur.getPrenom();

				this.bilans = userClient.getBilans(collaborateur_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String createBilan(){
		CollaborateurClient client = new CollaborateurClient();
		BIP bip = new BIP();
		bip.setDateCreation(new Date());
		client.addBIP(collaborateur_id,bip);
		return "app/bilans.xhtml?id="+collaborateur_id;
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
