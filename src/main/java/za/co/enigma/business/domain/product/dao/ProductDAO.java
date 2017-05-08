package za.co.enigma.business.domain.product.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import za.co.enigma.common.jpa.crud.BankingPersistenceUnit;
import za.co.enigma.common.jpa.crud.JPACrudService;

@Stateless
public class ProductDAO extends JPACrudService {

	public ProductDAO(){}
	
	@Inject
	public ProductDAO(@BankingPersistenceUnit EntityManager em){
		super(em);
	}
}
