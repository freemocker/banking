package za.co.enigma.business.domain.account.entity.loan;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="MORTGAGE_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MortgageAccount extends LoanAccount {

	private static final long serialVersionUID = 6137867763144850404L;

}
