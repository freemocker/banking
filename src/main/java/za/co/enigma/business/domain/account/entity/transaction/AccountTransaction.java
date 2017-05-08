package za.co.enigma.business.domain.account.entity.transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import za.co.enigma.business.domain.account.entity.Account;
import za.co.enigma.business.domain.account.entity.role.AccountTransactionRole;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ACCOUNT_TRANSACTION",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="ACCOUNT_TRANSACTION_02U", 
                columnNames={"ID", "UUID"})
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AccountTransaction extends ThingDomainArchetype  {
 
	private static final long serialVersionUID = -2904797992293560878L;
	
	private LocalDateTime transactionDate;
	private LocalDateTime entryDate;
	private LocalDateTime postDate;
	private double amount;
	protected List<AccountTransactionRole> accountTransactionRoles = new ArrayList<>();
	private Account account;
	
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@JoinTable(name= "ACCOUNT_TRANSACTION_ACCOUNT_TRANSACTION_ROLE",
			joinColumns=@JoinColumn(name ="ACCOUNT_TRANSACTION_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_TRANSACTION_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountTransactionRole> getAccountTransactionRoles() {
		return accountTransactionRoles;
	}
	public void setAccountTransactionRoles(List<AccountTransactionRole> accountTransactionRoles) {
		this.accountTransactionRoles = accountTransactionRoles;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_ID", foreignKey = @ForeignKey(name = "ACCOUNT_FK01"))
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	

}
