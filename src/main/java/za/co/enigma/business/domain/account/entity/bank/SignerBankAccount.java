package za.co.enigma.business.domain.account.entity.bank;

import za.co.enigma.business.domain.party.entity.role.PartyRole;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="SIGNER_BANK_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="SIGNER_BANK_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SignerBankAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -2178112454996985853L;

	private BankAccount bankAccount;
	private PartyRole partyRole;
	private double maximumAmount;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BANK_ACCOUNT_ID", foreignKey = @ForeignKey(name = "SIGNER_BANK_ACCOUNT_FK01"))
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "SIGNER_BANK_ACCOUNT_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}
	
	@Column(name="MAXIMUM_AMOUNT")
	public double getMaximumAmount() {
		return maximumAmount;
	}
	

	public void setMaximumAmount(double maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
	
	@XmlTransient
	public static class Builder {
		private SignerBankAccount signerBankAccount;
		
		public Builder() {
			this.signerBankAccount = new SignerBankAccount();
		}
		
		public Builder withId(long id) {
			this.signerBankAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.signerBankAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.signerBankAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.signerBankAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.signerBankAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBankAccount(BankAccount bankAccount){
			this.signerBankAccount.setBankAccount(bankAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.signerBankAccount.setPartyRole(partyRole);
			return this;
		}
		
		public SignerBankAccount build() {
			return this.signerBankAccount;
		}
	}
}
