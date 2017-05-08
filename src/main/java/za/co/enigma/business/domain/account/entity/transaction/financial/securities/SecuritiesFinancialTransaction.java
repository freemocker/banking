package za.co.enigma.business.domain.account.entity.transaction.financial.securities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import za.co.enigma.business.domain.account.entity.transaction.financial.FinancialTransaction;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="SECURITIES_FINANCIAL_TRANSACTION")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class SecuritiesFinancialTransaction extends FinancialTransaction {

	private static final long serialVersionUID = -8760069724035379350L;
	
}
