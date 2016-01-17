package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BIP extends Bilan implements Serializable {
	private static final long serialVersionUID = 3207158439314434363L;
	private String planFormation;
	private String actions;

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
}
