package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="virement")
public class Virement extends Operation {

	@Column(name="beneficiaire")
	private String beneficiaire;

	public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.setBeneficiaire(beneficiaire);
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
