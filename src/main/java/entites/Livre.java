package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;


/**
 * @author antoinethebault
 *Livre
 */
@Entity
public class Livre {
	/**id : Integer*/
	@Id
	Integer id;
	
	/**titre : String*/
	@Column(name="TITRE")
	String titre;
	
	/**auteur : String*/
	@Column(name="AUTEUR")
	String auteur;
	
	/**
	 * getLivre : retourne un livre en fonction de son id
	 * @param entityManager
	 * @param id
	 * @return livre
	 */
	public static Livre getLivreId(EntityManager entityManager, Integer id) {
		return entityManager.find(Livre.class, id);
	}
	
	/**
	 * getLivreTitre : retourne un livre en fonction de son titre
	 * @param entityManager
	 * @param titre
	 * @return
	 */
	public static Livre getLivreTitre(EntityManager entityManager, String titre) {
		TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre='"+titre+"'", Livre.class);
		return query.getResultList().get(0);
	}
	
	@Override
	public String toString () {
		return Integer.toString(id)+" "+titre+" "+auteur;
	}
}
