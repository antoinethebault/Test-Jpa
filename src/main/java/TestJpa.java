import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entites.Livre;

public class TestJpa {

	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		LOGGER.log(Level.INFO, "La connection est ouverte : " + entityManager.isOpen());
		LOGGER.log(Level.INFO, "Le livre d'id 2 : " + Livre.getLivreId(entityManager, 2));
		LOGGER.log(Level.INFO, "Le livre dont le titre est Germinal : " + Livre.getLivreTitre(entityManager, "Germinal"));
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
