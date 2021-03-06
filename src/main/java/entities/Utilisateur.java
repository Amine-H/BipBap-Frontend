package entities;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.codec.digest.DigestUtils;

@XmlRootElement
public class Utilisateur implements Serializable,Identifiable{
	private static final long serialVersionUID = -5054129581423435016L;
	private long id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String dtype;
	private Date dateEmbauche;
	private String matricule;
	private String poste;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = DigestUtils.md5Hex(password);
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getdtype() {
		return dtype;
	}
	public void setdtype(String dtype) {
		this.dtype = dtype;
	}
	public boolean isA(String role) {
		return role.equals(this.dtype);
	}
}
