package za.co.enigma.business.domain.account.entity.transaction.request;

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
@Table(name="CHANGE_ACCOUNT_REQUEST_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChangeAccountRequestFinancialTransaction extends AccountRequestFinancialTransaction {

	private static final long serialVersionUID = 4454889996006063818L;
	
	@XmlTransient
	public static class Builder {
		private ChangeAccountRequestFinancialTransaction changeAccountRequestFinancialTransaction;


		public Builder(){
			this.changeAccountRequestFinancialTransaction = new ChangeAccountRequestFinancialTransaction();
		}

		public Builder withId(long id) {
			this.changeAccountRequestFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.changeAccountRequestFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.changeAccountRequestFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.changeAccountRequestFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.changeAccountRequestFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.changeAccountRequestFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.changeAccountRequestFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.changeAccountRequestFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.changeAccountRequestFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.changeAccountRequestFinancialTransaction.setAccount(account);
			return this;
		}

		public ChangeAccountRequestFinancialTransaction build() {
			return this.changeAccountRequestFinancialTransaction;
		}
	}
}
