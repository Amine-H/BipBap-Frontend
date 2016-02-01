package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entities.BilanObjectif;
import rest.clients.BilanClient;

@RequestScoped
@ManagedBean
public class Bilan implements Serializable {
	private static final long serialVersionUID = -200706446360463884L;
	private List<BilanObjectif> objectifs;
	private float totalPoids = 0;
	private float noteFinale = 0;

	@PostConstruct
	public void postConstruct() {
		setUp();
	}

	private void setUp() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		try {
			if(!params.containsKey("id")){
				return;
			}
			long bilan_id = Long.parseLong(params.get("id"));
			// if u ever need this
			// String bilan_type = params.get("type");
			BilanClient client = new BilanClient();

			objectifs = client.getObjectifs(bilan_id);
			if (objectifs != null) {
				for (BilanObjectif objectif : objectifs) {
					totalPoids += objectif.getPoids();
					noteFinale += objectif.getPoids() * objectif.getResultat();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BilanObjectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<BilanObjectif> objectifs) {
		this.objectifs = objectifs;
	}

	public float getTotalPoids() {
		return totalPoids;
	}

	public void setTotalPoids(float totalPoids) {
		this.totalPoids = totalPoids;
	}

	public float getNoteFinale() {
		return noteFinale;
	}

	public void setNoteFinale(float noteFinale) {
		this.noteFinale = noteFinale;
	}
}
