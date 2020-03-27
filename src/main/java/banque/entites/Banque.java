package banque.entites;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

/**
 * @author antoinethebault
 *Banque
 */
@Entity
public class Banque {
	/**id : Integer*/
	@Id
	private Integer id;
	
	/**nom : String*/
	@Column(name="nom")
	private String nom;
	
	/**clients : Set<Client_>*/
	@OneToMany(mappedBy="banque")
	private Set<Client_> clients;
	
	/**Constructor
	 * 
	 */
	public Banque() {
		super();
		clients = new HashSet<>();
	}

	/**Constructor
	 * @param id
	 * @param nom
	 * @param clients
	 */
	public Banque(Integer id, String nom, Set<Client_> clients) {
		super();
		clients = new HashSet<>();
		this.id = id;
		this.nom = nom;
		this.clients = clients;
	}
	
	
}
