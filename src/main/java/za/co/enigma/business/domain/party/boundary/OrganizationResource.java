package za.co.enigma.business.domain.party.boundary;

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

import za.co.enigma.business.domain.party.control.OrganizationManager;
import za.co.enigma.business.domain.party.entity.organization.Organization;

@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("organization")
public class OrganizationResource {

	private OrganizationManager organizationManager;
	
	public OrganizationResource(){}

	@Inject
	public OrganizationResource(OrganizationManager organizationManager){
		this.organizationManager = organizationManager;
	}

	@POST
	public Response create(Organization request, @Context UriInfo info ) {
		System.out.println("@@@ REST create Organization " + request);
		JsonObject organization = organizationManager.createOrganization(request);
		long id =  organization.getInt(OrganizationManager.CONFIRMATION_ID);
	//	URI uri = info.getAbsolutePathBuilder().path("/" + id).build(); TODO: ONLY TEMP COZ RUNNING A STARTUP EJB
		System.out.println("@@@ End Rest " + organization);
	//	return Response.created(uri).entity(organization).build();
		return Response.ok().status(Status.CREATED).entity(organization).build();
	}

	@GET
	@Path("{id}")
	public Organization find(@PathParam("id") long  organizationId) {
		return organizationManager.findOrganization(organizationId);
	}

	@GET
	public Response all() {
		JsonArray personList = this.organizationManager.allAsJson();
		if (personList == null || personList.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(personList).build();
	}
}
