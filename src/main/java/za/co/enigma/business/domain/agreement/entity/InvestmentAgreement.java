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
@Table(name="INVESTMENT_AGREEMENT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InvestmentAgreement extends FinancialAgreement {

	private static final long serialVersionUID = -8456091140598695729L;
	
	@XmlTransient
	public static class Builder {
		private InvestmentAgreement investmentAgreement;
		
		public Builder() {
			this.investmentAgreement = new InvestmentAgreement();
		}
		public Builder withId(long id) {
	    	this.investmentAgreement.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.investmentAgreement.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.investmentAgreement.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.investmentAgreement.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.investmentAgreement.setEffectiveTo(effectiveTo);
	    	return this;
	    }
		
		public Builder withAgreementId(long agreementId) {
			this.investmentAgreement.setAgreementId(agreementId);
			return this;
		}
		
		public Builder withAgreementDate(LocalDate agreementDate) {
			this.investmentAgreement.setAgreementDate(agreementDate);
			return this;
		}
		
		public Builder withAgreementProduct(AgreementProduct agreementProduct) {
			this.investmentAgreement.getAgreementProducts().add(agreementProduct);
			return this;
		}
		
		public Builder withFeatureApplicability(FeatureApplicability featureApplicability) {
			this.investmentAgreement.getFeatureApplicabilities().add(featureApplicability);
			return this;
		}
		
		public Builder withAccountAgreement(AccountAgreement AccountAgreement) {
			this.investmentAgreement.getAccountAgreements().add(AccountAgreement);
			return this;
		}
		
		public InvestmentAgreement build() {
			return this.investmentAgreement;
		}
	}
}
