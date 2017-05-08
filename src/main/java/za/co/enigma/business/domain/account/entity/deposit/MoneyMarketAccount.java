package za.co.enigma.business.domain.account.entity.deposit;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="MONEY_MARKET_ACCOUNT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MoneyMarketAccount extends DepositAccount {

	private static final long serialVersionUID = -570458775599363963L;

}
