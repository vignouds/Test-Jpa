package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Compte {
	@Id private Integer id;
	@Column(name="numero")
	private String numero;
	@Column(name="solde")
	private double solde;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
}
