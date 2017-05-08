package za.co.enigma.business.domain.account.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import za.co.enigma.common.jpa.crud.BankingPersistenceUnit;
import za.co.enigma.common.jpa.crud.JPACrudService;

public class AccountDAO extends JPACrudService {

	public AccountDAO(){}
	
	@Inject
	public AccountDAO(@BankingPersistenceUnit EntityManager em){
		super(em);
	}
}
