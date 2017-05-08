package za.co.enigma.business.domain.agreement.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import za.co.enigma.business.domain.product.entity.AgreementProduct;
import za.co.enigma.business.domain.product.entity.FeatureApplicability;


@Entity
@Table(name="LEASING_AGREEMENT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LeasingAgreement extends FinancialAgreement {

	private static final long serialVersionUID = -4646024216614272450L;

	@XmlTransient
	public static class Builder {
		private LeasingAgreement leasingAgreement;
		
		public Builder() {
			this.leasingAgreement = new LeasingAgreement();
		}
		public Builder withId(long id) {
	    	this.leasingAgreement.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.leasingAgreement.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.leasingAgreement.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.leasingAgreement.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.leasingAgreement.setEffectiveTo(effectiveTo);
	    	return this;
	    }
		
		
		public Builder withAgreementId(long agreementId) {
			this.leasingAgreement.setAgreementId(agreementId);
			return this;
		}
		
		public Builder withAgreementDate(LocalDate agreementDate) {
			this.leasingAgreement.setAgreementDate(agreementDate);
			return this;
		}
		
		public Builder withAgreementProduct(AgreementProduct agreementProduct) {
			this.leasingAgreement.getAgreementProducts().add(agreementProduct);
			return this;
		}
		
		public Builder withFeatureApplicability(FeatureApplicability featureApplicability) {
			this.leasingAgreement.getFeatureApplicabilities().add(featureApplicability);
			return this;
		}
		
		public Builder withAccountAgreement(AccountAgreement AccountAgreement) {
			this.leasingAgreement.getAccountAgreements().add(AccountAgreement);
			return this;
		}
		
		public LeasingAgreement build() {
			return this.leasingAgreement;
		}
	}
}
