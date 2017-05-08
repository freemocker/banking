package za.co.enigma.business.domain.account.entity.transaction.financial.mutual;

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
@Table(name="EXCHANGE_TRANSACTION_MUTUAL_FUND_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeTransactionMutualFundTransaction extends MutualFundFinancialTransaction {

	private static final long serialVersionUID = -4244672798864682855L;

	@XmlTransient
	public static class Builder {
		private ExchangeTransactionMutualFundTransaction exchangeTransactionMutualFundTransaction;


		public Builder(){
			this.exchangeTransactionMutualFundTransaction = new ExchangeTransactionMutualFundTransaction();
		}

		public Builder withId(long id) {
			this.exchangeTransactionMutualFundTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.exchangeTransactionMutualFundTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.exchangeTransactionMutualFundTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.exchangeTransactionMutualFundTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.exchangeTransactionMutualFundTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.exchangeTransactionMutualFundTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.exchangeTransactionMutualFundTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.exchangeTransactionMutualFundTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.exchangeTransactionMutualFundTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.exchangeTransactionMutualFundTransaction.setAccount(account);
			return this;
		}

		public ExchangeTransactionMutualFundTransaction build() {
			return this.exchangeTransactionMutualFundTransaction;
		}
	}
}
