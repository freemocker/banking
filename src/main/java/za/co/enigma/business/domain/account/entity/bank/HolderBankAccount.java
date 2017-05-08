package za.co.enigma.business.domain.account.entity.bank;

import za.co.enigma.business.domain.party.entity.role.PartyRole;
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
@Table(name="HOLDER_BANK_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="HOLDER_BANK_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HolderBankAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -4872054566144385340L;

	private BankAccount bankAccount;
	private PartyRole partyRole;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BANK_ACCOUNT_ID", foreignKey = @ForeignKey(name = "BANK_ACCOUNT_HOLDER_FK01"))
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "BANK_ACCOUNT_HOLDER_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}
	
	@XmlTransient
	public static class Builder {
		private HolderBankAccount holderBankAccount;
		
		public Builder() {
			this.holderBankAccount = new HolderBankAccount();
		}
		
		public Builder withId(long id) {
			this.holderBankAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.holderBankAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.holderBankAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.holderBankAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.holderBankAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBankAccount(BankAccount bankAccount){
			this.holderBankAccount.setBankAccount(bankAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.holderBankAccount.setPartyRole(partyRole);
			return this;
		}
		
		public HolderBankAccount build() {
			return this.holderBankAccount;
		}
	}
	
}
