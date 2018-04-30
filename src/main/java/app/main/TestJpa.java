package app.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transac = em.getTransaction();
		transac.begin();
		
		Livre livre1 = em.find(Livre.class, 1);
		Query query = em.createQuery("select livre from Livre livre where livre.titre='Germinal'");
		Livre livre2 = (Livre) query.getResultList().get(0);
		
	}
}
