package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public class Bilan implements Serializable,Identifiable {
	private static final long serialVersionUID = -1027553204415003158L;
	private long id;
	private Date dateCreation;
	private Collaborateur collaborateur;
	private ManagerRH manager;
	@JsonIgnore
	private List<BilanObjectif> objectifs;
	private String DTYPE;
	protected float progression;

	public List<BilanObjectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<BilanObjectif> objectifs) {
		this.objectifs = objectifs;
	}

	public float getProgression() {
		return progression;
	}

	public void setProgression(float progression) {
		this.progression = progression;
	}

	public long getId() {
		return id;
	}

	public String getDTYPE() {
		return DTYPE;
	}

	public void setDTYPE(String dTYPE) {
		DTYPE = dTYPE;
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
