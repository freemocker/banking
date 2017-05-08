package za.co.enigma.business.domain.account;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import za.co.enigma.business.domain.account.boundary.AccountsResource;

@Startup
@Singleton
public class AccountDataInitializer {

	private AccountsResource accountsResource;
	
	public AccountDataInitializer() {}
	
	@Inject
	public AccountDataInitializer(AccountsResource accountsResource) {
		this.accountsResource = accountsResource;
	}
	
	@PostConstruct
	public void init(){
		createAccounts();
	}

	private void createAccounts() {
		// TODO Auto-generated method stub
		
	}
	
	
}
