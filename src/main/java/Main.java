import java.util.Date;
import java.util.Iterator;
import java.util.List;

import entities.BAP;
import entities.Collaborateur;
import entities.ManagerRH;
import rest.clients.BAPClient;
import rest.clients.CollaborateurClient;
import rest.clients.ManagerRHClient;

public class Main {
	public static void main(String args[]) {
		BAPClient client = new BAPClient();
		CollaborateurClient cClient = new CollaborateurClient();
		ManagerRHClient mgClient = new ManagerRHClient(); 
		BAP bap = new BAP();
		bap.setEtat("State");
		bap.setDateCreation(new Date());
		bap.setDecision("i'm not the one to decide");

		Collaborateur collab = new Collaborateur();
		collab.setEmail("email");
		collab.setPassword("password");
		collab.setMatricule("Matricule");
		collab.setNom("Hakkou");
		collab.setPrenom("Amine");
		collab.setPoste("JavaArchitect");

		ManagerRH manager = new ManagerRH();
		manager.setEmail("email1");
		manager.setPassword("pasword1");
		manager.setNom("Nom");
		manager.setPrenom("Prenom");

		bap.setCollaborateur(collab);
		bap.setManager(manager);

		try {
			//cClient.create(collab);
			//collab = cClient.findAll().get(0);
			//mgClient.create(manager);
			//manager = mgClient.findAll().get(0);
			client.create(bap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<BAP> list;
		list = client.findAll();

		for (Iterator<BAP> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next().getDecision());
		}
	}
}
