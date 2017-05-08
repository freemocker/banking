package za.co.enigma.business.domain.product.entity;

import za.co.enigma.domain.archetypes.ThingDomainArchetype;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="FEATURE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="FEATURE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature extends ThingDomainArchetype {

	private static final long serialVersionUID = 5317435599183774319L;
	
	private long featureId;
	private List<ProductFeature> productFeatures;
	private List<FeatureApplicability> featureApplicabilities;
	
	public Feature() {
		this.productFeatures = new ArrayList<>();
		this.featureApplicabilities = new ArrayList<>();
	}
	
	public long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}

	@JoinTable(name= "FEATURE_PRODUCT_FEATURE",
			joinColumns=@JoinColumn(name ="FEATURE_ID"),
			inverseJoinColumns = @JoinColumn(name = "PRODUCT_FEATURE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<ProductFeature> getProductFeatures() {
		return productFeatures;
	}
	public void setProductFeatures(List<ProductFeature> productFeatures) {
		this.productFeatures = productFeatures;
	}
	
	@JoinTable(name= "FEATURE_FEATURE_APPLICABILITY",
			joinColumns=@JoinColumn(name ="FEATURE_ID"),
			inverseJoinColumns = @JoinColumn(name = "FEATURE_APPLICABILITY_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<FeatureApplicability> getFeatureApplicabilities() {
		return featureApplicabilities;
	}

	public void setFeatureApplicabilities(List<FeatureApplicability> featureApplicabilities) {
		this.featureApplicabilities = featureApplicabilities;
	}

	@XmlTransient
	public static class Builder {
		private Feature feature;
		
		public Builder () {
			this.feature = new Feature();
		}

		public Builder withId(long id) {
			this.feature.setId(id);
			return this;
		}
		
		public Builder withUuid(String uuid) {
			this.feature.setUuid(uuid);
			return this;
		}
		
		public Builder withTenant(int tenant) {
			this.feature.setTenant(tenant);
			return this;
		}
		
		public Builder withName(String name) {
			this.feature.setName(name);
			return this;
		}
		
		
		public Builder withFeatureId(long featureId) {
			this.feature.setFeatureId(featureId);
			return this;
		}
		
		public Builder withProductFeature(ProductFeature productFeature) {
			this.feature.getProductFeatures().add(productFeature);
			return this;
		}
		
		public Builder withFeatureApplicability(FeatureApplicability featureApplicability) {
			this.feature.getFeatureApplicabilities().add(featureApplicability);
			return this;
		}
		public Feature build(){
			return this.feature;
		}
	}
}
