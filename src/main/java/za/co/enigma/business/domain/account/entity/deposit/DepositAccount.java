package za.co.enigma.business.domain.account.entity.deposit;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import za.co.enigma.business.domain.account.entity.Account;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="DEPOSIT_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DepositAccount extends Account {

	private static final long serialVersionUID = -3522972267131048928L;

}
