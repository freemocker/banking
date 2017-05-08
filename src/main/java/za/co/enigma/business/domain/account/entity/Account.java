package za.co.enigma.business.domain.account.entity;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;

import za.co.enigma.business.domain.account.entity.role.AccountRole;
import za.co.enigma.business.domain.account.entity.transaction.AccountTransaction;
import za.co.enigma.business.domain.agreement.entity.AccountAgreement;
import za.co.enigma.business.domain.product.entity.AccountProduct;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ACCOUNT",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="ACCOUNT_02U", 
                columnNames={"ID", "UUID"})
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Account extends ThingDomainArchetype {

	private static final long serialVersionUID = 8337223124848916035L;
	
	private long accountNumber;
	private String description;
	protected List<AccountRole> accountRoles = new ArrayList<>();
	protected List<AccountTransaction> accountTransactions = new ArrayList<>();
	protected List<AccountAgreement> accountAgreements = new  ArrayList<>();
	protected List<AccountProduct> accountProducts = new  ArrayList<>();
	
	@Column(name="ACCOUNT_NUMBER")
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JoinTable(name= "ACCOUNT_ACCOUNT_ROLE",
			joinColumns=@JoinColumn(name ="ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountRole> getAccountRoles() {
		return accountRoles;
	}
	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}
	
	@JoinTable(name= "ACCOUNT_ACCOUNT_TRANSACTION",
			joinColumns=@JoinColumn(name ="ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_TRANSACTION_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountTransaction> getAccountTransactions() {
		return accountTransactions;
	}
	public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
		this.accountTransactions = accountTransactions;
	}
	
	@JoinTable(name= "ACCOUNT_ACCOUNT_AGREEMENTS",
			joinColumns=@JoinColumn(name ="ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_AGREEMENT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountAgreement> getAccountAgreements() {
		return accountAgreements;
	}
	public void setAccountAgreements(List<AccountAgreement> accountAgreements) {
		this.accountAgreements = accountAgreements;
	}
	
	@JoinTable(name= "ACCOUNT_ACCOUNT_PRODUCT",
			joinColumns=@JoinColumn(name ="ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_PRODUCT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountProduct> getAccountProducts() {
		return accountProducts;
	}
	public void setAccountProducts(List<AccountProduct> accountProducts) {
		this.accountProducts = accountProducts;
	}
	
}
