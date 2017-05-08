package za.co.enigma.business.domain.account.entity.transaction.request;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import za.co.enigma.business.domain.account.entity.transaction.financial.FinancialTransaction;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ACCOUNT_REQUEST_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AccountRequestFinancialTransaction extends FinancialTransaction {
	
	private static final long serialVersionUID = 1272057944933162275L;
	
}
