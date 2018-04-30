package app.main;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Emprunt {
	
	@Id private Integer id;
	
	@Column(name="DATE_DEBUT", nullable=false)
	private LocalDateTime dateDebut;
	@Column(name="DATE_FIN", nullable=true)
	private LocalDateTime dateFin;
	@Column(name="DELAI", length=10, nullable=true)
	private Integer delai;
	
	@ManyToMany(mappedBy="emprunts")
	private Set<Livre>livres;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	public Emprunt() {

	}

}
