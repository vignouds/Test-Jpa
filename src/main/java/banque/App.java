package banque;

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
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
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
		
		Compte compte = new Compte("123456", 1200.50);
		em.persist(compte);
		
		Operation operation = new Operation(LocalDateTime.now(), 150.00, "motif", compte);
		em.persist(operation);
		transac.commit();

	}

}
