package managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@RequestScoped
@ManagedBean
public class Bilans implements Serializable{
	private static final long serialVersionUID = 4256290415066961372L;
	private String utilisateur;
	private TreeNode bilansTree;
	@PostConstruct 
	public void postConstruct(){
		this.utilisateur = "Amine Hakkou";
		bilansTree = new DefaultTreeNode();
	}

	public String getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TreeNode getBilansTree() {
		return bilansTree;
	}

	public void setBilansTree(TreeNode bilans) {
		this.bilansTree = bilans;
	}
}
