package za.co.enigma.business.domain.party.boundary;


import za.co.enigma.business.domain.party.control.PersonManager;
import za.co.enigma.business.domain.party.entity.person.Person;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;


@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("person")
public class PersonResource {

	private PersonManager partyManager;

	public PersonResource(){}

	@Inject
	public PersonResource(PersonManager partyManager){
		this.partyManager = partyManager;
	}

	@POST
	public Response create(Person request, @Context UriInfo info ) {
		System.out.println("@@@ REST create Person " + request);
		JsonObject person = partyManager.createPerson(request);
		long id =  person.getInt(PersonManager.CONFIRMATION_ID);
	//	URI uri = info.getAbsolutePathBuilder().path("/" + id).build(); TODO: ONLY TEMP COZ RUNNING A STARTUP EJB
		System.out.println("@@@ End Rest " + person);
	//	return Response.created(uri).entity(person).build();
		return Response.ok().status(Status.CREATED).entity(person).build();
	}

	@GET
	@Path("{id}")
	public Person find(@PathParam("id") long  personId) {
		return partyManager.findPerson(personId);
	}

	@GET
	public Response all() {
		JsonArray personList = this.partyManager.allAsJson();
		if (personList == null || personList.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(personList).build();
	}

}
