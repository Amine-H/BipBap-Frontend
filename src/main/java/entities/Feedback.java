package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Feedback implements Serializable {
	private static final long serialVersionUID = -6920749212303590449L;
	private long id;
	private Utilisateur evaluateur;
	private String poste;
	private String codeProjet;
	private String nomProjet;
	private Date dateDebut;
	private Date dateFin;
	private String role;
	private int nombreJours;
	private String commentaire;
	private boolean prive;
	private List<Qualification> qualifications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getEvaluateur() {
		return evaluateur;
	}

	public void setEvaluateur(Utilisateur evaluateur) {
		this.evaluateur = evaluateur;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getCodeProjet() {
		return codeProjet;
	}

	public void setCodeProjet(String codeProjet) {
		this.codeProjet = codeProjet;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getNombreJours() {
		return nombreJours;
	}

	public void setNombreJours(int nombreJours) {
		this.nombreJours = nombreJours;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isPrive() {
		return prive;
	}

	public void setPrive(boolean prive) {
		this.prive = prive;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
}
