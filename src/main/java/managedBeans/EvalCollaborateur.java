package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class EvalCollaborateur implements Serializable{
	private static final long serialVersionUID = -3263514994193779050L;
	private List<String> themes;
	private Map<String,Integer> qualifications;

	@PostConstruct
	public void postContruct() {
		//initializing themes
		themes = new ArrayList<>(
				Arrays.asList("Productivité", "Qualité / Fiabilité", "technicité", "Conception", "Avant-vente",
						"Gestion de projet", "Gestion de relation client", "Gestion des équipes", "Polyvalence"));
		//initializing qualifications
		qualifications = new HashMap<>();
		qualifications.put("Critique",0);
		qualifications.put("A Développer",1);
		qualifications.put("Selon attente",2);
		qualifications.put("Démontre des forces",3);
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
}
