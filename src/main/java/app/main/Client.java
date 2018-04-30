package app.main;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="livre")
public class Client {
	@Id private Integer id;
	@Column(name="NOM", length=50,nullable=false)
	private String nom;
	@Column(name="PRENOM", length=50,nullable=false)
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts; 
	
	
	public Client(){
	}

}
