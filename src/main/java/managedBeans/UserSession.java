package managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import entities.Utilisateur;
import rest.clients.UtilisateurClient;

@ManagedBean(name = "userSession")
@SessionScoped
public class UserSession implements Serializable {
	private static final long serialVersionUID = 5109798343236612624L;
	private Utilisateur user;
	private String email;
	private String password;
	private boolean signedIn;

	@PostConstruct
	public void postConstruct() {
		user = new Utilisateur();
		signedIn = false;
	}

	public String doLogin() {
		String location = "";
		UtilisateurClient client = new UtilisateurClient();
		try {
			Utilisateur usr = client.login(email, DigestUtils.md5Hex(password));
			if(usr != null){
				this.user = usr;
				this.signedIn = true;
				location = "app/dashboard";
			}else{
				this.signedIn = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "email et/ou mot de passe incorrect"));
		}
		return location;
	}
	
	public String forwardToDashboard(){
		if(this.signedIn){
			return "app/dashboard";
		}
		return null;
	}

	public String doLogout() {
		String location = "";

		this.user = new Utilisateur();
		this.signedIn = false;
		location = "/index";
		return location;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public boolean isA(String role){
		return role.equals(user.getdtype());
	}

	/**
	 * @return the signedIn
	 */
	public boolean isSignedIn() {
		return signedIn;
	}

	/**
	 * @param signedIn the signedIn to set
	 */
	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
}
