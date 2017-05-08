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
@Table(name="ACCOUNT_PAYMENT_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountPaymentFinancialTransaction extends FinancialTransaction {

	private static final long serialVersionUID = -4659807334555621628L;
	
	@XmlTransient
	public static class Builder {
		private AccountPaymentFinancialTransaction accountPaymentFinancialTransaction;


		public Builder(){
			this.accountPaymentFinancialTransaction = new AccountPaymentFinancialTransaction();
		}

		public Builder withId(long id) {
			this.accountPaymentFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.accountPaymentFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.accountPaymentFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.accountPaymentFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.accountPaymentFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.accountPaymentFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.accountPaymentFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.accountPaymentFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.accountPaymentFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.accountPaymentFinancialTransaction.setAccount(account);
			return this;
		}

		public AccountPaymentFinancialTransaction build() {
			return this.accountPaymentFinancialTransaction;
		}
	}
}
