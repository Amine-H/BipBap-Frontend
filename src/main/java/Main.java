import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import entities.BAP;
import entities.BilanObjectif;
import entities.Collaborateur;
import entities.Feedback;
import entities.ManagerRH;
import entities.Objectif;
import entities.Qualification;
import rest.clients.BAPClient;
import rest.clients.BilanObjectifClient;
import rest.clients.FeedbackClient;

public class Main {
	public static void main(String args[]) {
		BAPClient client = new BAPClient();
		BilanObjectifClient boClient = new BilanObjectifClient();
		FeedbackClient feedbackClient = new FeedbackClient();

		BAP bap = new BAP();
		bap.setEtat("State");
		bap.setDateCreation(new Date());
		bap.setDecision("i'm not the one to decide");
		bap.setProgression(75);

		Collaborateur collab = new Collaborateur();
		collab.setEmail("email");
		collab.setPassword("password");
		collab.setMatricule("Matricule");
		collab.setNom("Hakkou");
		collab.setPrenom("Amine");
		collab.setPoste("JavaArchitect");

		ManagerRH manager = new ManagerRH();
		manager.setEmail("email1");
		manager.setPassword("password1");
		manager.setNom("Nom");
		manager.setPrenom("Prenom");

		bap.setId(1);
		bap.setCollaborateur(collab);
		bap.setManager(manager);

		bap.setObjectifs(new ArrayList<BilanObjectif>());

		BilanObjectif bObjectif = new BilanObjectif();
		Objectif objectif = new Objectif();

		objectif.setCategorie("Categorie");
		objectif.setDescription("Description");
		objectif.setLibelle("Libelle");
		objectif.setMesure("Mesure");
		objectif.setResponsable_mesure("Responsable mesure");

		bObjectif.setId(4);
		bObjectif.setBilan(bap);
		bObjectif.setObjectif(objectif);
		bObjectif.setPoids(13f);
		bObjectif.setResultat(50f);

		Feedback feedback = new Feedback();
		feedback.setCodeProjet("Code Projet");
		feedback.setCommentaire("this is a long commmaaaaaant");
		feedback.setDateDebut(new Date());
		feedback.setDateFin(new Date());
		feedback.setNomProjet("nomprojet");
		
		Qualification qualification = new Qualification();
		qualification.setQualification(3);
		qualification.setRemarque("Very good (y)");
		qualification.setTheme("Productivité");


		try {
			// cClient.create(collab);
			// collab = cClient.findAll().get(0);
			// mgClient.create(manager);
			// manager = mgClient.findAll().get(0);
			client.create(bap);
			client.addObjectif(1, bObjectif);
			boClient.addFeedback(4, feedback);
			feedbackClient.addQualification(4, qualification);
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
