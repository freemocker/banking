package za.co.enigma.business.domain.account.entity.card;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.business.domain.account.entity.Account;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;

@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="FINANCIAL_CARD_ACCOUND")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class FinancialCardAccount extends Account {
	
	private static final long serialVersionUID = -2681409156964461013L;

}
