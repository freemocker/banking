package za.co.enigma.business.domain.agreement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import za.co.enigma.business.domain.product.entity.AgreementProduct;
import za.co.enigma.business.domain.product.entity.FeatureApplicability;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="AGREEMENT_ITEM",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="AGREEMENT_ITEM_02U", 
                columnNames={"ID", "UUID"})
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AgreementItem extends MomentIntervalDomainArchetype { 

	private static final long serialVersionUID = -1556314958550367244L;
	
	private long agreementId;
	private LocalDate agreementDate;
	protected List<AgreementProduct> agreementProducts = new ArrayList<>();
	protected List<FeatureApplicability> featureApplicabilities = new ArrayList<>();
	protected List<AccountAgreement> accountAgreements = new ArrayList<>();
	
	public long getAgreementId() {
		return agreementId;
	}
	public void setAgreementId(long agreementId) {
		this.agreementId = agreementId;
	}
	public LocalDate getAgreementDate() {
		return agreementDate;
	}
	public void setAgreementDate(LocalDate agreementDate) {
		this.agreementDate = agreementDate;
	}
	
	@JoinTable(name= "AGREEMENT_ITEM_AGREEMENT_PRODUCT",
			joinColumns=@JoinColumn(name ="AGREEMENT_ITEM_ID"),
			inverseJoinColumns = @JoinColumn(name = "AGREEMENT_PRODUCT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AgreementProduct> getAgreementProducts() {
		return agreementProducts;
	}
	public void setAgreementProducts(List<AgreementProduct> agreementProducts) {
		this.agreementProducts = agreementProducts;
	}
	
	@JoinTable(name= "AGREEMENT_ITEM_FEATURE_APPLICABILITY",
			joinColumns=@JoinColumn(name ="AGREEMENT_ITEM_ID"),
			inverseJoinColumns = @JoinColumn(name = "FEATURE_APPLICABILITY_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<FeatureApplicability> getFeatureApplicabilities() {
		return featureApplicabilities;
	}
	public void setFeatureApplicabilities(List<FeatureApplicability> featureApplicabilities) {
		this.featureApplicabilities = featureApplicabilities;
	}
	
	@JoinTable(name= "AGREEMENT_ITEM_ACCOUNT_AGREEMENT",
			joinColumns=@JoinColumn(name ="AGREEMENT_ITEM_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_AGREEMENT"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountAgreement> getAccountAgreements() {
		return accountAgreements;
	}
	public void setAccountAgreements(List<AccountAgreement> accountAgreements) {
		this.accountAgreements = accountAgreements;
	}

}
