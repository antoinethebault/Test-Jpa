package banque.entites;

import java.time.LocalDate;
import javax.persistence.*;

import java.util.Set;
import banque.entites.Compte;
import java.util.HashSet;

@Entity
@Table(name="client_banque")
public class ClientBanque {
	/**id : Integer*/
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**nom : String*/
	@Column(name="nom")
	private String nom;

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
	
	
	
	/**dateNaissance : LocalDate*/
	@Column(name="dateNaissance")
	private LocalDate dateNaissance;

	/**Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**adresse : Adresse*/
	@Embedded
	private Adresse adresse;

	/**Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	/**banque : Banque*/
	@ManyToOne 
	@JoinColumn(name="banqueId") 
	private Banque banque;

	
	
	/**comptes : Set<Compte>*/
	@ManyToMany 
	@JoinTable(name="compteAssocie",
			joinColumns= @JoinColumn(name="id_client", referencedColumnName="id"), 
			inverseJoinColumns= @JoinColumn(name="id_compte", referencedColumnName="id")
			)
	private Set<Compte> comptes;

	
	
	/**Constructor
	 * 
	 */
	public ClientBanque() {
		super();
		comptes = new HashSet<>();
		//banque = new Banque();
	}

	/**Constructor
	 * @param id
	 * @param nom
	 * @param dateNaissance
	 */
	public ClientBanque(Integer id, String nom, LocalDate dateNaissance) {
		super();
		comptes = new HashSet<>();
//		banque = new Banque();
		this.id = id;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}
	
	
	/**Constructor
	 * @param nom
	 * @param dateNaissance
	 * @param adresse
	 */
	public ClientBanque(String nom, LocalDate dateNaissance) {
		super();
		comptes = new HashSet<>();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	/**Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**Getter
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}


	/**Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
