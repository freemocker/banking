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
@Table(name="BENEFICIARY_BANK_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="BENEFICIARY_BANK_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BeneficiaryBankAccount extends MomentIntervalDomainArchetype{

	private static final long serialVersionUID = 5071727432983362696L;

	private BankAccount bankAccount;
	private PartyRole partyRole;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BANK_ACCOUNT_ID", foreignKey = @ForeignKey(name = "BANK_ACCOUNT_BENEFICIARY_FK01"))
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "BANK_ACCOUNT_BENEFICIARY_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private BeneficiaryBankAccount beneficiaryBankAccount;
		
		public Builder() {
			this.beneficiaryBankAccount = new BeneficiaryBankAccount();
		}
		
		public Builder withId(long id) {
			this.beneficiaryBankAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.beneficiaryBankAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.beneficiaryBankAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.beneficiaryBankAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.beneficiaryBankAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBankAccount(BankAccount bankAccount){
			this.beneficiaryBankAccount.setBankAccount(bankAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.beneficiaryBankAccount.setPartyRole(partyRole);
			return this;
		}
		
		public BeneficiaryBankAccount build() {
			return this.beneficiaryBankAccount;
		}
	}
}
