package entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bilan implements Serializable {
	private static final long serialVersionUID = -1027553204415003158L;
	protected long id;
	protected Date dateCreation;
	protected Collaborateur collaborateur;
	protected ManagerRH manager;
	protected float progression;

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
