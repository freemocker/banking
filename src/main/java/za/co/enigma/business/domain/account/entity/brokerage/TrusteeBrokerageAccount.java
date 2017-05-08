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
@Table(name="TRUSTEE_BROKERAGE_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="TRUSTEE_BROKERAGE_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrusteeBrokerageAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -4913375398245850532L;
	
	private BrokerageAccount brokerageAccount;
	private PartyRole partyRole;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BROKERAGE_ACCOUNT_ID", foreignKey = @ForeignKey(name = "BROKERAGE_ACCOUNT_TRUSTEE_FK01"))
	public BrokerageAccount getBrokerageAccount() {
		return brokerageAccount;
	}

	public void setBrokerageAccount(BrokerageAccount brokerageAccount) {
		this.brokerageAccount = brokerageAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "BROKERAGE_ACCOUNT_TRUSTEE_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private TrusteeBrokerageAccount trusteeBrokerageAccount;
		
		public Builder() {
			this.trusteeBrokerageAccount = new TrusteeBrokerageAccount();
		}
		
		public Builder withId(long id) {
			this.trusteeBrokerageAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.trusteeBrokerageAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.trusteeBrokerageAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.trusteeBrokerageAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.trusteeBrokerageAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBrokerageAccount(BrokerageAccount brokerageAccount){
			this.trusteeBrokerageAccount.setBrokerageAccount(brokerageAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.trusteeBrokerageAccount.setPartyRole(partyRole);
			return this;
		}
		
		public TrusteeBrokerageAccount build() {
			return this.trusteeBrokerageAccount;
		}
	}
}
