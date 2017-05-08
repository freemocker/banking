package za.co.enigma.business.domain.agreement.entity;

import za.co.enigma.business.domain.account.entity.Account;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ACCOUNT_AGREEMENT",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="ACCOUNT_AGREEMENT_02U", 
                columnNames={"ID", "UUID"})
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AccountAgreement extends MomentIntervalDomainArchetype {
	
	private static final long serialVersionUID = -4161021990974143614L;

	private AgreementItem agreementItem;
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "AGREEMENT_ITEM_ID", foreignKey = @ForeignKey(name = "AGREEMENT_ITEM_FK04"))
	public AgreementItem getAgreementItem() {
		return agreementItem;
	}

	public void setAgreementItem(AgreementItem agreementItem) {
		this.agreementItem = agreementItem;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ACCOUNT_ID", foreignKey = @ForeignKey(name = "ACCOUNT_FK14"))
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
