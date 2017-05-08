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
@Table(name="SPECIAL_ACCOUNT_REQUEST_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialAccountRequestFinancialTransaction extends AccountRequestFinancialTransaction {

	private static final long serialVersionUID = -1238301453355060400L;
	
	@XmlTransient
	public static class Builder {
		private SpecialAccountRequestFinancialTransaction specialAccountRequestFinancialTransaction;


		public Builder(){
			this.specialAccountRequestFinancialTransaction = new SpecialAccountRequestFinancialTransaction();
		}

		public Builder withId(long id) {
			this.specialAccountRequestFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.specialAccountRequestFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.specialAccountRequestFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.specialAccountRequestFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.specialAccountRequestFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.specialAccountRequestFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.specialAccountRequestFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.specialAccountRequestFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.specialAccountRequestFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.specialAccountRequestFinancialTransaction.setAccount(account);
			return this;
		}

		public SpecialAccountRequestFinancialTransaction build() {
			return this.specialAccountRequestFinancialTransaction;
		}
	}
}
