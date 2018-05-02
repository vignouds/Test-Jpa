package banque;

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
		
		em.close();

	}

}
