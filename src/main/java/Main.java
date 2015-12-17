import java.util.Date;
import java.util.Iterator;
import java.util.List;

import entities.BAP;
import entities.Bilan;
import entities.Collaborateur;
import rest.clients.BAPClient;

public class Main {
	public static void main(String args[]) {
		BAPClient client = new BAPClient();
	
		BAP bap = new BAP();
		bap.setEtat("State");
		bap.setDateCreation(new Date());
		bap.setDecision("i'm not to decide");
		
		Collaborateur collab = new Collaborateur();
		collab.setEmail("email");
		collab.setPassword("password");
		collab.setMatricule("Matricule");
		collab.setNom("Hakkou");
		collab.setPrenom("Amine");
		collab.setPoste("JavaArchitect");
		
		bap.setCollaborateur(collab);
		
		try {
			client.create(bap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<BAP> list;
		list = client.findAll();

		for (Iterator<BAP> iter = list.iterator();iter.hasNext();) {
			System.out.println(iter.next().getDecision());
		}
	}
}
