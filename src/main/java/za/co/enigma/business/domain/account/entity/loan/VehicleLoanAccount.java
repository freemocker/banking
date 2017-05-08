package za.co.enigma.business.domain.account.entity.loan;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="VEHICLE_LOAN_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleLoanAccount extends LoanAccount {

	private static final long serialVersionUID = 5829852855685625220L;

}
