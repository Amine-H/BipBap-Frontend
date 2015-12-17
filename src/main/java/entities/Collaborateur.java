package entities;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Collaborateur extends Utilisateur {
	private static final long serialVersionUID = 950417161308108107L;

	private Set<Bilan> bilans;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}
}
