package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable {
	private static final long serialVersionUID = 842615694609350104L;
	private Map<String, String> taskList = null;
	@ManagedProperty(value = "#{userSession}")
	private UserSession userSession;

	@PostConstruct
	public void postConstruct() {
		entities.Utilisateur user = userSession.getUser();
		if (user.isA("ManagerRH")) {
			this.taskList = this.getManagerRHTaskList();
		} else if (user.isA("Administrateur")) {
			this.taskList = this.getAdministrateurTaskList();
		} else if (user.isA("Collaborateur")) {
			this.taskList = this.getCollaborateurTaskList();
		} else if (user.isA("Evaluateur")) {
			this.taskList = this.getEvaluateurTaskList();
		}
		this.taskList.put("modifier cordonées", "utilisateur.xhtml?id=" + userSession.getUser().getId());
	}
	
	public List<String> getKeyList(){
	     return new ArrayList<String>(taskList.keySet());
	}

	/**
	 * @return the userSession
	 */
	public UserSession getUserSession() {
		return userSession;
	}

	/**
	 * @param userSession
	 *            the userSession to set
	 */
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	/**
	 * @return the taskList
	 */
	public Map<String, String> getTaskList() {
		return taskList;
	}

	/**
	 * @param taskList
	 *            the taskList to set
	 */
	public void setTaskList(Map<String, String> taskList) {
		this.taskList = taskList;
	}

	private Map<String, String> getManagerRHTaskList() {
		// label,link
		Map<String, String> list = new HashMap<>();
		list.put("list des Collaborateurs", "collaborateurs.xhtml");
		return list;
	}

	private Map<String, String> getEvaluateurTaskList() {
		// label,link
		Map<String, String> list = new HashMap<>();
		list.put("list des Collaborateurs", "collaborateurs.xhtml");
		return list;
	}

	private Map<String, String> getCollaborateurTaskList() {
		// label,link
		Map<String, String> list = new HashMap<>();
		list.put("list des Bilans", "bilans.xhtml?id=" + userSession.getUser().getId());
		return list;
	}

	private Map<String, String> getAdministrateurTaskList() {
		// label,link
		Map<String, String> list = new HashMap<>();
		list.put("list des Collaborateurs", "collaborateurs.xhtml");
		list.put("gerer les Utilisateurs", "utilisateurs.xhtml");
		return list;
	}
}
