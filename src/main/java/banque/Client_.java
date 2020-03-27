package banque;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Client_ {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	@Column(name="nom")
	String nom;
	@Column(name="dateNaissance")
	LocalDate dateNaissance;
	@Embedded
	private Adresse adresse;
	
	@ManyToOne 
	@JoinColumn(name="banqueId") 
	private Banque banque;
	
	@ManyToMany 
	@JoinTable(name="compteAssocie",
			joinColumns= @JoinColumn(name="id_client", referencedColumnName="ID"), 
			inverseJoinColumns= @JoinColumn(name="id_compte", referencedColumnName="ID")
			)
	private Set<Compte> comptes;

	/**Constructor
	 * @param id
	 * @param nom
	 * @param dateNaissance
	 */
	public Client_(Integer id, String nom, LocalDate dateNaissance) {
		super();
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
