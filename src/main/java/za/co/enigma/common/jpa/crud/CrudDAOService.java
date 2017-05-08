package za.co.enigma.common.jpa.crud;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(CrudService.class)
/*@TransactionAttribute(TransactionAttributeType.MANDATORY)*/
public class CrudDAOService<T> implements CrudService {

/*	@PersistenceContext(name="remUDS")*/
	@BankingPersistenceUnit
	EntityManager em;
	
	public CrudDAOService() {
		
	}
	
	public CrudDAOService(EntityManager em) {
		this.em = em;
	}
	public <T> T create(T t) {
		em.persist(t);
		em.flush();
		return t;
	}

	public   <T> T findById(Object id) {
		Class<T> type = (Class<T>) retrieveEntityType();
		return em.find(type, id);
	}

	public void deleteById(Object id) {
		Class<T> type = retrieveEntityType();
		Object ref = em.getReference(type, id);	
		if (ref != null) {
			em.remove(ref);
		}
	}

	public  <T> T update(T t) {
		t = em.merge(t);
		em.flush();
		return t;
	}

	public List<T> findWithNamedQuery(String namedQueryName){
		Class<T> type = retrieveEntityType();
		return em.createNamedQuery(namedQueryName,type).getResultList();
	}

	@SuppressWarnings("hiding")
	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<String,? super Object> parameters){
		return (List<T>) findWithNamedQuery(namedQueryName, parameters, 0);
	}

	public List<T> findWithNamedQuery(String queryName, int resultLimit) {
		Class<T> type = retrieveEntityType();
		return em.createNamedQuery(queryName,type)
				.setMaxResults(resultLimit)
				.getResultList();    
	}

	@SuppressWarnings("hiding")
	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<String,? super Object> parameters, int resultLimit){
		Class<T> type = (Class<T>) retrieveEntityType();
		Query query = em.createNamedQuery(namedQueryName,type);
		if(resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String,? super Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return query.getResultList();
	}


	public T findWithNamedAndParamsQuery(String namedQueryName, Map<String,? super Object> parameters){
		Class<T> type = retrieveEntityType();
		Query query = em.createNamedQuery(namedQueryName,type);
		for (Entry<String,? super Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return (T) query.getSingleResult();		
	}
	private <T> Class<T> retrieveEntityType(){
		Class< ?> cls = getClass();
		Class<T> entityBeanType = ReflectionUtil.retrieveParameterizedType(cls);
		return entityBeanType;
	}

	public <T> T find(Class<T> type, Object id) {
		return	em.find(type, id);
	}

	public void delete(Object t) {
		Class<T> type = retrieveEntityType();
		Object ref = em.getReference(type, t);	
		if (ref != null) {
			em.remove(ref);
		}
	}
}
