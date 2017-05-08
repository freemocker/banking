package za.co.enigma.business.domain.account.entity;

import za.co.enigma.business.domain.account.entity.bank.BankAccount;
import za.co.enigma.business.domain.account.entity.brokerage.BrokerageAccount;
import za.co.enigma.business.domain.account.entity.loan.LoanAccount;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="ACCOUNT_TYPE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACCOUNT_TYPE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountType extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -6627399664654518372L;

	private long accountTypeId;
	private String description;
	private List<BankAccount> bankAccounts;
	private List<LoanAccount> loanAccounts;
	private List<BrokerageAccount> brokerageAccounts;

	public AccountType() {
		this.bankAccounts = new ArrayList<>();
		this.loanAccounts  = new ArrayList<>();
		this.brokerageAccounts = new ArrayList<>();
	}

	@Column(name="ACCOUNT_TYPE_ID")
	public long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JoinTable(name= "ACCOUNT_TYPE_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="ACCOUNT_TYPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@JoinTable(name= "ACCOUNT_TYPE__LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="ACCOUNT_TYPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<LoanAccount> getLoanAccounts() {
		return loanAccounts;
	}

	public void setLoanAccounts(List<LoanAccount> loanAccounts) {
		this.loanAccounts = loanAccounts;
	}
	@JoinTable(name= "ACCOUNT_TYPE__LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="ACCOUNT_TYPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "BROKERAGE_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<BrokerageAccount> getBrokerageAccounts() {
		return brokerageAccounts;
	}

	public void setBrokerageAccounts(List<BrokerageAccount> brokerageAccounts) {
		this.brokerageAccounts = brokerageAccounts;
	}

	@XmlTransient
	public static class Builder {
		private AccountType accountType;

		public Builder(){
			this.accountType = new AccountType();
		}
		public Builder withId(long id) {
			this.accountType.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.accountType.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant){
			this.accountType.setTenant(tenant);
			return this;
		}
		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.accountType.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.accountType.setEffectiveTo(effectiveTo);
			return this;
		}

		public Builder withAccountTypeId(long accountTypeId) {
			this.accountType.setAccountTypeId(accountTypeId);
			return this;
		}
		
		public Builder withDescription(String description) {
			this.accountType.setDescription(description);
			return this;
		}

		public Builder withBankAccount(BankAccount bankAccount) {
			this.accountType.getBankAccounts().add(bankAccount);
			return this;
		}
		
		public Builder withLoanAccount(LoanAccount loanAccount) {
			this.accountType.getLoanAccounts().add(loanAccount);
			return this;
		}
		
		public Builder withBrokerageAccount(BrokerageAccount brokerageAccount) {
			this.accountType.getBrokerageAccounts().add(brokerageAccount);
			return this;
		}
		
		public AccountType build() {
			return this.accountType;
		}
	}
}
