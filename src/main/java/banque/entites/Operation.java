package banque.entites;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * @author antoinethebault
 *Operation
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="operation")
public class Operation {
	/**id : Integer*/
	@Id
	private Integer id;
	
	/**date : LocalDate*/
	@Column(name="date")
	private LocalDate date;
	
	/**montant : Double*/
	@Column(name="montant")
	private Double montant;
	
	/**motif : String*/
	@Column(name="motif")
	private String motif;
	
	/**compte : Compte*/
	@ManyToOne 
	@JoinColumn(name="compte_id") 
	private Compte compte;

	/**Constructor
	 * 
	 */
	public Operation() {
		super();
		//compte=new Compte();
	}

	/**Constructor
	 * @param id
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Operation(LocalDate date, Double montant, String motif) {
		super();
		//compte=new Compte();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}

	/**Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Getter
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**Getter
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Setter
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**Setter
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
