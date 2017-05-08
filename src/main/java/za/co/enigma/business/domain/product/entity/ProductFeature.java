package za.co.enigma.business.domain.product.entity;

import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="PRODUCT_FEATURE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="PRODUCT_FEATURE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductFeature extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -6419272038982815284L;

	private Feature feature;
	private FinancialProduct financialProduct;
    private List<AgreementProduct> agreementProducts;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "FEATURE_ID", foreignKey = @ForeignKey(name = "FEATURE_FK01"))
	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "FINANCIAL_PRODUCT_ID", foreignKey = @ForeignKey(name = "FINANCIAL_PRODUCT_FK01"))
	public FinancialProduct getFinancialProduct() {
		return financialProduct;
	}

	public void setFinancialProduct(FinancialProduct financialProduct) {
		this.financialProduct = financialProduct;
	}

	@JoinTable(name= "FEATURE_PRODUCT_FEATURE",
			joinColumns=@JoinColumn(name ="FEATURE_ID"),
			inverseJoinColumns = @JoinColumn(name = "PRODUCT_FEATURE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AgreementProduct> getAgreementProducts() {
		return agreementProducts;
	}

	public void setAgreementProducts(List<AgreementProduct> agreementProducts) {
		this.agreementProducts = agreementProducts;
	}
	
	@XmlTransient
	public static class Builder {
		private ProductFeature productFeature;
		
		public Builder() {
			this.productFeature = new ProductFeature();
		}
		
		public Builder withId(long id) {
	    	this.productFeature.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.productFeature.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.productFeature.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.productFeature.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.productFeature.setEffectiveTo(effectiveTo);
	    	return this;
	    }
	    
	    public Builder withFeature(Feature feature) {
	    	this.productFeature.setFeature(feature);
	    	return this;
	    }
	    
	    public Builder withFinancialProduct(FinancialProduct financialProduct) {
	    	this.productFeature.setFinancialProduct(financialProduct);
	    	return this;
	    }
	    
	    public Builder withAgreementProduct(AgreementProduct agreementProduct) {
	    	this.productFeature.getAgreementProducts().add(agreementProduct);
	    	return this;
	    }
	    
	    public ProductFeature build() {
	    	return this.productFeature;
	    }
	}
}
