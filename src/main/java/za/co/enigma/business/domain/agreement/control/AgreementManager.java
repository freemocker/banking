package za.co.enigma.business.domain.agreement.control;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.co.enigma.business.domain.agreement.dao.AgreementDAO;

@Stateless
public class AgreementManager {

	private AgreementDAO agreementDao;
	
	public AgreementManager(){}
	
	
	@Inject
	public AgreementManager(AgreementDAO agreementDao) {
		this.agreementDao = agreementDao;
	}
}
