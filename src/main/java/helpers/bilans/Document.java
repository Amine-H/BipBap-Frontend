package helpers.bilans;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable {
	private static final long serialVersionUID = -7176631550281536393L;
	private Date dateCreation;
	private float progression;

	public Document(Date dateCreation,float progression){
		this.dateCreation = dateCreation;
		this.progression = progression;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public float getProgression() {
		return progression;
	}

	public void setProgression(float progression) {
		this.progression = progression;
	}
}
