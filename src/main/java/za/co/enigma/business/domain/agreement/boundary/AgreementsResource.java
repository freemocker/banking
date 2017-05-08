package za.co.enigma.business.domain.agreement.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import za.co.enigma.business.domain.agreement.control.AgreementManager;

@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("agreement")
public class AgreementsResource {

	private AgreementManager agreementManager;
	
	public AgreementsResource(){}
	
	@Inject
	public AgreementsResource(AgreementManager agreementManager){
		this.agreementManager = agreementManager;
	}
}
