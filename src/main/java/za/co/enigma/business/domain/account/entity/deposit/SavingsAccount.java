package za.co.enigma.business.domain.account.entity.deposit;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="SAVINGS_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SavingsAccount extends DepositAccount {

	private static final long serialVersionUID = 1598936475438381434L;

}
