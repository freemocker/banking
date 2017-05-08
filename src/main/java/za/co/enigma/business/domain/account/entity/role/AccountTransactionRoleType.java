package za.co.enigma.business.domain.account.entity.role;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="ACCOUNT_TRANSACTION_ROLE_TYPE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountTransactionRoleType extends RoleType {

	private static final long serialVersionUID = -626854530210548058L;
	
	private List<AccountTransactionRole> accountTransactionRoles = new ArrayList<>();

	@JoinTable(name= "ACCOUNT_TRANSACTION_ROLE_TYPE_ACCOUNT_TRANSACTION_ROLE",
			joinColumns=@JoinColumn(name ="ACCOUNT_TRANSACTION_ROLE_TYPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_TRANSACTION_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountTransactionRole> getAccountTransactionRoles() {
		return accountTransactionRoles;
	}

	public void setAccountTransactionRoles(List<AccountTransactionRole> accountTransactionRoles) {
		this.accountTransactionRoles = accountTransactionRoles;
	}
	
	@XmlTransient
	public static class Builder {
		private AccountTransactionRoleType accountTransactionRoleType;
		
		public Builder(){
			this.accountTransactionRoleType = new AccountTransactionRoleType();
		}

		public Builder withId(long id){
	    	this.accountTransactionRoleType.setId(id);
	    	return this;
	    }
	    
	    public Builder withUuid(String uuid) {
	    	this.accountTransactionRoleType.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.accountTransactionRoleType.setTenant(tenant);
	    	return this;
	    }
		
		public Builder withName(String name) {
			this.accountTransactionRoleType.setName(name);
			return this;
		}
		
		public Builder withCode(String code) {
			this.accountTransactionRoleType.setCode(code);
			return this;
		}
		
		public Builder withNote(String note) {
			this.accountTransactionRoleType.setNote(note);
			return this;
		}
		
		public Builder withDescription(String description) {
			this.accountTransactionRoleType.setDescription(description);
			return this;
		}
		
		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.accountTransactionRoleType.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}
		
		public AccountTransactionRoleType build(){
			return this.accountTransactionRoleType;
		}
	}

}
