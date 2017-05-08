package za.co.enigma.business.domain.account.entity.brokerage;

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
@Table(name="BENEFICIARY_BROKERAGE_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="BENEFICIARY_BROKERAGE_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BeneficiaryBrokerageAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -5973719634190376601L;


	private BrokerageAccount brokerageAccount;
	private PartyRole partyRole;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BROKERAGE_ACCOUNT_ID", foreignKey = @ForeignKey(name = "BENEFICIARY_BROKERAGE_ACCOUNT_FK01"))
	public BrokerageAccount getBrokerageAccount() {
		return brokerageAccount;
	}

	public void setBrokerageAccount(BrokerageAccount brokerageAccount) {
		this.brokerageAccount = brokerageAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "BENEFICIARY_BROKERAGE_ACCOUNT_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private BeneficiaryBrokerageAccount beneficiaryBrokerageAccount;
		
		public Builder() {
			this.beneficiaryBrokerageAccount = new BeneficiaryBrokerageAccount();
		}
		
		public Builder withId(long id) {
			this.beneficiaryBrokerageAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.beneficiaryBrokerageAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.beneficiaryBrokerageAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.beneficiaryBrokerageAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.beneficiaryBrokerageAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBrokerageAccount(BrokerageAccount brokerageAccount){
			this.beneficiaryBrokerageAccount.setBrokerageAccount(brokerageAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.beneficiaryBrokerageAccount.setPartyRole(partyRole);
			return this;
		}
		
		public BeneficiaryBrokerageAccount build() {
			return this.beneficiaryBrokerageAccount;
		}
	}
}
