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
@Table(name="DEPOSIT_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositFinancialTransaction extends FinancialTransaction {

	private static final long serialVersionUID = 1067992703389866851L;
	
	@XmlTransient
	public static class Builder {
		private DepositFinancialTransaction depositFinancialTransaction;


		public Builder(){
			this.depositFinancialTransaction = new DepositFinancialTransaction();
		}

		public Builder withId(long id) {
			this.depositFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.depositFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.depositFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.depositFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.depositFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.depositFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.depositFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.depositFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.depositFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.depositFinancialTransaction.setAccount(account);
			return this;
		}

		public DepositFinancialTransaction build() {
			return this.depositFinancialTransaction;
		}
	}
}
