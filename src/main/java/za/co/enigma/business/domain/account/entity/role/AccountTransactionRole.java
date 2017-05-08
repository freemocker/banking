package za.co.enigma.business.domain.account.entity.role;

import za.co.enigma.business.domain.account.entity.transaction.AccountTransaction;
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
@Table(name="ACCOUNT_TRANSACTION_ROLE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACCOUNT_TRANSACTION_ROLE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountTransactionRole extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -4873273236299332320L;

	private Party party;
	private AccountTransaction accountTransaction;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ID", foreignKey = @ForeignKey(name = "PARTY_FK04"))
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_TRANSACTION_ID", foreignKey = @ForeignKey(name = "ACCOUNT_TRANSACTION_FK01"))
	public AccountTransaction getAccountTransaction() {
		return accountTransaction;
	}

	public void setAccountTransaction(AccountTransaction accountTransaction) {
		this.accountTransaction = accountTransaction;
	}
	
	@XmlTransient
	public static class Builder {
		private AccountTransactionRole accountTransactionRole;
		
		public Builder() {
			this.accountTransactionRole = new AccountTransactionRole();
		}
		
	    public Builder withId(long id) {
	    	this.accountTransactionRole.setId(id);
	    	return this;
	    }
	    
	    public Builder withUuid(String uuid) {
	    	this.accountTransactionRole.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.accountTransactionRole.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.accountTransactionRole.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.accountTransactionRole.setEffectiveTo(effectiveTo);
	    	return this;
	    }
		public Builder withParty(Party party) {
			this.accountTransactionRole.setParty(party);
			return this;
		}
		
		public Builder withAccountTransaction(AccountTransaction accountTransaction) {
			this.accountTransactionRole.setAccountTransaction(accountTransaction);
			return this;
		}
		public AccountTransactionRole build() {
			return this.accountTransactionRole;
		}
	}
	
}
