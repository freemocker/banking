package za.co.enigma.business.domain.product.entity;

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

import za.co.enigma.business.domain.agreement.entity.AgreementItem;


@Entity
@Table(name="AGREEMENT_PRODUCT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AgreementProduct extends Product {

	private static final long serialVersionUID = -3653611595739467308L;
	
	private AgreementItem agreementItem;
	private FinancialProduct financialProduct;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "AGREEMENT_ITEM_ID", foreignKey = @ForeignKey(name = "AGREEMENT_ITEM_FK01"))
	public AgreementItem getAgreementItem() {
		return agreementItem;
	}

	public void setAgreementItem(AgreementItem agreementItem) {
		this.agreementItem = agreementItem;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "FINANCIAL_PRODUCT_ID", foreignKey = @ForeignKey(name = "FINANCIAL_PRODUCT_FK12"))
	public FinancialProduct getFinancialProduct() {
		return financialProduct;
	}

	public void setFinancialProduct(FinancialProduct financialProduct) {
		this.financialProduct = financialProduct;
	}
	
	@XmlTransient
	public static class Builder {
		private AgreementProduct agreementProduct;
		
		public Builder(){
			this.agreementProduct = new AgreementProduct();
		}

	    public Builder withId(long id) {
	    	this.agreementProduct.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.agreementProduct.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.agreementProduct.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.agreementProduct.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.agreementProduct.setEffectiveTo(effectiveTo);
	    	return this;
	    }
		
		public Builder withAgreementItem(AgreementItem agreementItem) {
			this.agreementProduct.setAgreementItem(agreementItem);
			return this;
		}
		
		public Builder withFinancialProduct(FinancialProduct financialProduct) {
			this.agreementProduct.setFinancialProduct(financialProduct);
			return this;
		}
		
		public AgreementProduct build() {
			return this.agreementProduct;
		}
	}
}
