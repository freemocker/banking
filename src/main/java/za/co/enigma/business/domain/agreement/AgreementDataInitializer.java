package za.co.enigma.business.domain.agreement;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import za.co.enigma.business.domain.agreement.boundary.AgreementsResource;

@Startup
@Singleton
public class AgreementDataInitializer {

	private AgreementsResource agreementsResource;
	
	public AgreementDataInitializer(){}
	
	@Inject
	public AgreementDataInitializer(AgreementsResource agreementsResource){
		this.agreementsResource = agreementsResource;
	}
	
	
	@PostConstruct
	public void init(){
		createAgreements();
	}

	private void createAgreements() {
		// TODO Auto-generated method stub
		
	}
	
}
