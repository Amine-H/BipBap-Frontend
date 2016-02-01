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
	private String dtype;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}

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
}
