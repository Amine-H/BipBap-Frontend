package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Feedback;
import entities.Qualification;
import rest.clients.BilanObjectifClient;
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
	private Long objectif_id;
	private Long feedback_id;
	
	@ManagedProperty(value="#{userSession}")
	private UserSession userSession;

	@PostConstruct
	public void postContruct() {
		initThemes();
		initQualifications();

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		try{
			if(params.containsKey("o_id")){
				this.objectif_id = new Long(params.get("o_id"));
			}
			if(params.containsKey("id")){
				Long feedback_id = this.feedback_id = new Long(params.get("id"));
				FeedbackClient client = new FeedbackClient();
				feedback = client.find(feedback_id);
				List<Qualification> qualifications = client.getQualifications(feedback_id);
				if(qualifications == null){
					qualifications = initNewQualifications();
				}

				feedback.setQualifications(qualifications);
			}else{
				feedback = initNewFeedback();
				entities.Utilisateur user = userSession.getUser();
				if(user.isA("Evaluateur")){
					feedback.setEvaluateur((entities.Evaluateur)user);
				}else{
					FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.xhtml");
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	private Feedback initNewFeedback(){
		Feedback feedback = new Feedback();
		List<Qualification> qualifications = initNewQualifications();
		feedback.setQualifications(qualifications);

		return feedback;
	}
	
	private List<Qualification> initNewQualifications(){
		List<Qualification> qualifications = new ArrayList<>();
		//populate List<Qualification>
		for(int i = 0;i < themes.size();i++){
			Qualification qualification = new Qualification();
			qualification.setTheme(themes.get(i));
			qualifications.add(qualification);
		}
		
		return qualifications;
	}
	
	
	
	public String doEnregistrer(){
		System.out.println("started doEnregistrer");
		
		if(objectif_id != null){
			if(feedback_id != null){//update feedback
				FeedbackClient client = new FeedbackClient();
				client.update(feedback, feedback_id);
				client.updateQualifications(feedback_id, feedback.getQualifications());
			}else{//create feedback
				System.out.println("adding new feedback to objectif "+ objectif_id);
				//add feedback
				BilanObjectifClient objectifClient = new BilanObjectifClient();
				objectifClient.addFeedback(objectif_id, this.feedback);
				
				//set Qualifications
				FeedbackClient feedbackClient = new FeedbackClient();
				feedbackClient.setQualifications(objectif_id, this.feedback.getQualifications());
			}
		}else{
			System.out.println("error please specify o_id");
		}
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
		qualifications.put("Critique", 1);
		qualifications.put("A Développer", 2);
		qualifications.put("Selon attente", 3);
		qualifications.put("Démontre des forces", 4);
	}

	/**
	 * @return the objectif_id
	 */
	public Long getObjectif_id() {
		return objectif_id;
	}

	/**
	 * @param objectif_id the objectif_id to set
	 */
	public void setObjectif_id(Long objectif_id) {
		this.objectif_id = objectif_id;
	}

	/**
	 * @return the feedback_id
	 */
	public Long getFeedback_id() {
		return feedback_id;
	}

	/**
	 * @param feedback_id the feedback_id to set
	 */
	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}

	/**
	 * @return the userSession
	 */
	public UserSession getUserSession() {
		return userSession;
	}

	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
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
