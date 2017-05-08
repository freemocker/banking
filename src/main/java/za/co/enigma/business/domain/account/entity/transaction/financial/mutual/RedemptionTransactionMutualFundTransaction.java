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
@Table(name="REDEMPTION_TRANSACTION_MUTUAL_FUND_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RedemptionTransactionMutualFundTransaction extends MutualFundFinancialTransaction {

	private static final long serialVersionUID = 8600550244799549333L;
	
	@XmlTransient
	public static class Builder {
		private RedemptionTransactionMutualFundTransaction redemptionTransactionMutualFundTransaction;


		public Builder(){
			this.redemptionTransactionMutualFundTransaction = new RedemptionTransactionMutualFundTransaction();
		}

		public Builder withId(long id) {
			this.redemptionTransactionMutualFundTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.redemptionTransactionMutualFundTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.redemptionTransactionMutualFundTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.redemptionTransactionMutualFundTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.redemptionTransactionMutualFundTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.redemptionTransactionMutualFundTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.redemptionTransactionMutualFundTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.redemptionTransactionMutualFundTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.redemptionTransactionMutualFundTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.redemptionTransactionMutualFundTransaction.setAccount(account);
			return this;
		}

		public RedemptionTransactionMutualFundTransaction build() {
			return this.redemptionTransactionMutualFundTransaction;
		}
	}

}
