package za.co.enigma.business.domain.agreement.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="FINANCIAL_AGREEMENT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class FinancialAgreement extends AgreementItem {

	private static final long serialVersionUID = 3088462146455116382L;

}
