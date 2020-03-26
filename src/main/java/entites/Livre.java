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
	private Integer id;
	
	/**titre : String*/
	@Column(name="TITRE")
	private String titre;
	
	/**auteur : String*/
	@Column(name="AUTEUR")
	private String auteur;
	
	/**Constructor
	 * 
	 */
	public Livre() {
		super();
	}

	
	
	/**Constructor
	 * @param id
	 * @param titre
	 * @param auteur
	 */
	public Livre(Integer id, String titre, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}



	/**Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**Getter
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}



	/**Getter
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}



	/**Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**Setter
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}



	/**Setter
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}



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
