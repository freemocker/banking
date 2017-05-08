package za.co.enigma.business.domain.party.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import za.co.enigma.common.jpa.crud.BankingPersistenceUnit;
import za.co.enigma.common.jpa.crud.JPACrudService;

@Stateless
public class PartyDAO extends JPACrudService {

	public PartyDAO(){}
	
	@Inject
	public PartyDAO(@BankingPersistenceUnit EntityManager em){
		super(em);
	}
}
