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
@Table(name="BUY_TRANSACTION_SECURITIES_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BuyTransactionSecuritiesTransaction extends SecuritiesFinancialTransaction {

	private static final long serialVersionUID = -2187752365666769416L;
	
	
	@XmlTransient
	public static class Builder {
		private BuyTransactionSecuritiesTransaction buyTransactionSecuritiesTransaction;


		public Builder(){
			this.buyTransactionSecuritiesTransaction = new BuyTransactionSecuritiesTransaction();
		}

		public Builder withId(long id) {
			this.buyTransactionSecuritiesTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.buyTransactionSecuritiesTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.buyTransactionSecuritiesTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.buyTransactionSecuritiesTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.buyTransactionSecuritiesTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.buyTransactionSecuritiesTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.buyTransactionSecuritiesTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.buyTransactionSecuritiesTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.buyTransactionSecuritiesTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.buyTransactionSecuritiesTransaction.setAccount(account);
			return this;
		}

		public BuyTransactionSecuritiesTransaction build() {
			return this.buyTransactionSecuritiesTransaction;
		}
	}
}
