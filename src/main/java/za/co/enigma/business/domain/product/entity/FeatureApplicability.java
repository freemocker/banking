package za.co.enigma.business.domain.product.entity;

import za.co.enigma.business.domain.agreement.entity.AgreementItem;
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
@Table(name="FEATURE_APPLICABILITY",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="FEATURE_APPLICABILITY_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FeatureApplicability extends MomentIntervalDomainArchetype{

	private static final long serialVersionUID = -2533505371898603048L;
	private Feature feature;
	private long applicabilityId;
	private AgreementItem agreementItem;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "FEATURE_ID", foreignKey = @ForeignKey(name = "FEATURE_FK01"))
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	public long getApplicabilityId() {
		return applicabilityId;
	}
	public void setApplicabilityId(long applicabilityId) {
		this.applicabilityId = applicabilityId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "AGREEMENT_ITEM_ID", foreignKey = @ForeignKey(name = "AGREEMENT_ITEM_FK02"))
	public AgreementItem getAgreementItem() {
		return agreementItem;
	}
	public void setAgreementItem(AgreementItem agreementItem) {
		this.agreementItem = agreementItem;
	}
	
	@XmlTransient
	public static class Builder {
		private FeatureApplicability featureApplicability;
		
		public Builder(){
			this.featureApplicability = new FeatureApplicability();
		}
		
		public Builder withId(long id) {
	    	this.featureApplicability.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.featureApplicability.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.featureApplicability.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.featureApplicability.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.featureApplicability.setEffectiveTo(effectiveTo);
	    	return this;
	    }

		public Builder withFeature(Feature feature) {
			this.featureApplicability.setFeature(feature);
			return this;
		}
	    
		public Builder withApplicabilityId(long applicabilityId) {
			this.featureApplicability.setApplicabilityId(applicabilityId);
			return this;
		}
		
		public Builder withAgreementItem(AgreementItem agreementItem) {
			this.featureApplicability.setAgreementItem(agreementItem);
			return this;
		}
		
	    public FeatureApplicability build() {
	    	return this.featureApplicability;
	    }
	}
}
