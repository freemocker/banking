package za.co.enigma.business.domain.account.entity.transaction.financial;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import za.co.enigma.business.domain.account.entity.transaction.AccountTransaction;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class FinancialTransaction extends AccountTransaction {

	private static final long serialVersionUID = -7144732743880379471L;
	
}
