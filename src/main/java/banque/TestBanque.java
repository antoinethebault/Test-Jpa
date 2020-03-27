package banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entites.Adresse;
import banque.entites.Banque;
import banque.entites.Client_;
import banque.entites.Compte;
import banque.entites.Operation;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		loadData(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	/**
	 * loadData : charge de nouvelles donnees en base de donnees
	 * @param entityManager
	 */
	public static void loadData (EntityManager entityManager) {
		
		//creation des clients
		Client_ client = new Client_(1, "Albert", LocalDate.of(1980,12,12));
		Client_ client2 = new Client_(2, "Renaud", LocalDate.of(1980,12,12));
		Client_ client3 = new Client_(3, "Rene", LocalDate.of(1980,12,12));
		client.setAdresse(new Adresse(1,2,"rue des lilas",22100,"Dinan"));
		client2.setAdresse(new Adresse(2,3,"rue des lilas",22100,"Dinan"));
		client3.setAdresse(new Adresse(3,4,"rue des lilas",22100,"Dinan"));
		Set<Client_> clients = new HashSet<Client_>();
		clients.add(client);
		clients.add(client2);
		clients.add(client3);
		Set<Client_> clients2 = new HashSet<Client_>();
		clients2.add(client2);
		Set<Client_> clients3 = new HashSet<Client_>();
		clients3.add(client3);
		
		
		//creation de la banque
		Banque banque = new Banque(1, "CA", clients);
		client.setBanque(banque);
		client2.setBanque(banque);
		client3.setBanque(banque);
		
		//creation des comptes
		Compte compte1 = new Compte(1,"12345",100.00);
		Compte compte2 = new Compte(2,"123456",150.00);
		Compte compte3 = new Compte(3,"1234567",125.25);
		compte1.addClient(client2);
		compte2.addClient(client3);
		compte3.addClient(client);
		compte3.addClient(client2);
		compte3.addClient(client3);
		
		
		//creation des operations
		Operation operation1 = new Operation(1, LocalDate.of(2020,1,1), 15.00, "achat");
		Operation operation2 = new Operation(2, LocalDate.of(2020,1,1), 20.50, "achat2");
		operation1.setCompte(compte1);
		operation2.setCompte(compte1);
		HashSet<Operation> operations = new HashSet<>();
		operations.add(operation1);
		operations.add(operation2);
		compte1.setOperations(operations);
		
		//integration des donnees en base de donnees
		EntityTransaction tx1 = entityManager.getTransaction();
		tx1.begin();
		entityManager.persist(client);
		entityManager.persist(client2);
		entityManager.persist(client3);
		entityManager.persist(banque);
		entityManager.persist(compte1);
		entityManager.persist(compte2);
		entityManager.persist(compte3);
		entityManager.persist(operation1);
		entityManager.persist(operation2);
		tx1.commit();
		
	}

}
