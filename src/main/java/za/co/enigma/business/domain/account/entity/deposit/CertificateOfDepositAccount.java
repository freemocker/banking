package za.co.enigma.business.domain.account.entity.deposit;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="CERTIFICATE_OF_DEPOSIT_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CertificateOfDepositAccount extends DepositAccount {

	private static final long serialVersionUID = -8214265524601742675L;

}
