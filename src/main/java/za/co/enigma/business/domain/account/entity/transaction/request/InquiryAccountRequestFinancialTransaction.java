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
@Table(name="INQUIRY_ACCOUNT_REQUEST_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InquiryAccountRequestFinancialTransaction extends AccountRequestFinancialTransaction {

	private static final long serialVersionUID = 1708125417330127140L;
	
	@XmlTransient
	public static class Builder {
		private InquiryAccountRequestFinancialTransaction inquiryAccountRequestFinancialTransaction;


		public Builder(){
			this.inquiryAccountRequestFinancialTransaction = new InquiryAccountRequestFinancialTransaction();
		}

		public Builder withId(long id) {
			this.inquiryAccountRequestFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.inquiryAccountRequestFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.inquiryAccountRequestFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.inquiryAccountRequestFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.inquiryAccountRequestFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.inquiryAccountRequestFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.inquiryAccountRequestFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.inquiryAccountRequestFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.inquiryAccountRequestFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.inquiryAccountRequestFinancialTransaction.setAccount(account);
			return this;
		}

		public InquiryAccountRequestFinancialTransaction build() {
			return this.inquiryAccountRequestFinancialTransaction;
		}
	}
}
