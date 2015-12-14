package managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Utilisateur implements Serializable{
	private static final long serialVersionUID = -2794216803947290097L;
	private entities.Utilisateur utilisateur;

	@PostConstruct
	public void postConstruct(){
		
	}
	
	public String modifier(){
		String result = "";
		//update utilisateur
		return result;
	}
	
	public String annuler(){
		String result = "";
		//redirect to the same page
		return result;
	}

	public entities.Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(entities.Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
