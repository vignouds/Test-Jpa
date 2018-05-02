package banque2;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@Table(name="compte")
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="numero")
	private String numero;
	@Column(name="solde")
	private double solde;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;

	public Compte(String numero, double solde) {
		Set<Operation> op = null;
		this.numero = numero;
		this.solde = solde;
		this.operations = op;		
	}
}
