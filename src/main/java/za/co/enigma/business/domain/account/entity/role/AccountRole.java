package za.co.enigma.business.domain.account.entity.role;

import za.co.enigma.business.domain.account.entity.Account;
import za.co.enigma.business.domain.party.entity.Party;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="ACCOUNT_ROLE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACCOUNT_ROLE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountRole extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -3842122759296268859L;
	
	private Party party;
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ID", foreignKey = @ForeignKey(name = "PARTY_FK06"))
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_ID", foreignKey = @ForeignKey(name = "ACCOUNT_FK10"))
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@XmlTransient
	public static class Builder {
		private AccountRole accountRole;
		
		public Builder(){
			this.accountRole = new AccountRole();
		}
	    
	    public Builder withId(long id) {
	    	this.accountRole.setId(id);
	    	return this;
	    }
	    
	    public Builder withUuid(String uuid) {
	    	this.accountRole.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.accountRole.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.accountRole.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.accountRole.setEffectiveTo(effectiveTo);
	    	return this;
	    }
	    
		public Builder withParty(Party party) {
			this.accountRole.setParty(party);
			return this;
		}
		
		public Builder withAccount(Account account) {
			this.accountRole.setAccount(account);
			return this;
		}
		
		public AccountRole build(){
			return this.accountRole;
		}
	}
}
