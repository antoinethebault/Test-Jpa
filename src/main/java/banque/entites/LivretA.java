package banque.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="livret_a")
public class LivretA extends Compte{
	/**taux : double*/
	@Column(name="TAUX")
	Double taux;

	/**Constructor
	 * 
	 */
	public LivretA() {
		super();
	}

	/**Constructor
	 * @param id
	 * @param numero
	 * @param solde
	 * @param taux
	 */
	public LivretA( String numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	/**Getter
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**Setter
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
}
