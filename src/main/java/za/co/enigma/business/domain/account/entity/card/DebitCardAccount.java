package za.co.enigma.business.domain.account.entity.card;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="DEBIT_CARD_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DebitCardAccount extends FinancialCardAccount {

	private static final long serialVersionUID = 8710751163264700135L;

}
