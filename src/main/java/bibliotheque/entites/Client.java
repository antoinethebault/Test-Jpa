package bibliotheque.entites;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Set;

import javax.persistence.*;

/**
 * @author antoinethebault
 *Client
 */
@Entity
public class Client {
	
	/**id : Integer*/
	@Id
	private Integer id;
	
	/**nom : String*/
	@Column(name="NOM")
	private String nom;
	
	/**prenom : String*/
	@Column(name="PRENOM")
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts;
	
	private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

	/**Constructor
	 * 
	 */
	public Client() {
		super();
	}

	/**Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public static void getEmprunts(EntityManager entityManager, Integer id) {
		TypedQuery<Emprunt> query = entityManager.createQuery("SELECT e FROM Emprunt e, Client c WHERE e.client.id=c.id AND c.id='"+id+"'", Emprunt.class);
		List<Emprunt> liste = query.getResultList();
		for (Emprunt emprunt : liste)
			LOGGER.log(Level.INFO, emprunt.toString());
	}
}
