package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author antoinethebault
 *Client
 */
@Entity
public class Client {
	/**id : Integer*/
	@Id
	Integer id;
	
	/**nom : String*/
	@Column(name="NOM")
	String nom;
	
	/**prenom : String*/
	@Column(name="PRENOM")
	String prenom;
}
