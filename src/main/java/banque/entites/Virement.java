package banque.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="virement")
public class Virement extends Operation{
	/**beneficiaire : String*/
	@Column(name="BENEFICIAIRE")
	String beneficiaire;
	
	/**Constructor
	 * 
	 */
	public Virement() {
		super();
	}

	/**Constructor
	 * @param date
	 * @param montant
	 * @param motif
	 * @param beneficiaire
	 */
	public Virement(LocalDate date, Double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
	}
	
	
}
