package za.co.enigma.business.domain.account.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import za.co.enigma.business.domain.account.control.AccountManager;

@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("account")
public class AccountsResource {

	private AccountManager accountManager;
	
	public AccountsResource() {}
	
	@Inject
	public AccountsResource(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}
