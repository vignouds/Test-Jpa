package banque2;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("LA")
public class LivretA extends Compte{
	@Column(name="taux")
	private double taux;

	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.setTaux(taux);
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
}
