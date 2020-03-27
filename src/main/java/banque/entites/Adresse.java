package banque.entites;

import javax.persistence.*;

/**
 * @author antoinethebault
 *Adresse
 */
@Embeddable
public class Adresse {
	/**id : Integer*/
	//@Id
	//private Integer id;
	
	/**numero : Integer*/
	@Column(name="numero")
	private Integer numero;
	
	/**rue : String*/
	@Column(name="rue")
	private String rue;
	
	/**codePostal : Integer*/
	@Column(name="codePostal")
	private Integer codePostal;
	
	/**ville : String*/
	@Column(name="ville")
	private String ville;
	
	
	/**Constructor
	 * 
	 */
	public Adresse() {
		super();
	}


	/**Constructor
	 * @param id
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
}
