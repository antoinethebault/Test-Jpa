package banque.entites;

import java.time.LocalDate;
import javax.persistence.*;

import java.util.Set;
import banque.entites.Compte;
import java.util.HashSet;

@Entity
public class Client_ {
	/**id : Integer*/
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	/**nom : String*/
	@Column(name="nom")
	private String nom;
	
	/**dateNaissance : LocalDate*/
	@Column(name="dateNaissance")
	private LocalDate dateNaissance;
	
	/**adresse : Adresse*/
	@Embedded
	private Adresse adresse;
	
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
	public Client_() {
		super();
		comptes = new HashSet<>();
		banque = new Banque();
	}

	/**Constructor
	 * @param id
	 * @param nom
	 * @param dateNaissance
	 */
	public Client_(Integer id, String nom, LocalDate dateNaissance) {
		super();
		comptes = new HashSet<>();
		banque = new Banque();
		this.id = id;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
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
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
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
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
