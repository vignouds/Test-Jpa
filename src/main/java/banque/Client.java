package banque;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="dateNaissance", nullable=false)
	private LocalDate dateNaissance;
	@Embedded Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="BANQ_ID")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="CLi_CPT",
	joinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="ID_CPT", referencedColumnName="id"))
	private Set<Compte> comptes;

	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		Set<Compte> cp = null;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = cp;
	}
}

@Embeddable
class Adresse{
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	
	public Adresse() {
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
}