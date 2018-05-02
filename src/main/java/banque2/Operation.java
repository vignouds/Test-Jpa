package banque2;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@Table(name="operation")
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="date", nullable=false)
	private LocalDateTime date;
	@Column(name="montant")
	private double montant;
	@Column(name="motif")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="CPT_ID")
	private Compte compte;

	public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}
}
