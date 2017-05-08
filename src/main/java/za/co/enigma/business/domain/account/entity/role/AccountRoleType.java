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
@Table(name="ACCOUNT_ROLE_TYPE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountRoleType extends RoleType {

	private static final long serialVersionUID = 5003853446079704777L;
	
	private List<AccountRole> accountRoles = new ArrayList<>();

	@JoinTable(name= "ACCOUNT_ROLE_TYPE_ACCOUNT_ROLE",
			joinColumns=@JoinColumn(name ="ACCOUNT_ROLE_TYPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountRole> getAccountRoles() {
		return accountRoles;
	}

	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}
	
	@XmlTransient
	public static class Builder {
		private AccountRoleType accountRoleType;
		
		public Builder(){
			this.accountRoleType = new AccountRoleType();
		}

		public Builder withId(long id){
	    	this.accountRoleType.setId(id);
	    	return this;
	    }
	    
	    public Builder withUuid(String uuid) {
	    	this.accountRoleType.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.accountRoleType.setTenant(tenant);
	    	return this;
	    }
		
		public Builder withName(String name) {
			this.accountRoleType.setName(name);
			return this;
		}
		
		public Builder withCode(String code) {
			this.accountRoleType.setCode(code);
			return this;
		}
		
		public Builder withNote(String note) {
			this.accountRoleType.setNote(note);
			return this;
		}
		
		public Builder withDescription(String description) {
			this.accountRoleType.setDescription(description);
			return this;
		}
		
		public Builder withAccountRole(AccountRole accountRole) {
			this.accountRoleType.getAccountRoles().add(accountRole);
			return this;
		}
		
		public AccountRoleType build(){
			return this.accountRoleType;
		}
	}
}
