package banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entites.Adresse;
import banque.entites.AssuranceVie;
import banque.entites.Banque;
import banque.entites.ClientBanque;
import banque.entites.Compte;
import banque.entites.LivretA;
import banque.entites.Operation;
import banque.entites.Virement;

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
		ClientBanque client = new ClientBanque("Albert", LocalDate.of(1980,12,12));
		ClientBanque client2 = new ClientBanque("Renaud", LocalDate.of(1980,12,12));
		ClientBanque client3 = new ClientBanque("Rene", LocalDate.of(1980,12,12));
		client.setAdresse(new Adresse(2,"rue des lilas",22100,"Dinan"));
		client2.setAdresse(new Adresse(3,"rue des lilas",22100,"Dinan"));
		client3.setAdresse(new Adresse(4,"rue des lilas",22100,"Dinan"));
		Set<ClientBanque> clients = new HashSet<ClientBanque>();
		clients.add(client);
		clients.add(client2);
		clients.add(client3);
		Set<ClientBanque> clients2 = new HashSet<ClientBanque>();
		clients2.add(client2);
		Set<ClientBanque> clients3 = new HashSet<ClientBanque>();
		clients3.add(client3);
	
		//creation de la banque
		Banque banque = new Banque("CA", clients);
		client.setBanque(banque);
		client2.setBanque(banque);
		client3.setBanque(banque);
		
		//creation des comptes
		Compte compte1 = new Compte("12345",100.00);
		compte1.addClient(client);
		compte1.addClient(client2);
		AssuranceVie assuranceVie = new AssuranceVie("123456", 150.00,LocalDate.of(2030, 1, 1),5.00);
		LivretA livretA = new LivretA("1234567",200.50,2.50);
		assuranceVie.addClient(client3);
		livretA.addClient(client3);
		
		//creation des virements
		Virement virement1 = new Virement(LocalDate.of(2020,1,1), 15.00, "achat", "beneficiaire1");
		Virement virement2 = new Virement(LocalDate.of(2020,1,1), 15.00, "achat2", "beneficiaire1");
		HashSet<Operation> virements = new HashSet<>();
		//virements.add(virement1);
		//virements.add(virement2);
		virement1.setCompte(compte1);
		virement2.setCompte(compte1);
		//compte1.setOperations(virements);
		
		//creation des operations
		Operation operation1 = new Operation(LocalDate.of(2020,1,1), 15.00, "achat");
		Operation operation2 = new Operation(LocalDate.of(2020,1,1), 20.50, "achat2");
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
		entityManager.persist(assuranceVie);
		entityManager.persist(livretA);
		entityManager.persist(compte1);
		entityManager.persist(operation1);
		entityManager.persist(operation2);
		entityManager.persist(virement1);
		entityManager.persist(virement2);
		tx1.commit();
		
	}

}
