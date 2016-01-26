package managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Objectif;
import rest.clients.ObjectifClient;

@ManagedBean
@ViewScoped
public class Objectif_mb implements Serializable{
	private static final long serialVersionUID = -7774795865954906489L;
	private Objectif objectif;

	@PostConstruct
	public void postConstruct() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		try {
			if (params.containsKey("id")) {
				long objectif_id = Long.parseLong(params.get("id"));
				ObjectifClient client = new ObjectifClient();
				objectif = client.find(objectif_id);
			} else {
				objectif = new Objectif();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doSave() {
		ObjectifClient client = new ObjectifClient();

		if (objectif.getId() != 0) {// update
			client.update(objectif, objectif.getId());
		} else {// save
			client.create(objectif);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("bilan.xhtml?id=1&type=BAP");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}
}
