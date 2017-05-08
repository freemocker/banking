package za.co.enigma.business.domain.party.control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import za.co.enigma.business.domain.party.dao.PartyDAO;
import za.co.enigma.business.domain.party.entity.organization.Organization;

@Stateless
public class OrganizationManager {
	
	public static final String CONFIRMATION_ID = "confirmation-id";
	
	private PartyDAO partyDAO;
	
	public OrganizationManager(){}
	
	@Inject
	public OrganizationManager(PartyDAO partyDAO){
		this.partyDAO = partyDAO;
	}

	public JsonObject createOrganization(Organization request) {
		//	   tracer.info("Organization arrived: " + request);
		System.out.println("@@@ Manager create Organization " + request);
		Organization organization = partyDAO.create(request);
		//    tracer.info("Organization stored: " + request);
		System.out.println("@@@ stored Organization " + organization);
		return convertOrganization(organization);
	}

	public Organization findOrganization(long organizationId) {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonArray allAsJson() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Because the application only offers JAX-RS endpoint and may offer
	 * WebSockets in the future, the conversion from domain objects (entities)
	 * to JsonObjects happens in the protocol-neutral boundary.
	 *
	 * You could also convert entities into JsonObject in the JAX-RS / WebSocket
	 * endpoints in case you need the domain objects for a serverside Java web
	 * framework.
	 */
	JsonObject convertOrganization(Organization organization) {
	
		JsonObject personJsonObject = Json.createObjectBuilder().
				add(CONFIRMATION_ID, organization.getId()).
				add("tenant", organization.getTenant()).
				add("uuid", organization.getUuid()).
				add("cellphone", organization.getCellphone()).
				add("telephone", organization.getTelephone()).
				add("emailAddress", organization.getEmailAddress()).
				add("address", organization.getAddress())
				.add("shortName", organization.getShortName())
				.add("tradingAs", organization.getTradingAs())
				.add("registeredOn", organization.getRegisteredOn().toString())
				.add("deRegistedOn", organization.getDeRegistedOn().toString())
				.add("name", organization.getName())
				.build();

		System.out.println("@@@ Converted Person " + personJsonObject);
		return personJsonObject;
	}

}
