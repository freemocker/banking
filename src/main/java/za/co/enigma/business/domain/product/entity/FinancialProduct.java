package za.co.enigma.business.domain.product.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="FINANCIAL_PRODUCT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FinancialProduct extends Product {

	private static final long serialVersionUID = 6643281350450644905L;
	
	private List<AccountProduct> accountProducts;
	private List<ProductFeature> productFeatures;
	private List<AgreementProduct> agreementProducts;
	
	@JoinTable(name= "FINANCIAL_PRODUCT_ACCOUNT_PRODUCT",
			joinColumns=@JoinColumn(name ="FINANCIAL_PRODUCT_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_PRODUCT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountProduct> getAccountProducts() {
		return accountProducts;
	}
	public void setAccountProducts(List<AccountProduct> accountProducts) {
		this.accountProducts = accountProducts;
	}
	
	@JoinTable(name= "FINANCIAL_PRODUCT_PRODUCT_FEATURE",
			joinColumns=@JoinColumn(name ="FINANCIAL_PRODUCT_ID"),
			inverseJoinColumns = @JoinColumn(name = "PRODUCT_FEATURE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<ProductFeature> getProductFeatures() {
		return productFeatures;
	}
	public void setProductFeatures(List<ProductFeature> productFeatures) {
		this.productFeatures = productFeatures;
	}
	
	@JoinTable(name= "FINANCIAL_PRODUCT_AGREEMENT_PRODUCT",
			joinColumns=@JoinColumn(name ="FINANCIAL_PRODUCT_ID"),
			inverseJoinColumns = @JoinColumn(name = "AGREEMENT_PRODUCT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AgreementProduct> getAgreementProducts() {
		return agreementProducts;
	}
	public void setAgreementProducts(List<AgreementProduct> agreementProducts) {
		this.agreementProducts = agreementProducts;
	}

	@XmlTransient
	public static class Builder {
		private FinancialProduct financialProduct;
		
		public Builder(){
			this.financialProduct = new FinancialProduct();
		}
		
		public Builder withId(long id) {
	    	this.financialProduct.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.financialProduct.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.financialProduct.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.financialProduct.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.financialProduct.setEffectiveTo(effectiveTo);
	    	return this;
	    }
		
		public Builder withAccountProduct(AccountProduct accountProduct) {
			this.financialProduct.getAccountProducts().add(accountProduct);
			return this;
		}
		
		public Builder withProductFeature(ProductFeature productFeature) {
			this.financialProduct.getProductFeatures().add(productFeature);
			return this;
		}
	    
		public Builder withAgreementProduct(AgreementProduct agreementProduct) {
			this.financialProduct.getAgreementProducts().add(agreementProduct);
			return this;
		}
		
	    public FinancialProduct build() {
	    	return this.financialProduct;
	    }
	}
}
