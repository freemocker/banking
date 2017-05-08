package za.co.enigma.business.domain.account.control;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.co.enigma.business.domain.account.dao.AccountDAO;

@Stateless
public class AccountManager {

	private AccountDAO accountDao;
	
	public AccountManager(){}
	
	@Inject
	public AccountManager(AccountDAO accountDao){
		this.accountDao = accountDao;
	}
}
