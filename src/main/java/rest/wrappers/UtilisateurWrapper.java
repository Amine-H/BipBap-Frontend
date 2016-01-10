package rest.wrappers;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import entities.Bilan;
import entities.Utilisateur;

@XmlRootElement
public class UtilisateurWrapper extends Utilisateur implements Serializable {
	private static final long serialVersionUID = -4800031417810545542L;
	@JsonIgnore
	private Set<Bilan> bilans;
	private String DTYPE;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}

	public String getDTYPE() {
		return DTYPE;
	}

	public void setDTYPE(String dTYPE) {
		DTYPE = dTYPE;
	}
}
