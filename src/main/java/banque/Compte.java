package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	@Id private Integer id;
	@Column(name="numero")
	private String numero;
	@Column(name="solde")
	private double solde;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;

	public Compte(Integer id, String numero, double solde) {
		Set<Operation> op = null;
		this.id = id;
		this.numero = numero;
		this.solde = solde;
		this.operations = op;		
	}
}
