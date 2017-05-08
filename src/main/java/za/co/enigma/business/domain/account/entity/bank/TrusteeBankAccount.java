package za.co.enigma.business.domain.account.entity.bank;

import za.co.enigma.business.domain.party.entity.role.PartyRole;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="TRUSTEE_BANK_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="TRUSTEE_BANK_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrusteeBankAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = 1902900144624978910L;

	private BankAccount bankAccount;
	private PartyRole partyRole;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BANK_ACCOUNT_ID", foreignKey = @ForeignKey(name = "BANK_ACCOUNT_TRUSTEE_FK01"))
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "PARTY_ROLE_FK012"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private TrusteeBankAccount trusteeBankAccount;
		
		public Builder() {
			this.trusteeBankAccount = new TrusteeBankAccount();
		}
		
		public Builder withId(long id) {
			this.trusteeBankAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.trusteeBankAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.trusteeBankAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.trusteeBankAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.trusteeBankAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBankAccount(BankAccount bankAccount){
			this.trusteeBankAccount.setBankAccount(bankAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.trusteeBankAccount.setPartyRole(partyRole);
			return this;
		}
		
		public TrusteeBankAccount build() {
			return this.trusteeBankAccount;
		}
	}
	
}
