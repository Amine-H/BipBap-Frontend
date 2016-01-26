package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Feedback;
import entities.Qualification;
import rest.clients.FeedbackClient;

@ManagedBean
@ViewScoped
public class FeedbackBean implements Serializable {
	private static final long serialVersionUID = -235526721152831672L;
	private List<String> themes;
	private Map<String, Integer> qualifications;
	private String collab_nom;
	private String collab_prenom;
	private String collab_matricule;
	private Feedback feedback;

	@PostConstruct
	public void postContruct() {
		initThemes();
		initQualifications();
		
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		try{
			if(params.containsKey("id")){
				long feedback_id = Long.parseLong(params.get("id"));
				FeedbackClient client = new FeedbackClient();
				feedback = client.find(feedback_id);
			}else{
				feedback = initNewFeedback();
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	private Feedback initNewFeedback(){
		Feedback feedback = new Feedback();
		List<Qualification> qualifications = new ArrayList<>();
		feedback.setQualifications(qualifications);
		
		//populate List<Qualification>
		for(int i = 0;i < themes.size();i++){
			Qualification qualification = new Qualification();
			qualification.setTheme(themes.get(i));
			qualifications.add(qualification);
		}
		return feedback;
	}
	
	public String doEnregistrer(){
		
		return "";
	}

	private void initThemes() {
		// initializing themes
		themes = new ArrayList<>(
				Arrays.asList("Productivité", "Qualité / Fiabilité", "technicité", "Conception", "Avant-vente",
						"Gestion de projet", "Gestion de relation client", "Gestion des équipes", "Polyvalence"));
	}

	private void initQualifications() {
		// initializing qualifications
		qualifications = new HashMap<>();
		qualifications.put("Critique", 0);
		qualifications.put("A Développer", 1);
		qualifications.put("Selon attente", 2);
		qualifications.put("Démontre des forces", 3);
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public Map<String, Integer> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Map<String, Integer> qualifications) {
		this.qualifications = qualifications;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	/**
	 * @return the collab_nom
	 */
	public String getCollab_nom() {
		return collab_nom;
	}

	/**
	 * @param collab_nom the collab_nom to set
	 */
	public void setCollab_nom(String collab_nom) {
		this.collab_nom = collab_nom;
	}

	/**
	 * @return the collab_prenom
	 */
	public String getCollab_prenom() {
		return collab_prenom;
	}

	/**
	 * @param collab_prenom the collab_prenom to set
	 */
	public void setCollab_prenom(String collab_prenom) {
		this.collab_prenom = collab_prenom;
	}

	/**
	 * @return the collab_matricule
	 */
	public String getCollab_matricule() {
		return collab_matricule;
	}

	/**
	 * @param collab_matricule the collab_matricule to set
	 */
	public void setCollab_matricule(String collab_matricule) {
		this.collab_matricule = collab_matricule;
	}
}
