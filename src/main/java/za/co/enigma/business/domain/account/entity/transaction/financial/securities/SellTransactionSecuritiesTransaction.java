package za.co.enigma.business.domain.account.entity.transaction.financial.securities;

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
@Table(name="SELL_TRANSACTION_SECURITIES_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SellTransactionSecuritiesTransaction extends SecuritiesFinancialTransaction {

	private static final long serialVersionUID = 1563668316506539982L;

	@XmlTransient
	public static class Builder {
		private SellTransactionSecuritiesTransaction sellTransactionSecuritiesTransaction;


		public Builder(){
			this.sellTransactionSecuritiesTransaction = new SellTransactionSecuritiesTransaction();
		}

		public Builder withId(long id) {
			this.sellTransactionSecuritiesTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.sellTransactionSecuritiesTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.sellTransactionSecuritiesTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.sellTransactionSecuritiesTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.sellTransactionSecuritiesTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.sellTransactionSecuritiesTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.sellTransactionSecuritiesTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.sellTransactionSecuritiesTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.sellTransactionSecuritiesTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.sellTransactionSecuritiesTransaction.setAccount(account);
			return this;
		}

		public SellTransactionSecuritiesTransaction build() {
			return this.sellTransactionSecuritiesTransaction;
		}
	}
}
