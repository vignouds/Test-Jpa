package banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Banque {
	@Id private Integer id;
	@Column(name="nom")
	private String nom;
}
