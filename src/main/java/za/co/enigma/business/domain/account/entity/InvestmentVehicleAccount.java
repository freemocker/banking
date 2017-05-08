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
@Table(name="INVESTMENT_VEHICLE_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InvestmentVehicleAccount extends Account {

	private static final long serialVersionUID = -5889484757609734181L;

	@XmlTransient
	public static class Builder {
		private InvestmentVehicleAccount investmentVehicleAccount;

		public Builder() {
			this.investmentVehicleAccount = new InvestmentVehicleAccount();
		}

		public Builder withId(long id){
			this.investmentVehicleAccount.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.investmentVehicleAccount.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.investmentVehicleAccount.setTenant(tenant);
			return this;
		}
		public Builder withName(String name) {
			this.investmentVehicleAccount.setName(name);
			return this;
		}

		public Builder withAccountNumber(long accountNumber) {
			this.investmentVehicleAccount.setAccountNumber(accountNumber);
			return this;
		}

		public Builder withDescription(String description){
			this.investmentVehicleAccount.setDescription(description);
			return this;
		}

		public Builder withAccountRole(AccountRole accountRole) {
			this.investmentVehicleAccount.getAccountRoles().add(accountRole);
			return this;
		}

		public Builder withAccountTransaction(AccountTransaction accountTransaction) {
			this.investmentVehicleAccount.getAccountTransactions().add(accountTransaction);
			return this;
		}

		public Builder withAccountAgreement(AccountAgreement accountAgreement) {
			this.investmentVehicleAccount.getAccountAgreements().add(accountAgreement);
			return this;
		}

		public Builder withAccountProduct(AccountProduct accountProduct) {
			this.investmentVehicleAccount.getAccountProducts().add(accountProduct);
			return this;
		}

		public InvestmentVehicleAccount build(){
			return this.investmentVehicleAccount;
		}
	}
}
