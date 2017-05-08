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
@Table(name="LOAN_AGREEMENT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanAgreement extends FinancialAgreement {

	private static final long serialVersionUID = 5234209173853770683L;
	
	@XmlTransient
	public static class Builder {
		private LoanAgreement loanAgreement;
		
		public Builder() {
			this.loanAgreement = new LoanAgreement();
		}
		public Builder withId(long id) {
	    	this.loanAgreement.setId(id);
	    	return this;
	    }
	    public Builder withUuid(String uuid) {
	    	this.loanAgreement.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.loanAgreement.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
	    	this.loanAgreement.setEffectiveFrom(effectiveFrom);
	    	return this;
	    }
	    
	    public Builder withEffectiveTo(LocalDateTime effectiveTo) {
	    	this.loanAgreement.setEffectiveTo(effectiveTo);
	    	return this;
	    }
		
		public Builder withAgreementId(long agreementId) {
			this.loanAgreement.setAgreementId(agreementId);
			return this;
		}
		
		public Builder withAgreementDate(LocalDate agreementDate) {
			this.loanAgreement.setAgreementDate(agreementDate);
			return this;
		}
		
		public Builder withAgreementProduct(AgreementProduct agreementProduct) {
			this.loanAgreement.getAgreementProducts().add(agreementProduct);
			return this;
		}
		
		public Builder withFeatureApplicability(FeatureApplicability featureApplicability) {
			this.loanAgreement.getFeatureApplicabilities().add(featureApplicability);
			return this;
		}
		
		public Builder withAccountAgreement(AccountAgreement AccountAgreement) {
			this.loanAgreement.getAccountAgreements().add(AccountAgreement);
			return this;
		}
		
		public LoanAgreement build() {
			return this.loanAgreement;
		}
	}
}
