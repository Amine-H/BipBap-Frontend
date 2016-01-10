package entities;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
@XmlRootElement
public class ManagerRH extends Utilisateur {
	private static final long serialVersionUID = 3259601862182253323L;
	@JsonIgnore
	private Set<Bilan> bilans;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}
}
