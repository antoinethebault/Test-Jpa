package banque.entites;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

/**
 * @author antoinethebault
 *Banque
 */
@Entity
@Table(name="banque")
public class Banque {
	/**id : Integer*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**nom : String*/
	@Column(name="nom")
	private String nom;
	
	/**clients : Set<Client_>*/
	@OneToMany(mappedBy="banque")
	private Set<ClientBanque> clients;
	
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
	public Banque(String nom, Set<ClientBanque> clients) {
		super();
		clients = new HashSet<>();
		this.nom = nom;
		this.clients = clients;
	}
	
	
}
