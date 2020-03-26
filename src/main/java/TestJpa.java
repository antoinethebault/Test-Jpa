import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entites.Client;
import entites.Emprunt;
import entites.Livre;

public class TestJpa {

	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		LOGGER.log(Level.INFO, "La connection est ouverte : " + entityManager.isOpen());
		LOGGER.log(Level.INFO, "Le livre d'id 2 : " + Livre.getLivreId(entityManager, 2));
		LOGGER.log(Level.INFO, "Le livre dont le titre est Germinal : " + Livre.getLivreTitre(entityManager, "Germinal"));
		LOGGER.log(Level.INFO, "---------Recuperer tous les livres lies a l'emprunt 1-----");
		Emprunt.getEmpruntLivres(entityManager,1);
		LOGGER.log(Level.INFO, "---------Recuperer tous les emprunts lies au client 1-----");
		Client.getEmprunts(entityManager,1);
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
