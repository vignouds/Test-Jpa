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
	private static Emprunt emprunt1;

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transac = em.getTransaction();
		transac.begin();
		
		Livre livre1 = em.find(Livre.class, 1);
		LOG.debug(livre1.toString());
		
		Query query = em.createQuery("select livre from Livre livre where livre.titre=:reference");
		query.setParameter("reference", "Germinal");
		Livre livre2 = (Livre) query.getResultList().get(0);
		LOG.debug(livre2.toString());
		
		Query query2 = em.createQuery("from Emprunt where id=:identifiant");
		query2.setParameter("identifiant", 2);

		
		Query query3 = em.createQuery("from Client where id=:identifiant");
		query3.setParameter("identifiant", 2);
		
		em.close();
	}
}
