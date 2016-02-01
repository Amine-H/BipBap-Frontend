package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Utilisateur;
import rest.clients.UtilisateurClient;

@ManagedBean
@ViewScoped
public class Utilisateurs implements Serializable{
	private static final long serialVersionUID = 1230450026396766037L;
	private List<Utilisateur> list;

	@PostConstruct
	public void postConstruct(){
		UtilisateurClient client = new UtilisateurClient();
		list = client.findAll();
	}
	
	public List<Utilisateur> getList() {
		return list;
	}

	public void setList(List<Utilisateur> list) {
		this.list = list;
	}
}
