package banque2;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Banque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;

	public Banque(String nom) {
		Set<Client> cl = null;
		this.nom = nom;
		this.clients = cl;
	}
	
	public Set<Client> getClients(){
		return this.clients;
	}
}
