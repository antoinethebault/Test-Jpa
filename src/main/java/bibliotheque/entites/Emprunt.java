package bibliotheque.entites;


import java.time.LocalDate;

import javax.persistence.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Set;

/**
 * @author antoinethebault
 *Emprunt
 */
@Entity
public class Emprunt {
	
	/**id : Integer*/
	@Id
	private Integer id;
	
	/**date_debut : LocalDate*/
	@Column(name="DATE_DEBUT")
	private LocalDate date_debut;
	
	/**date_fin : LocalDate*/
	@Column(name="DATE_FIN")
	private LocalDate date_fin;
	
	/**delai : Integer*/
	@Column(name="DELAI")
	private Integer delai;
	
	///**id_client : Integer*/
	//@Column(name="ID_CLIENT")
	//private Integer id_client;
	
	@ManyToOne 
	@JoinColumn(name="ID_CLIENT") 
	private Client client;
	
	@ManyToMany 
	@JoinTable(name="Compo",
			joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"), inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
			)
	private Set<Livre> livres;
	
	private static final Logger LOGGER = Logger.getLogger(Emprunt.class.getName());
	
	
	
	/**
	 * getEmpruntLivres affiche un emprunt specifie et tous les livres associes
	 * @param entityManager
	 */
	public static void getEmpruntLivres(EntityManager entityManager, Integer id) {
		Emprunt emprunt = entityManager.find(Emprunt.class,id);
		LOGGER.log(Level.INFO, emprunt.toString());
		
		TypedQuery<Livre> query = entityManager.createQuery("SELECT new bibliotheque.entites.Livre(l.id, l.titre, l.auteur) FROM Livre l, Compo c, Emprunt e WHERE l.id=c.id_liv AND c.id_emp=e.id AND e.id=:id", Livre.class);
		query.setParameter("id", id);
		List<Livre> liste = query.getResultList();
		for (Livre livre : liste)
			LOGGER.log(Level.INFO, livre.toString());
		
	}

	/**Constructor
	 * 
	 */
	public Emprunt() {
		super();
	}

	/**Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Getter
	 * @return the date_debut
	 */
	public LocalDate getDate_debut() {
		return date_debut;
	}

	/**Getter
	 * @return the date_fin
	 */
	public LocalDate getDate_fin() {
		return date_fin;
	}

	/**Getter
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}



	/**Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Setter
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	/**Setter
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	/**Setter
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}


	@Override
	public String toString() {
		return "EMPRUNT "+this.id+" - date debut : "+this.date_debut+" - date fin : "+this.date_fin+" - delai : "+this.delai;
	}
	
	
}
