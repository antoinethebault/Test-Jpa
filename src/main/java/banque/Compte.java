package banque;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Compte {
	@Id
	Integer id;
	@Column(name="numero")
	String numero;
	@Column(name="solde")
	Double solde;
	
	@ManyToMany(mappedBy="comptes") 
	private Set<Client_> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
}
