package entities;

import java.util.Set;

public class ManagerRH extends Utilisateur {
	private static final long serialVersionUID = 3259601862182253323L;
	private Set<Bilan> bilans;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}
}