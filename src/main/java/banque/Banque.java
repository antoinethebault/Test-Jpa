package banque;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Banque {
	@Id
	Integer id;
	@Column(name="nom")
	String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client_> clients;
}
