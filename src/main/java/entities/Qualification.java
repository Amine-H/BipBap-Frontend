package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public class Qualification implements Serializable, Identifiable {
	private static final long serialVersionUID = 3980681774958277995L;
	private long id;
	private String theme;
	private int qualification;
	private String remarque;
	@JsonIgnore
	private Feedback feedback;

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;		
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	/**
	 * @return the feedback
	 */
	public Feedback getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

}