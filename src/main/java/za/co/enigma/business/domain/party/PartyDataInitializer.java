package za.co.enigma.business.domain.party;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import za.co.enigma.business.domain.party.boundary.OrganizationResource;
import za.co.enigma.business.domain.party.boundary.PersonResource;
import za.co.enigma.business.domain.party.entity.IdentificationType;
import za.co.enigma.business.domain.party.entity.organization.Organization;
import za.co.enigma.business.domain.party.entity.organization.OrganizationStatus;
import za.co.enigma.business.domain.party.entity.organization.OrganizationType;
import za.co.enigma.business.domain.party.entity.person.Citizenship;
import za.co.enigma.business.domain.party.entity.person.Country;
import za.co.enigma.business.domain.party.entity.person.MaritalStatusType;
import za.co.enigma.business.domain.party.entity.person.Passport;
import za.co.enigma.business.domain.party.entity.person.Person;
import za.co.enigma.business.domain.party.entity.person.Title;
import za.co.enigma.business.domain.party.entity.person.Gender;

@Startup
@Singleton
public class PartyDataInitializer {

	public static final String HOST = "http://localhost:8080/banking/api/";

	private WebTarget webTarget;
	private Client client;
	private PersonResource personResource;
	private OrganizationResource organizationResource;

	public PartyDataInitializer() {
		/*this.client = ClientBuilder.newBuilder().
	                build();*/
	}

	@Inject
	public PartyDataInitializer(PersonResource personResource,
			OrganizationResource organizationResource) {
		this.personResource = personResource;
		this.organizationResource = organizationResource;
	}

	@PostConstruct
	public void init() {
		createPerson();
		createOrganization();
		retrievePerson();
		createOrganization();
	}

	private void createPerson() {
		int tenant = 1;
		String uuid = UUID.randomUUID().toString();
		Country country = new Country.Builder()
				.withIso("ZW")
				.withIso3("ZWE")
				.withPhoneCode("263")
				.withNumCode("716")
				.withName("ZIMBABWE")
				.withNiceName("Zimbabwe")
				.withTenant(tenant)
				.build();

		LocalDate date = LocalDate.of(1990, Month.NOVEMBER, 29);
		LocalTime time = LocalTime.of(0, 0);
		Citizenship citizenship = new Citizenship.Builder()
				.withCountry(country)
				.withTenant(tenant)
				.withEffectiveFrom(LocalDateTime.of(date, time))
				.build();

		Passport passport = new Passport.Builder()
				.withCitizenship(citizenship)
				.withIssueDate(LocalDate.of(2010, Month.AUGUST, 01))
				.withExpirationDate(LocalDate.of(2020, Month.AUGUST, 31))
				.withName("Zim")
				.withPassportId(10)
				.withPassportNumber("BC973493")
				.withTenant(tenant)
				.withUuid(uuid)
				.build();


		Person person = new Person.Builder()
				.withTenantId(tenant)
				.withUUID(uuid)
				.withCellphone("0844724897")
				.withTelephone("0123456789")
				.withNickname("@Singleton")
				.withFamilyName("Karikoga")
				.withGivenName("Luckson")
				.withMothersMaidenName("Karikoga")
				.withPreferredName("Lux")
				.withHeight(170)
				.withWeight(84)
				.withAddress("Unit 120B, San Ridge Heights, Cnr Lever Road & 13th Road, Carlswald, Midrand")//TDO special character like C\O
				.withBornOnDate(LocalDate.of(1990, Month.NOVEMBER, 29))
				//.withDiedOnDate(null)
				.withEmailAddress("luckson.karikoga@gmail.com")
				.withIdentificationNumber("63-344345-G32")
				.withIdentificationType(IdentificationType.PASSPORT)
				.withMaritalStatusType(MaritalStatusType.ENGAGED)
				.withPassport(passport)
				.withGender(Gender.MALE)
				.withSuffix("II") //TODO come back to suffix and prefix
				.withPrefix("Sir")
				.withTitle(Title.MR)
				.build();

		/*	this.client = ClientBuilder.newBuilder().
                build();
		System.out.println(HOST+"person");
		this.webTarget = client.target(HOST+"person");
		Response personResponse = this.webTarget.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(person, MediaType.APPLICATION_XML));

		System.out.println("Created Person" + personResponse);*/

		// hard wire it
		Response createdHardWired = personResource.create(person, null);
		System.out.println("Created Hardwired Person" + createdHardWired);
	}

	private void createOrganization() {
		int tenant = 1;
		String uuid = UUID.randomUUID().toString();
		
		
		OrganizationStatus organizationStatus = new OrganizationStatus.Builder()
				.withTenant(tenant)
				.withUuid(uuid)
				.withCode("ACTIVE")
				.withDescription("This means that the organization is in operating status")
				.withName("Operating")
				.withNote("This means that the organization is in operating status")
				.build();
		
		
	
		OrganizationType organizationType = new OrganizationType.Builder()
				.withTenant(tenant)
				.withUuid(uuid)
				.withCode("FSP")
				.withDescription("Insurance,and  Banking")
				.withName("Financial Service Provider")
				.withNote("Insurance,and  Banking")
				.build();
		
		
		Organization organization = new Organization.Builder()
				.withTenant(tenant)
				.withUUID(uuid)
				.withAddress("156 Rajpark Midrand")
				.withCellphone("000-000-0000")
				.withRegisteredOn(LocalDate.of(2010, Month.JANUARY, 01))
				//.withDeregisteredOn(deregisteredOn)
				.withEmailAddress("info@enigma.co.za")
				.withName("Enigma Turing Technologies")
				.withTradingAs("Turing Tech")
				.withOrganizationStatus(organizationStatus)
				.withOrganizationType(organizationType)
				.withShortName("Turing")
				.withTelephone("0123456789")
				.build();

		
		Response createdHardwired = organizationResource.create(organization, null);
		System.out.println("Created Hardwired Person" + createdHardwired);
	}
	
	
	private void retrievePerson() {
		// TODO Auto-generated method stub

	}




}
