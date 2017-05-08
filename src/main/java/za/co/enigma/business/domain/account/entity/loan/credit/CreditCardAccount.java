package za.co.enigma.business.domain.account.entity.loan.credit;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="CREDIT_CARD_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardAccount extends LineOfCreditAccount {

	private static final long serialVersionUID = -4019449496825024949L;

}
