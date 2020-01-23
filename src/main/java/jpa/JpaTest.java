package jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import metier.DateApp;
import metier.Participant;
import metier.Sondage;
import metier.UserApp;

import java.util.*;

public class JpaTest {
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		
		EntityManager manager = factory.createEntityManager();
		
		JpaTest test = new JpaTest(manager);
		
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			new JpaTest(manager).createSondage();
			new JpaTest(manager).createDate();
			new JpaTest(manager).createParticipant();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listParticipant();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
		

	}

	private void createParticipant() {
		int numOfParticipant = manager.createQuery("Select a From Participant a", Participant.class).getResultList().size();
		if (numOfParticipant == 0) {

			Participant p1 = new Participant("Joss","Jocelyn","mailJoss");
			Participant p2 = new Participant("Rinch","Eva","mailRinch");
			Participant p3 = new Participant("Renee","Esma","mailRenee");

			manager.persist(p1);
			manager.persist(p2);
			manager.persist(p3);
		}
	}

	private void createDate() {
		int numOfDateApps = manager.createQuery("Select a From DateApp a", DateApp.class).getResultList().size();
		if (numOfDateApps == 0) {

			Calendar date1 = Calendar.getInstance();
			date1.set(2020,2,12,10,30);
			Calendar date2 = Calendar.getInstance();
			date2.set(2020,2,12,16,00);

			//DateApp dateApp1 = new DateApp(date1, true);
			//DateApp dateApp2 = new DateApp(date2, false);

			//manager.persist(dateApp1);
			//manager.persist(dateApp2);
		}
	}

	private void createSondage() {
		List<Participant> ListPart = (List<Participant>) manager.createQuery("Select a From Participant a", Participant.class).getResultList();
		List<DateApp> ListDate = (List<DateApp>) manager.createQuery("Select a From DateApp a", DateApp.class).getResultList();
		Set<Sondage> SetSondage = new HashSet <Sondage>();
		//Sondage sondage = new Sondage(ListPart, ListDate);
		//SetSondage.add(sondage);
		
		Set <String> ListPrefUser = new HashSet <String>();
		UserApp user = new UserApp(SetSondage);
		manager.persist(user);
		//manager.persist(sondage);
		}
	
	private void listParticipant() {
		List<Participant> resultList = manager.createQuery("Select a From Participant a", Participant.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Participant next : resultList) {
			System.out.println("next Participant: " + next);
		}
	}


}
