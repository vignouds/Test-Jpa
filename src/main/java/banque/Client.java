package banque;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Client {
	@Id private Integer id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="dateNiassance", nullable=false)
	private LocalDate dateNiassance;
	@Embedded Adresse adresse;
}

@Embeddable
class Adresse{
	@Column(name="numero")
	private int numero;
	@Column(name="rue")
	private String rue;
	@Column(name="codePostal")
	private int codePostal;
	@Column(name="ville")
	private String ville;
}