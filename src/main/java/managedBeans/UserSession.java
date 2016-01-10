package managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Utilisateur;
import rest.clients.UtilisateurClient;

@ManagedBean(name = "userSession")
@SessionScoped
public class UserSession implements Serializable {
	private static final long serialVersionUID = 5109798343236612624L;
	private Utilisateur user;

	@PostConstruct
	public void postConstruct() {
		user = new Utilisateur();
	}

	public String doLogin() {
		String location = "";
		UtilisateurClient client = new UtilisateurClient();
		try {
			Utilisateur usr = client.login(user.getEmail(), user.getPassword());
			this.user = usr;
			location = "app/bilans";
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "email et/ou mot de passe incorrect"));
		}
		return location;
	}

	public String doLogout() {
		String location = "";

		this.user = new Utilisateur();

		location = "/login";
		return location;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
}
