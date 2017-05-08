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
@Table(name="WITHDRAWAL_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WithdrawalFinancialTransaction extends FinancialTransaction {

	private static final long serialVersionUID = -7103054386899849741L;
	
	@XmlTransient
	public static class Builder {
		private WithdrawalFinancialTransaction withdrawalFinancialTransaction;

		public Builder(){
			this.withdrawalFinancialTransaction = new WithdrawalFinancialTransaction();
		}

		public Builder withId(long id) {
			this.withdrawalFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.withdrawalFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.withdrawalFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.withdrawalFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.withdrawalFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.withdrawalFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.withdrawalFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.withdrawalFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.withdrawalFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.withdrawalFinancialTransaction.setAccount(account);
			return this;
		}

		public WithdrawalFinancialTransaction build() {
			return this.withdrawalFinancialTransaction;
		}
	}
}
