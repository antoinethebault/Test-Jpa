import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		LOGGER.log(Level.INFO, "La connection est ouverte : " + entityManager.isOpen());
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
