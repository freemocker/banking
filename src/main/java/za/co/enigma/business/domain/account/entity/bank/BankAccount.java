package za.co.enigma.business.domain.account.entity.bank;

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
@Table(name="BANK_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="BANK_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -3247837839711027008L;
	
	private AccountType accountType;
	private long accountNumber;
	private String description;
	private LocalDate establishedDate;
	private LocalDate closedDate;
	private List<TrusteeBankAccount> trusteeBankAccounts;
	private List<BeneficiaryBankAccount> beneficiaryBankAccounts;
	private List<SignerBankAccount> signerBankAccounts;
	private List<HolderBankAccount> holderBankAccounts;
	
	public BankAccount() {
		this.trusteeBankAccounts = new ArrayList<>();
		this.beneficiaryBankAccounts = new ArrayList<>();
		this.signerBankAccounts = new ArrayList<>();
		this.holderBankAccounts = new ArrayList<>();
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_TYPE_ID", foreignKey = @ForeignKey(name = "ACCOUNT_TYPE_FK01"))
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
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
	
	@JoinTable(name= "BANK_ACCOUNT_TRUSTEE_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="BANK_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "TRUSTEE_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<TrusteeBankAccount> getTrusteeBankAccounts() {
		return trusteeBankAccounts;
	}
	public void setTrusteeBankAccounts(List<TrusteeBankAccount> trusteeBankAccounts) {
		this.trusteeBankAccounts = trusteeBankAccounts;
	}
	
	@JoinTable(name= "BANK_ACCOUNT_BENEFICIARY_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="BANK_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "BENEFICIARY_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<BeneficiaryBankAccount> getBeneficiaryBankAccounts() {
		return beneficiaryBankAccounts;
	}
	public void setBeneficiaryBankAccounts(List<BeneficiaryBankAccount> beneficiaryBankAccounts) {
		this.beneficiaryBankAccounts = beneficiaryBankAccounts;
	}
	
	@JoinTable(name= "BANK_ACCOUNT_SIGNER_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="BANK_ACCOUNT__ID"),
			inverseJoinColumns = @JoinColumn(name = "SIGNER_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<SignerBankAccount> getSignerBankAccounts() {
		return signerBankAccounts;
	}
	public void setSignerBankAccounts(List<SignerBankAccount> signerBankAccounts) {
		this.signerBankAccounts = signerBankAccounts;
	}
	
	@JoinTable(name= "BANK_ACCOUNT_HOLDER_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="BANK_ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "HOLDER_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<HolderBankAccount> getHolderBankAccounts() {
		return holderBankAccounts;
	}
	public void setHolderBankAccounts(List<HolderBankAccount> holderBankAccounts) {
		this.holderBankAccounts = holderBankAccounts;
	}
	
	@XmlTransient
	public static class Builder {
		private BankAccount bankAccount;
		
		public Builder(){
			this.bankAccount = new BankAccount();
		}
		
	    public Builder withId(long id) {
	    	this.bankAccount.setId(id);
	    	return this;
	    }
	    
	    public Builder withUuid(String uuid) {
	    	this.bankAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.bankAccount.setTenant(tenant);
	    	return this;
	    }

	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.bankAccount.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.bankAccount.setEffectiveTo(effectiveTo);
	    	return this;
	    }

	    public Builder withAccountType(AccountType accountType) {
	    	this.bankAccount.setAccountType(accountType);
	    	return this;
	    }

	    public Builder withAccountNumber(long accountNumber) {
	    	this.bankAccount.setAccountNumber(accountNumber);
	    	return this;
	    }
	
	    public Builder withDescription(String description) {
	    	this.bankAccount.setDescription(description);
	    	return this;
	    }

	    public Builder withEstablishedDate(LocalDate establishedDate) {
	    	this.bankAccount.setEstablishedDate(establishedDate);
	    	return this;
	    }

	    public Builder withClosedDate(LocalDate closedDate) {
	    	this.bankAccount.setClosedDate(closedDate);
	    	return this;
	    }

	    public Builder withTrusteeBankAccount(TrusteeBankAccount trusteeBankAccount) {
	    	this.bankAccount.getTrusteeBankAccounts().add(trusteeBankAccount);
	    	return this;
	    }
	    public Builder withBeneficiaryBankAccount(BeneficiaryBankAccount beneficiaryBankAccount) {
	    	this.bankAccount.getBeneficiaryBankAccounts().add(beneficiaryBankAccount);
	    	return this;
	    }
	    public Builder withSignerBankAccount(SignerBankAccount signerBankAccount) {
	    	this.bankAccount.getSignerBankAccounts().add(signerBankAccount);
	    	return this;
	    }
	    public Builder withHolderBankAccount(HolderBankAccount holderBankAccount) {
	    	this.bankAccount.getHolderBankAccounts().add(holderBankAccount);
	    	return this;
	    }
				
		public BankAccount build() {
			return this.bankAccount;
		}
	}
}
