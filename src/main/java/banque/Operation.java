package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Operation {
	@Id private Integer id;
	@Column(name="date", nullable=false)
	private LocalDateTime date;
	@Column(name="montant")
	private double montant;
	@Column(name="motif")
	private String motif;
}
