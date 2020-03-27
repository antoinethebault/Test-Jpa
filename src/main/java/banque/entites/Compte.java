package banque.entites;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

/**
 * @author antoinethebault
 *Compte
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="compte")
public class Compte {
	/**id : Integer*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**numero : String*/
	@Column(name="numero")
	private String numero;
	
	/**solde : Double*/
	@Column(name="solde")
	private Double solde;
	
	/**clients : Set<Client_>*/
	@ManyToMany(mappedBy="comptes") 
	private Set<ClientBanque> clients;
	
	/**operations : Set<Operation>*/
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;

	/**Constructor
	 * 
	 */
	public Compte() {
		super();
		clients = new HashSet<>();
		operations = new HashSet<>();
	}

	/**Constructor
	 * @param id
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, Double solde) {
		super();
		clients = new HashSet<>();
		operations = new HashSet<>();
		this.numero = numero;
		this.solde = solde;
	}

	/**Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Getter
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**Getter
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**Getter
	 * @return the clients
	 */
	public Set<ClientBanque> getClients() {
		return clients;
	}

	/**Getter
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**Setter
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**Setter
	 * @param clients the clients to set
	 */
	public void setClients(Set<ClientBanque> clients) {
		this.clients = clients;
	}

	/**Setter
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	/**
	 * addClient ajoute un client
	 * @param client
	 */
	public void addClient(ClientBanque client) {
		clients.add(client);
		client.getComptes().add(this);
	}
	
}
