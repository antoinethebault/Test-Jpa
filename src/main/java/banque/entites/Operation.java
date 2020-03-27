package banque.entites;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Operation {
	@Id
	Integer id;
	@Column(name="date")
	LocalDate date;
	@Column(name="montant")
	Double montant;
	@Column(name="motif")
	String motif;
	
	@ManyToOne 
	@JoinColumn(name="compte_id") 
	private Compte compte;
}
