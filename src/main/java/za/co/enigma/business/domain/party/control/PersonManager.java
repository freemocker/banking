package za.co.enigma.business.domain.party.control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import java.util.stream.Collector;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;


import za.co.enigma.business.domain.party.dao.PartyDAO;
import za.co.enigma.business.domain.party.entity.person.Person;

@Stateless
public class PersonManager {

	public static String CONFIRMATION_ID = "confirmation-id";

	private PartyDAO partyDAO;

	/*@Inject
    Logger tracer;
	 */
	public PersonManager(){}

	@Inject
	public PersonManager(PartyDAO partyDAO){
		this.partyDAO = partyDAO;
	}

	public JsonObject createPerson(Person request) {
		//	   tracer.info("party arrived: " + request);
		System.out.println("@@@ Manager create Person " + request);
		Person person = partyDAO.create(request);
		//    tracer.info("party stored: " + request);
		System.out.println("@@@ stored person " + person);
		return convertPerson(person);
	}

	public Person findPerson(long partyId) {
		return partyDAO.find(Person.class, partyId);
	}



	public JsonObject findAsJson(int partyId) {
		return convertPerson(findPerson(partyId));
	}

	@SuppressWarnings("unchecked")
	public List<Person> all() {
		return this.partyDAO.findWithNamedQuery(Person.findAll);
	}

	public JsonArray allAsJson() {
		Collector<JsonObject, ?, JsonArrayBuilder> jsonCollector
		= Collector.of(Json::createArrayBuilder, JsonArrayBuilder::add,
				(left, right) -> {
					left.add(right);
					return left;
				});
		return all().stream().map(this::convertPerson).
				collect(jsonCollector).build();

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
	JsonObject convertPerson(Person person) {
	/*	JsonObject passportJsonObject = Json.createObjectBuilder()
		.add("passport", (JsonValue) person.getPassports().get(0))
		.build();*/
		
		JsonObject personJsonObject = Json.createObjectBuilder().
				add(CONFIRMATION_ID, person.getId()).
				add("tenant", person.getTenant()).
				add("uuid", person.getUuid()).
				add("cellphone", person.getCellphone()).
				add("telephone", person.getTelephone()).
				add("emailAddress", person.getEmailAddress()).
				add("address", person.getAddress()).
				add("gender", person.getGender().toString()).
				add("title", person.getTitle().toString()).
				add("bornOn", person.getBornOn().toString()).
				add("diedOn", person.getDiedOn().toString()).
				add("suffix", person.getSuffix()).
				add("prefix", person.getPrefix()).
				add("givenName", person.getGivenName()).
				add("familyName", person.getFamilyName()).
				add("preferredName", person.getPreferredName()).
				add("nickname", person.getNickname()).
				add("identificationType", person.getIdentificationType().toString()).
				add("identificationNumber", person.getIdentificationNumber()).
				add("mothersMaidenName", person.getMothersMaidenName()).
				add("height", person.getHeight()).
				add("weight", person.getWeight()).
				add("maritalStatus", person.getMaritalStatus().toString())
			//	add("passports", (JsonValue) person.getPassports())
			//	add("passport", passportJsonObject)
				.build();

		System.out.println("@@@ Converted Person " + personJsonObject);
		return personJsonObject;
	}

}
