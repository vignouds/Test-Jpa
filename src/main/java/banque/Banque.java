package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Banque {
	@Id private Integer id;
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;

	public Banque(Integer id, String nom) {
		Set<Client> cl = null;
		this.id = id;
		this.nom = nom;
		this.clients = cl;
	}
}
