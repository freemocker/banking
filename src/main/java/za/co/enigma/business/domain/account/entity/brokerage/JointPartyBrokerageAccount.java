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
@Table(name="JOINT_PARTY_BROKERAGE_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="JOINT_PARTY_BROKERAGE_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JointPartyBrokerageAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -9056411917310604459L;

	private BrokerageAccount brokerageAccount;
	private PartyRole partyRole;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "BROKERAGE_ACCOUNT_ID", foreignKey = @ForeignKey(name = "JOINT_PARTY_BROKERAGE_ACCOUNT_FK01"))
	public BrokerageAccount getBrokerageAccount() {
		return brokerageAccount;
	}

	public void setBrokerageAccount(BrokerageAccount brokerageAccount) {
		this.brokerageAccount = brokerageAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "JOINT_PARTY_BROKERAGE_ACCOUNT_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private JointPartyBrokerageAccount jointPartyBrokerageAccount;
		
		public Builder() {
			this.jointPartyBrokerageAccount = new JointPartyBrokerageAccount();
		}
		
		public Builder withId(long id) {
			this.jointPartyBrokerageAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.jointPartyBrokerageAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.jointPartyBrokerageAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.jointPartyBrokerageAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.jointPartyBrokerageAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBrokerageAccount(BrokerageAccount brokerageAccount){
			this.jointPartyBrokerageAccount.setBrokerageAccount(brokerageAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.jointPartyBrokerageAccount.setPartyRole(partyRole);
			return this;
		}
		
		public JointPartyBrokerageAccount build() {
			return this.jointPartyBrokerageAccount;
		}
	}
}
