package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author antoinethebault
 *Compo
 */
@Entity
public class Compo {
	/**id : Integer*/
	@Id
	Integer id;
	
	/**id_liv : Integer*/
	@Column(name="ID_LIV")
	Integer id_liv;
	
	/**id_emp : Integer*/
	@Column(name="ID_EMP")
	Integer id_emp;

	/**Constructor
	 * 
	 */
	public Compo() {
		super();
	}

	/**Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Getter
	 * @return the id_liv
	 */
	public Integer getId_liv() {
		return id_liv;
	}

	/**Getter
	 * @return the id_emp
	 */
	public Integer getId_emp() {
		return id_emp;
	}

	/**Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Setter
	 * @param id_liv the id_liv to set
	 */
	public void setId_liv(Integer id_liv) {
		this.id_liv = id_liv;
	}

	/**Setter
	 * @param id_emp the id_emp to set
	 */
	public void setId_emp(Integer id_emp) {
		this.id_emp = id_emp;
	}
	
	
	
	
}
