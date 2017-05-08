package za.co.enigma.business.domain.party.entity.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="TELECOMMUNICATIONS_NUMBER",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="TELECOMMUNICATIONS_NUMBER_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TelecommunicationsNumber extends ThingDomainArchetype {

	private static final long serialVersionUID = -1207305773803436697L;
	private int areaCode;
	private String contactNumber;
	private String countryCode;
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
