package banque.entites;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Banque {
	@Id
	Integer id;
	@Column(name="nom")
	String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client_> clients;
	
	/**Constructor
	 * 
	 */
	public Banque() {
		super();
		clients = new HashSet<Client_>();
	}

	/**Constructor
	 * @param id
	 * @param nom
	 * @param clients
	 */
	public Banque(Integer id, String nom, Set<Client_> clients) {
		super();
		clients = new HashSet<Client_>();
		this.id = id;
		this.nom = nom;
		this.clients = clients;
	}
	
	
}
