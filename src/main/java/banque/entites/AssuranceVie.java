package banque.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="assurance_vie")
public class AssuranceVie extends Compte{
	/**dateFin : LocalDate*/
	@Column(name="DATEFIN")
	LocalDate dateFin;
	
	/**taux : Double*/
	@Column(name="TAUX")
	Double taux;

	/**Constructor
	 * 
	 */
	public AssuranceVie() {
		super();
	}

	/**Constructor
	 * @param id
	 * @param numero
	 * @param solde
	 * @param dateFin
	 * @param taux
	 */
	public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	/**Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**Getter
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**Setter
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
}
