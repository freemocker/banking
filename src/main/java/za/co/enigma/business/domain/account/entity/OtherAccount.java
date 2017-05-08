package za.co.enigma.business.domain.account.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import za.co.enigma.business.domain.account.entity.role.AccountRole;
import za.co.enigma.business.domain.account.entity.transaction.AccountTransaction;
import za.co.enigma.business.domain.agreement.entity.AccountAgreement;
import za.co.enigma.business.domain.product.entity.AccountProduct;


@Entity
@Table(name="OTHER_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherAccount extends Account {

	private static final long serialVersionUID = -8395190971092468115L;


	@XmlTransient
	public static class Builder {
		private OtherAccount otherAccount;

		public Builder() {
			this.otherAccount = new OtherAccount();
		}

		public Builder withId(long id){
			this.otherAccount.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.otherAccount.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.otherAccount.setTenant(tenant);
			return this;
		}
		public Builder withName(String name) {
			this.otherAccount.setName(name);
			return this;
		}

		public Builder withAccountNumber(long accountNumber) {
			this.otherAccount.setAccountNumber(accountNumber);
			return this;
		}

		public Builder withDescription(String description){
			this.otherAccount.setDescription(description);
			return this;
		}

		public Builder withAccountRole(AccountRole accountRole) {
			this.otherAccount.getAccountRoles().add(accountRole);
			return this;
		}

		public Builder withAccountTransaction(AccountTransaction accountTransaction) {
			this.otherAccount.getAccountTransactions().add(accountTransaction);
			return this;
		}

		public Builder withAccountAgreement(AccountAgreement accountAgreement) {
			this.otherAccount.getAccountAgreements().add(accountAgreement);
			return this;
		}

		public Builder withAccountProduct(AccountProduct accountProduct) {
			this.otherAccount.getAccountProducts().add(accountProduct);
			return this;
		}

		public OtherAccount build(){
			return this.otherAccount;
		}
	}
}
