import java.util.Date;
import java.util.List;

import entities.BAP;
import rest.clients.BAPClient;

public class Main {
	public static void main(String args[]){
		BAPClient client = new BAPClient();
		BAP bap = new BAP();
		bap.setEtat("Etat");
		bap.setDateCreation(new Date());
		bap.setDecision("decision");
		client.create(bap);
		
		List<BAP> list;
		list = client.findAll();
		
		for(BAP b:list){
			System.out.println(b);
		}
	}
}
