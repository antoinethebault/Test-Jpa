package banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entites.Adresse;
import banque.entites.Client_;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		loadData(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	public static void loadData (EntityManager entityManager) {
		
		Client_ client = new Client_(1, "Albert", LocalDate.of(1980,12,12));
		Client_ client2 = new Client_(2, "Renaud", LocalDate.of(1980,12,12));
		client.setAdresse(new Adresse(1,2,"rue des lilas",22100,"Dinan"));
		client2.setAdresse(new Adresse(1,3,"rue des lilas",22100,"Dinan"));
		
		EntityTransaction tx1 = entityManager.getTransaction();
		tx1.begin();
		entityManager.persist(client);
		entityManager.persist(client2);
		tx1.commit();
		
	}

}
