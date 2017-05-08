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
@Table(name="PURCHASE_TRANSACTION_MUTUAL_FUND_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseTransactionMutualFundTransaction extends MutualFundFinancialTransaction {

	private static final long serialVersionUID = 5110641315251637200L;
	
	@XmlTransient
	public static class Builder {
		private PurchaseTransactionMutualFundTransaction purchaseTransactionMutualFundTransaction;


		public Builder(){
			this.purchaseTransactionMutualFundTransaction = new PurchaseTransactionMutualFundTransaction();
		}

		public Builder withId(long id) {
			this.purchaseTransactionMutualFundTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.purchaseTransactionMutualFundTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.purchaseTransactionMutualFundTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.purchaseTransactionMutualFundTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.purchaseTransactionMutualFundTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.purchaseTransactionMutualFundTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.purchaseTransactionMutualFundTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.purchaseTransactionMutualFundTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.purchaseTransactionMutualFundTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.purchaseTransactionMutualFundTransaction.setAccount(account);
			return this;
		}

		public PurchaseTransactionMutualFundTransaction build() {
			return this.purchaseTransactionMutualFundTransaction;
		}
	}
}
