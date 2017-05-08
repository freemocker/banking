package za.co.enigma.business.domain.account.entity.loan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import za.co.enigma.business.domain.account.entity.AccountType;
import za.co.enigma.common.util.LocalDateAdapter;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

@Entity
@Table(name="LOAN_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(
				name="LOAN_ACCOUNT_02U", 
				columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -1867993740758282650L;

	private long accountNumber;
	private String description;
	private LocalDate establishedDate;
	private LocalDate closedDate;
	private List<CoSignerLoanAccount> coSignerLoanAccounts;
	private List<AuthorizedBorrowerLoanAccount> authorizedBorrowerLoanAccounts;
	private List<GuarantorLoanAccount> guarantorLoanAccounts;
	private List<CoBorrowerLoanAccount> coBorrowerLoanAccounts;
	private AccountType accountType;
	
	
	public LoanAccount() {
		this.coSignerLoanAccounts = new ArrayList<>();
		this.authorizedBorrowerLoanAccounts = new ArrayList<>();
		this.guarantorLoanAccounts = new ArrayList<>();
		this.coBorrowerLoanAccounts = new ArrayList<>();
	}
	
	
	@Column(name = "ACCOUNT_NUMBER")
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "ESTABLISHED_DATE")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(LocalDate establishedDate) {
		this.establishedDate = establishedDate;
	}
	
	@Column(name = "CLOSED_DATE")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}
	
	@JoinTable(name= "LOAN_ACCOUNT_CO_SIGNER_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="LOAN_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "CO_SIGNER_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<CoSignerLoanAccount> getCoSignerLoanAccounts() {
		return coSignerLoanAccounts;
	}
	public void setCoSignerLoanAccounts(List<CoSignerLoanAccount> coSignerLoanAccounts) {
		this.coSignerLoanAccounts = coSignerLoanAccounts;
	}
	
	@JoinTable(name= "LOAN_ACCOUNT_AUTHORIZED_BORROWER_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="LOAN_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTHORIZED_BORROWER_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AuthorizedBorrowerLoanAccount> getAuthorizedBorrowerLoanAccounts() {
		return authorizedBorrowerLoanAccounts;
	}
	public void setAuthorizedBorrowerLoanAccounts(List<AuthorizedBorrowerLoanAccount> authorizedBorrowerLoanAccounts) {
		this.authorizedBorrowerLoanAccounts = authorizedBorrowerLoanAccounts;
	}
	
	@JoinTable(name= "LOAN_ACCOUNT_GUARANTOR_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="LOAN_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "GUARANTOR_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<GuarantorLoanAccount> getGuarantorLoanAccounts() {
		return guarantorLoanAccounts;
	}
	public void setGuarantorLoanAccounts(List<GuarantorLoanAccount> guarantorLoanAccounts) {
		this.guarantorLoanAccounts = guarantorLoanAccounts;
	}
	
	@JoinTable(name= "LOAN_ACCOUNT_CO_BORROWER_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="LOAN_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "CO_BORROWER_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<CoBorrowerLoanAccount> getCoBorrowerLoanAccounts() {
		return coBorrowerLoanAccounts;
	}
	public void setCoBorrowerLoanAccounts(List<CoBorrowerLoanAccount> coBorrowerLoanAccounts) {
		this.coBorrowerLoanAccounts = coBorrowerLoanAccounts;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_TYPE_ID", foreignKey = @ForeignKey(name = "ACCOUNT_TYPE_FK08"))
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@XmlTransient
	public static class Builder {
		private LoanAccount loanAccount;

		public Builder() {
			this.loanAccount = new LoanAccount();
		}

		public Builder withId(long id) {
			this.loanAccount.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.loanAccount.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.loanAccount.setTenant(tenant);
			return this;
		}

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.loanAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}

		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.loanAccount.setEffectiveTo(effectiveTo);
			return this;
		}

		public Builder withAccountNumber(long accountNumber) {
			this.loanAccount.setAccountNumber(accountNumber);
			return this;
		}

		public Builder withDescription(String description) {
			this.loanAccount.setDescription(description);
			return this;
		}

		public Builder withEstablishedDate(LocalDate establishedDate) {
			this.loanAccount.setEstablishedDate(establishedDate);
			return this;
		}

		public Builder withClosedDate(LocalDate closedDate) {
			this.loanAccount.setClosedDate(closedDate);
			return this;
		}

		public Builder withCoSignerLoanAccount(CoSignerLoanAccount coSignerLoanAccount) {
			this.loanAccount.getCoSignerLoanAccounts().add(coSignerLoanAccount);
			return this;
		}

		public Builder withAuthorizedBorrowerLoanAccount(AuthorizedBorrowerLoanAccount authorizedBorrowerLoanAccount) {
			this.loanAccount.getAuthorizedBorrowerLoanAccounts().add(authorizedBorrowerLoanAccount);
			return this;
		}

		public Builder withGuarantorLoanAccount(GuarantorLoanAccount guarantorLoanAccount) {
			this.loanAccount.getGuarantorLoanAccounts().add(guarantorLoanAccount);
			return this;
		}

		public Builder withCoBorrowerLoanAccount(CoBorrowerLoanAccount coBorrowerLoanAccount) {
			this.loanAccount.getCoBorrowerLoanAccounts().add(coBorrowerLoanAccount);
			return this;
		}

		public LoanAccount build() {
			return this.loanAccount;
		}
	}

}
