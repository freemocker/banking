package za.co.enigma.business.domain.account.entity.transaction.financial;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import za.co.enigma.business.domain.account.entity.Account;
import za.co.enigma.business.domain.account.entity.role.AccountTransactionRole;


@Entity
@Table(name="INTEREST_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InterestFinancialTransaction extends FinancialTransaction {

	private static final long serialVersionUID = 7437698250753039628L;
	
	@XmlTransient
	public static class Builder {
		private InterestFinancialTransaction interestFinancialTransaction;


		public Builder(){
			this.interestFinancialTransaction = new InterestFinancialTransaction();
		}

		public Builder withId(long id) {
			this.interestFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.interestFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.interestFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.interestFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.interestFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.interestFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.interestFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.interestFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.interestFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.interestFinancialTransaction.setAccount(account);
			return this;
		}

		public InterestFinancialTransaction build() {
			return this.interestFinancialTransaction;
		}
	}

}
