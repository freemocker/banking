package za.co.enigma.business.domain.account.entity.loan.credit;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="EQUITY_LINE_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EquityLineAccount extends LineOfCreditAccount {

	private static final long serialVersionUID = 6459599005674695449L;

}
