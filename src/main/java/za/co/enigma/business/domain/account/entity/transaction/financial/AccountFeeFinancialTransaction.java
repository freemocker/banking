package za.co.enigma.business.domain.account.entity.transaction.financial;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.business.domain.account.entity.Account;
import za.co.enigma.business.domain.account.entity.role.AccountTransactionRole;
import za.co.enigma.business.domain.account.entity.transaction.financial.securities.SellTransactionSecuritiesTransaction;
import za.co.enigma.business.domain.account.entity.transaction.financial.securities.SellTransactionSecuritiesTransaction.Builder;


@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ACCOUNT_FEE_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountFeeFinancialTransaction extends FinancialTransaction {
	
	private static final long serialVersionUID = -8147392770940330231L;
	
	@XmlTransient
	public static class Builder {
		private AccountFeeFinancialTransaction accountFeeFinancialTransaction;


		public Builder(){
			this.accountFeeFinancialTransaction = new AccountFeeFinancialTransaction();
		}

		public Builder withId(long id) {
			this.accountFeeFinancialTransaction.setId(id);
			return this;
		}

		public Builder withUuid(String uuid){
			this.accountFeeFinancialTransaction.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.accountFeeFinancialTransaction.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.accountFeeFinancialTransaction.setName(name);
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.accountFeeFinancialTransaction.setTransactionDate(transactionDate);
			return this;
		}

		public Builder withEntryDate(LocalDateTime entryDate) {
			this.accountFeeFinancialTransaction.setEntryDate(entryDate);
			return this;
		}

		public Builder withPostDate(LocalDateTime postDate) {
			this.accountFeeFinancialTransaction.setPostDate(postDate);
			return this;
		}

		public Builder withAmount(double amount) {
			this.accountFeeFinancialTransaction.setAmount(amount);
			return this;
		}

		public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
			this.accountFeeFinancialTransaction.getAccountTransactionRoles().add(accountTransactionRole);
			return this;
		}

		public Builder withAccount(Account account) {
			this.accountFeeFinancialTransaction.setAccount(account);
			return this;
		}

		public AccountFeeFinancialTransaction build() {
			return this.accountFeeFinancialTransaction;
		}
	}
}
