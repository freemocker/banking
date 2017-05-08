package za.co.enigma.business.domain.account.entity.loan.credit;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import za.co.enigma.business.domain.account.entity.loan.LoanAccount;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="LINE_OF_CREDIT_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class LineOfCreditAccount extends LoanAccount {

	private static final long serialVersionUID = 1330382725377586103L;

}
