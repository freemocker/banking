package za.co.enigma.business.domain.product.entity;

import za.co.enigma.business.domain.account.entity.Account;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="ACCOUNT_PRODUCT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACCOUNT_PRODUCT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountProduct extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -2433292835626216766L;
	
	private FinancialProduct financialProduct;
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "FINANCIAL_PRODUCT_ID", foreignKey = @ForeignKey(name = "FINANCIAL_PRODUCT_FK10"))
	public FinancialProduct getFinancialProduct() {
		return financialProduct;
	}

	public void setFinancialProduct(FinancialProduct financialProduct) {
		this.financialProduct = financialProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_ID", foreignKey = @ForeignKey(name = "ACCOUNT_FK16"))
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@XmlTransient
	public static class Builder {
		private AccountProduct accountProduct;
		
		public Builder(){
			this.accountProduct = new AccountProduct();
		}
	    
	    public Builder withId(long id) {
	    	this.accountProduct.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.accountProduct.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.accountProduct.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.accountProduct.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo( LocalDateTime effectiveTo) {
	    	this.accountProduct.setEffectiveTo(effectiveTo);
	    	return this;
	    }
	    
		public Builder withFinancialProduct(FinancialProduct financialProduct) {
			this.accountProduct.setFinancialProduct(financialProduct);
			return this;
		}
	    
		public Builder withAccount(Account account) {
			this.accountProduct.setAccount(account);
			return this;
		}
	    public AccountProduct build(){
	    	return this.accountProduct;
	    }
	}

}
