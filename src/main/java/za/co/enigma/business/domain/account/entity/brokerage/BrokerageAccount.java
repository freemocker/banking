package za.co.enigma.business.domain.account.entity.brokerage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import za.co.enigma.business.domain.account.entity.AccountType;
import za.co.enigma.common.util.LocalDateAdapter;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name="BROKERAGE_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="BROKERAGE_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BrokerageAccount extends  MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -4193537882137025255L;

	private long accountNumber;
	private String description;
	private LocalDate establishedDate;
	private LocalDate closedDate;
	private List<TrusteeBrokerageAccount> trusteeBrokerageAccounts;
	private List<BeneficiaryBrokerageAccount> beneficiaryBrokerageAccounts;
	private List<AuthorizedSignerBrokerageAccount> authorizedSignerBrokerageAccounts;
	private List<JointPartyBrokerageAccount> jointPartyBrokerageAccounts;
	private AccountType accountType;

	public BrokerageAccount() {
		this.trusteeBrokerageAccounts = new ArrayList<>();
		this.beneficiaryBrokerageAccounts = new ArrayList<>();
		this.authorizedSignerBrokerageAccounts = new ArrayList<>();
		this.jointPartyBrokerageAccounts = new ArrayList<>();
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "ESTABLISHED_DATE")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getEstablishedDate() {
		if (this.establishedDate == null) {
			this.establishedDate = LocalDate.of(2017, Month.JANUARY, 01);
		}
		return establishedDate;
	}
	public void setEstablishedDate(LocalDate establishedDate) {
		this.establishedDate = establishedDate;
	}
	@Column(name = "CLOSED_DATE")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getClosedDate() {
		if (this.closedDate == null) {
			this.closedDate = LocalDate.of(9999, Month.DECEMBER, 31);
		}
		return closedDate;
	}
	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}

	@JoinTable(name= "BROKERAGE_ACCOUNT_TRUSTEE_BROKERAGE_ACCOUNT",
			joinColumns=@JoinColumn(name ="BROKERAGE_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "TRUSTEE_BROKERAGE_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<TrusteeBrokerageAccount> getTrusteeBrokerageAccounts() {
		return trusteeBrokerageAccounts;
	}
	public void setTrusteeBrokerageAccounts(List<TrusteeBrokerageAccount> trusteeBrokerageAccounts) {
		this.trusteeBrokerageAccounts = trusteeBrokerageAccounts;
	}

	@JoinTable(name= "BROKERAGE_ACCOUNT_BENEFICIARY_BROKERAGE_ACCOUNT",
			joinColumns=@JoinColumn(name ="BROKERAGE_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "BENEFICIARY_BROKERAGE_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<BeneficiaryBrokerageAccount> getBeneficiaryBrokerageAccounts() {
		return beneficiaryBrokerageAccounts;
	}
	public void setBeneficiaryBrokerageAccounts(List<BeneficiaryBrokerageAccount> beneficiaryBrokerageAccounts) {
		this.beneficiaryBrokerageAccounts = beneficiaryBrokerageAccounts;
	}

	@JoinTable(name= "BROKERAGE_ACCOUNT_AUTHORIZED_SIGNER_BROKERAGE_ACCOUNT",
			joinColumns=@JoinColumn(name ="BROKERAGE_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTHORIZED_SIGNER_BROKERAGE_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AuthorizedSignerBrokerageAccount> getAuthorizedSignerBrokerageAccounts() {
		return authorizedSignerBrokerageAccounts;
	}
	public void setAuthorizedSignerBrokerageAccounts(
			List<AuthorizedSignerBrokerageAccount> authorizedSignerBrokerageAccounts) {
		this.authorizedSignerBrokerageAccounts = authorizedSignerBrokerageAccounts;
	}

	@JoinTable(name= "BANK_ACCOUNT_TRUSTEE_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="BROKERAGE_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "TRUSTEE_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<JointPartyBrokerageAccount> getJointPartyBrokerageAccounts() {
		return jointPartyBrokerageAccounts;
	}
	public void setJointPartyBrokerageAccounts(List<JointPartyBrokerageAccount> jointPartyBrokerageAccounts) {
		this.jointPartyBrokerageAccounts = jointPartyBrokerageAccounts;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_TYPE_ID", foreignKey = @ForeignKey(name = "ACCOUNT_BROKERAGE_FK01"))
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	@XmlTransient
	public static class Builder {
		private BrokerageAccount brokerageAccount;

		public Builder(){
			this.brokerageAccount = new BrokerageAccount();
		}
		public Builder withId(long id) {
			this.brokerageAccount.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.brokerageAccount.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.brokerageAccount.setTenant(tenant);
			return this;
		}

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.brokerageAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}

		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.brokerageAccount.setEffectiveTo(effectiveTo);
			return this;
		}

		public Builder withAccountNumber(long accountNumber) {
			this.brokerageAccount.setAccountNumber(accountNumber);
			return this;
		}

		public Builder withDescription(String description) {
			this.brokerageAccount.setDescription(description);
			return this;
		}

		public Builder withEstablishedDate(LocalDate establishedDate) {
			this.brokerageAccount.setEstablishedDate(establishedDate);
			return this;
		}

		public Builder withClosedDate(LocalDate closedDate) {
			this.brokerageAccount.setClosedDate(closedDate);
			return this;
		}

		public Builder withTrusteeBrokerageAccount(TrusteeBrokerageAccount trusteeBrokerageAccount) {
			this.brokerageAccount.getTrusteeBrokerageAccounts().add(trusteeBrokerageAccount);
			return this;
		}
		public Builder withBeneficiaryBrokerageAccount(BeneficiaryBrokerageAccount beneficiaryBrokerageAccount) {
			this.brokerageAccount.getBeneficiaryBrokerageAccounts().add(beneficiaryBrokerageAccount);
			return this;
		}

		public Builder withAuthorizedSignerBrokerageAccount(AuthorizedSignerBrokerageAccount authorizedSignerBrokerageAccount) {
			this.brokerageAccount.getAuthorizedSignerBrokerageAccounts().add(authorizedSignerBrokerageAccount);
			return this;
		}

		public Builder withJointPartyBrokerageAccount(JointPartyBrokerageAccount jointPartyBrokerageAccount) {
			this.brokerageAccount.getJointPartyBrokerageAccounts().add(jointPartyBrokerageAccount);
			return this;
		}

		public Builder withAccountType(AccountType accountType) {
			this.brokerageAccount.setAccountType(accountType);
			return this;
		}

		public BrokerageAccount build() {
			return this.brokerageAccount;
		}
	}
}
