package banque;

import javax.persistence.*;

@Entity
@Embeddable
public class Adresse {
	@Id
	Integer id;
	@Column(name="numero")
	Integer numero;
	@Column(name="rue")
	String rue;
	@Column(name="codePostal")
	Integer codePostal;
	@Column(name="ville")
	String ville;
	/**Constructor
	 * @param id
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(Integer id, Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
}
