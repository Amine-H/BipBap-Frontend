package entities;

import java.io.Serializable;
import java.util.Date;


public class Bilan implements Serializable {
	private static final long serialVersionUID = -1027553204415003158L;
	private long id;
	private Date dateCreation;
	private Collaborateur collaborateur;
	private ManagerRH manager;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public ManagerRH getManager() {
		return manager;
	}

	public void setManager(ManagerRH manager) {
		this.manager = manager;
	}
}
