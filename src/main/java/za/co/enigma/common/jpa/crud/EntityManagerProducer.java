package za.co.enigma.common.jpa.crud;


import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EntityManagerProducer {

	@Produces
	@BankingPersistenceUnit
	@PersistenceContext
	private EntityManager em;
	
	public void dispose(@Disposes @BankingPersistenceUnit EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
}
