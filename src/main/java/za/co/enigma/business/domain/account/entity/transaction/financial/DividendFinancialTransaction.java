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
@Table(name="DIVIDEND_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DividendFinancialTransaction extends FinancialTransaction {

	private static final long serialVersionUID = -8386201529227073363L;
	
	@XmlTransient
	public static class Builder {
		private DividendFinancialTransaction dividendFinancialTransaction;


		public Builder(){
			this.dividendFinancialTransaction = new DividendFinancialTransaction();
		}

		public Builder withId(long id) {
			this.dividendFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.dividendFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.dividendFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.dividendFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.dividendFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.dividendFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.dividendFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.dividendFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.dividendFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.dividendFinancialTransaction.setAccount(account);
			return this;
		}

		public DividendFinancialTransaction build() {
			return this.dividendFinancialTransaction;
		}
	}
}
