package banque2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque2");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transac = em.getTransaction();
		transac.begin();
		
		Banque creditAgricole = new Banque("Credit Agricole");
		Banque caisseDep = new Banque("Caisse d'Epargne");
		em.persist(creditAgricole);
		em.persist(caisseDep);
		
		Adresse adresse = new Adresse();
		adresse.setNumero(580);
		adresse.setRue("rue du chef lieu");
		adresse.setCodePostal(73330);
		adresse.setVille("Domessin");
		
		Client seb = new Client("Vignoud", "Sébastien", LocalDate.of(1989, Month.NOVEMBER, 9),adresse, creditAgricole);
		em.persist(seb);
		Client yuli = new Client("Perez", "Guiuliana", LocalDate.of(1987, Month.SEPTEMBER, 29),adresse, creditAgricole);
		em.persist(yuli);
		
		
		LivretA livretA = new LivretA("789789", 2500.00, 3.1);
		em.persist(livretA);
		
		AssuranceVie assuranceVie = new AssuranceVie("112233", 25000.00, LocalDate.now(), 1.5);
		em.persist(assuranceVie);
		
		Virement virement = new Virement(LocalDateTime.now(), 100.00, "motif", livretA, "beneficiaire");
		em.persist(virement);
		
		creditAgricole.getClients().add(seb);
		creditAgricole.getClients().add(yuli);

		transac.commit();
	}

}
