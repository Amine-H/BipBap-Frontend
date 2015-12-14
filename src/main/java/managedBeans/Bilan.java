package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Bilan implements Serializable{
	private static final long serialVersionUID = -200706446360463884L;
	private List<String> objectifs;
	
	@PostConstruct
	public void postConstruct(){
		objectifs = new ArrayList<>();
		objectifs.add("Hey");
	}

	public List<String> getObjectifs() {
		return objectifs;
	}
	public void setObjectifs(List<String> objectifs) {
		this.objectifs = objectifs;
	}
}
