package za.co.enigma.business.domain.agreement.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import za.co.enigma.common.jpa.crud.BankingPersistenceUnit;
import za.co.enigma.common.jpa.crud.JPACrudService;

@Stateless
public class AgreementDAO  extends JPACrudService {

	public AgreementDAO(){}
	
	@Inject
	public AgreementDAO(@BankingPersistenceUnit EntityManager em){
		super(em);
	}
}
