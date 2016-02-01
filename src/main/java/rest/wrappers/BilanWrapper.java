package rest.wrappers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import entities.BilanObjectif;

@XmlRootElement
public class BilanWrapper implements Serializable{
	private static final long serialVersionUID = -1027553204415003158L;
	protected long id;
	protected Date dateCreation;
	protected UtilisateurWrapper collaborateur;
	protected UtilisateurWrapper manager;
	protected float progression;
	private String decision;
	private String etat;
	private String planFormation;
	private String actions;
	private String dtype;
	private List<BilanObjectif> objectifs;

	/**
	 * @return the dtype
	 */
	public String getDtype() {
		return dtype;
	}

	/**
	 * @param dtype the dtype to set
	 */
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public float getProgression() {
		return progression;
	}

	public void setProgression(float progression) {
		this.progression = progression;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getPlanFormation() {
		return planFormation;
	}

	public void setPlanFormation(String planFormation) {
		this.planFormation = planFormation;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

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

	public UtilisateurWrapper getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(UtilisateurWrapper collaborateur) {
		this.collaborateur = collaborateur;
	}

	public UtilisateurWrapper getManager() {
		return manager;
	}

	public void setManager(UtilisateurWrapper manager) {
		this.manager = manager;
	}

	public List<BilanObjectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<BilanObjectif> objectifs) {
		this.objectifs = objectifs;
	}
}
