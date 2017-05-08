package za.co.enigma.business.domain.party.entity.organization;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.business.domain.account.entity.role.AccountRole;
import za.co.enigma.business.domain.account.entity.role.AccountTransactionRole;
import za.co.enigma.business.domain.party.entity.Party;
import za.co.enigma.business.domain.party.entity.role.PartyRole;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ORGANIZATION")
public class Organization extends Party implements Serializable {

	private static final long serialVersionUID = -1190096609066336170L;

	private String shortName;
	private String tradingAs;
	private LocalDate registeredOn;
	private LocalDate deRegistedOn;
	private String name;
	private OrganizationType organizationType;
	private OrganizationStatus organizationStatus ;

	@NotNull(message = "\" The Short Name field cannot be null. \"")
	@Column(name ="SHORT_NAME")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	@NotNull(message = "\" The Trading As field cannot be null. \"")
	@Column(name ="TRADING_AS")
	public String getTradingAs() {
		return tradingAs;
	}

	public void setTradingAs(String tradingAs) {
		this.tradingAs = tradingAs;
	}
	
	@NotNull(message = "\" The Registered On field cannot be null. \"")
	@Column(name ="REGISTERED_ON")
	public LocalDate getRegisteredOn() {
		if (this.registeredOn == null) {
			this.registeredOn = LocalDate.of(1970, Month.JANUARY, 01);
		}
		return registeredOn;
	}

	public void setRegisteredOn(LocalDate registeredOn) {
		this.registeredOn = registeredOn;
	}
	
	@Column(name ="DE_REGISTERED_ON")
	public LocalDate getDeRegistedOn() {
		if (this.deRegistedOn == null) {
			this.deRegistedOn = LocalDate.of(9999, Month.DECEMBER, 31);
		}
		return deRegistedOn;
	}

	public void setDeRegistedOn(LocalDate deRegistedOn) {
		this.deRegistedOn = deRegistedOn;
	}
	
	@NotNull(message = "\" The Name field cannot be null. \"")
	@Column(name ="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JoinColumn(name = "ORGANIZATION_TYPE")
	@OneToOne(cascade=CascadeType.ALL)
	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}
	
	@JoinColumn(name = "ORGANIZATION_STATUS")
	@OneToOne(cascade=CascadeType.ALL)
	public OrganizationStatus getOrganizationStatus() {
		return organizationStatus;
	}

	public void setOrganizationStatus(OrganizationStatus organizationStatus) {
		this.organizationStatus = organizationStatus;
	}
	
	//Builder
	@XmlTransient
	public static class Builder {
		private Organization organization;
		
		public Builder() {
			this.organization = new Organization();
		}
		
		public Builder withTenant(int tenant) {
			this.organization.setTenant(tenant);
			return this;
		}
		
		public Builder withUUID(String uuid) {
			this.organization.setUuid(uuid);
			return this;
		}
		
		public Builder withCellphone(String cellphone) {
			this.organization.setCellphone(cellphone);
			return this;
		}
		public Builder withTelephone(String telephone) {
			this.organization.setTelephone(telephone);
			return this;
		}
		
		public Builder withEmailAddress(String emailAddress) {
			this.organization.setEmailAddress(emailAddress);
			return this;
		}
		
		public Builder withAddress(String address) {
			this.organization.setAddress(address);
			return this;
		}
		
		public Builder withShortName(String shortName) {
			this.organization.setShortName(shortName);
			return this;
		}
		
		public Builder withTradingAs(String tradingAs) {
			this.organization.setTradingAs(tradingAs);
			return this;
		}
		
		public Builder withRegisteredOn(LocalDate registeredOn) {
			this.organization.setRegisteredOn(registeredOn);
			return this;
		}
		
		
		public Builder withDeregisteredOn(LocalDate deregisteredOn) {
			this.organization.setDeRegistedOn(deregisteredOn);
			return this;
		}
		
		public Builder withName(String name) {
			this.organization.setName(name);
			return this;
		}
		
		public Builder withOrganizationType(OrganizationType type) {
			this.organization.setOrganizationType(type);
			return this;
		}
		
		public Builder withOrganizationStatus(OrganizationStatus status) {
			this.organization.setOrganizationStatus(status);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.organization.getPartyRoles().add(partyRole);
			return this;
		}
	    
	    public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
	    	this.organization.getAccountTransactionRoles().add(accountTransactionRole);
	    	return this;
	    }
	    
	    public Builder withAccountRole(AccountRole accountRole) {
	    	this.organization.getAccountRoles().add(accountRole);
	    	return this;
	    }
		
		public Organization build() {
			// some validations.
			return this.organization;
		}
	}
}
