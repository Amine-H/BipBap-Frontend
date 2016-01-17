package entities;

import java.io.Serializable;

public class Objectif implements Serializable {
	private static final long serialVersionUID = 63484090573148674L;
	private long id;
	private String libelle;
	private String description;
	private String categorie;
	private String mesure;
	private String responsable_mesure;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMesure() {
		return mesure;
	}

	public void setMesure(String mesure) {
		this.mesure = mesure;
	}

	public String getResponsable_mesure() {
		return responsable_mesure;
	}

	public void setResponsable_mesure(String responsable_mesure) {
		this.responsable_mesure = responsable_mesure;
	}
}
